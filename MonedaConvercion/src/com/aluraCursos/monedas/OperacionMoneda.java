package com.aluraCursos.monedas;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;

public class OperacionMoneda {

    public double leerYConvertirValor(String valorInput) {
        valorInput = valorInput.replace(",", ".");  // Reemplazamos las comas por puntos si es necesario
        double valor = 0;
        try {
            valor = Double.parseDouble(valorInput);  /* Convertimos a double*/
        } catch (NumberFormatException e) {
            System.out.println("El valor ingresado no es válido.");
        }
        return valor;
    }
    public String calcularConversion(String valorInput, double tasaConversion) {
        double valor = Double.parseDouble(valorInput);
        double resultado1 = valor * tasaConversion;

        BigDecimal resultadoRedondeado = BigDecimal.valueOf(resultado1).setScale(2, RoundingMode.HALF_UP);
        NumberFormat numberFormat = NumberFormat.getInstance(Locale.forLanguageTag("es-CO")); // Usa el locale adecuado
        return numberFormat.format(resultadoRedondeado);
    }


}
