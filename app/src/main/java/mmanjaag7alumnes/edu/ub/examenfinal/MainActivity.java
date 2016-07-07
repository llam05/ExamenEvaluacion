package mmanjaag7alumnes.edu.ub.examenfinal;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button despeses,prestecs,deutes,guardar,cargar,salir;
    private Controlador control;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.despeses = (Button) findViewById(R.id.btnDespesa);
        this.deutes = (Button) findViewById(R.id.btnDeute);
        this.prestecs = (Button) findViewById(R.id.btnPrestec);
        this.salir = (Button) findViewById(R.id.salir);
        this.guardar = (Button) findViewById(R.id.guardar);
        this.cargar = (Button) findViewById(R.id.cargar);

        this.control = new Controlador();

        this.despeses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Comunicador.setObjeto(control);
                Intent intent = new Intent(MainActivity.this, ActivityDespeses.class);
                startActivity(intent);
            }
        });

        this.deutes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Comunicador.setObjeto(control);
                Intent intent = new Intent(MainActivity.this, ActivityDeutes.class);
                startActivity(intent);
            }
        });

        this.prestecs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Comunicador.setObjeto(control);
                Intent intent = new Intent(MainActivity.this, ActivityPrestecs.class);
                startActivity(intent);
            }
        });

        this.guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarDatos();
            }
        });

        this.cargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cargarDatos();
            }
        });

        this.salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    public void guardarDatos () {
        try {
            ObjectOutputStream archivo=new ObjectOutputStream(openFileOutput("notas.txt", Activity.MODE_PRIVATE));

            archivo.writeObject(control.getDespeses());
            archivo.writeObject(control.getDeutes());
            archivo.writeObject(control.getPrestecs());
            archivo.flush();
            archivo.close();
        } catch (IOException e) {
        }
        Toast t = Toast.makeText(this, "Los datos fueron grabados",
                Toast.LENGTH_SHORT);
        t.show();
    }

    public void cargarDatos () {
        try {
            ObjectInputStream br=new ObjectInputStream(openFileInput("notas.txt"));
            control.setDespeses((ArrayList<Despesa>) br.readObject());
            control.setDeutes((ArrayList<Deute>) br.readObject());
            control.setPrestecs((ArrayList<Prestec>) br.readObject());
        } catch (IOException e) {
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Toast t = Toast.makeText(this, "Los datos fueron cargados",
                Toast.LENGTH_SHORT);
        t.show();
    }
}
