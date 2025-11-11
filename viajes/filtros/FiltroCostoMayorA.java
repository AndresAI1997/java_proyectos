package viajes.filtros;

import viajes.Paquete;

public class FiltroCostoMayorA extends Filtro {

    private double minimo;

    public FiltroCostoMayorA(double minimo) {
        this.minimo = minimo;
    }

    @Override
    public boolean cumple(Paquete paquete) {
        return paquete.getCosto() > minimo;
    }
}
