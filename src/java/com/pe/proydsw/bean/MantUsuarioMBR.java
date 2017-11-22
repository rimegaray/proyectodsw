/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.proydsw.bean;

import com.pe.proydsw.utils.MensajeSYSUtils;
import com.sium.dao.component.UsuarioDAO;
import com.sium.dao.to.UsuarioTO;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author CARLOS
 */
@ManagedBean
//@SessionScoped
@ViewScoped
public class MantUsuarioMBR extends MensajeSYSUtils {

    private UsuarioDAO usuariodao;
    private UsuarioTO musuario;

    public UsuarioTO getMusuario() {
        return musuario;
    }

    public void setMusuario(UsuarioTO musuario) {
        this.musuario = musuario;
    }

    @PostConstruct
    private void init() {
        initInstancia();
    }

    private void initInstancia() {

        this.musuario = new UsuarioTO();
        this.usuariodao = new UsuarioDAO();
    }

    public String ingresoSistema() {

        boolean validado = false;

        try {

            validado = usuariodao.validarUsuario(musuario);

            if (validado == true) {
                System.out.println("EXISTE");

                return "FrmListado";

            } else {
                messageError("Usuario o contraseña incorrecto");
                this.musuario = new UsuarioTO();

                return "index";
            }

        } catch (Exception e) {
            System.out.println("error" + e);
        }

        messageInfo("No existe el Usuario ");
        return "index";
    }

}
