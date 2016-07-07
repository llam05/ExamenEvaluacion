package mmanjaag7alumnes.edu.ub.examenfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ActivityMostrarDespesa extends AppCompatActivity {

    private Controlador control;
    private ListView lista;
    private String valor;
    private ArrayList<Despesa> despeses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_mostrar_despesa);

        control = Comunicador.getObjeto();

        lista = (ListView) findViewById(R.id.lista);

        this.despeses = new ArrayList<Despesa>();
        this.despeses = control.getDespeses();

        this.lista.setAdapter(new DespesaAdapter(this, despeses));

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long arg) {

                Despesa item = (Despesa) lista.getAdapter().getItem(position);
                Intent intent = new Intent(ActivityMostrarDespesa.this, VisionDespesa.class);
                intent.putExtra("cantidad", item.getCantidad());
                intent.putExtra("data", item.getFecha());
                intent.putExtra("categoria", item.getCategoria());
                intent.putExtra("posicion", Integer.toString(position));

                startActivity(intent);
                finish();

            }
        });


    }
}
