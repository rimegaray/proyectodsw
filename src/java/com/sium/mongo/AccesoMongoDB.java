/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sium.mongo;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoException;

/**
 *
 * @author Aisac
 */
public class AccesoMongoDB {
    static private MongoClient db;
    
    private AccesoMongoDB(){}
    
    static public MongoClient getAccesoSingleton(){
        if(db == null){
            try{
            db = new MongoClient(new MongoClientURI("mongodb://aisac:aisac@ds058508.mlab.com:58508/sium"));
//            db = new MongoClient(new MongoClientURI("mongodb://localhost:27017/sium"));

            }catch(MongoException e){
                System.out.println(e.getMessage());
            }
        }
        return db;
    }
    
}
