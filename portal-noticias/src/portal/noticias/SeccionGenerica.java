package portal.noticias;

/** Implementación simple de sección que usa el comportamiento por defecto. */
public class SeccionGenerica extends Secciones {
    public SeccionGenerica(String nombre, int posicionCategoria, ComponentePortal... componentes) {
        super(nombre, posicionCategoria, componentes);
    }
}
