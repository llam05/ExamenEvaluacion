package mmanjaag7alumnes.edu.ub.examenfinal;

import android.app.Activity;

import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Created by mmanjaag7.alumnes on 07/07/16.
 */
public class Controlador {

    private ArrayList<Despesa> despeses;
    private ArrayList<Deute> deutes;
    private ArrayList<Prestec> prestecs;

    public Controlador() {
        this.despeses = new ArrayList<Despesa>();
        this.deutes = new ArrayList<Deute>();
        this.prestecs = new ArrayList<Prestec>();
    }

    public ArrayList<Despesa> getDespeses() {
        return despeses;
    }

    public ArrayList<Deute> getDeutes() {
        return deutes;
    }

    public ArrayList<Prestec> getPrestecs() {
        return prestecs;
    }

    public void setDespeses(ArrayList<Despesa> despeses) {
        this.despeses = despeses;
    }

    public void setDeutes(ArrayList<Deute> deutes) {
        this.deutes = deutes;
    }

    public void setPrestecs(ArrayList<Prestec> prestecs) {
        this.prestecs = prestecs;
    }

    public void agregaDespesa (String categoria, String cantidad, String fecha) {
        this.despeses.add(new Despesa(categoria,cantidad,fecha));
    }

    public void modificaDespesa (String categoria, String cantidad, String fecha) {
        this.despeses.add(new Despesa(categoria, cantidad, fecha));
    }

    public void eliminaDespesa (int pos) {
        this.despeses.remove(pos);
    }

    public void agregaDeute (String persona, String cantidad) {
        this.deutes.add(new Deute(persona,cantidad));
    }

    public void agregaPrestec (String persona, String cantidad) {
        this.prestecs.add(new Prestec(persona, cantidad));
    }


}
