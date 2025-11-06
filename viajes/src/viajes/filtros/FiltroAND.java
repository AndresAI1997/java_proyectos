package viajes.filtros;

import viajes.Paquete;

public class FiltroAND extends Filtro {

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
