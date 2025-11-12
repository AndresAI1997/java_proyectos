package portal.noticias;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** Sección con categoría fija "qatar2022" y top 3 palabras clave. */
public class SeccionQatar2022 extends Secciones {
    public SeccionQatar2022(String nombre, int posicionCategoria, ComponentePortal... componentes) {
        super(nombre, posicionCategoria, componentes);
    }

    @Override
    public String getCategoria() {
        return "qatar2022";
    }

    @Override
    public List<String> getPalabrasClave() {
        List<String> base = new ArrayList<>(super.getPalabrasClave());
        if (base.size() > 3) {
            base = new ArrayList<>(base.subList(0, 3));
        }
        return Collections.unmodifiableList(base);
    }
}
