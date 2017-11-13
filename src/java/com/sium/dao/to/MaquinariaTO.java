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

public class MaquinariaTO {
    private String categoria;
    private String nombre;
    private Integer codigoMaquinaria;
    private int estado;
    
    /**
     * @return the categoria
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCodigoMaquinaria() {
        return codigoMaquinaria;
    }

    public void setCodigoMaquinaria(Integer codigoMaquinaria) {
        this.codigoMaquinaria = codigoMaquinaria;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    

    
    

    
}
