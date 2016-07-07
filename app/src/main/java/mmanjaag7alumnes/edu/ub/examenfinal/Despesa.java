package mmanjaag7alumnes.edu.ub.examenfinal;

import java.io.Serializable;

/**
 * Created by mmanjaag7.alumnes on 07/07/16.
 */
public class Despesa implements Serializable {

    private String categoria, cantidad, fecha;

    public Despesa(String categoria, String cantidad, String fecha) {
        this.categoria = categoria;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
