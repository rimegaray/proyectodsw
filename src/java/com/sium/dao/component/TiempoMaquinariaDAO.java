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
import static com.mongodb.client.model.Updates.combine;
import static com.mongodb.client.model.Updates.set;
import com.sium.dao.design.ITiempoMaquinariaDAO;
import com.sium.dao.to.TiempoMaquinariaTO;


import com.sium.mongo.AccesoMongoDB;
import org.bson.Document;

/**
 *
 * @author Aisac
 */
public class TiempoMaquinariaDAO implements ITiempoMaquinariaDAO {

    private final MongoClient db;
    private MongoDatabase database;
    private MongoCollection<Document> collection;

    public TiempoMaquinariaDAO() {
        this.db = AccesoMongoDB.getAccesoSingleton();
        database = db.getDatabase("sium");
    }

    @Override
    public String insertarTiempoMaquinaria(TiempoMaquinariaTO tiempoMaquinaria) {
        try {
            collection = database.getCollection("tiempoMaquinaria");
            Document jTiempoMaquinaria = new Document().append("codigoMaquinaria", tiempoMaquinaria.getCodigoMaquinaria())
                    .append("idTurno", tiempoMaquinaria.getTurno())
                    .append("fecha", tiempoMaquinaria.getFecha())
                    .append("tiempoUso", tiempoMaquinaria.getTiempoUso())
                    .append("tiempoNoUso", tiempoMaquinaria.getTiempoNoUso());
            collection.insertOne(jTiempoMaquinaria);
            return "correcto";
        } catch (MongoException e) {
            System.out.println(e.getMessage());
            return "fallo";
        }
    }

    @Override
    public String actualizarTiempoMaquinaria(TiempoMaquinariaTO tiempoMaquinaria) {
        String rpta = "";
        collection = database.getCollection("tiempoMaquinaria");
        FindIterable<Document> findIterable = collection.find(
                and(
                        eq("codigoMaquinaria", tiempoMaquinaria.getCodigoMaquinaria()),
                        eq("idTurno", tiempoMaquinaria.getTurno()),
                        eq("fecha", tiempoMaquinaria.getFecha())
                )
        );
        String objectid = findIterable.first().getString("_id");
        collection.updateOne(
                eq("_id", objectid),
                combine(
                        set("tiempoUso", tiempoMaquinaria.getTiempoUso()),
                        set("tiempoNoUso",tiempoMaquinaria.getTiempoNoUso())
                )
        );
        return rpta;
    }
    
    @Override
    public TiempoMaquinariaTO obtenerTiempoMaquinaria(Integer codigoMaquinaria) {
        TiempoMaquinariaTO tmaquinaria = new TiempoMaquinariaTO();
        int probando=1;
        try {
            collection = database.getCollection("tiempoMaquinaria");
            FindIterable<Document> findIterable = collection.find(eq("codigoMaquinaria", String.valueOf(codigoMaquinaria)));
            if (findIterable.first() != null) {
                probando=0;
                for (Document dMaquinaria : findIterable) {
                    String codigoMaq;
                    System.out.println("aca1");
                    codigoMaq = dMaquinaria.getString("codigoMaquinaria");
                    tmaquinaria.setCodigoMaquinaria(Integer.valueOf(codigoMaq));
                    System.out.println("aca1");
                    
                    tmaquinaria.setFecha(dMaquinaria.getString("fecha"));
                    System.out.println("aca2");
                    tmaquinaria.setTiempoUso((dMaquinaria.getInteger("tiempoUso")));
                    System.out.println("aca3");
                    tmaquinaria.setTiempoNoUso(dMaquinaria.getInteger("tiempoNoUso"));
                    System.out.println("aca4");
                    tmaquinaria.setTurno(dMaquinaria.getInteger("idTurno"));
                    System.out.println("aca5");
                }
                return tmaquinaria;
            } else {
                
                return null;
            }
        } catch (MongoException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
