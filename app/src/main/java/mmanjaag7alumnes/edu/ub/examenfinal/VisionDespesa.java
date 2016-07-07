package mmanjaag7alumnes.edu.ub.examenfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class VisionDespesa extends AppCompatActivity {

    private TextView cantidad, data, categoria;
    private Button volver, modifica, elimina;
    private Controlador control;
    private String pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vision_despesa);

        this.control = Comunicador.getObjeto();

        this.cantidad = (TextView) findViewById(R.id.asig);
        this.data = (TextView) findViewById(R.id.dataDespesa1);
        this.categoria = (TextView) findViewById(R.id.categoria1);

        this.elimina = (Button) findViewById(R.id.eliminar);
        this.modifica = (Button) findViewById(R.id.modifi);

        Intent i = getIntent();
        String scantidad = i.getStringExtra("cantidad");
        String sdata = i.getStringExtra("data");
        String scategoria = i.getStringExtra("categoria");
        pos = i.getStringExtra("posicion");

        this.cantidad.setText(scantidad);
        this.data.setText(sdata);
        this.categoria.setText(scategoria);


        this.elimina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                control.eliminaDespesa(Integer.parseInt(pos));
                Intent intent = new Intent(VisionDespesa.this, ActivityMostrarDespesa.class);
                startActivity(intent);
                finish();
            }
        });

        this.modifica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Comunicador.setObjeto(control);
                Intent intent = new Intent(VisionDespesa.this, ActivityModificaDespesa.class);
                intent.putExtra("posicion", pos);
                startActivity(intent);
                finish();
            }
        });
    }
}
