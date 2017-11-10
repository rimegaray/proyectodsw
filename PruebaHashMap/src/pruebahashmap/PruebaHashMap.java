/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebahashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author RAUL
 */
public class PruebaHashMap {

    /**
     * @param args the command line arguments
     */
    //private String respuesta;
    //int respuesta=0;
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int respuesta=0;
        int identificador=0;
        String valor=null;
        Map<Integer, String> hash = new HashMap<Integer,String>();
        do {            
            System.out.println("Ingrese identificador de la variable");
            identificador = cin.nextInt();
            
            System.out.println("Ingrese el valor de la variable");
            valor = cin.next();
            
            for (Map.Entry<Integer, String> entry : hash.entrySet()) {
                System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
            }


            System.out.println("¿Desea continuar con la prueba");
            respuesta = cin.nextInt();
            
            
            
        } while (respuesta==1);
    
    }
    
    
}
