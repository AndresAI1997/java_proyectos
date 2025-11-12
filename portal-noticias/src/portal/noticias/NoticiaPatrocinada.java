package portal.noticias;

import java.util.List;
import portal.noticias.filtros.Filtro;

/** Noticia especial que siempre cumple cualquier filtro de búsqueda. */
public class NoticiaPatrocinada extends Noticia {
    public NoticiaPatrocinada(String titulo, String contenido, String autor, String categoria, List<String> palabrasClave) {
        super(titulo, contenido, autor, categoria, palabrasClave);
    }

    @Override
    /** Sobrescribe la evaluación de filtro para incluirse siempre. */
    public boolean cumple(Filtro filtro) {
        return true;
    }
}
