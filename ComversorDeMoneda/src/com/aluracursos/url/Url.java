package com.aluracursos.url;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Url {
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/db67996497877e892843ee00/latest/";

    // Método para obtener la URL completa basada en la moneda
    public String construirUrl(String moneda) {
        return BASE_URL + moneda;
    }

    // Método para realizar la solicitud HTTP y devolver la respuesta en formato JSON
    public String obtenerRespuestaApi(String url) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }
}
