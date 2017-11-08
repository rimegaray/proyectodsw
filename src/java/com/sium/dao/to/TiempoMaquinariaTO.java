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
    private String codigoMaquinaria;
    private String fecha;
    private Integer tiempoNoUso;
    private Integer tiempoUso;
    private int turno;

    public TiempoMaquinariaTO() {
    }

    
    /**
     * @return the codigoMaquinaria
     */
    public String getCodigoMaquinaria() {
        return codigoMaquinaria;
    }

    /**
     * @param codigoMaquinaria the codigoMaquinaria to set
     */
    public void setCodigoMaquinaria(String codigoMaquinaria) {
        this.codigoMaquinaria = codigoMaquinaria;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the tiempoNoUso
     */
    public Integer getTiempoNoUso() {
        return tiempoNoUso;
    }

    /**
     * @param tiempoNoUso the tiempoNoUso to set
     */
    public void setTiempoNoUso(Integer tiempoNoUso) {
        this.tiempoNoUso = tiempoNoUso;
    }

    /**
     * @return the tiempoUso
     */
    public Integer getTiempoUso() {
        return tiempoUso;
    }

    /**
     * @param tiempoUso the tiempoUso to set
     */
    public void setTiempoUso(Integer tiempoUso) {
        this.tiempoUso = tiempoUso;
    }

    /**
     * @return the turno
     */
    public int getTurno() {
        return turno;
    }

    /**
     * @param turno the turno to set
     */
    public void setTurno(int turno) {
        this.turno = turno;
    }

    @Override
    public String toString() {
        return "TiempoMaquinariaTO{" + "codigoMaquinaria=" + codigoMaquinaria + ", fecha=" + fecha + ", tiempoNoUso=" + tiempoNoUso + ", tiempoUso=" + tiempoUso + ", turno=" + turno + '}';
    }

    
}
