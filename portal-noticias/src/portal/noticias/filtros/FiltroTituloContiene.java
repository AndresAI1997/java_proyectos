package portal.noticias.filtros;

import portal.noticias.ComponentePortal;
import portal.noticias.Noticia;

/** Título contiene (subcadena, case-insensitive). */
public class FiltroTituloContiene extends Filtro {
    private final String texto;

    public FiltroTituloContiene(String texto) {
        this.texto = texto;
    }

    @Override
    public boolean cumple(ComponentePortal componente) {
        if (componente instanceof Noticia) {
            Noticia n = (Noticia) componente;
            return n.getTitulo().toLowerCase().contains(texto.toLowerCase());
        }
        return false;
    }
}
