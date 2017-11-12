/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sium.dao.design;

import com.sium.dao.to.ParadaTO;
import java.util.List;

/**
 *
 * @author Aisac
 */
public interface IParadaDAO {
    abstract public String insertarParada(ParadaTO parada);
    abstract public List<ParadaTO> listaParadas(int turno, Integer codigoMaquinaria, String fecha);
}
