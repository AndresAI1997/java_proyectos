package viajes.filtros;

import VIAJES.Paquete;

public class FiltroAND extends Filtro {
    // Combinación lógica AND de filtros.

    private Filtro primero;
    private Filtro segundo;

    public FiltroAND(Filtro primero, Filtro segundo) {
        this.primero = primero;
        this.segundo = segundo;
    }

    @Override
    public boolean cumple(Paquete paquete) {
        return primero.cumple(paquete) && segundo.cumple(paquete);
    }
}
