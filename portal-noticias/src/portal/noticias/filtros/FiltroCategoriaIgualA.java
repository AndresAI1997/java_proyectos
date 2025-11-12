package portal.noticias.filtros;

import java.util.Objects;
import portal.noticias.ComponentePortal;

/** Filtra componentes por categoría exacta. */
public class FiltroCategoriaIgualA extends Filtro {
    private final String categoria;

    public FiltroCategoriaIgualA(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public boolean cumple(ComponentePortal componente) {
        return Objects.equals(categoria, componente.getCategoria());
    }
}
