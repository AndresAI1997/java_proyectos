package portal.noticias;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import portal.noticias.filtros.Filtro;

/**
 * Noticia base (abstracta). Modela título, contenido, autor, categoría
 * y sus palabras clave (encapsuladas e inmutables hacia afuera).
 */
public abstract class Noticia implements ComponentePortal {
    private final String titulo;
    private final String contenido;
    private final String autor;
    private final String categoria;
    private List<String> palabrasClave;

    public Noticia(String titulo, String contenido, String autor, String categoria, List<String> palabrasClave) {
        this.titulo = titulo;
        this.contenido = contenido;
        this.autor = autor;
        this.categoria = categoria;
        this.palabrasClave = new ArrayList<>(palabrasClave);
    }

    public String getTitulo() { return titulo; }
    public String getContenido() { return contenido; }
    public String getAutor() { return autor; }
    public String getCategoria() { return categoria; }

    /** Devuelve copia inmutable de las palabras clave. */
    public List<String> getPalabrasClave() {
        return Collections.unmodifiableList(new ArrayList<>(palabrasClave));
    }

    /**
     * Permite que la noticia responda si cumple un filtro.
     * Subclases pueden sobreescribir (p.ej. patrocinadas devuelven true).
     */
    public boolean cumple(Filtro filtro) {
        return filtro.cumple(this);
    }


    @Override
    public String toString() {
        return titulo + " (" + categoria + ") - " + autor;
    }
}
