/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sium.dao.design;

import com.sium.dao.to.CategoriaTO;
import java.util.List;

/**
 *
 * @author Aisac
 */
public interface ICategoriaDAO {
    abstract public boolean eliminarCategoria(String codigoCategoria);
    abstract public String insertCategoria(CategoriaTO categoria);
    abstract public List<CategoriaTO> listaCategoria();
    abstract public int ContadorDeRegCategoria();
}
