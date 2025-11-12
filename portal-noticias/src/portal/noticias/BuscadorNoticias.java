package portal.noticias;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import portal.noticias.filtros.Filtro;

/**
 * Utilidad para buscar noticias dentro de un árbol de componentes.
 * Aplana la jerarquía y aplica filtros devolviendo una lista inmutable,
 * evitando duplicados por título (no por identidad de objeto).
 */
public final class BuscadorNoticias {
    private BuscadorNoticias() {}

    /** Busca noticias dentro de una lista de componentes (sin duplicados por título). */
    public static List<Noticia> buscar(List<ComponentePortal> componentes, Filtro filtro) {
        List<Noticia> todas = new ArrayList<>();
        for (ComponentePortal c : componentes) {
            extraer(c, todas);
        }
        List<Noticia> res = new ArrayList<>();
        Set<String> titulosVistos = new LinkedHashSet<>();
        for (Noticia n : todas) {
            if (n.cumple(filtro)) {
                String titulo = n.getTitulo();
                if (titulosVistos.add(titulo)) {
                    res.add(n);
                }
            }
        }
        return java.util.Collections.unmodifiableList(new ArrayList<>(res));
    }

    /** Busca noticias a partir de un componente raíz (sin duplicados por título). */
    public static List<Noticia> buscar(ComponentePortal componente, Filtro filtro) {
        List<Noticia> todas = new ArrayList<>();
        extraer(componente, todas);
        List<Noticia> res = new ArrayList<>();
        Set<String> titulosVistos = new LinkedHashSet<>();
        for (Noticia n : todas) {
            if (n.cumple(filtro)) {
                String titulo = n.getTitulo();
                if (titulosVistos.add(titulo)) {
                    res.add(n);
                }
            }
        }
        return java.util.Collections.unmodifiableList(new ArrayList<>(res));
    }

    /** Recorre recursivamente y acumula solo instancias de Noticia. */
    private static void extraer(ComponentePortal c, List<Noticia> acc) {
        if (c instanceof Noticia) {
            acc.add((Noticia) c);
        } else if (c instanceof UnionNotis) {
            for (ComponentePortal hijo : ((UnionNotis) c).getComponentes()) {
                extraer(hijo, acc);
            }
        }
    }
}
