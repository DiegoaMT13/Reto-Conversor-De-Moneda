package com.aluracursos.mensajes;

public class Mensajes {
    private String mensajeIngreso =  "Ingresa el valor, que deseas convertir: ";
    private String mensajePaisDestino ="Escribe solo el numero, del pais destino";
    private String mensajeError = "Elije una opción válida:";

    public String getMensajeIngreso() {
        return mensajeIngreso;
    }

    public String getMensajePaisDestino() {
        return mensajePaisDestino;
    }

    public String getMensajeError() {
        return mensajeError;
    }
}
