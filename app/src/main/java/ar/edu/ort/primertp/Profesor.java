package ar.edu.ort.primertp;

/**
 * Created by 41823413 on 19/4/2016.
 */
public class Profesor extends Persona {
    String materia;

    public Profesor(String nombre, String a, int sexo, String materia) {
        super(nombre, a, sexo);
        nombre = nombre;
        apellido=a;
        sexo= sexo;
        this.materia = materia;

    }

    public String imprimir() throws Exception {
        super.imprimir();
        if (nombre.isEmpty() || apellido.isEmpty())
            throw new Exception("Falta un dato");
        if (materia.isEmpty())
            throw new Exception("Llene el campo Curso.");

        return "Nombre: " + nombre + "\n" + "Apellido: " + apellido + "\n" + "Materia: " + materia;

    }

    public int getSexo() {
        return sexo;
    }


}
