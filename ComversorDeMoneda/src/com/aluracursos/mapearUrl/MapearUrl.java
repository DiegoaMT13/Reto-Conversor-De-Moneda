package com.aluracursos.mapearUrl;

import com.google.gson.annotations.SerializedName;
import java.util.Map;

public class MapearUrl {

    @SerializedName("conversion_rates")
    private Map<String, Double> conversionRates;

    public Map<String, Double> getConversionRates() {
        return conversionRates;
    }

    public void setConversionRates(Map<String, Double> conversionRates) {
        this.conversionRates = conversionRates;
    }

    public String getValorPorMoneda(String moneda) {
        if (conversionRates != null && conversionRates.containsKey(moneda)) {
            return moneda + ": " + conversionRates.get(moneda);
        }
        return "Moneda no encontrada";
    }

    @Override
    public String toString() {
        return "Conversiones: " + conversionRates;
    }
}
