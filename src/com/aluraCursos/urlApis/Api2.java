package com.aluraCursos.urlApis;

import com.aluraCursos.urlApis.mapearApis.MapearApi2;
import com.aluraCursos.monedas.Monedas;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;


    public class Api2 {
        private final Gson gson;

        public Api2() {
            this.gson = new Gson();
        }

        public MapearApi2 obtenerTasaConversion(Monedas moneda) throws IOException, InterruptedException {
            String apiKey = URLEncoder.encode("54868|GRVFR8Jkx6n5ZyRvsV96", StandardCharsets.UTF_8.toString());
            URI direccion1 = URI.create("https://api.cambio.today/v1/full/" + moneda + "/json?key=" + apiKey);

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(direccion1)
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();

            // Deserializar el JSON y devolver el objeto MapearApi1
            return gson.fromJson(json, MapearApi2.class);
        }
    }

