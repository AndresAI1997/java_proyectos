package portal.noticias.filtros;

import java.util.Objects;
import portal.noticias.ComponentePortal;
import portal.noticias.Noticia;

/** Filtra noticias por autor exacto (solo aplica a Noticia). */
public class FiltroAutorIgualA extends Filtro {
    private final String autor;

    public FiltroAutorIgualA(String autor) {
        this.autor = autor;
    }

    @Override
    public boolean cumple(ComponentePortal componente) {
        if (componente instanceof Noticia) {
            Noticia n = (Noticia) componente;
            return Objects.equals(autor, n.getAutor());
        }
        return false;
    }
}
