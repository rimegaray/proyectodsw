package com.pe.proydsw.entidades;
// Generated 01-nov-2017 12:41:01 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Turno generated by hbm2java
 */
public class Turno  implements java.io.Serializable {


     private int intIdTurno;
     private String varNombreTurno;
     private String varInicioTurno;
     private String varFinTurno;
     private Set tiempomaquinarias = new HashSet(0);
     private Set registros = new HashSet(0);
     private Set paradas = new HashSet(0);

    public Turno() {
    }

	
    public Turno(int intIdTurno, String varNombreTurno, String varInicioTurno, String varFinTurno) {
        this.intIdTurno = intIdTurno;
        this.varNombreTurno = varNombreTurno;
        this.varInicioTurno = varInicioTurno;
        this.varFinTurno = varFinTurno;
    }
    public Turno(int intIdTurno, String varNombreTurno, String varInicioTurno, String varFinTurno, Set tiempomaquinarias, Set registros, Set paradas) {
       this.intIdTurno = intIdTurno;
       this.varNombreTurno = varNombreTurno;
       this.varInicioTurno = varInicioTurno;
       this.varFinTurno = varFinTurno;
       this.tiempomaquinarias = tiempomaquinarias;
       this.registros = registros;
       this.paradas = paradas;
    }
   
    public int getIntIdTurno() {
        return this.intIdTurno;
    }
    
    public void setIntIdTurno(int intIdTurno) {
        this.intIdTurno = intIdTurno;
    }
    public String getVarNombreTurno() {
        return this.varNombreTurno;
    }
    
    public void setVarNombreTurno(String varNombreTurno) {
        this.varNombreTurno = varNombreTurno;
    }
    public String getVarInicioTurno() {
        return this.varInicioTurno;
    }
    
    public void setVarInicioTurno(String varInicioTurno) {
        this.varInicioTurno = varInicioTurno;
    }
    public String getVarFinTurno() {
        return this.varFinTurno;
    }
    
    public void setVarFinTurno(String varFinTurno) {
        this.varFinTurno = varFinTurno;
    }
    public Set getTiempomaquinarias() {
        return this.tiempomaquinarias;
    }
    
    public void setTiempomaquinarias(Set tiempomaquinarias) {
        this.tiempomaquinarias = tiempomaquinarias;
    }
    public Set getRegistros() {
        return this.registros;
    }
    
    public void setRegistros(Set registros) {
        this.registros = registros;
    }
    public Set getParadas() {
        return this.paradas;
    }
    
    public void setParadas(Set paradas) {
        this.paradas = paradas;
    }




}


