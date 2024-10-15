package com.aluraCursos.principalApp;

import com.aluraCursos.archivoGson.OrganizarLista;
import com.aluraCursos.mensajes.Mensajes;
import com.aluraCursos.menuOpciones.MenuDePaises;
import com.aluraCursos.monedas.Monedas;
import com.aluraCursos.monedas.OperacionMoneda;
import com.aluraCursos.paises.Paises;
import com.aluraCursos.salidas.Salida;
import com.aluraCursos.urlApis.Api1;
import com.aluraCursos.urlApis.Api2;
import com.aluraCursos.urlApis.InterruptorApi2;
import com.aluraCursos.urlApis.mapearApis.MapearApi1;


import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PrincipalApi2 {
    private static int salida = 15;

    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner lectura = new Scanner(System.in);
        Mensajes mensaje = new Mensajes();
        OperacionMoneda operacionMoneda = new OperacionMoneda();
        InterruptorApi2 interruptorApi1 = new InterruptorApi2();
        OrganizarLista organizarLista = new OrganizarLista();
        Api2 api2 = new Api2();
        Api1 api1 = new Api1();

        int opcion = 0;

        while (opcion != 15) {
            System.out.println(MenuDePaises.getMenu());
            try {
                int paisSeleccionado = lectura.nextInt();

                // Verificar si el usuario quiere salir ingresando 16
                if (paisSeleccionado == 16) {
                    System.out.println("Cerrando el programa. ¡Hasta luego!");
                    System.exit(0); // Cerrar el programa
                }

                if (Salida.validarPaisSeleccionado(paisSeleccionado)) {
                    continue; // Si es salida o se ejecutó otra parte, se continúa
                }

                Paises pais = Paises.values()[paisSeleccionado - 1];
                Monedas moneda = Monedas.values()[paisSeleccionado - 1];

                System.out.println("País de origen: " + pais +" La moneda es: " + moneda);

                // Obtener la tasa de conversión desde la clase Api2
                MapearApi1 resultadoApi = interruptorApi1.obtenerTasaConversion(moneda);


                System.out.println("=====================================================================");
                System.out.println(mensaje.getMensajeIngresoValor());
                String valorInput = lectura.next();
                double valorNumerico;
                double valor = Double.parseDouble(valorInput);

                System.out.println("=====================================================================");
                // Selección del país destino
                System.out.println(mensaje.getMensajePaisDestino());
                int paisDestino = lectura.nextInt();

                // Verificar si el usuario quiere salir ingresando 16
                if (paisSeleccionado == 16) {
                    System.out.println("Cerrando el programa. ¡Hasta luego!");
                    System.exit(0); // Cerrar el programa
                }

                if (Salida.validarPaisDestino(paisDestino)) {
                    continue; // Si es salida o se ejecutó otra parte, se continúa
                }

                Paises paisD = Paises.values()[paisDestino - 1];

                // Obtener la moneda destino seleccionada
                Monedas monedaD = Monedas.values()[paisDestino - 1];
                // Buscar el valor de conversión de la moneda destino
                //Double tasaConversion = resultadoApi1.getValorPorMoneda(monedaD.toString());
                Double tasaConversion = resultadoApi.getValorPorMoneda(monedaD.toString());

                String resultadoFormateado = operacionMoneda.calcularConversion(valorInput, tasaConversion);


                System.out.println("País destino: "+paisD+","+" la moneda es: " + monedaD+ " igual a: " + resultadoFormateado);
                // Agregar la consulta a la lista
                organizarLista.agregarConsulta(pais.toString(), valor, paisD.toString(), resultadoFormateado);
                System.out.println("=====================================================================");
                System.out.println("¿Deseas guardar la consulta? (1 para sí, 0 para no)");
                int guardarOpcion = lectura.nextInt();
                if (guardarOpcion == 1) {
                    organizarLista.guardarConsultas();
                    System.out.println("Consulta guardada exitosamente.");
                }
                organizarLista.mostrarConsultas();
                System.out.println("Gracias por usar el programa. ¡Hasta luego!");

            } catch (InputMismatchException e) {
                System.out.println(mensaje.getMensajeErrorPaisUsuario());
                lectura.next(); // Limpiar el buffer
            } catch (Exception e) {
                System.out.println("Ocurrió un error: " + e.getMessage());
            }



        }
        lectura.close(); // Cerrar el scanner
    }
}
