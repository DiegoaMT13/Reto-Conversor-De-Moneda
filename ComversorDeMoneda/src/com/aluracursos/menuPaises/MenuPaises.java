package com.aluracursos.menuPaises;

public class MenuPaises {

    private static String menu = """
            *********************************************************************
            Primero: escrive solo el numero, del pais origen:
            Segundo: escrive el valor:
            Por ultimo: escribe solo el numero del pais destino a convertir:
            *********************************************************************
            1 - Estdos unidos  2 - Europa    3 - Argentina   4 - Bolivia
            5 - Brasil         6 - Canada    7 - Chile       8 - Colombia
            9 - Ecuador        10 - México   11 - Peru       12 - Uruguay
            
            13 - salir
            
            Elije una opción válida:
            *********************************************************************
            """;

    public MenuPaises() {

    }

    public static String getMenu() {
        return menu;
    }
}
