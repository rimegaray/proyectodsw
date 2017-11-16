/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.proydsw.bean;

import com.pe.proydsw.utils.MensajeSYSUtils;
import com.sium.dao.dao.DAOFactory;
import com.sium.dao.design.IMaquinariaDAO;
import com.sium.dao.to.MaquinariaTO;
import com.sium.mqtt.Subscriber;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author RAUL
 */
@ManagedBean
@ViewScoped
public class MaquinariaMBR extends MensajeSYSUtils{     
    
   
    private IMaquinariaDAO maquinariaDAO;
    private MaquinariaTO mmaquinaria;
    private Subscriber suscriber;
    String nombremaq;
    String categoriamaq;
    
    Map<String,String> hashmapestados;
    
    private List<MaquinariaTO> listamaquinaria;

    @PostConstruct
    private void init(){
        initInstancia();
        listadoMaquinarias();
        cargarEstado();
       
    }
    public void cargarEstado(){
        if(MaquinaEstado.estadosMaq.isEmpty()==false){
           for (Map.Entry<String, String> entry : MaquinaEstado.estadosMaq.entrySet()) {
          
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
        
        this.maquinariaDAO = DAOFactory.getInstance().getMaquinariaDAO();
        this.mmaquinaria = new MaquinariaTO();
        this.listamaquinaria = new ArrayList();
        this.hashmapestados = new HashMap<>();
        
        this.suscriber = new Subscriber();
        suscriber.start();
    }
    
    
    public String registrarCate(){
        try {
            this.mmaquinaria = new MaquinariaTO();
            String respuesta;
            int countReg=maquinariaDAO.ContadorDeRegMaquinaria();
            int idCate=0;
            if(countReg!=0){
                idCate=countReg+1;
            }else{
                idCate=1;
            }
            
            this.mmaquinaria.setCodigoMaquinaria(idCate);
            this.mmaquinaria.setNombre(nombremaq);
            this.mmaquinaria.setCategoria(categoriamaq);
            respuesta = maquinariaDAO.insertMaquinaria(mmaquinaria);
        
        if (respuesta.equals("correcto")){
            messageInfo("Se realizo la creación de la Maquinaria");
        }else{
            messageError("NO Se realizo la creación de la Maquinaria");
        }
        }
        catch (Exception ex) {
           
            messageFatal("Error Fatal: Por favor contacte con su administrador"+ex.getMessage());
            
            return null;
        }
           
        return "/formularios/Frmagregar";
    }
    
    public List<MaquinariaTO> listadoMaquinarias(){
        
        try {
            this.listamaquinaria= maquinariaDAO.listaMaquinaria();
            return this.listamaquinaria;
        }
        catch (Exception ex) {
            messageFatal("Error Fatal: Por favor contacte con su administrador"+ex.getMessage());
            return null;
        }
            
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

    public IMaquinariaDAO getMaquinariaDAO() {
        return maquinariaDAO;
    }

    public void setMaquinariaDAO(IMaquinariaDAO maquinariaDAO) {
        this.maquinariaDAO = maquinariaDAO;
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
