/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sium.mqtt;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;

/**
 *
 * @author Aisac
 */
public class Subscriber {

    public static final String BROKER_URL = "tcp://ec2-18-220-180-195.us-east-2.compute.amazonaws.com:1883";
    private MqttClient client;
    private String estado;
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
            client.setCallback(new SubscribeCallback());
            client.connect();
            client.subscribe("/soldexa/Prensa/1");
            client.subscribe("/soldexa/Prensa/2");
            client.subscribe("/soldexa/Prensa/3");
            //client.subscribe("/casa/habitaciones/hab1/luz");
        } catch (MqttException e) {
            e.printStackTrace();
            System.exit(1);
        }

    }
}
