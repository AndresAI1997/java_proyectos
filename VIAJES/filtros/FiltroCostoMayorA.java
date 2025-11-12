package viajes.filtros;

import VIAJES.Paquete;

public class FiltroCostoMayorA extends Filtro {
    // Filtra por costo mayor al mínimo.

    private double minimo;

    public FiltroCostoMayorA(double minimo) {
        this.minimo = minimo;
    }

    @Override
    public boolean cumple(Paquete paquete) {
        return paquete.getCosto() > minimo;
    }
}
