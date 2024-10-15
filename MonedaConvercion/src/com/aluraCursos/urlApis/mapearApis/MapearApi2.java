package com.aluraCursos.urlApis.mapearApis;

import com.aluraCursos.excepciones.ErrorNotieneDatos;
import com.aluraCursos.urlApis.conversionApis.ConversionApi2;
import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapearApi2 {
    @SerializedName("result")
    private Result result;

    public Result getResult() {
        return result;
    }

    public static class Result {
        @SerializedName("conversion")
        private List<ConversionApi2> conversiones;

        public List<ConversionApi2> getConversiones() {
            return conversiones;
        }
    }

    public Double getValorPorMoneda(String moneda) throws ErrorNotieneDatos {
        for (ConversionApi2 conversion : result.getConversiones()) {
            if (conversion.getTo().equals(moneda)) {
                return conversion.getRate();
            }
        }
        throw new ErrorNotieneDatos("No se encontró la tasa de cambio para la moneda: " + moneda);
    }
    public Map<String, Double> getConversiones() {
        Map<String, Double> conversionMap = new HashMap<>();
        for (ConversionApi2 conversion : result.getConversiones()) {
            conversionMap.put(conversion.getTo(), conversion.getRate());
        }
        return conversionMap;
    }

    @Override
    public String toString() {
        return "MapearApi1{" +
                "result=" + result +
                '}';
    }
}
