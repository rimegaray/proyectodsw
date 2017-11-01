/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.proydsw.service;

import com.pe.proydsw.entidades.Categoria;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Juan Carlos
 */
public interface CategoriaService {
    
    public abstract List<Categoria> ListadoCategoriaTodos(Session session) throws Exception;
    public abstract Categoria ListadoCategoriaxId(Session session,int IdCate);   
    public abstract boolean GrabarCategoria(Categoria carg);
    public abstract boolean ActualizarCategoria(Session session,Categoria cate);
    
    public Integer ContadorDeRegCategoria(Session session) throws Exception;
    
}
