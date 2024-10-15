package com.aluraCursos.menuOpciones;

public class MenuApis {
    private static String menuApis = """
            =====================================================================
                                   conversor de moneda
            =====================================================================
            Primero: escribe solo el numero, de la Api casa de cambio :
            El más actualizado es el:1 
            =====================================================================
             
             1 - Exchange rate API         
             
             2 - Currencies converter API  - Cambio 
             
            15 - salir        
            
            Elije una opción válida:
            =====================================================================
            """;


    public static String getMenuApis() {
        return menuApis;
    }

    public MenuApis() {
    }
}
