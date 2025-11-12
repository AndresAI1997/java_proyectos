package portal.noticias;

import java.util.List;

/**
 * Contrato común para elementos del portal (Noticias, Secciones, Grupos).
 * Permite tratarlos de forma homogénea en colecciones y filtros.
 */
public interface ComponentePortal {
    /** Categoría del componente (puede ser fija o derivada). */
    String getCategoria();

    /** Palabras clave visibles del componente (siempre lista inmutable). */
    List<String> getPalabrasClave();
}
