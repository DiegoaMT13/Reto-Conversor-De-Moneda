package com.aluraCursos.excepciones;

public class Excepciones extends RuntimeException {
    private String mensajeErorApi;



    @Override
    public String getMessage() {
        return this.mensajeErorApi;
    }




}
