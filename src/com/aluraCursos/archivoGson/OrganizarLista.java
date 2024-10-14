package com.aluraCursos.archivoGson;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrganizarLista {
    private List<HashMap<String, String>> consultas = new ArrayList<>();
    private Gson gson;

    public OrganizarLista() {
        gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();
    }

    public void agregarConsulta(String paisOrigen, double valor, String paisDestino, String resultadoConversion) {
        HashMap<String, String> consulta = new HashMap<>();
        consulta.put("Pais de Origen", paisOrigen);
        consulta.put("Valor Ingresado", String.format("%.1f", valor));
        consulta.put("Pais de Destino", paisDestino);
        consulta.put("Resultado de la Conversion", resultadoConversion);

        consultas.add(consulta);
    }

    public void guardarConsultas() {
        try (FileWriter escritura = new FileWriter("consultasUsuarios.json")) {
            escritura.write(gson.toJson(consultas));
        } catch (IOException e) {
            System.out.println("Error al guardar las consultas: " + e.getMessage());
        }
    }

    public void mostrarConsultas() {
        System.out.println("Lista de Consultas:");
        for (HashMap<String, String> consulta : consultas) {
            System.out.println("====================================");
            System.out.println("País de Origen: " + consulta.get("Pais de Origen"));
            System.out.println("Valor Ingresado: " + consulta.get("Valor Ingresado"));
            System.out.println("País de Destino: " + consulta.get("Pais de Destino"));
            System.out.println("Resultado de la Conversión: " + consulta.get("Resultado de la Conversion"));
            System.out.println("====================================");
        }
    }

}

