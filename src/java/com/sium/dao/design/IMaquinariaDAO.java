/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sium.dao.design;

import com.sium.dao.to.MaquinariaTO;
import java.util.List;

/**
 *
 * @author Aisac
 */
public interface IMaquinariaDAO {
    abstract public boolean eliminarMaquinaria(String codigoMaquinaria);
    abstract public String insertMaquinaria(MaquinariaTO maquinaria);
    abstract public List<MaquinariaTO> listaMaquinaria();
    abstract public int ContadorDeRegMaquinaria();
}
