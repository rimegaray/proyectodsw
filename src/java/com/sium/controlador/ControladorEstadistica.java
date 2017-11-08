/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sium.controlador;

import com.sium.dao.dao.DAOFactory;
import com.sium.dao.design.IRegistroDAO;
import com.sium.dao.design.ITiempoMaquinariaDAO;
import com.sium.estadistica.Estadistica;
import com.sium.estadistica.Paquete;

/**
 *
 * @author Aisac
 */
public class ControladorEstadistica {

    private Estadistica estadistica;

    public ControladorEstadistica(Paquete paquete) {
        this.estadistica = new Estadistica(paquete);
        estadistica.calcularDuracion();
        estadistica.calcularPorcentajeUtilizacion();
    }

    public void guardarRegistro() {
        IRegistroDAO registroDAO = DAOFactory.getInstance().getRegistroDAO();
        registroDAO.insertRegistro(estadistica.getRegistro());
    }

    public void guardarTiempoMaquinaria() {
        ITiempoMaquinariaDAO tiempoMaquinariaDAO = DAOFactory.getInstance().getTiempoMaquinariaDAO();
        tiempoMaquinariaDAO.insertarTiempoMaquinaria(estadistica.getTiempoMaquinaria());
    }

}
