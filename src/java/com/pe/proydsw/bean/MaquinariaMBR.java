/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.proydsw.bean;

import com.pe.proydsw.utils.MensajeSYSUtils;
import com.sium.dao.component.MaquinariaDAO;
import com.sium.dao.to.MaquinariaTO;
import com.sium.mqtt.SubscribeCallback;
import com.sium.mqtt.Subscriber;
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
    private Subscriber suscriber;
    String nombremaq;
    String catmaq;
    
    public String estado1=null;
    public String estado2=null;
    public String estado3=null;

    private List<MaquinariaTO> listamaquinaria;

    private Boolean insert = Boolean.TRUE;
    private Boolean chkestado;
    
    @PostConstruct
    private void init(){
        initInstancia();
//        initli
       
    }
    public void cargarEstado(){
        System.out.println("oie este es mi estado "+ estado1);
        System.out.println("oie este es mi estado "+ estado2);
        System.out.println("oie este es mi estado "+ estado3);
        //estado1 = MaquinaEstado.estadoMaq1;
        //estado2 = MaquinaEstado.estadoMaq2;
        //estado3 = MaquinaEstado.estadoMaq3; 
        estado1 = MaquinaEstado.estadosMaq.get("1");
        estado2 = MaquinaEstado.estadosMaq.get("2");
        estado3 = MaquinaEstado.estadosMaq.get("3");
    }
    
    private void initInstancia(){        
        this.mmaquinaria = new MaquinariaTO();
        System.out.println("hola we");
        this.maquinariadao = new MaquinariaDAO(); 
        this.listamaquinaria = new ArrayList();
       this.suscriber = new Subscriber();
        suscriber.start();
        chkestado = true;
    }
    
    private void initlistDep() {
    }

    public String registrarCate(){
        System.out.println("sdsd: "+nombremaq);
        System.out.println("sdsd: "+catmaq);
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
            //this.mmaquinaria.setNombre(nombremaq);
            //this.mmaquinaria.setCategoria(catmaq);
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

    
     public String getEstado1() {
        return estado1;
    }

    public void setEstado1(String estado1) {
        this.estado1 = estado1;
    }

    public String getEstado2() {
        return estado2;
    }

    public void setEstado2(String estado2) {
        this.estado2 = estado2;
    }

    public String getEstado3() {
        return estado3;
    }

    public void setEstado3(String estado3) {
        this.estado3 = estado3;
    }
    
    
    
}
