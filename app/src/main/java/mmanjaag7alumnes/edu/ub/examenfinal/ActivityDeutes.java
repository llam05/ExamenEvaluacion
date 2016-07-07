package mmanjaag7alumnes.edu.ub.examenfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityDeutes extends AppCompatActivity {

    private Button agrega,muestra,salir;
    private Controlador control;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_deutes);
        control = Comunicador.getObjeto();

        this.agrega = (Button) findViewById(R.id.btnAgregaDeutes);
        this.muestra = (Button) findViewById(R.id.btnMostrarDeutes);
        this.salir = (Button) findViewById(R.id.salirDeutes);

        this.agrega.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Comunicador.setObjeto(control);
                Intent intent = new Intent(ActivityDeutes.this, ActivityAgregaDeute.class);
                startActivity(intent);
            }
        });

        this.muestra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Comunicador.setObjeto(control);
                Intent intent = new Intent(ActivityDeutes.this, ActivityMostrarDeute.class);
                startActivity(intent);
            }
        });

        this.salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
