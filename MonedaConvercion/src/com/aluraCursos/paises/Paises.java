package com.aluraCursos.paises;

public enum Paises {
    Estados_unidos, Europa, Argentina, Bolivia, Brasil, Canada, Chile, Colombia, paraguay, Mexico, Peru, Uruguay,;

    // Metodo para el Array Lista
    public static String[] names() {
        Paises[] paisesEnum = values();
        String[] names = new String[paisesEnum.length];
        for (int i = 0; i < paisesEnum.length; i++) {
            names[i] = paisesEnum[i].name();
        }
        return names;
    }

}
