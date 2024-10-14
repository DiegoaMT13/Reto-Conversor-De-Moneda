package com.aluraCursos.mensajes;

public class Mensajes {
    private String mensajeIngresoValor =  "Ingresa el valor, que deseas convertir";
    private String mensajePaisDestino ="Escribe solo el numero, del país destino";
    private String mensajeErrorUsuarioPais = "Elije una opción válida:";
    private String mensajeErrorPaisUsuario = "Elije un número correcto de país, en el menú del ( 1 al 14)";
    private String mensajeSalida =  "Cerrando el programa. ¡Hasta pronto! ";

    public String getMensajeIngresoValor() {
        return mensajeIngresoValor;
    }

    public String getMensajePaisDestino() {
        return mensajePaisDestino;
    }

    public String getMensajeErrorUsuarioPais() {
        return mensajeErrorUsuarioPais;
    }

    public String getMensajeErrorPaisUsuario() {
        return mensajeErrorPaisUsuario;
    }

    public String getMensajeSalida() {
        return mensajeSalida;
    }
}
