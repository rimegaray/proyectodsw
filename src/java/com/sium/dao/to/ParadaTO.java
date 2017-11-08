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
public class ParadaTO {
    private String codigoMaquinaria;
    private String fecha;
    private String horaInicio;
    private String horaFin;
    private int turno;

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
     * @return the horaInicio
     */
    public String getHoraInicio() {
        return horaInicio;
    }

    /**
     * @param horaInicio the horaInicio to set
     */
    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    /**
     * @return the horaFin
     */
    public String getHoraFin() {
        return horaFin;
    }

    /**
     * @param horaFin the horaFin to set
     */
    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
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
    
}
