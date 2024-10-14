package com.aluraCursos.salidas;


import com.aluraCursos.mensajes.Mensajes;
import com.aluraCursos.InicioDeApp;

import java.io.IOException;

public class Salida {

    InicioDeApp inicioDeApp = new InicioDeApp();
    private static Mensajes mensaje = new Mensajes();

    public static boolean validarPaisSeleccionado(int paisSeleccionado) throws IOException, InterruptedException {
        if (paisSeleccionado < 1 || paisSeleccionado > 15) {
            return false; // País no válido
        }
        if (paisSeleccionado == 13) {
            System.out.println(mensaje.getMensajeSalida());
            return true; // Salida
        }
        if (paisSeleccionado == 14) {
            InicioDeApp.main(new String[0]); // Ejecutar la clase ListaProductos
            return true; // Continuar en otra parte
        }
        return false; // País válido
    }

    public static boolean validarPaisDestino(int paisDestino) throws IOException, InterruptedException {
        if (paisDestino < 1 || paisDestino > 15) {
            return false; // País no válido
        }
        if (paisDestino == 13) {
            System.out.println(mensaje.getMensajeSalida());
            return true; // Salida
        }
        if (paisDestino == 14) {
            InicioDeApp.main(new String[0]); // Ejecutar la clase ListaProductos
            return true; // Continuar en otra parte
        }
        return false; // País válido
    }
}