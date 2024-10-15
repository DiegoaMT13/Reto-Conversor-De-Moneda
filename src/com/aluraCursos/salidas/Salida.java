package com.aluraCursos.salidas;

import com.aluraCursos.mensajes.Mensajes;
import com.aluraCursos.principalApp.ListaProductos;

import java.io.IOException;

public class Salida {
    private static Mensajes mensaje = new Mensajes();

    public static boolean validarPaisSeleccionado(int paisSeleccionado) throws IOException, InterruptedException {
        if (paisSeleccionado < 1 || paisSeleccionado > 18) {
            return false; // País no válido
        }
        if (paisSeleccionado == 15) {
            System.out.println(mensaje.getMensajeSalida());
            return true; // Salida
        }
        if (paisSeleccionado == 13) {
            ListaProductos.main(new String[0]); // Ejecutar la clase ListaProductos
            return true; // Continuar con ListaProductos
        }
        if (paisSeleccionado == 14) {
            ListaProductos.main(new String[0]); // Ejecutar la clase ListaProductos
            return true; // Ejecutar ListaProductos cuando el usuario ingresa 14
        }
        return false; // País válido
    }

    public static boolean validarPaisDestino(int paisDestino) throws IOException, InterruptedException {
        if (paisDestino < 1 || paisDestino > 18) {
            return false; // País no válido
        }
        if (paisDestino == 15) {
            System.out.println(mensaje.getMensajeSalida());
            return true; // Salida
        }
        if (paisDestino == 14) {
            ListaProductos.main(new String[0]); // Ejecutar la clase ListaProductos
            return true; // Ejecutar ListaProductos cuando el usuario ingresa 14
        }
        return false; // País válido
    }
}