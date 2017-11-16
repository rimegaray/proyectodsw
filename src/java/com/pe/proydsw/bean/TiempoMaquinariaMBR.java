/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.proydsw.bean;

import com.pe.proydsw.utils.MensajeSYSUtils;
import com.sium.dao.dao.DAOFactory;
import com.sium.dao.design.ITiempoMaquinariaDAO;
import com.sium.dao.to.TiempoMaquinariaTO;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author RAUL
 */
@ManagedBean
@SessionScoped
public class TiempoMaquinariaMBR extends MensajeSYSUtils  {

    
    private  ITiempoMaquinariaDAO tiempomaquidao;
    private TiempoMaquinariaTO mtiempomaqui;

    private Integer tiempouso;
    private Integer tiemponouso;

    

    @PostConstruct
    private void init() {
        initInstancia();

    }

    private void initInstancia() {
        
        this.mtiempomaqui = new TiempoMaquinariaTO();
        
    }


    public void verDetalles(Integer codigo) {
        
        
        tiempomaquidao = DAOFactory.getInstance().getTiempoMaquinariaDAO();
        mtiempomaqui = tiempomaquidao.obtenerTiempoMaquinaria(codigo);
        int tiempototal = mtiempomaqui.getTiempoUso()+mtiempomaqui.getTiempoNoUso();
        
        this.tiempouso = mtiempomaqui.getTiempoUso()*100/tiempototal;
        
        this.tiemponouso = mtiempomaqui.getTiempoNoUso()*100/tiempototal;
        

    }


    public ITiempoMaquinariaDAO getTiempomaquidao() {
        return tiempomaquidao;
    }

    public void setTiempomaquidao(ITiempoMaquinariaDAO tiempomaquidao) {
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
