package com.aluraCursos.principalApp;

import com.aluraCursos.archivoGson.OrganizarProductoLista;
import com.aluraCursos.mensajes.Mensajes;
import com.aluraCursos.menuOpciones.MenuProductos;
import com.aluraCursos.monedas.Monedas;
import com.aluraCursos.monedas.OperacionMoneda;
import com.aluraCursos.paises.Paises;
import com.aluraCursos.salidas.Salida;

import com.aluraCursos.urlApis.InterruptorApi1;
import com.aluraCursos.urlApis.mapearApis.MapearApi1;


import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ListaProductos {
    private static int salida = 15;

    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner lectura = new Scanner(System.in);
        Mensajes mensaje = new Mensajes();
        InterruptorApi1 interruptorApi1 = new InterruptorApi1();
        OperacionMoneda operacionMoneda = new OperacionMoneda();
        MenuProductos menuProductos = new MenuProductos();
        OrganizarProductoLista organizarProductoLista = new OrganizarProductoLista(); // Instancia para manejar productos

        int opcion = 0;

        while (opcion != 15) {
            System.out.println(MenuProductos.getMenuProductos());
            try {
                int paisSeleccionado = lectura.nextInt();
                lectura.nextLine(); // Limpiar el buffer
                // Verificar si el usuario quiere salir ingresando 16
                if (paisSeleccionado == 16) {
                    System.out.println("Cerrando el programa. ¡Hasta luego!");
                    System.exit(0); // Cerrar el programa
                }

                if (Salida.validarPaisSeleccionado(paisSeleccionado)) {
                    continue; // Continuar si es la opción de salida
                }

                Paises pais = Paises.values()[paisSeleccionado - 1];
                Monedas moneda = Monedas.values()[paisSeleccionado - 1];

                System.out.println("El país de origen: " + pais + " La moneda es: " + moneda);

                // Obtener la tasa de conversión usando InterruptorApi1
                MapearApi1 resultadoApi = interruptorApi1.obtenerTasaConversion(moneda);

                System.out.println("=====================================================================");
                while (true) {
                    System.out.println("Escribe el nombre del producto (o 15 para salir): ");
                    String producto = lectura.nextLine();

                    if (producto.equals("15")) {
                        break; // Salir del ciclo de productos
                    }

                    System.out.println("=====================================================================");
                    System.out.println("Valor del producto:");

                    // Obtener el valor del producto
                    int valorInput = lectura.nextInt();
                    lectura.nextLine(); // Limpiar buffer

                    double valor = (double) valorInput;

                    // Obtener las conversiones para cada país
                    Monedas[] monedas = Monedas.values();
                    Paises[] paises = Paises.values();

                    for (int i = 0; i < monedas.length; i++) {
                        Monedas monedaD = monedas[i];
                        Paises paisD = paises[i];

                        Double tasaConversion = resultadoApi.getValorPorMoneda(monedaD.toString());

                        // Realizar la conversión
                        String resultadoFormateado = operacionMoneda.calcularConversion(String.valueOf(valorInput), tasaConversion);

                        // Guardar la consulta en el objeto OrganizarProducto
                        organizarProductoLista.agregarConsultap(pais.toString(), producto, valor, paisD.toString(), resultadoFormateado);

                        // Mostrar el resultado en consola
                        System.out.println("En: " + paisD + " : " + resultadoFormateado);
                    }
                    System.out.println("=====================================================================");
                }

                // Guardar las consultas en JSON
                organizarProductoLista.guardarConsultasp();

                // Mostrar las consultas de productos después de terminar
                organizarProductoLista.mostrarConsultasp();
            } catch (InputMismatchException e) {
                System.out.println(mensaje.getMensajeErrorPaisUsuario());
                lectura.next(); // Limpiar el buffer
            } catch (Exception e) {
                System.out.println("Ocurrió un error: " + e.getMessage());
            }
        }

    }


}