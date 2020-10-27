package com.nemoreno.healthApp.Modelos;

public class recordContract {


    public static final String TABLE_NAME = "registros";
    public static final String ID = "id";
    public static final String NOMBRE = "nombre";
    public static final String SISTOLICO = "sistolico";
    public static final String DISTOLICO = "distolico";
    public static final String DATE = "date";
    public static final String BARRIO = "barrio";
    static final String CREAR_TABLA_CONTACTO = "CREATE TABLE "+TABLE_NAME+"(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + NOMBRE + " TEXT," + DISTOLICO+
            " TEXT," + BARRIO + " TEXT,"+ SISTOLICO + " TEXT," + DATE + " TEXT)";
}
