package ar.edu.ort.primertp;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    int sexo;
    int tipo;
    int proceso;
    ArrayList<Persona> Personas;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
        Personas = new ArrayList<>();

    }


    public void btnAgregarPersona(View v) {


        EditText nombre = (EditText) findViewById(R.id.nombre);
        EditText apellido = (EditText) findViewById(R.id.apellido);
        EditText materia = (EditText) findViewById(R.id.materia);
        EditText curso = (EditText) findViewById(R.id.curso);
        Intent intent = new Intent(this, printActivity.class);

        Persona persona;
        if (nombre != null || apellido != null || (materia != null && curso != null)) {
            if (tipo == 1) {
                persona = new Profesor(nombre.getText().toString(), apellido.getText().toString(), sexo, materia.getText().toString());
                //intent.putExtra("persona", PerArray);
                Personas.add(persona);
            } else if (tipo == 2) {
                persona = new Alumno(nombre.getText().toString(), apellido.getText().toString(), sexo, curso.getText().toString());
                //intent.putExtra("persona", PerArray);
                Personas.add(persona);
            }
        }
            else
            {
                Toast.makeText(this, "Hay campos vacios.", Toast.LENGTH_LONG).show();
            }


        ((EditText) findViewById(R.id.nombre)).getText().clear();
        ((EditText) findViewById(R.id.apellido)).getText().clear();
        ((EditText) findViewById(R.id.materia)).getText().clear();
        ((EditText) findViewById(R.id.curso)).getText().clear();
    }

    public void btnImprimir(View v) {

        ImageView vv;
        EditText nombre = (EditText) findViewById(R.id.nombre);
        EditText apellido = (EditText) findViewById(R.id.apellido);
        EditText materia = (EditText) findViewById(R.id.materia);
        EditText curso = (EditText) findViewById(R.id.curso);
        Intent intent = new Intent(this, printActivity.class);
        Persona p = new Persona(nombre.getText().toString(), apellido.getText().toString(), sexo);
        if (tipo == 1) {
            Persona Per = new Profesor(nombre.getText().toString(), apellido.getText().toString(), sexo, materia.getText().toString());
            intent.putExtra("persona", Per);
        } else if (tipo == 2) {
            Persona Per = new Alumno(nombre.getText().toString(), apellido.getText().toString(), sexo, curso.getText().toString());
            intent.putExtra("persona", Per);
        }

        for (Persona persona : Personas) {
            try {
                Log.d(this.getClass().getSimpleName(), persona.imprimir());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        intent.putExtra("pers1", p);
        //intent.putExtra("pers2", p2);
        startActivity(intent);
    }


    public void eligeSexo(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.masculino:
                if (checked)
                    //Toast.makeText(this,"Masculino", Toast.LENGTH_SHORT).show();
                    sexo = Persona.MASCULINO;
                break;
            case R.id.femenino:
                if (checked)
                    //Toast.makeText(this,"Femenino", Toast.LENGTH_SHORT).show();
                    sexo = Persona.FEMENINO;
                break;
        }
    }

    public void eligeProfesion(View view) {
        EditText materia = (EditText) findViewById(R.id.materia);
        EditText curso = (EditText) findViewById(R.id.curso);
        RadioButton alumno = (RadioButton) findViewById(R.id.alumno);
        RadioButton profesor = (RadioButton) findViewById(R.id.profesor);
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.profesor:
                if (checked)
                    //Toast.makeText(this,"Profesor", Toast.LENGTH_SHORT).show();
                    materia.setVisibility(View.VISIBLE);
                curso.setVisibility(View.GONE);
                tipo = 1;
                break;
            case R.id.alumno:
                if (checked)
                    //Toast.makeText(this,"Alumno", Toast.LENGTH_SHORT).show();
                    curso.setVisibility(View.VISIBLE);
                materia.setVisibility(View.GONE);
                tipo = 2;
                break;
        }
    }

    public void eligeProceso(View view) {
        EditText materia = (EditText) findViewById(R.id.materia);
        EditText curso = (EditText) findViewById(R.id.curso);
        RadioButton alumno = (RadioButton) findViewById(R.id.alumno);
        RadioButton profesor = (RadioButton) findViewById(R.id.profesor);
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.NombreMasLargo:
                if (checked)
                    //Toast.makeText(this,"Profesor", Toast.LENGTH_SHORT).show();

                 proceso = 1;
                break;
            case R.id.NombreConMasA:
                if (checked)
                    proceso = 2;
                break;
        }
    }


    public void btnProcesarPersonas (View v) {

        EditText materia = (EditText) findViewById(R.id.materia);
        EditText curso = (EditText) findViewById(R.id.curso);
        RadioButton alumno = (RadioButton) findViewById(R.id.alumno);
        RadioButton profesor = (RadioButton) findViewById(R.id.profesor);
        RadioButton NombreMasLargo = (RadioButton) findViewById(R.id.NombreMasLargo);
        RadioButton NombreConMasA = (RadioButton) findViewById(R.id.NombreConMasA);

        if (proceso == 1)
        {
            int NombreLargo = 0;
            Persona NombreLargo2=null;

                for (Persona persona : Personas) {
                    if (persona.nombre.length() > NombreLargo) {
                        NombreLargo = persona.nombre.length();
                        NombreLargo2 = persona;
                    }
                }
            Intent INTENTO = new Intent(this, printActivity.class);
            INTENTO.putExtra("persona", NombreLargo2);
            startActivity(INTENTO);
            }


        if (proceso == 2) {
            int cantA1 = 0;
            Persona anombre = null;
            Persona persona;
            for (int i = 0; i < Personas.size(); i++) {
                persona = Personas.get(i);
                int cantA = 0;
                for (int y = 0; y < persona.nombre.length(); y++) {
                    if (persona.nombre.charAt(y) == 'a' || persona.nombre.charAt(y) == 'A') {
                        cantA++;
                    }

                    if (cantA > cantA1) {
                        cantA1 = cantA;
                        anombre = persona;
                    }
                }

            }
            Intent INTENTO2 = new Intent(this, printActivity.class);
            INTENTO2.putExtra("persona", anombre);
            startActivity(INTENTO2);
            }
        }


    public void btnInvisible(View v) {
        EditText apellido = (EditText) findViewById(R.id.apellido);
        apellido.setVisibility(View.INVISIBLE);
        EditText nombre = (EditText) findViewById(R.id.nombre);
        nombre.setTextColor(Color.BLUE);
    }

    public void btnGone(View v) {
        EditText apellido = (EditText) findViewById(R.id.apellido);
        apellido.setVisibility(View.GONE);
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://ar.edu.ort.primertp/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://ar.edu.ort.primertp/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
