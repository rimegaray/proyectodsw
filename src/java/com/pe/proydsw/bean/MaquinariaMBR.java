/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.proydsw.bean;

import com.pe.proydsw.utils.MensajeSYSUtils;
import com.sium.dao.component.MaquinariaDAO;
import com.sium.dao.to.MaquinariaTO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
    
    String nombremaq;
    String catmaq;
    
    
    private List<MaquinariaTO> listamaquinaria;

    private Boolean insert = Boolean.TRUE;
    private Boolean chkestado;
    
    @PostConstruct
    private void init(){
        initInstancia();
//        initlistDep();
    }
    
    private void initInstancia(){        
        this.mmaquinaria = new MaquinariaTO();
        this.maquinariadao = new MaquinariaDAO(); 
        this.listamaquinaria = new ArrayList();
        chkestado = true;
    }
    
    private void initlistDep() {
    }

    public String registrarCate(){
        System.out.println("nombre: "+nombremaq);
        System.out.println("categoria: "+catmaq);
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
            this.mmaquinaria.setCategoria(catmaq);
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
    

//    public String cargarcategoria(int id){
//        this.session=null;
//        this.transaction=null;
//        String micategoria = null;
//        
//        try {
//            
//            this.session = HibernateUtil.getSessionFactory().openSession();
//            this.transaction = this.session.beginTransaction();
//            
//            Maquinaria mimaquina = maquinariadao.ListadoMaquinariaxId(session, id);
//           micategoria = mimaquina.getCategoria().getVarNombreCategoria();            
//
//        }
//        catch (Exception ex) {
//            System.out.println("ERROR :"+ex.getMessage());
//            if (this.transaction!=null){
//                this.transaction.rollback();
//            }
//            messageFatal("Error Fatal: Por favor contacte con su administrador"+ex.getMessage());
//            
//        }
//            finally
//            {
//                if (this.session!=null){
//                    this.session.close();
//                }
//            }
//            return micategoria;
//    }
    
//    public void cargarCombos(){
//        this.session=null;
//        this.transaction=null;
//        
//        try {
//            
//            this.session = HibernateUtil.getSessionFactory().openSession();
//            this.transaction = this.session.beginTransaction();
//        //CARGAR COMBOS
//            
//            char op=this.mmaquinaria.getChrestado();
//            if (op=='A') {
//                chkestado=true;
//            }else{
//                chkestado=false;
//            }
//            insert = Boolean.FALSE;
//            
//            }
//            catch (Exception ex) {
//                System.out.println("ERROR :"+ex.getMessage());
//                if (this.transaction!=null){
//                    this.transaction.rollback();
//                }
//                messageFatal("Error Fatal: Por favor contacte con su administrador"+ex.getMessage());
//
//            }
//                finally
//                {
//                    if (this.session!=null){
//                        this.session.close();
//                    }
//                }
//        }

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

    public String getCatmaq() {
        return catmaq;
    }

    public void setCatmaq(String catmaq) {
        this.catmaq = catmaq;
    }

    
    
    
    
    
}