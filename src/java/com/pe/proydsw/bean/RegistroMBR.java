/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.proydsw.bean;

import com.pe.proydsw.utils.MensajeSYSUtils;
import com.sium.dao.component.CategoriaDAO;
import com.sium.dao.component.MaquinariaDAO;
import com.sium.dao.component.RegistroDAO;
import com.sium.dao.to.CategoriaTO;
import com.sium.dao.to.MaquinariaTO;
import com.sium.dao.to.RegistroTO;
import com.sium.mqtt.SubscribeCallback;
import com.sium.mqtt.Subscriber;
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
public class RegistroMBR extends MensajeSYSUtils implements Serializable {

    private RegistroDAO registrodao;
    private RegistroTO mregistro;
    private List<RegistroTO> listaregistro;

    public RegistroDAO getRegistrodao() {
        return registrodao;
    }

    public void setRegistrodao(RegistroDAO registrodao) {
        this.registrodao = registrodao;
    }

    public RegistroTO getMregistro() {
        return mregistro;
    }

    public void setMregistro(RegistroTO mregistro) {
        this.mregistro = mregistro;
    }

    public List<RegistroTO> getListaregistro() {
        return listaregistro;
    }

    public void setListaregistro(List<RegistroTO> listaregistro) {
        this.listaregistro = listaregistro;
    }

   

    @PostConstruct
    private void init() {
        initInstancia();
        initlistDep();

    }

    private void initInstancia() {
        this.mregistro = new RegistroTO();
        this.registrodao = new RegistroDAO();
        this.listaregistro = new ArrayList();

    }

    private void initlistDep() {
        
        
    }

    public String verDetalles(MaquinariaTO item){
        
        this.listaregistro = registrodao.listaRegistroxId(item.getCodigoMaquinaria());
    
        return "formularios/FrmHistorialPorcentaje";
    }
    

    public String CalcularActividades() {
        
        try {

            int N = this.listaregistro.size();
            Double varnomb = null;
            String varsacado = "";
            for (int i = 0; i < N; i++) {
                RegistroTO Obj = new RegistroTO();
                Obj = this.listaregistro.get(i);

//                BigDecimal duracion = Obj.getVarDuracion();
//
//                double duraConv = duracion.doubleValue();
                varnomb = Obj.getPorcentajeUtilizacion();
                varsacado += "'" + varnomb + "',";
//                varsacado+="'" + varnomb+ "',";

            }
            String vFinal = varsacado;
//            System.out.println("lll="+vFinal);
            return vFinal;

        } catch (Exception ex) {
            System.out.println("ERROR funcion cal:" + ex.getMessage());
            
            return null;
//            messageFatal("Por favor contacte con su administrador" + ex.getMessage());

        }
    }
    

}
