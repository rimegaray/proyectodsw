package com.pe.proydsw.entidades;
// Generated 01-nov-2017 11:12:33 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Categoria generated by hbm2java
 */
public class Categoria  implements java.io.Serializable {


     private int intIdCategoria;
     private String varNombreCategoria;
     private Set maquinarias = new HashSet(0);

    public Categoria() {
    }

	
    public Categoria(int intIdCategoria, String varNombreCategoria) {
        this.intIdCategoria = intIdCategoria;
        this.varNombreCategoria = varNombreCategoria;
    }
    public Categoria(int intIdCategoria, String varNombreCategoria, Set maquinarias) {
       this.intIdCategoria = intIdCategoria;
       this.varNombreCategoria = varNombreCategoria;
       this.maquinarias = maquinarias;
    }
   
    public int getIntIdCategoria() {
        return this.intIdCategoria;
    }
    
    public void setIntIdCategoria(int intIdCategoria) {
        this.intIdCategoria = intIdCategoria;
    }
    public String getVarNombreCategoria() {
        return this.varNombreCategoria;
    }
    
    public void setVarNombreCategoria(String varNombreCategoria) {
        this.varNombreCategoria = varNombreCategoria;
    }
    public Set getMaquinarias() {
        return this.maquinarias;
    }
    
    public void setMaquinarias(Set maquinarias) {
        this.maquinarias = maquinarias;
    }




}


