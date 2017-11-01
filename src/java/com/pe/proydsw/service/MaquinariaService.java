/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.proydsw.service;

import com.pe.proydsw.entidades.Categoria;
import com.pe.proydsw.entidades.Maquinaria;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Juan Carlos
 */
public interface MaquinariaService {
    
    public abstract List<Maquinaria> ListadoMaquinariaTodos(Session session) throws Exception;
    public abstract Maquinaria ListadoMaquinariaxId(Session session,int IdCate);   
    public abstract boolean GrabarMaquinaria(Maquinaria maq);
    public abstract boolean ActualizarMaquinaria(Session session,Maquinaria cate);
    
    public Integer ContadorDeRegMaquinaria(Session session) throws Exception;
    
}
