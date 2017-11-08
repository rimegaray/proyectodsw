/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sium.estadistica;

import com.sium.dao.to.RegistroTO;
import com.sium.dao.to.TiempoMaquinariaTO;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.StringTokenizer;

/**
 *
 * @author Aisac
 */
public class Estadistica {

    private final Integer tiempoJornada;
    private RegistroTO registro;
    private TiempoMaquinariaTO tiempoMaquinaria;

    public Estadistica(Paquete paquete) {
        this.tiempoJornada = 32400;
            registro = new RegistroTO();
            tiempoMaquinaria = new TiempoMaquinariaTO();
            registro.setCodigoMaquinaria(paquete.getCodigoMaquinaria());
            registro.setHoraInicio(paquete.getHoraInicio());
            registro.setHoraFin(paquete.getHoraFin());
            registro.setTurno(paquete.getTurno());
            tiempoMaquinaria.setCodigoMaquinaria(paquete.getCodigoMaquinaria());
            tiempoMaquinaria.setTurno(paquete.getTurno());
            this.asignarFecha();
    }

    public void calcularDuracion() {
        Integer tiempoUso = this.horaASegundos(registro.getHoraFin()) - this.horaASegundos(registro.getHoraInicio());
        Integer tiempoNoUso = tiempoJornada - tiempoUso;
        tiempoMaquinaria.setTiempoUso(tiempoUso);
        tiempoMaquinaria.setTiempoNoUso(tiempoNoUso);
    }

    public void calcularPorcentajeUtilizacion() {
        Double porcentaje = ((double) tiempoMaquinaria.getTiempoUso() / (double) tiempoJornada);
        Double porcentajeUtilizacion = new BigDecimal(porcentaje * 100D)
                .setScale(3, RoundingMode.HALF_EVEN).doubleValue();
        registro.setPorcentajeUtilizacion(porcentajeUtilizacion);
    }

    private Integer horaASegundos(String hora) {
        StringTokenizer token = new StringTokenizer(hora, "\\:");
        Integer sHora = Integer.parseInt(token.nextToken()) * 3600;
        Integer sMinuto = Integer.parseInt(token.nextToken()) * 60;
        Integer segundo = Integer.parseInt(token.nextToken());

        return sHora + sMinuto + segundo;
    }

    private void asignarFecha() {
        Fecha fecha = new Fecha();
        registro.setFecha(fecha.getFecha());
        tiempoMaquinaria.setFecha(fecha.getFecha());
    }

    public TiempoMaquinariaTO getTiempoMaquinaria() {
        return tiempoMaquinaria;
    }

    public RegistroTO getRegistro() {
        return registro;
    }

}
