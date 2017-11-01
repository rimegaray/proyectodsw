/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.proydsw.bean;



import com.pe.proydsw.dao.CategoriaDao;
import com.pe.proydsw.dao.MaquinariaDao;
import com.pe.proydsw.entidades.Categoria;
import com.pe.proydsw.entidades.Maquinaria;
import com.pe.proydsw.utils.HibernateUtil;
import com.pe.proydsw.utils.MensajeSYSUtils;
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
    
    private MaquinariaDao maquinariadao;
    private Maquinaria mmaquinaria;
    
    
    private List<Maquinaria> listamaquinaria;

   
    
    private Boolean insert = Boolean.TRUE;
    private Boolean chkestado;

    
   

    
    
    @PostConstruct
    private void init(){
        initInstancia();
//        initlistDep();
    }
    
    private void initInstancia(){        
        this.mmaquinaria = new Maquinaria();
        this.maquinariadao = new MaquinariaDao(); 
        this.listamaquinaria = new ArrayList();
        
        chkestado = true;
        
    }
    
    private void initlistDep() {
        
    }

    public String registrarCate(){
            
        this.session=null;
        this.transaction=null;
        
        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaction = this.session.beginTransaction();
            boolean respuesta;
        
            int countReg=maquinariadao.ContadorDeRegMaquinaria(this.session);
            int idCate=0;
            if(countReg!=0){
                idCate=countReg+1;
            }else{
                idCate=1;
            }
            
            this.mmaquinaria.setIntIdMaquinaria(idCate);
            
       
            respuesta = maquinariadao.GrabarMaquinaria(this.mmaquinaria);
            this.transaction.commit();
        
        if (respuesta){
            messageInfo("Se realizo la creación del Nivel");
        }else{
            messageError("NO Se realizo la creación del Nivel");
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
        return "/FORMULARIOS/FrmManttoNivel";
        
    }
    
    public String limpiarcajas(){
        return "/FORMULARIOS/FrmManttoNivel";
    }
    
    public List<Maquinaria> listadoMaquinarias()
    {
        System.out.println("INGRESO A LA FUNCION");
        this.session=null;
        this.transaction=null;
        
        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaction = this.session.beginTransaction();
            
            this.listamaquinaria= maquinariadao.ListadoMaquinariaTodos(session);

            this.transaction.commit();
            
            return this.listamaquinaria;
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
                this.mmaquinaria.setChrEstado('A');
            }else{                
                this.mmaquinaria.setChrEstado('I');
            }
            
            maquinariadao.ActualizarMaquinaria(this.session,this.mmaquinaria);

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
            return "/FORMULARIOS/FrmManttoNivel";
    }
    
    public String cargarcategoria(int id)
    {
        this.session=null;
        this.transaction=null;
        String micategoria = null;
        
        try {
            
            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaction = this.session.beginTransaction();
            
            Maquinaria mimaquina = maquinariadao.ListadoMaquinariaxId(session, id);
           micategoria = mimaquina.getCategoria().getVarNombreCategoria();
            
            

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
            return micategoria;
    }
    
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
    
    public Boolean getInsert() {
        return insert;
    }
    
    public void setInsert(Boolean insert) {
        this.insert = insert;
    }

    
    public boolean isChkestado() {
        return chkestado;
    }

    public void setChkestado(boolean chkestado) {
        this.chkestado = chkestado;
    }

    public List<Maquinaria> getListamaquinaria() {
        return listamaquinaria;
    }

    public void setListamaquinaria(List<Maquinaria> listamaquinaria) {
        this.listamaquinaria = listamaquinaria;
    }

    public Maquinaria getMmaquinaria() {
        return mmaquinaria;
    }

    public void setMmaquinaria(Maquinaria mmaquinaria) {
        this.mmaquinaria = mmaquinaria;
    }
    
    

    

    
    
    
    
    
    }



    

    

