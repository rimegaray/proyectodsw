/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sium.dao.to;

/**
 *
 * @author Aisac
 */
public class TiempoMaquinariaTO {
    private Integer codigoMaquinaria;
    private String fecha;
    private Integer tiempoNoUso;
    private Integer tiempoUso;
    private Integer turno;

    public TiempoMaquinariaTO() {
    }

    public Integer getCodigoMaquinaria() {
        return codigoMaquinaria;
    }

    public void setCodigoMaquinaria(Integer codigoMaquinaria) {
        this.codigoMaquinaria = codigoMaquinaria;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Integer getTiempoNoUso() {
        return tiempoNoUso;
    }

    public void setTiempoNoUso(Integer tiempoNoUso) {
        this.tiempoNoUso = tiempoNoUso;
    }

    public Integer getTiempoUso() {
        return tiempoUso;
    }

    public void setTiempoUso(Integer tiempoUso) {
        this.tiempoUso = tiempoUso;
    }

    public Integer getTurno() {
        return turno;
    }

    public void setTurno(Integer turno) {
        this.turno = turno;
    }

    
    

    @Override
    public String toString() {
        return "TiempoMaquinariaTO{" + "codigoMaquinaria=" + codigoMaquinaria + ", fecha=" + fecha + ", tiempoNoUso=" + tiempoNoUso + ", tiempoUso=" + tiempoUso + ", turno=" + turno + '}';
    }

    
}
