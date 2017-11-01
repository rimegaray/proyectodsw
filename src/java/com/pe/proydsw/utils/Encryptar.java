/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.proydsw.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author joseasto
 */
public class Encryptar {
  
    public static String sha5256(String cadena)
    {
        StringBuilder sb = new StringBuilder();
        
        try
        {
            MessageDigest md=MessageDigest.getInstance("SHA-256");
        
            md.update(cadena.getBytes());

            byte[] mb=md.digest();

            for(int i = 0; i < mb.length; i++) 
            {
                sb.append(Integer.toString((mb[i] & 0xff) + 0x100, 16).substring(1));
            }
        }
        catch(NoSuchAlgorithmException ex)
        {
            /*...*/
        }
 
        return sb.toString();
    }    
}
