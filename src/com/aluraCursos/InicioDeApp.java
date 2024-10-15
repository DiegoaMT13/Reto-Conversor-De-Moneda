package com.aluraCursos;

import com.aluraCursos.mensajes.Mensajes;

import com.aluraCursos.menuOpciones.MenuApis;
import com.aluraCursos.principalApp.PrincipalApi1;
import com.aluraCursos.principalApp.PrincipalApi2;
import com.aluraCursos.urlApis.Api1;
import com.aluraCursos.urlApis.Api2;
import com.aluraCursos.urlApis.InterruptorApi1;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InicioDeApp {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner lectura = new Scanner(System.in);
        Mensajes mensaje = new Mensajes();
        MenuApis menuApis = new MenuApis();
        InterruptorApi1 interruptorApi1 = new InterruptorApi1();
        Api2 api2 = new Api2();
        Api1 api1 = new Api1();

        int opcion = 0;

        while (opcion != 15) {
            System.out.println(MenuApis.getMenuApis());
            try {
                int paisSeleccionado = lectura.nextInt();

                if (paisSeleccionado == 15) {
                    System.out.println(mensaje.getMensajeSalida());
                    break;
                }
                if (paisSeleccionado == 1) {
                    PrincipalApi1.main(new String[0]);  // Ejecutar la clase ListaProductos
                    continue; // Evitar ejecución de más lógica en este ciclo
                }
                if (paisSeleccionado == 2) {
                    PrincipalApi2.main(new String[0]);  // Ejecutar la clase ListaProductos
                    continue; // Evitar ejecución de más lógica en este ciclo
                }
            } catch (InputMismatchException e) {
                System.out.println(mensaje.getMensajeErrorPaisUsuario());
                lectura.next(); // Limpiar el buffer
            } catch (Exception e) {
                System.out.println("Ocurrió un error: " + e.getMessage());
            }

            lectura.close(); // Cerrar el scanner
            break;
        }
    }

}