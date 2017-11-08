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
import com.sium.dao.design.IRegistroDAO;
import com.sium.dao.to.RegistroTO;
import com.sium.mongo.AccesoMongoDB;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;

/**
 *
 * @author Aisac
 */
public class RegistroDAO implements IRegistroDAO {

    private final MongoClient db;
    private MongoDatabase database;
    private MongoCollection<Document> collection;

    public RegistroDAO() {
        this.db = AccesoMongoDB.getAccesoSingleton();
        database = db.getDatabase("sium");
    }

    @Override
    public String insertRegistro(RegistroTO registro) {
        try {
            collection = database.getCollection("registros");
            Document jRegistro = new Document().append("codigoMaquinaria", registro.getCodigoMaquinaria())
                    .append("idTurno", registro.getTurno())
                    .append("fecha", registro.getFecha())
                    .append("horaInicio", registro.getHoraInicio())
                    .append("horaFin", registro.getHoraFin())
                    .append("porcentajeUtilizacion", registro.getPorcentajeUtilizacion());
            collection.insertOne(jRegistro);
            return "correcto";
        } catch (MongoException e) {
            System.out.println(e.getMessage());
            return "fallo";
        }
    }

    @Override
    public List<RegistroTO> listaRegistro(int turno, String codigoMaquinaria, String fecha) {
        List<RegistroTO> listaRegistros = new ArrayList<>();
        try {
            collection = database.getCollection("registros");
            FindIterable<Document> findIterable = collection.find(
                    and(
                            eq("idTurno", turno),
                            eq("codigoMaquinaria",codigoMaquinaria),
                            eq("fecha", fecha)
                    )
            );
            if (findIterable != null) {
                for (Document dregistro : findIterable) {
                    RegistroTO registro = new RegistroTO();
                    registro.setCodigoMaquinaria(codigoMaquinaria);
                    registro.setTurno(turno);
                    registro.setFecha(fecha);
                    registro.setHoraInicio(dregistro.getString("horaInicio"));
                    registro.setHoraFin(dregistro.getString("horaFin"));
                    registro.setPorcentajeUtilizacion(dregistro.getDouble("porcentajeUtilizacion"));
                    listaRegistros.add(registro);
                }
            } else {
                System.out.println("No existe registros");
            }
        } catch (MongoException e) {
            System.out.println(e.getMessage());
        }
        return listaRegistros;
    }

}
