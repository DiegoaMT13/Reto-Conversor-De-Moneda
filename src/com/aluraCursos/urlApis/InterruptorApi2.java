package com.aluraCursos.urlApis;

import com.aluraCursos.monedas.Monedas;
import com.aluraCursos.urlApis.mapearApis.MapearApi1;
import com.aluraCursos.urlApis.mapearApis.MapearApi2;

import java.io.IOException;

public class InterruptorApi2 {
    private final Api1 api1;
    private final Api2 api2;

    public InterruptorApi2() {
        this.api1 = new Api1(); // Inicializa Api1
        this.api2 = new Api2(); // Inicializa Api2
    }

    public MapearApi1 obtenerTasaConversion(Monedas moneda) throws IOException, InterruptedException {
        try {
            // Intentar con Api2 primero
            System.out.println("Obteniendo tasa de conversión de Api2...");
            MapearApi2 resultadoApi2 = api2.obtenerTasaConversion(moneda);

            // Crear MapearApi1 y establecer las tasas de conversión
            MapearApi1 mapApi1 = new MapearApi1();
            mapApi1.setConversionRates(resultadoApi2.getConversiones()); // Asegúrate de que esto sea compatible

            return mapApi1;
        } catch (Exception e) {
            // Si falla Api2, intentar con Api1
            System.out.println("Api2 falló, intentando con Api1...");
            return api1.obtenerTasaConversion(moneda);
        }
    }
}