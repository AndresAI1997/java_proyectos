package viajes.filtros;

import VIAJES.Paquete;

public class FiltroCostoEntre extends Filtro {
    // Filtra por costo entre dos valores.

    private double minimo;
    private double maximo;

    public FiltroCostoEntre(double minimo, double maximo) {
        this.minimo = minimo;
        this.maximo = maximo;
    }

    @Override
    public boolean cumple(Paquete paquete) {
        double c = paquete.getCosto();
        return c >= minimo && c <= maximo;
    }
}
