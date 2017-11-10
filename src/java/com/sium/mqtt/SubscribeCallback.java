/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sium.mqtt;

import com.pe.proydsw.bean.MaquinariaMBR;
import com.sium.controlador.ControladorEstadistica;
import com.sium.dao.to.MaquinariaTO;
import com.sium.estadistica.Paquete;
import java.util.StringTokenizer;
import org.eclipse.paho.client.mqttv3.*;

/**
 *
 * @author Aisac
 */
public class SubscribeCallback implements MqttCallback {

    private Paquete paquete;
    private MaquinariaTO mmaquinaria;
    private ControladorEstadistica controlador;
    public String estado;
    

    public SubscribeCallback() {
    }
   //asa
    private void desempaquetar(String cadena) {
        StringTokenizer token = new StringTokenizer(cadena, "\\.");
        if (token.nextToken().equals("ESTADO")) {
            
            token.nextToken();
            this.estado = token.nextToken();
            
            MaquinariaMBR.estado = this.estado;
            System.out.println("estado en CAllback"+estado);
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
}
