package ar.edu.ort.primertp;

/**
 * Created by 41823413 on 19/4/2016.
 */
public class Alumno extends Persona {
    String curso;

    public Alumno(String nombre, String a, int sexo, String curso) {
        super(nombre, a, sexo);
        nombre = nombre;
        apellido=a;
        sexo= sexo;
        this.curso = curso;

    }

    public String imprimir() throws Exception {
super.imprimir();

        if (nombre.isEmpty() || apellido.isEmpty())
            throw new Exception("Falta un dato");
        if (curso.isEmpty())
            throw new Exception("Llene el campo Curso.");

        return "Nombre: " + nombre + "\n" + "Apellido: " + apellido + "\n" + "Curso: " + curso;

    }

    public int getSexo() {
        return sexo;
    }

}
