/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sium.dao.design;

import com.sium.dao.to.TiempoMaquinariaTO;

/**
 *
 * @author Aisac
 */
public interface ITiempoMaquinariaDAO {
    abstract String insertarTiempoMaquinaria(TiempoMaquinariaTO tiempoMaquinaria);
    abstract String actualizarTiempoMaquinaria(TiempoMaquinariaTO tiempoMaquinaria);
    public TiempoMaquinariaTO obtenerTiempoMaquinaria(Integer codigoMaquinaria);
}
