package com.aluraCursos.menuOpciones;

public class MenuProductos {
    private static String menuProductos = """
            =====================================================================
                                   Lista de procuctos
            =====================================================================
            1 - : escribe solo el numero, del pais origen:
            2 - : escribe el nombre del producto:
            3 - : escribe el valor:
            Por ultimo: escribe solo el numero del pais destino a convertir:
            =====================================================================
            1 - Estdos unidos  2 - Europa    3 - Argentina   4 - Bolivia
            5 - Brasil         6 - Canada    7 - Chile       8 - Colombia
            9 - Paraguay       10 - México   11 - Peru       12 - Uruguay
            
            13 - volver a el menu Principal         14 - Lista de productos
           
            15 - salir
            16 - cerrar programa 
            
            Elije una opción válida:
            =====================================================================
            """;

    public static String getMenuProductos() {
        return menuProductos;
    }
}
