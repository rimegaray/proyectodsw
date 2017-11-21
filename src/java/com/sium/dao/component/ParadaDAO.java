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
import com.sium.dao.design.IParadaDAO;
import com.sium.dao.to.ParadaTO;
import com.sium.mongo.AccesoMongoDB;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;

/**
 *
 * @author Aisac
 */
public class ParadaDAO implements IParadaDAO {

    private final MongoClient db;
    private MongoDatabase database;
    private MongoCollection<Document> collection;

    public ParadaDAO() {
        this.db = AccesoMongoDB.getAccesoSingleton();
        database = db.getDatabase("sium");
    }

    @Override
    public String insertarParada(ParadaTO parada) {
        try {
            collection = database.getCollection("paradas");
            Document jParada = new Document().append("codigoMaquinaria", parada.getCodigoMaquinaria())
                    .append("idTurno", parada.getTurno())
                    .append("fecha", parada.getFecha())
                    .append("horaInicio", parada.getHoraInicio())
                    .append("horaFin", parada.getHoraFin());
            collection.insertOne(jParada);
            return "correcto";
        } catch (MongoException e) {
            System.out.println(e.getMessage());
            return "fallo";
        }
    }

    @Override
    public List<ParadaTO> listaParadas(int turno, Integer codigoMaquinaria, String fecha) {
        List<ParadaTO> listaParadas = new ArrayList<ParadaTO>();
        try {
            collection = database.getCollection("paradas");
            FindIterable<Document> findIterable = collection.find(
                    and(
                            eq("idTurno", turno),
                            eq("codigoMaquinaria",codigoMaquinaria),
                            eq("fecha", fecha)
                    )
            );
            if (findIterable.first() != null) {
                for (Document dparada : findIterable) {
                    ParadaTO parada = new ParadaTO();
                    parada.setCodigoMaquinaria(codigoMaquinaria);
                    parada.setTurno(turno);
                    parada.setFecha(fecha);
                    parada.setHoraInicio(dparada.getString("horaInicio"));
                    parada.setHoraFin(dparada.getString("horaFin"));
                    listaParadas.add(parada);
                }
            } else {
                System.out.println("No existe paradas");
            }
        } catch (MongoException e) {
            System.out.println(e.getMessage());
        }
        return listaParadas;
    }

}
