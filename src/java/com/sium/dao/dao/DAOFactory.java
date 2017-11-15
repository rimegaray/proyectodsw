/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sium.dao.dao;

import com.sium.dao.component.CategoriaDAO;
import com.sium.dao.component.MaquinariaDAO;
import com.sium.dao.component.ParadaDAO;
import com.sium.dao.component.RegistroDAO;
import com.sium.dao.component.TiempoMaquinariaDAO;
import com.sium.dao.component.UsuarioDAO;
import com.sium.dao.design.ICategoriaDAO;
import com.sium.dao.design.IMaquinariaDAO;
import com.sium.dao.design.IParadaDAO;
import com.sium.dao.design.IRegistroDAO;
import com.sium.dao.design.ITiempoMaquinariaDAO;
import com.sium.dao.design.IUsuarioDAO;

/**
 *
 * @author Aisac
 */
public class DAOFactory {
    private static DAOFactory daoFac;
    
    static{
        daoFac = new DAOFactory();
    }
    
    public static DAOFactory getInstance(){
        return daoFac;
    }
    
    
    
    public IParadaDAO getParadaDAO(){
        return new ParadaDAO();
    }
    
    public IRegistroDAO getRegistroDAO(){
        return new RegistroDAO();
    }
    
    public ITiempoMaquinariaDAO getTiempoMaquinariaDAO(){
        return new TiempoMaquinariaDAO();
    }
    
    public IUsuarioDAO getUsuarioDAO(){
        return new UsuarioDAO();
    }
    
    public IMaquinariaDAO getMaquinariaDAO(){
        return new MaquinariaDAO();
    }
    
    public ICategoriaDAO getCategoriaDAO(){
        return new CategoriaDAO();
    }
}
