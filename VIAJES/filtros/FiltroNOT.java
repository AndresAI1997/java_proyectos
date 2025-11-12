package viajes.filtros;

import VIAJES.Paquete;

public class FiltroNOT extends Filtro {
    // Negación de un filtro existente.

    private Filtro filtro;

    public FiltroNOT(Filtro filtro) {
        this.filtro = filtro;
    }

    @Override
    public boolean cumple(Paquete paquete) {
        return !filtro.cumple(paquete);
    }
}
