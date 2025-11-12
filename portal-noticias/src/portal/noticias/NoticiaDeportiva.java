package portal.noticias;

import java.util.List;

/** Noticia de categoría Deportes y autor fijo. */
public class NoticiaDeportiva extends Noticia {
    private static final String AUTOR_FIJO = "Ernesto Cherq";
    private static final String CATEGORIA_FIJA = "Deportes";
    
    public NoticiaDeportiva(String titulo, String contenido, List<String> palabrasClave) {
        super(titulo, contenido, AUTOR_FIJO, CATEGORIA_FIJA, palabrasClave);
    }
}
