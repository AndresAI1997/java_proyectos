package portal.noticias.filtros;

import portal.noticias.ComponentePortal;

/** Verifica que el componente contenga una palabra clave exacta. */
public class FiltroContienePalabraClave extends Filtro {
    private final String palabraClave;

    public FiltroContienePalabraClave(String palabraClave) {
        this.palabraClave = palabraClave;
    }

    @Override
    public boolean cumple(ComponentePortal componente) {
        return componente.getPalabrasClave().contains(palabraClave);
    }
}
