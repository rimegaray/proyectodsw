package com.pe.proydsw.entidades;
// Generated 01-nov-2017 11:12:33 by Hibernate Tools 4.3.1



/**
 * Parada generated by hbm2java
 */
public class Parada  implements java.io.Serializable {


     private int intIdParada;
     private Maquinaria maquinaria;
     private Turno turno;
     private String varFecha;
     private String varHoraInicio;
     private String varHoraFin;

    public Parada() {
    }

	
    public Parada(int intIdParada, Maquinaria maquinaria, Turno turno, String varFecha, String varHoraInicio) {
        this.intIdParada = intIdParada;
        this.maquinaria = maquinaria;
        this.turno = turno;
        this.varFecha = varFecha;
        this.varHoraInicio = varHoraInicio;
    }
    public Parada(int intIdParada, Maquinaria maquinaria, Turno turno, String varFecha, String varHoraInicio, String varHoraFin) {
       this.intIdParada = intIdParada;
       this.maquinaria = maquinaria;
       this.turno = turno;
       this.varFecha = varFecha;
       this.varHoraInicio = varHoraInicio;
       this.varHoraFin = varHoraFin;
    }
   
    public int getIntIdParada() {
        return this.intIdParada;
    }
    
    public void setIntIdParada(int intIdParada) {
        this.intIdParada = intIdParada;
    }
    public Maquinaria getMaquinaria() {
        return this.maquinaria;
    }
    
    public void setMaquinaria(Maquinaria maquinaria) {
        this.maquinaria = maquinaria;
    }
    public Turno getTurno() {
        return this.turno;
    }
    
    public void setTurno(Turno turno) {
        this.turno = turno;
    }
    public String getVarFecha() {
        return this.varFecha;
    }
    
    public void setVarFecha(String varFecha) {
        this.varFecha = varFecha;
    }
    public String getVarHoraInicio() {
        return this.varHoraInicio;
    }
    
    public void setVarHoraInicio(String varHoraInicio) {
        this.varHoraInicio = varHoraInicio;
    }
    public String getVarHoraFin() {
        return this.varHoraFin;
    }
    
    public void setVarHoraFin(String varHoraFin) {
        this.varHoraFin = varHoraFin;
    }




}

