/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.proydsw.bean;

import com.pe.proydsw.utils.MensajeSYSUtils;
import com.sium.dao.dao.DAOFactory;
import com.sium.dao.design.ICategoriaDAO;
import com.sium.dao.to.CategoriaTO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author RAUL
 */
@ManagedBean
@ViewScoped
public class CategoriaMBR extends MensajeSYSUtils implements Serializable {

    
    private CategoriaTO mcategoria;
    private ICategoriaDAO categoriaDAO;
    private List<CategoriaTO> listacategoria;
    private List<String> listacategorianombre; 
    
   
    @PostConstruct
    private void init() {
        initInstancia();
        initlistDep();
    }

    private void initInstancia() {
        this.mcategoria = new CategoriaTO();
        this.categoriaDAO = DAOFactory.getInstance().getCategoriaDAO();
        this.listacategoria = new ArrayList();
        this.listacategorianombre = new ArrayList();    }

    private void initlistDep() {
        this.listacategoria = categoriaDAO.listaCategoria();
        System.out.println("aqui si llega");
        listanombrescategorias();
    }
    
    public void listanombrescategorias(){
        for (CategoriaTO nomcategoria : this.listacategoria) {
                String nom = nomcategoria.getNombre();
                this.listacategorianombre.add(nom);
            //System.out.println(nomcategoria);
        }
    }
    
    public String registrarCate() {

        try {
            this.mcategoria = new CategoriaTO();
            String respuesta;

            int countReg = categoriaDAO.ContadorDeRegCategoria();
            int idCate = 0;
            if (countReg != 0) {
                idCate = countReg + 1;
            } else {
                idCate = 1;
            }

            this.mcategoria.setCodigoCategoria(idCate);

            respuesta = categoriaDAO.insertCategoria(mcategoria);

            if (respuesta.equals("correcto")) {
                messageInfo("Se realizo la creación de la Categoria");
            } else {
                messageError("NO Se realizo la creación de la Categoria");
            }
        } catch (Exception ex) {

            messageFatal("Error Fatal: Por favor contacte con su administrador" + ex.getMessage());

            return null;
        }

        return "/formularios/Frmagregar";
    }

    
    
     

    public CategoriaTO getMcategoria() {
        return mcategoria;
    }

    public void setMcategoria(CategoriaTO mcategoria) {
        this.mcategoria = mcategoria;
    }

    public List<CategoriaTO> getListacategoria() {
        return listacategoria;
    }

    public void setListacategoria(List<CategoriaTO> listacategoria) {
        this.listacategoria = listacategoria;
    }

    public List<String> getListacategorianombre() {
        return listacategorianombre;
    }

    public void setListacategorianombre(List<String> listacategorianombre) {
        this.listacategorianombre = listacategorianombre;
    }

    public ICategoriaDAO getCategoriaDAO() {
        return categoriaDAO;
    }

    public void setCategoriaDAO(ICategoriaDAO categoriaDAO) {
        this.categoriaDAO = categoriaDAO;
    }
    
    

        
    

}
