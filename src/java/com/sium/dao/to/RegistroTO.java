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
public class RegistroTO {

    private Integer codigoMaquinaria;
    private String fecha;
    private String horaInicio;
    private String horaFin;
    private Double porcentajeUtilizacion;
    private int turno;

    public RegistroTO() {
    }

    public Integer getCodigoMaquinaria() {
        return codigoMaquinaria;
    }

    
    public void setCodigoMaquinaria(Integer codigoMaquinaria) {    
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
     * @return the porcentajeUtilizacion
     */
    public Double getPorcentajeUtilizacion() {
        return porcentajeUtilizacion;
    }

    /**
     * @param porcentajeUtilizacion the porcentajeUtilizacion to set
     */
    public void setPorcentajeUtilizacion(Double porcentajeUtilizacion) {
        this.porcentajeUtilizacion = porcentajeUtilizacion;
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
        return "RegistroTO{" + "codigoMaquinaria=" + codigoMaquinaria + ", fecha=" + fecha + ", horaInicio=" + horaInicio + ", horaFin=" + horaFin + ", porcentajeUtilizacion=" + porcentajeUtilizacion + ", turno=" + turno + '}';
    }

}
