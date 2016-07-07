package mmanjaag7alumnes.edu.ub.examenfinal;

import java.io.Serializable;

/**
 * Created by mmanjaag7.alumnes on 07/07/16.
 */
public class Prestec implements Serializable{

    private String persona, cantidad;

    public Prestec(String persona, String cantidad) {
        this.persona = persona;
        this.cantidad = cantidad;
    }

    public String getPersona() {
        return persona;
    }

    public void setPersona(String persona) {
        this.persona = persona;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

}
