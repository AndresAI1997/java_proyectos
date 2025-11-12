package portal.noticias.filtros;

import portal.noticias.ComponentePortal;

/** Base abstracta para filtros de búsqueda. */
public abstract class Filtro {
    /** Evalúa si el componente cumple el criterio. */
    public abstract boolean cumple(ComponentePortal componente);
}
