package portal.noticias;

import java.util.List;

/** Noticia sin comportamiento especial; usa la lógica base de Noticia. */
public class NoticiaGenerica extends Noticia {
    public NoticiaGenerica(String titulo, String contenido, String autor, String categoria, List<String> palabrasClave) {
        super(titulo, contenido, autor, categoria, palabrasClave);
    }
}
