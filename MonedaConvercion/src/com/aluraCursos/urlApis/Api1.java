package com.aluraCursos.urlApis;

import com.aluraCursos.urlApis.mapearApis.MapearApi1;
import com.aluraCursos.monedas.Monedas;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Api1 {

    // Instancia de Gson
    private final Gson gson = new Gson();

    // Método para obtener la tasa de conversión
    public MapearApi1 obtenerTasaConversion(Monedas moneda) throws IOException, InterruptedException {

        // Construcción de la URL para la solicitud
        URI direccion2 = URI.create("https://v6.exchangerate-api.com/v6/db67996497877e892843ee00/latest/" + moneda);

        // Creación del cliente y la solicitud HTTP
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion2)
                .build();

        // Envío de la solicitud y recepción de la respuesta
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();

        // Deserializar el JSON a un objeto MapearApi1
        return gson.fromJson(json, MapearApi1.class);
    }
}


