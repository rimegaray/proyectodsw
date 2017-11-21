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
import static com.mongodb.client.model.Filters.eq;
import com.sium.dao.design.IMaquinariaDAO;
import com.sium.dao.to.MaquinariaTO;
import com.sium.mongo.AccesoMongoDB;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;

/**
 *
 * @author Aisac
 */
public class MaquinariaDAO implements IMaquinariaDAO {

    private final MongoClient db;
    private MongoDatabase database;
    private MongoCollection<Document> collection;

    public MaquinariaDAO() {
        this.db = AccesoMongoDB.getAccesoSingleton();
        database = db.getDatabase("sium");
    }

    @Override
    public boolean eliminarMaquinaria(String codigoMaquinaria) {
        try {
            collection = database.getCollection("maquinarias");
            collection.deleteOne(eq("codigoMaquinaria", codigoMaquinaria));
            return true;
        } catch (MongoException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public String insertMaquinaria(MaquinariaTO maquinaria) {
        try {
            collection = database.getCollection("maquinarias");
            Document jMaquinaria = new Document().append("codigoMaquinaria", maquinaria.getCodigoMaquinaria())
                    .append("nombreMaquinaria", maquinaria.getNombre())
                    .append("categoria", maquinaria.getCategoria());
            collection.insertOne(jMaquinaria);
            return "correcto";
        } catch (MongoException e) {
            System.out.println(e.getMessage());
            return "fallo";
        }
    }

    @Override
    public List<MaquinariaTO> listaMaquinaria() {
        List<MaquinariaTO> listaMaquinarias = new ArrayList<>();
        try {
            collection = database.getCollection("maquinarias");
            FindIterable<Document> findIterable = collection.find(new Document());
            if (findIterable.first() != null) {
                for (Document dMaquinaria : findIterable) {
                    MaquinariaTO maquinaria = new MaquinariaTO();
                    maquinaria.setCodigoMaquinaria(dMaquinaria.getInteger("codigoMaquinaria"));
                    maquinaria.setNombre(dMaquinaria.getString("nombreMaquinaria"));
                    maquinaria.setCategoria(dMaquinaria.getString("categoria"));
                    listaMaquinarias.add(maquinaria);
                }
            } else {
                System.out.println("No existe maquinarias");
            }
        } catch (MongoException e) {
            System.out.println(e.getMessage());
        }
        return listaMaquinarias;
    }

    @Override
    public int ContadorDeRegMaquinaria() {
        long cantidadMaquinaria;
        int cantMaq = 0;
        try {
            collection = database.getCollection("maquinarias");
            cantidadMaquinaria = collection.count();
            cantMaq = (int) cantidadMaquinaria;
        } catch (MongoException e) {
            System.out.println(e.getMessage());
        }
        return cantMaq;
    }

}
