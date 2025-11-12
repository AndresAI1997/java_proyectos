package portal.noticias.filtros;

import portal.noticias.ComponentePortal;

/** Combina dos filtros con lógica AND. */
public class FiltroAND extends Filtro {
    private final Filtro primero;
    private final Filtro segundo;

    public FiltroAND(Filtro primero, Filtro segundo) {
        this.primero = primero;
        this.segundo = segundo;
    }

    @Override
    public boolean cumple(ComponentePortal componente) {
        return primero.cumple(componente) && segundo.cumple(componente);
    }
}
