/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.proydsw.bean;

import com.pe.proydsw.utils.MensajeSYSUtils;
import com.sium.dao.component.MaquinariaDAO;
import com.sium.dao.to.CategoriaTO;
import com.sium.dao.to.MaquinariaTO;
import com.sium.mqtt.Subscriber;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author RAUL
 */
@ManagedBean
@ViewScoped
public class MaquinariaMBR extends MensajeSYSUtils implements Serializable{     
    
    Session session;
    Transaction transaction;
    
    private MaquinariaDAO maquinariadao;
    private MaquinariaTO mmaquinaria;
    private Subscriber suscriber;
    String nombremaq;
    String categoriamaq;
    
    Map<String,String> hashmapestados;
    
    private List<MaquinariaTO> listamaquinaria;

    private Boolean insert = Boolean.TRUE;
    private Boolean chkestado;
    
    @PostConstruct
    private void init(){
        initInstancia();
        listadoMaquinarias();
        cargarEstado();
//        initli
       
    }
    public void cargarEstado(){
        if(MaquinaEstado.estadosMaq.isEmpty()==false){
           for (Map.Entry<String, String> entry : MaquinaEstado.estadosMaq.entrySet()) {
          //System.out.println("clave=" + entry.getKey() + ", valor=" + entry.getValue());
                if(entry.getValue()!=null){
                    int codigoMaq = Integer.parseInt(entry.getKey());
                    
                    int posicion=0;
                    for (MaquinariaTO maquinariaTO : this.listamaquinaria) {
                        if(maquinariaTO.getCodigoMaquinaria()==codigoMaq){
                            listamaquinaria.get(posicion).setEstado(Integer.parseInt(entry.getValue()));
                        }
                        posicion++;
                    }
                }
            } 
        }
    }
    
    private void initInstancia(){        
        this.mmaquinaria = new MaquinariaTO();
        System.out.println("hola we");
        this.maquinariadao = new MaquinariaDAO(); 
        this.listamaquinaria = new ArrayList();
        this.hashmapestados = new HashMap<>();
        this.suscriber = new Subscriber();
        suscriber.start();
        chkestado = true;
    }
    
    private void initlistDep() {
    }
    
    public String registrarCate(){
        System.out.println("sdsd: "+nombremaq);
        System.out.println("sdsd: "+categoriamaq);
        try {
            this.mmaquinaria = new MaquinariaTO();
            String respuesta;
        
            int countReg=maquinariadao.ContadorDeRegMaquinaria();
            int idCate=0;
            if(countReg!=0){
                idCate=countReg+1;
            }else{
                idCate=1;
            }
            
            
            this.mmaquinaria.setCodigoMaquinaria(idCate);
            this.mmaquinaria.setNombre(nombremaq);
            this.mmaquinaria.setCategoria(categoriamaq);
//            System.out.println(nombremaq);
            
            
            respuesta = maquinariadao.insertMaquinaria(mmaquinaria);
        
        if (respuesta.equals("correcto")){
            messageInfo("Se realizo la creación del Nivel");
        }else{
            messageError("NO Se realizo la creación del Nivel");
        }
        }
        catch (Exception ex) {
           
            messageFatal("Error Fatal: Por favor contacte con su administrador"+ex.getMessage());
            
            return null;
        }
           
        return "/formularios/Frmagregar";
    }
    
    public String limpiarcajas(){
        return "/FORMULARIOS/FrmManttoNivel";
    }
    
    public List<MaquinariaTO> listadoMaquinarias(){
        
        try {
            this.listamaquinaria= maquinariadao.listaMaquinaria();

            this.transaction.commit();
            
            return this.listamaquinaria;
//            System.out.println(listaTEmpresa.size());
        }
        catch (Exception ex) {
            System.out.println("ERROR :"+ex.getMessage());
            
            messageFatal("Error Fatal: Por favor contacte con su administrador"+ex.getMessage());
            
            return null;
        }
            
    }
    
    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public MaquinariaDAO getMaquinariadao() {
        return maquinariadao;
    }

    public void setMaquinariadao(MaquinariaDAO maquinariadao) {
        this.maquinariadao = maquinariadao;
    }

    public MaquinariaTO getMmaquinaria() {
        return mmaquinaria;
    }

    public void setMmaquinaria(MaquinariaTO mmaquinaria) {
        this.mmaquinaria = mmaquinaria;
    }

    public List<MaquinariaTO> getListamaquinaria() {
        return listamaquinaria;
    }

    public void setListamaquinaria(List<MaquinariaTO> listamaquinaria) {
        this.listamaquinaria = listamaquinaria;
    }

    public Boolean getInsert() {
        return insert;
    }

    public void setInsert(Boolean insert) {
        this.insert = insert;
    }

    public Boolean getChkestado() {
        return chkestado;
    }

    public void setChkestado(Boolean chkestado) {
        this.chkestado = chkestado;
    }

    public String getNombremaq() {
        return nombremaq;
    }

    public void setNombremaq(String nombremaq) {
        this.nombremaq = nombremaq;
    }

    public String getCategoriamaq() {
        return categoriamaq;
    }

    public void setCategoriamaq(String categoriamaq) {
        this.categoriamaq = categoriamaq;
    }

    public Map<String, String> getHashmapestados() {
        return hashmapestados;
    }

    public void setHashmapestados(Map<String, String> hashmapestados) {
        this.hashmapestados = hashmapestados;
    }
    
}
