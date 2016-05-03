package ar.edu.ort.primertp;

import java.io.Serializable;


public class Persona implements Serializable {


    public static int MASCULINO=1;
    public static int FEMENINO=2;

    protected String nombre;
    protected String apellido;
    protected int sexo;

    public Persona(String nombre, String a, int sexo) {
        this.nombre = nombre;
        apellido=a;
        this.sexo= sexo;
    }

    public String imprimir() throws Exception {

        if (nombre.isEmpty() || apellido.isEmpty())
            throw new Exception("Falta un dato");

        return "Nombre: " + nombre + "\n" + "Apellido: " + apellido;


    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getSexo() {
        return sexo;
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
    }
}
