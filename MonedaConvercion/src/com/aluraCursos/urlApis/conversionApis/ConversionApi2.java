package com.aluraCursos.urlApis.conversionApis;



import com.google.gson.annotations.SerializedName;

public class ConversionApi2 {
    @SerializedName("to")
    private String to;

    @SerializedName("rate")
    private double rate;

    public String getTo() {
        return to;
    }

    public double getRate() {
        return rate;
    }

    @Override
    public String toString() {
        return "Conversion{" +
                "to='" + to + '\'' +
                ", rate=" + rate +
                '}';
    }
}


