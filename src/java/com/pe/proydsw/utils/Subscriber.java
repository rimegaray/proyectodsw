/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.proydsw.utils;

import com.pe.proydsw.bean.MaquinariatrMBR;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
/**
 *
 * @author Aisac
 */
public class Subscriber {

    public static final String BROKER_URL = "tcp://0.0.0.0:1883";
    private MqttClient client;

    public Subscriber() {

        String clientId = "soldexa";
        try {
            client = new MqttClient(BROKER_URL, clientId);
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    public void start() {

        try {
            client.setCallback(new MaquinariatrMBR());
            client.connect();
            client.subscribe("casa/habitaciones/hab1/luz");
            //client.subscribe("/casa/habitaciones/hab1/luz");
        } catch (MqttException e) {
            e.printStackTrace();
            System.exit(1);
        }

    }
}