/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.proydsw.bean;

import com.pe.proydsw.utils.Paquete;
import java.util.StringTokenizer;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 *
 * @author RAUL
 */
@ManagedBean
@ViewScoped
public class MaquinariatrMBR implements MqttCallback{
    
    private Paquete paquete;
    
    public void desempaquetar(String cadena) {
        StringTokenizer token = new StringTokenizer(cadena, "\\.");
        String valor = token.nextToken();
        if (valor.equals("CAMBIO")) {
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
        }
     
    }
    
    @Override
    public void connectionLost(Throwable thrwbl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void messageArrived(String topic, MqttMessage message) throws Exception {
        this.desempaquetar(message.toString());
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken imdt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Paquete getPaquete() {
        return paquete;
    }

    public void setPaquete(Paquete paquete) {
        this.paquete = paquete;
    }
    
    
    
}
