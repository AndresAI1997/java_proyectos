package portal.noticias.filtros;

import portal.noticias.ComponentePortal;
import portal.noticias.Noticia;

/** Contenido contiene (subcadena, case-insensitive). */
public class FiltroContenidoContiene extends Filtro {
    private final String texto;

    public FiltroContenidoContiene(String texto) {
        this.texto = texto;
    }

    @Override
    public boolean cumple(ComponentePortal componente) {
        if (componente instanceof Noticia) {
            Noticia n = (Noticia) componente;
            return n.getContenido().toLowerCase().contains(texto.toLowerCase());
        }
        return false;
    }
}
