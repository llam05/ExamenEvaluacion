package mmanjaag7alumnes.edu.ub.examenfinal;

/**
 * Created by mmanjaag7.alumnes on 03/06/16.
 */
class Comunicador {
    private static Controlador objeto = null;

    public static void setObjeto(Controlador newObjeto) {
        objeto = newObjeto;
    }

    public static Controlador getObjeto() {
        return objeto;
    }
}
