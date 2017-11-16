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
import com.sium.dao.component.TiempoMaquinariaDAO;
import com.sium.dao.to.CategoriaTO;
import com.sium.dao.to.MaquinariaTO;
import com.sium.dao.to.RegistroTO;
import com.sium.dao.to.TiempoMaquinariaTO;
import com.sium.mqtt.SubscribeCallback;
import com.sium.mqtt.Subscriber;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import org.primefaces.context.RequestContext;

/**
 *
 * @author RAUL
 */
@ManagedBean
@SessionScoped
public class RegistroMBR extends MensajeSYSUtils implements Serializable {

    private RegistroDAO registrodao;
    private RegistroTO mregistro;
    private List<RegistroTO> listaregistro;
    private TiempoMaquinariaDAO tiempomaquidao;
    private TiempoMaquinariaTO mtiempomaqui;

    private String nombre;
    private String categoria;
    private Integer tiempouso;
    private Integer tiemponouso;
    private Integer codigoMaquinaria;
    private int number;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

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
        this.tiempomaquidao = new TiempoMaquinariaDAO();
        this.mtiempomaqui = new TiempoMaquinariaTO();
        
    }

    private void initlistDep() {

    }

    public void verDetalles(Integer codigo) {
        
        System.out.println("este es mi codigo"+codigo);
        
        mtiempomaqui = tiempomaquidao.obtenerTiempoMaquinaria(codigo);
        int tiempototal = mtiempomaqui.getTiempoUso()+mtiempomaqui.getTiempoNoUso();
        System.out.println("askjaksks"+tiempototal);
        this.tiempouso = mtiempomaqui.getTiempoUso()*100/tiempototal;
        
        this.tiemponouso = mtiempomaqui.getTiempoNoUso()*100/tiempototal;
        
        System.out.println(tiempouso);
        System.out.println(tiemponouso);

    }

    public void cargarImagen(){
        
    }
    
    public String calcularFechas() {

        try {

            int N = this.listaregistro.size();
            String varnomb = null;
            String varsacado = "";
            for (int i = 0; i < N; i++) {
                RegistroTO Obj = new RegistroTO();
                Obj = this.listaregistro.get(i);

//                BigDecimal duracion = Obj.getVarDuracion();
//
//                double duraConv = duracion.doubleValue();
                varnomb = Obj.getFecha();
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
    
    public String increment() {
        number++;
        System.out.println(number);
        if(number == 3){
            return "FrmHistorialPorcentaje";
        }
        return null;
    }

    public String calcularPorcentaje() {

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
    
    public TiempoMaquinariaDAO getTiempomaquidao() {
        return tiempomaquidao;
    }

    public void setTiempomaquidao(TiempoMaquinariaDAO tiempomaquidao) {
        this.tiempomaquidao = tiempomaquidao;
    }

    public TiempoMaquinariaTO getMtiempomaqui() {
        return mtiempomaqui;
    }

    public void setMtiempomaqui(TiempoMaquinariaTO mtiempomaqui) {
        this.mtiempomaqui = mtiempomaqui;
    }

    public Integer getTiempouso() {
        return tiempouso;
    }

    public void setTiempouso(Integer tiempouso) {
        this.tiempouso = tiempouso;
    }

    public Integer getTiemponouso() {
        return tiemponouso;
    }

    public void setTiemponouso(Integer tiemponouso) {
        this.tiemponouso = tiemponouso;
    }
    
}
