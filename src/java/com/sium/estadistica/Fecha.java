/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sium.estadistica;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Aisac
 */
public class Fecha {

    private Calendar calendario;
    private String fecha;

    public Fecha() {
        calendario = new GregorianCalendar();
        int dia = calendario.get(Calendar.DAY_OF_MONTH);
        int mes = calendario.get(Calendar.MONTH);
        int year = calendario.get(Calendar.YEAR);

        fecha = dia + "/" + mes + "/" + year;
    }

    public String getFecha() {
        return fecha;
    }
}
