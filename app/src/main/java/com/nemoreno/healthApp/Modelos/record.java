package com.nemoreno.healthApp.Modelos;

public class record {
    private int id;
    private String nombre;
    private String barrio;
    private String apellido;
    private String telefono;
    private String cumpleaños;

    public record(int id, String nombre, String Barrio, String apellido, String telefono, String cumpleaños) {
        this.id = id;
        this.barrio = Barrio;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.cumpleaños = cumpleaños;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCumpleaños() {
        return cumpleaños;
    }

    public String getBarrio() {
        return barrio;
    }

    @Override
    public String toString() {
        return "record{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", barrio='" + barrio + '\'' +
                ", apellido='" + apellido + '\'' +
                ", telefono='" + telefono + '\'' +
                ", cumpleaños='" + cumpleaños + '\'' +
                '}';
    }
}
