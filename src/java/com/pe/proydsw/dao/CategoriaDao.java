/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.proydsw.dao;

import com.pe.proydsw.entidades.Categoria;
import com.pe.proydsw.service.CategoriaService;
import com.pe.proydsw.utils.HibernateUtil;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Juan Carlos
 */
public class CategoriaDao implements CategoriaService{
    
    private Session session;

    @Override
    public List<Categoria> ListadoCategoriaTodos(Session session) throws Exception {
        String hql = " from Categoria";        
        Query query = session.createQuery(hql);
        List<Categoria> listaTCP= (List<Categoria>) query.list();
        
        return listaTCP;
    }

    @Override
    public Categoria ListadoCategoriaxId(Session session, int IdCate) {
        return (Categoria) session.get(Categoria.class, IdCate);
    }

    @Override
    public boolean GrabarCategoria(Categoria carg) {
        
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
    public boolean ActualizarCategoria(Session session, Categoria cate) {
        
            boolean resp = false;
        try {
            session.update(cate);
            resp = true;
        } catch (Exception e) {
            resp = false;
        }
        
        return resp;
    }

    @Override
    public Integer ContadorDeRegCategoria(Session session) throws Exception {
        String hql = "select count(*) from Categoria";
        Query query = session.createQuery(hql);
        Long FilasTab=(Long) query.uniqueResult();
        Integer cont=FilasTab.intValue();
        return cont;
    }

    
}
