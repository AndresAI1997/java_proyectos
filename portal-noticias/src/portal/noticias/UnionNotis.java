package portal.noticias;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * Base para uniones de componentes (secciones/grupos).
 * Almacena componentes inmutablemente y agrega palabras clave únicas.
 */
public abstract class UnionNotis implements ComponentePortal {
    private final String nombre;
    private final List<ComponentePortal> componentes;

    protected UnionNotis(String nombre) {
        this(nombre, Collections.emptyList());
    }

    protected UnionNotis(String nombre, List<ComponentePortal> componentes) {
        this.nombre = nombre;
        this.componentes = Collections.unmodifiableList(new ArrayList<>(componentes));
    }

    protected UnionNotis(String nombre, ComponentePortal... componentes) {
        this(nombre, Arrays.asList(componentes));
    }

    public String getNombre() { return nombre; }

    /** Componentes contenidos (lista inmutable). */
    public List<ComponentePortal> getComponentes() {
        return componentes;
    }

    public List<String> getPalabrasClave() {
        LinkedHashSet<String> unicas = new LinkedHashSet<>();
        for (ComponentePortal c : componentes) {
            unicas.addAll(c.getPalabrasClave());
        }
        return Collections.unmodifiableList(new ArrayList<>(unicas));
    }

    /** Obtiene categoría desde una posición 1-based o "sin definir" si no existe. */
    protected String categoriaDesdePosicion(int posicion1Base) {
        int idx = posicion1Base - 1;
        if (idx < 0 || idx >= componentes.size()) {
            return "sin definir";
        }
        return componentes.get(idx).getCategoria();
    }

    public abstract String getCategoria();

    public abstract String tipo();

    @Override
    public String toString() {
        return tipo() + " \"" + nombre + "\" con " + noticias.size() + " noticias";
    }
}
