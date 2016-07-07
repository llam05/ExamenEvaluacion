package mmanjaag7alumnes.edu.ub.examenfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class ActivityModificaDespesa extends AppCompatActivity {

    private Button aceptar, cancelar;
    private EditText cantidad, fecha;
    private RadioGroup radio;
    private Controlador objeto;
    private String categoria,pos;
    private RadioButton ra1,ra2,ra3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_modifica_despesa);

        objeto = Comunicador.getObjeto();

        Intent i = getIntent();
        pos = i.getStringExtra("posicion");

        Despesa despesa;
        despesa = objeto.getDespeses().get(Integer.parseInt(pos));


        this.categoria = "ninguna";

        // Botones
        this.aceptar = (Button) findViewById(R.id.aceptarDespesa);
        this.cancelar = (Button) findViewById(R.id.cancelarDespesa);

        // Edit Text
        this.cantidad = (EditText) findViewById(R.id.cantidadDespesa1);
        this.fecha = (EditText) findViewById(R.id.dataDespesa1);
        this.cantidad.setText(despesa.getCantidad().toString());
        this.fecha.setText(despesa.getFecha().toString());


        //radioButon
        this.radio = (RadioGroup) findViewById(R.id.finalizada);
        this.ra1 = (RadioButton) findViewById(R.id.Rb1);
        this.ra2 = (RadioButton) findViewById(R.id.Rb2);
        this.ra3 = (RadioButton) findViewById(R.id.Rb3);

        if (despesa.getCategoria().equals("Casa")){
            ra1.setChecked(true);
            ra2.setChecked(false);
            ra3.setChecked(false);
        } else if(despesa.getCategoria().equals("Familia")){
            ra1.setChecked(false);
            ra2.setChecked(true);
            ra3.setChecked(false);
        } else if (despesa.getCategoria().equals("Amics")) {
            ra1.setChecked(false);
            ra2.setChecked(false);
            ra3.setChecked(true);
        }
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

                objeto.eliminaDespesa(Integer.parseInt(pos));
                objeto.modificaDespesa(categoria, cantidad.getText().toString(), fecha.getText().toString());
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
