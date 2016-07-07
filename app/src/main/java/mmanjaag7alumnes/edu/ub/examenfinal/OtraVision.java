package mmanjaag7alumnes.edu.ub.examenfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class OtraVision extends AppCompatActivity {

    private TextView cantidad, persona;
    private Controlador control;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otra_vision);

        this.control = Comunicador.getObjeto();

        this.cantidad = (TextView) findViewById(R.id.asig);
        this.persona = (TextView) findViewById(R.id.persona1);


        Intent i = getIntent();
        String scantidad = i.getStringExtra("cantidad");
        String sdata = i.getStringExtra("persona");

        this.cantidad.setText(scantidad);
        this.persona.setText(sdata);

    }
 }

