/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sium.mongo;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoException;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;

import org.bson.Document;

/**
 *
 * @author Aisac
 */
public class MongoTest {

    public static void main(String[] args) {
        System.setProperty("java.net.preferIPv4Stack", "true");
        try {
            MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://aisac:aisac@ds058508.mlab.com:58508/sium"));
            MongoDatabase database = mongoClient.getDatabase("sium");
            MongoCollection<Document> collection = database.getCollection("user");
            Document doc = new Document("nombre", "Raul");
            collection.insertOne(doc);
        } catch (MongoException e) {
            System.out.println(e.getMessage());
        }
    }

}
