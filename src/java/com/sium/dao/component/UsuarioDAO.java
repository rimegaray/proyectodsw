/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sium.dao.component;

import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import com.sium.dao.design.IUsuarioDAO;
import com.sium.dao.to.UsuarioTO;
import com.sium.mongo.AccesoMongoDB;
import org.bson.Document;

/**
 *
 * @author Aisac
 */
public class UsuarioDAO implements IUsuarioDAO {

    private final MongoClient db;
    private MongoDatabase database;
    private MongoCollection<Document> collection;

    public UsuarioDAO() {
        this.db = AccesoMongoDB.getAccesoSingleton();
        database = db.getDatabase("sium");
    }

    @Override
    public boolean validarUsuario(UsuarioTO usuario) {
        try {
            collection = database.getCollection("usuario");
            FindIterable<Document> findIterable = collection.find(
                    and(
                            eq("usuario", usuario.getUsuario()),
                            eq("password", usuario.getPassword())
                    )
            );
            return findIterable != null;
        } catch (MongoException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

}
