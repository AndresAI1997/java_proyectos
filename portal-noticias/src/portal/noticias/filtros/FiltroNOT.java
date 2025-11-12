package portal.noticias.filtros;

import portal.noticias.ComponentePortal;

/** Niega el resultado de otro filtro. */
public class FiltroNOT extends Filtro {
    private final Filtro filtro;

    public FiltroNOT(Filtro filtro) {
        this.filtro = filtro;
    }

    @Override
    public boolean cumple(ComponentePortal componente) {
        return !filtro.cumple(componente);
    }
}
