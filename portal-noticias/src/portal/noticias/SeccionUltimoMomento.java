package portal.noticias;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Sección "último momento": categoría fija y palabras clave
 * ordenadas alfabéticamente (máximo 5).
 */
public class SeccionUltimoMomento extends Secciones {
    
    public SeccionUltimoMomento(String nombre, int posicionCategoria, ComponentePortal... componentes) {
        super(nombre, posicionCategoria, componentes);
    }

    @Override
    public String getCategoria() {
        return "ultimo momento";
    }

    @Override
    public List<String> getPalabrasClave() {
        List<String> base = new ArrayList<>(super.getPalabrasClave());
        Collections.sort(base, String::compareToIgnoreCase);
        if (base.size() > 5) {
            base = new ArrayList<>(base.subList(0, 5));
        }
        return Collections.unmodifiableList(base);
    }
}
