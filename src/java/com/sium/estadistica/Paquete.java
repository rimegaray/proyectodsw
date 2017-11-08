/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sium.estadistica;

/**
 *
 * @author Aisac
 */
public class Paquete {

    private String codigoMaquinaria;
    private String horaInicio;
    private String horaFin;
    private Integer turno;

    public Paquete() {
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
    public Integer getTurno() {
        return turno;
    }

    /**
     * @param turno the turno to set
     */
    public void setTurno(Integer turno) {
        this.turno = turno;
    }

    @Override
    public String toString() {
        return "Paquete{" + "codigoMaquinaria=" + codigoMaquinaria + ", horaInicio=" + horaInicio + ", horaFin=" + horaFin + ", turno=" + turno + '}';
    }

}
