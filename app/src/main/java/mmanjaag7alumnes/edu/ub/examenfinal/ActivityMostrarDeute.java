package mmanjaag7alumnes.edu.ub.examenfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ActivityMostrarDeute extends AppCompatActivity {

    private Controlador control;
    private ListView lista;
    private ArrayList<Deute> deutes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_mostrar_deute);

        control = Comunicador.getObjeto();

        lista = (ListView) findViewById(R.id.listaDeute);

        this.deutes = new ArrayList<Deute>();
        this.deutes = control.getDeutes();

        this.lista.setAdapter(new DeuteAdapter(this, deutes));

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long arg) {

                Deute item = (Deute) lista.getAdapter().getItem(position);
                Intent intent = new Intent(ActivityMostrarDeute.this, OtraVision.class);
                intent.putExtra("cantidad", item.getCantidad());
                intent.putExtra("persona", item.getPersona());

                startActivity(intent);
                finish();

            }
        });
    }
}
