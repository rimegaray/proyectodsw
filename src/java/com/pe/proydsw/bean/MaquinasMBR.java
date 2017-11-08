/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.proydsw.bean;


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
 * @author CARLOS
 */
@ManagedBean
@ViewScoped
public class MaquinasMBR  implements Serializable{     
    
    Session session;
    Transaction transaction;
    
    private MaquinariaDAO maquinariadao;
    private MaquinariaTO mmaquinaria;

//   
//    private FamiliaDAO familiadao;
//    private Mfamilia mfamilia;
//    private List<Mfamilia> listafamilia;
//    
//    private List<Mfamilia> listaFamiliaFiltrado;
    boolean chkestado;
//    private boolean insert = true;
//    private Boolean insert = Boolean.TRUE;

//    public Mfamilia getMfamilia() {
//        return mfamilia;
//    }
//
//    public void setMfamilia(Mfamilia mfamilia) {
//        this.mfamilia = mfamilia;
//    }

    

    
    
    
    @PostConstruct
    private void init(){
        initInstancia();
        initlistDep();
    }
    
    private void initInstancia(){        
        this.mfamilia = new Mfamilia();
        this.familiadao = new FamiliaDAO(); 
        this.listafamilia = new ArrayList();
        
        chkestado = true;
        
    }
    
    private void initlistDep() {
        
    }

    public String registrarFami(){
            
        this.session=null;
        this.transaction=null;
        
        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaction = this.session.beginTransaction();
            boolean respuesta;
        
            int countReg=familiadao.ContadorDeRegFamilia(this.session);
            int idFamilia=0;
            if(countReg!=0){
                idFamilia=countReg+1;
            }else{
                idFamilia=1;
            }
            
            this.mfamilia.setIntidfamilia(idFamilia);
            if (chkestado==true) {                
                this.mfamilia.setChrestado('A');
            }else{                
                this.mfamilia.setChrestado('I');
            }
       
            respuesta = familiadao.GrabarFamilia(this.mfamilia);
            this.transaction.commit();
        
        if (respuesta){
            messageInfo("Se realizo la creación de la Familia");
        }else{
            messageError("NO Se realizo la creación de la Familia");
        }
        }
        catch (Exception ex) {
            
            if (this.transaction!=null){
                this.transaction.rollback();
            }
            messageFatal("Error Fatal: Por favor contacte con su administrador"+ex.getMessage());
            
            return null;
        }
            finally
            {
                if (this.session!=null){
                    this.session.close();
                }
            }
        return "/MANTENIMIENTOS/FrmManttoFamilia";
        
    }
    
    public String limpiarcajas(){
        return "/MANTENIMIENTOS/FrmManttoFamilia";
    }
    
    public List<Mfamilia> listadoCargo()
    {
        //System.out.println("INGRESO A LA FUNCION");
        this.session=null;
        this.transaction=null;
        
        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaction = this.session.beginTransaction();
            
            this.listafamilia= familiadao.ListadoFamiliaTodos(this.session);

            this.transaction.commit();
            
            return this.listafamilia;
//            System.out.println(listaTEmpresa.size());
        }
        catch (Exception ex) {
            System.out.println("ERROR :"+ex.getMessage());
            if (this.transaction!=null){
                this.transaction.rollback();
            }
            messageFatal("Error Fatal: Por favor contacte con su administrador"+ex.getMessage());
            
            return null;
        }
            finally
            {
                if (this.session!=null){
                    this.session.close();
                }
            }
            
    }
    
    public String update()
    {
        this.session=null;
        this.transaction=null;
        
        try {
            
            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaction = this.session.beginTransaction();
            
            if (chkestado==true) {                
                this.mfamilia.setChrestado('A');
            }else{                
                this.mfamilia.setChrestado('I');
            }
            
            familiadao.ActualizarFamilia(this.session,this.mfamilia);

            this.transaction.commit();
            
            messageInfo("Correcto: Los cambios fueron guardados correctamente");
            
            insert = Boolean.TRUE;

        }
        catch (Exception ex) {
            System.out.println("ERROR :"+ex.getMessage());
            if (this.transaction!=null){
                this.transaction.rollback();
            }
            messageFatal("Error Fatal: Por favor contacte con su administrador"+ex.getMessage());
            
        }
            finally
            {
                if (this.session!=null){
                    this.session.close();
                }
            }
            return "/MANTENIMIENTOS/FrmManttoFamilia";
    }
    
    public void cargarCombos(){
        this.session=null;
        this.transaction=null;
        
        try {
            
            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaction = this.session.beginTransaction();
        //CARGAR COMBOS
            
            char op=this.mfamilia.getChrestado();
            if (op=='A') {
                chkestado=true;
            }else{
                chkestado=false;
            }
            insert = Boolean.FALSE;
            
            }
            catch (Exception ex) {
                System.out.println("ERROR :"+ex.getMessage());
                if (this.transaction!=null){
                    this.transaction.rollback();
                }
                messageFatal("Error Fatal: Por favor contacte con su administrador"+ex.getMessage());

            }
                finally
                {
                    if (this.session!=null){
                        this.session.close();
                    }
                }
        }
    
    public Boolean getInsert() {
        return insert;
    }
    
    public void setInsert(Boolean insert) {
        this.insert = insert;
    }

    public List<Mfamilia> getListaCargoFiltrado() {
        return listaFamiliaFiltrado;
    }

    public void setListaCargoFiltrado(List<Mfamilia> listaFamiliaFiltrado) {
        this.listaFamiliaFiltrado = listaFamiliaFiltrado;
    }

    
    public boolean isChkestado() {
        return chkestado;
    }

    public void setChkestado(boolean chkestado) {
        this.chkestado = chkestado;
    }

    
    
    
    
    }



    

    

