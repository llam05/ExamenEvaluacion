package mmanjaag7alumnes.edu.ub.examenfinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActivityAgregaPrestec extends AppCompatActivity {

    private Button aceptar, cancelar;
    private EditText persona, cantidad;
    private Controlador objeto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_agrega_prestec);
        objeto = Comunicador.getObjeto();

        // Botones
        this.aceptar = (Button) findViewById(R.id.aceptarPrestec);
        this.cancelar = (Button) findViewById(R.id.cancelarPrestec);

        // Edit Text
        this.cantidad = (EditText) findViewById(R.id.cantidadPrestec1);
        this.persona = (EditText) findViewById(R.id.personaPrestec1);


        this.aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                objeto.agregaPrestec(persona.getText().toString(), cantidad.getText().toString());
                finish();

            }
        });

        this.cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
