package com.aluraCursos.urlApis.mapearApis;

import java.util.Map;

public class MapearApi1 {
    private Map<String, Double> conversion_rates;

    public Double getValorPorMoneda(String moneda) {
        return conversion_rates.get(moneda);
    }

    public Map<String, Double> getConversionRates() {
        return conversion_rates;
    }

    public void setConversionRates(Map<String, Double> conversion_rates) {
        this.conversion_rates = conversion_rates;
    }
}

