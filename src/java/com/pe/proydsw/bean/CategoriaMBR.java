/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.proydsw.bean;

import com.pe.proydsw.utils.MensajeSYSUtils;
import com.sium.dao.component.CategoriaDAO;
import com.sium.dao.component.MaquinariaDAO;
import com.sium.dao.to.CategoriaTO;
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
public class CategoriaMBR extends MensajeSYSUtils implements Serializable {

    private CategoriaDAO categoriadao;
    private CategoriaTO mcategoria;
    private List<CategoriaTO> listacategoria;

    public CategoriaDAO getCategoriadao() {
        return categoriadao;
    }

    public void setCategoriadao(CategoriaDAO categoriadao) {
        this.categoriadao = categoriadao;
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

    @PostConstruct
    private void init() {
        initInstancia();
        initlistDep();

    }

    private void initInstancia() {
        this.mcategoria = new CategoriaTO();

        this.categoriadao = new CategoriaDAO();
        this.listacategoria = new ArrayList();

    }

    private void initlistDep() {
        
        this.listacategoria = categoriadao.listaCategoria();
    }

    public String registrarCate() {

        try {
            this.mcategoria = new CategoriaTO();
            String respuesta;

            int countReg = categoriadao.ContadorDeRegCategoria();
            int idCate = 0;
            if (countReg != 0) {
                idCate = countReg + 1;
            } else {
                idCate = 1;
            }

            this.mcategoria.setCodigoCategoria(idCate);

            respuesta = categoriadao.insertCategoria(mcategoria);

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

    public String limpiarcajas() {
        return "/FORMULARIOS/FrmManttoNivel";
    }

    

}
