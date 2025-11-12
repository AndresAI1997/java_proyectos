package viajes.filtros;

import VIAJES.Paquete;

public abstract class Filtro {
    // Clase base para filtros de búsqueda.

    public abstract boolean cumple(Paquete paquete);
}
