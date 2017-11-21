/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sium.mqtt;

import com.sium.dao.dao.DAOFactory;
import com.sium.dao.design.IMaquinariaDAO;
import com.sium.dao.to.MaquinariaTO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;

/**
 *
 * @author Aisac
 */
public class Subscriber {

    //public static final String BROKER_URL = "tcp://ec2-18-220-180-195.us-east-2.compute.amazonaws.com:1883";
    public static final String BROKER_URL = "tcp://0.0.0.0:1883";
    private MqttClient client;
    private List<MaquinariaTO> listaMaquinarias;

    public Subscriber() {

        String clientId = "soldexa";
        try {
            client = new MqttClient(BROKER_URL, clientId);
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    public void cargarMaquinarias() {
        IMaquinariaDAO maquinariaDAO = DAOFactory.getInstance().getMaquinariaDAO();
        listaMaquinarias = maquinariaDAO.listaMaquinaria();
    }
    
    public void subscribirse(String categoria, Integer codigoMaquinaria){
        try {
            client.subscribe("/soldexa/" + categoria + "/" + String.valueOf(codigoMaquinaria));
        } catch (MqttException ex) {
            Logger.getLogger(Subscriber.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void start() {

        try {
            client.setCallback(new SubscribeCallback());
            client.connect();
            listaMaquinarias.stream().forEach(maquinaria -> {
                this.subscribirse(maquinaria.getCategoria(), maquinaria.getCodigoMaquinaria());
            });
        } catch (MqttException e) {
            e.printStackTrace();
            System.exit(1);
        }

    }
}
