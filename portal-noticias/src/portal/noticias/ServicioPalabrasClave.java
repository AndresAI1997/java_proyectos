package portal.noticias;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
 
import portal.noticias.filtros.Filtro;

/**
 * Servicio para completar palabras clave sin mutar la noticia original.
 * Usa filtros del sistema (título, contenido, etc.) para decidir si agrega
 * nuevas palabras y devuelve una nueva instancia preservando la subclase.
 */
public final class ServicioPalabrasClave {
    private ServicioPalabrasClave() {}

    

    /**
     * Aplica un filtro sobre la noticia y, si cumple, retorna una copia
     * con las palabras clave agregadas. La semántica depende del filtro.
     */
    public static Noticia agregarSi(Noticia n, Filtro filtro, String... palabrasClave) {
        if (n.cumple(filtro)) {
            return copiarConPalabras(n, Arrays.asList(palabrasClave));
        }
        return n;
    }

    /** Helper interno: copia con una palabra nueva. */
    private static Noticia copiarConPalabra(Noticia n, String palabra) {
        List<String> nuevas = new ArrayList<>(n.getPalabrasClave());
        nuevas.add(palabra);
        return recrearNoticia(n, nuevas);
    }

    /** Helper interno: copia con varias palabras nuevas. */
    private static Noticia copiarConPalabras(Noticia n, List<String> palabras) {
        List<String> nuevas = new ArrayList<>(n.getPalabrasClave());
        nuevas.addAll(palabras);
        return recrearNoticia(n, nuevas);
    }

    // Métodos para añadir palabras manualmente a una noticia ya creada
    public static Noticia agregarPalabras(Noticia n, String... palabras) {
        List<String> nuevas = new ArrayList<>(n.getPalabrasClave());
        for (String p : palabras) nuevas.add(p);
        return recrearNoticia(n, nuevas);
    }

    public static Noticia agregarPalabras(Noticia n, List<String> palabras) {
        List<String> nuevas = new ArrayList<>(n.getPalabrasClave());
        nuevas.addAll(palabras);
        return recrearNoticia(n, nuevas);
    }

    /** Recrea la noticia con nuevas palabras, preservando su subclase. */
    private static Noticia recrearNoticia(Noticia n, List<String> nuevasPalabras) {
        if (n instanceof NoticiaDeportiva) {
            return new NoticiaDeportiva(n.getTitulo(), n.getContenido(), nuevasPalabras);
        }
        if (n instanceof NoticiaPatrocinada) {
            return new NoticiaPatrocinada(n.getTitulo(), n.getContenido(), n.getAutor(), n.getCategoria(), nuevasPalabras);
        }
        // Por defecto, genérica
        return new NoticiaGenerica(n.getTitulo(), n.getContenido(), n.getAutor(), n.getCategoria(), nuevasPalabras);
    }

    
}
