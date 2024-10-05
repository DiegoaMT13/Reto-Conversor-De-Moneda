package com.aluracursos;

import com.aluracursos.mensajes.Mensajes;
import com.aluracursos.menuPaises.MenuPaises;
import com.aluracursos.mapearUrl.MapearUrl;
import com.aluracursos.paises.Paises;
import com.aluracursos.url.Url;
import com.google.gson.Gson;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class ConversorDeMoneda {
    public static void main(String[] args)throws IOException, InterruptedException{
        /* Objetos***********************************************************************************************************************************************************/
        MenuPaises menu = new MenuPaises();
        Mensajes mensaje = new Mensajes();
        Paises paisesData = new Paises();
        Scanner lectura = new Scanner(System.in);
        Url url= new Url();
        /* variables y listas ***********************************************************************************************************************************************/
        String[] monedas = paisesData.getMonedas();  // Obtener las monedas desde la clase Paises
        String[] paises = paisesData.getPaises();
        /* comienza el ciclo ***********************************************************************************************************************************************/

        int opcion = 0;
             while (opcion != 13) {

                /* 1 - Primera parte menu y selección **********************************************************************************************************************/
                System.out.println(menu.getMenu());
                int busqueda = lectura.nextInt();

                /* salida del programa *************************************************************************************************************************************/
                    if (busqueda == 13) {
                        System.out.println("Saliendo del programa...Gracias");
                        break;
                    }
                /*confirmación del pais elegido ****************************************************************************************************************************/
                String paisBusqueda = "";

                    if (busqueda >= 1 && busqueda <= paises.length) {
                        paisBusqueda = paises[busqueda - 1];
                    } else {
                        System.out.println(mensaje.getMensajeError());
                    }
                System.out.println("El pais de origen es: " + paisBusqueda);
                /* 2 - Armado de la url concatenar con la elección *********************************************************************************************************/
                String direccion = "";

                    if (busqueda >= 1 && busqueda <= monedas.length) {
                        direccion = url.construirUrl(monedas[busqueda - 1]);
                    } else {
                        System.out.println(mensaje.getMensajeError());
                    }
                /* 3 - Conectar la url con la Api y traer los datos en json*************************************************************************************************/

                 String json = url.obtenerRespuestaApi(direccion);  // Llamando al método de la clase Url para obtener la respuesta
                /* 4 - Trabajando con la biblioteca de Json *****************************************************************************************************************/


                Gson gson = new Gson();
                /* 5 - Mapear y notaciones del nombre Url y Api *************************************************************************************************************/
                MapearUrl extraerUrl = gson.fromJson(json, MapearUrl.class);
                /* 6 -  mensaje Ingresa el valor que deseas convertir y el valor*********************************************************************************************/
                System.out.println(mensaje.getMensajeIngreso());
                String valorInput = lectura.next();  // Capturamos la entrada como String para poder procesar la coma
                valorInput = valorInput.replace(",", ".");  // Reemplazamos las comas por puntos si es necesario
                double valor = 0;
                     try {
                         valor = Double.parseDouble(valorInput);  // Convertimos a double
                     } catch (NumberFormatException e) {
                         System.out.println("El valor ingresado no es válido.");
                         continue;  // Volver al menú en caso de error
                     }
                /*  Selección pais destino y confirmación *******************************************************************************************************************/
                System.out.println(mensaje.getMensajePaisDestino());
                int busqueda2 = lectura.nextInt();
                     if (busqueda2 == 13) {
                         System.out.println("Saliendo del programa...Gracias");
                         break;
                     }
                    if (busqueda2 >= 1 && busqueda2 <= paises.length) {
                        paisBusqueda = paises[busqueda2 - 1];
                    } else {
                        System.out.println(mensaje.getMensajeError());
                    }
                /* 7 - Ubicar pais para extraer valorMoneda ********************************************************************************************************************/
                String direccion2 = "";
                    if (busqueda2 >= 1 && busqueda2 <= monedas.length) {
                        direccion2 = monedas[busqueda2 - 1];
                    } else {
                        System.out.println(mensaje.getMensajeError());
                        return;
                    }
                System.out.println("El pais destino es: " + paisBusqueda);
                /* Se extrae solo el valor de la moneda *************************************************************************************************************************/
                String valorMoneda = extraerUrl.getValorPorMoneda(direccion2);

                String[] partes = valorMoneda.split(":");
                String soloValor = "";

                    if (partes.length > 1) {
                        soloValor = partes[1].trim(); // Separamos y eliminamos espacios en blanco
                    } else {
                        System.out.println("No se encontró el valor.");
                        return;
                    }
                /* 8 - final operación de la conversión ***************************************************************************************************************************/
                try {
                    double valorNumerico = Double.parseDouble(soloValor);
                    BigDecimal convercion = new BigDecimal((double) valor * valorNumerico).setScale(2, RoundingMode.HALF_UP);
                    System.out.println("La Conversión es : " + convercion);
                } catch (NumberFormatException e) {
                    System.out.println("El valor no es un número válido.");
                }


            }
    }
}
