/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sium.dao.design;

import com.sium.dao.to.RegistroTO;
import java.util.List;

/**
 *
 * @author Aisac
 */
public interface IRegistroDAO {
    abstract public  String insertRegistro(RegistroTO registro);
    abstract public List<RegistroTO> listaRegistro(int turno, Integer codigoMaquinaria, String fecha);
    abstract public List<RegistroTO> listaRegistroxId( Integer codigoMaquinaria);
}
