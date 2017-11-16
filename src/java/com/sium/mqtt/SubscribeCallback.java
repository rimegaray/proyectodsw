/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sium.mqtt;

import com.pe.proydsw.bean.MaquinaEstado;
import java.util.StringTokenizer;
import org.eclipse.paho.client.mqttv3.*;

/**
 *
 * @author Aisac
 */
public class SubscribeCallback implements MqttCallback {

      
    public String estado;
    public String maquinaria;

    public SubscribeCallback() {
    }
    

    private void desempaquetar(String cadena) {
        StringTokenizer token = new StringTokenizer(cadena, "\\.");
        if (token.nextToken().equals("ESTADO")) {
            this.maquinaria = token.nextToken();
            this.estado = token.nextToken();
            MaquinaEstado.estadosMaq.put(maquinaria, estado);
        } 

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

    public String getMaquinaria() {
        return maquinaria;
    }

    public void setMaquinaria(String maquinaria) {
        this.maquinaria = maquinaria;
    }

}
