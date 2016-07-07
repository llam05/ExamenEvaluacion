package mmanjaag7alumnes.edu.ub.examenfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityDespeses extends AppCompatActivity {

    private Button agrega,muestra,salir;
    private Controlador control;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_despeses);
        control = Comunicador.getObjeto();

        this.agrega = (Button) findViewById(R.id.btnAgregaDespesa);
        this.muestra = (Button) findViewById(R.id.btnMostrarDespesa);
        this.salir = (Button) findViewById(R.id.salirDespesa);

        this.agrega.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Comunicador.setObjeto(control);
                Intent intent = new Intent(ActivityDespeses.this, ActivityAgregarDespesa.class);
                startActivity(intent);
            }
        });

        this.muestra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Comunicador.setObjeto(control);
                Intent intent = new Intent(ActivityDespeses.this, ActivityMostrarDespesa.class);
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
