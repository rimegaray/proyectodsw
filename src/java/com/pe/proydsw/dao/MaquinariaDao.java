/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.proydsw.dao;

import com.pe.proydsw.entidades.Categoria;
import com.pe.proydsw.entidades.Maquinaria;
import com.pe.proydsw.service.CategoriaService;
import com.pe.proydsw.service.MaquinariaService;
import com.pe.proydsw.utils.HibernateUtil;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Juan Carlos
 */
public class MaquinariaDao implements MaquinariaService{
    
    private Session session;

    @Override
    public List<Maquinaria> ListadoMaquinariaTodos(Session session) throws Exception {
        String hql = " from Maquinaria";        
        Query query = session.createQuery(hql);
        List<Maquinaria> listaTCP= (List<Maquinaria>) query.list();
        
        return listaTCP;
    }

    @Override
    public Maquinaria ListadoMaquinariaxId(Session session, int IdCate) {
        return (Maquinaria) session.get(Maquinaria.class, IdCate);
    }

    @Override
    public boolean GrabarMaquinaria(Maquinaria carg) {
        
        boolean resp = false;
        session=HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();
        try {
            session.save(carg);
            transaction.commit();
            resp = true;
        } catch (Exception e) {
            session.close();
            resp = false;
        }
        
        return resp;
    }

    @Override
    public boolean ActualizarMaquinaria(Session session, Maquinaria maq) {
        
            boolean resp = false;
        try {
            session.update(maq);
            resp = true;
        } catch (Exception e) {
            resp = false;
        }
        
        return resp;
    }

    @Override
    public Integer ContadorDeRegMaquinaria(Session session) throws Exception {
        String hql = "select count(*) from Maquinaria";
        Query query = session.createQuery(hql);
        Long FilasTab=(Long) query.uniqueResult();
        Integer cont=FilasTab.intValue();
        return cont;
    }

    
}
