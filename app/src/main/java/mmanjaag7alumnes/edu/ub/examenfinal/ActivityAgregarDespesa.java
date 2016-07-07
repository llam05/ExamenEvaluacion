package mmanjaag7alumnes.edu.ub.examenfinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class ActivityAgregarDespesa extends AppCompatActivity {

    private Button aceptar, cancelar;
    private EditText cantidad, fecha;
    private RadioGroup radio;
    private Controlador objeto;
    private String categoria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_agregar_despesa);
        objeto = Comunicador.getObjeto();

        this.categoria = "ninguna";

        // Botones
        this.aceptar = (Button) findViewById(R.id.aceptarDespesa);
        this.cancelar = (Button) findViewById(R.id.cancelarDespesa);

        // Edit Text
        this.cantidad = (EditText) findViewById(R.id.cantidadDespesa1);
        this.fecha = (EditText) findViewById(R.id.dataDespesa1);


        //radioButon
        this.radio = (RadioGroup) findViewById(R.id.finalizada);
        radio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch(checkedId) {
                    case R.id.Rb1:
                        categoria = "Casa";
                        break;
                    case R.id.Rb2:
                        categoria = "Familia";
                        break;

                    case R.id.Rb3:
                        categoria = "Amics";
                        break;
                }
            }
        });

        this.aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                objeto.agregaDespesa(categoria, cantidad.getText().toString(), fecha.getText().toString());
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
