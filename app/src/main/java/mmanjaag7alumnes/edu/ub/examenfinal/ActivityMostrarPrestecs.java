package mmanjaag7alumnes.edu.ub.examenfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ActivityMostrarPrestecs extends AppCompatActivity {

    private Controlador control;
    private ListView lista;
    private ArrayList<Prestec> prestecs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_mostrar_prestecs);

        control = Comunicador.getObjeto();

        lista = (ListView) findViewById(R.id.listaPrestec);

        this.prestecs = new ArrayList<Prestec>();
        this.prestecs = control.getPrestecs();

        this.lista.setAdapter(new PrestecAdapter(this, prestecs));

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long arg) {

                Prestec item = (Prestec) lista.getAdapter().getItem(position);
                Intent intent = new Intent(ActivityMostrarPrestecs.this, OtraVision.class);
                intent.putExtra("cantidad", item.getCantidad());
                intent.putExtra("persona", item.getPersona());

                startActivity(intent);
                finish();

            }
        });
    }
}
