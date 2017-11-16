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
import com.sium.dao.design.ICategoriaDAO;
import com.sium.dao.to.CategoriaTO;
import com.sium.mongo.AccesoMongoDB;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;

/**
 *
 * @author Aisac
 */
public class CategoriaDAO implements ICategoriaDAO {

    private final MongoClient db;
    private MongoDatabase database;
    private MongoCollection<Document> collection;

    public CategoriaDAO() {
        this.db = AccesoMongoDB.getAccesoSingleton();
        database = db.getDatabase("sium");
    }

    @Override
    public boolean eliminarCategoria(String codigoCategoria) {
        try {
            collection = database.getCollection("categorias");
            collection.deleteOne(eq("codigoCategoria", codigoCategoria));
            return true;
        } catch (MongoException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public String insertCategoria(CategoriaTO categoria) {
        try {
            collection = database.getCollection("maquinarias");
            Document jCategoria = new Document().append("codigoCategoria", categoria.getCodigoCategoria())
                    .append("nombreCategoria", categoria.getNombre());
            collection.insertOne(jCategoria);
            return "correcto";
        } catch (MongoException e) {
            System.out.println(e.getMessage());
            return "fallo";
        }
    }

    @Override
    public List<CategoriaTO> listaCategoria() {
        List<CategoriaTO> listaCategoria = new ArrayList<>();
        try {
            collection = database.getCollection("categorias");
            FindIterable<Document> findIterable = collection.find(new Document());        
            if (findIterable != null) {
                for (Document dCategoria : findIterable) {
                    CategoriaTO categoria = new CategoriaTO();
                    //Al insertar en duro, mongo lo guarda como un double --> 1.0
                    //Double codCate = dCategoria.getDouble("codigoCategoria");
                    categoria.setCodigoCategoria(dCategoria.getInteger("codigoCategoria"));
                    
                    //categoria.setCodigoCategoria(dCategoria.getInteger("codigoCategoria"));
                    categoria.setNombre(dCategoria.getString("nombreCategoria"));
                    listaCategoria.add(categoria);
                }
            } else {
                
            }
        } catch (MongoException e) {
            System.out.println(e.getMessage());
        }
        return listaCategoria;
    }

    @Override
    public int ContadorDeRegCategoria() {
        long cantidadCategoria;
        int cantCat = 0;
        try {
            collection = database.getCollection("categorias");
            cantidadCategoria = collection.count();
            cantCat = (int) cantidadCategoria;
        } catch (MongoException e) {
            System.out.println(e.getMessage());
        }
        return cantCat;
    }

}
