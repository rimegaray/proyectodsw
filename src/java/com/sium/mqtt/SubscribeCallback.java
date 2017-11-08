/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sium.mqtt;

import com.sium.controlador.ControladorEstadistica;
import com.sium.estadistica.Paquete;
import java.util.StringTokenizer;
import org.eclipse.paho.client.mqttv3.*;

/**
 *
 * @author Aisac
 */
public class SubscribeCallback implements MqttCallback {

    private Paquete paquete;
    private ControladorEstadistica controlador;

    public SubscribeCallback() {
    }

    private void desempaquetar(String cadena) {
        StringTokenizer token = new StringTokenizer(cadena, "\\.");
        if (token.nextToken().equals("CAMBIO")) {
            paquete = new Paquete();
            System.out.println(paquete);
            paquete.setCodigoMaquinaria(token.nextToken());
            System.out.println(paquete);
            paquete.setTurno(Integer.valueOf(token.nextToken()));
            System.out.println(paquete);
            paquete.setHoraInicio(token.nextToken());
            System.out.println(paquete);
            paquete.setHoraFin(token.nextToken());
            System.out.println(paquete);
            procesarPaquete(paquete);
        }
          
    }

    private void procesarPaquete(Paquete paquete) {
        controlador = new ControladorEstadistica(paquete);
        controlador.guardarRegistro();
        controlador.guardarTiempoMaquinaria();
    }

    @Override
    public void connectionLost(Throwable thrwbl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void messageArrived(String topic, MqttMessage message) throws Exception {
        System.out.println("inicio");
        this.desempaquetar(message.toString());
        
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken imdt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
