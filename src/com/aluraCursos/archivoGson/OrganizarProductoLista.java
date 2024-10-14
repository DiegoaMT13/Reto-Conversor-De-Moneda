
package com.aluraCursos.archivoGson;

import com.aluraCursos.paises.Paises;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrganizarProductoLista {
    private List<HashMap<String, Object>> consultasProducto = new ArrayList<>();
    private Gson gson;

    public OrganizarProductoLista() {
        gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();
    }

    public void agregarConsultap(String paisOrigen, String producto, double valor, String paisDestino, String resultadoConversion) {
        // Lógica para agregar la consulta a la lista
        HashMap<String, Object> consultaProducto = null;
        for (HashMap<String, Object> consulta : consultasProducto) {
            if (consulta.get("Producto").equals(producto) && consulta.get("Pais de Origen").equals(paisOrigen)) {
                consultaProducto = consulta;
                break;
            }
        }

        if (consultaProducto == null) {
            consultaProducto = new HashMap<>();
            consultaProducto.put("Pais de Origen", paisOrigen);
            consultaProducto.put("Producto", producto);
            consultaProducto.put("Valor Ingresado", String.format("%.1f", valor));
            consultaProducto.put("Destinos", new ArrayList<HashMap<String, String>>());
            consultasProducto.add(consultaProducto);
        }

        List<HashMap<String, String>> destinos = (List<HashMap<String, String>>) consultaProducto.get("Destinos");
        HashMap<String, String> destinoInfo = new HashMap<>();
        destinoInfo.put("Pais de Destino", paisDestino);
        destinoInfo.put("Resultado de la Conversion", resultadoConversion);
        destinos.add(destinoInfo);
    }

    public void guardarConsultasp() {
        try (FileWriter escritura = new FileWriter("Lista_de_Productos.json")) {
            escritura.write(gson.toJson(consultasProducto));
        } catch (IOException e) {
            System.out.println("Error al guardar las consultas: " + e.getMessage());
        }
    }

    public void mostrarConsultasp() {
        String[] paisesFijos = Paises.names();  // Obtener los países desde el enum Paises

        System.out.println("Lista de Consultas:\n");

        boolean mostrarPaises = true;
        int espacioColumna = 21;

        for (HashMap<String, Object> consulta : consultasProducto) {
            if (mostrarPaises) {
                System.out.printf("País de Origen:   ");
                for (String pais : paisesFijos) {
                    int longitudPais = pais.length();
                    int espaciosIzquierda = (espacioColumna - longitudPais) / 2;
                    int espaciosDerecha = espacioColumna - longitudPais - espaciosIzquierda;

                    System.out.printf("%" + espaciosIzquierda + "s%s%" + espaciosDerecha + "s", "", pais, "");
                }
                System.out.println();
                mostrarPaises = false;
            }

            String producto = (String) consulta.get("Producto");
            System.out.printf("Producto: %-10s", producto);

            List<HashMap<String, String>> destinos = (List<HashMap<String, String>>) consulta.get("Destinos");

            for (String pais : paisesFijos) {
                boolean encontrado = false;
                String valorMostrar = "N/A";

                for (HashMap<String, String> destino : destinos) {
                    String paisDestino = destino.get("Pais de Destino");
                    if (paisDestino.equals(pais)) {
                        String resultadoConversion = destino.get("Resultado de la Conversion");
                        valorMostrar = resultadoConversion;
                        encontrado = true;
                        break;
                    }
                }

                int longitudValor = valorMostrar.length();
                int espaciosIzquierda = (espacioColumna - longitudValor) / 2;
                int espaciosDerecha = espacioColumna - longitudValor - espaciosIzquierda;

                System.out.printf("%" + espaciosIzquierda + "s%s%" + espaciosDerecha + "s", "", valorMostrar, "");
            }

            System.out.println();
        }
    }
}