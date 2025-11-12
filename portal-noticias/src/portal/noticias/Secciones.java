package portal.noticias;

/**
 * Sección abstracta del portal. Subclases pueden fijar categoría
 * o derivarla según reglas propias (posición, o fija).
 */
public abstract class Secciones extends UnionNotis {
    private int posicionCategoria;

    public Secciones(String nombre, int posicionCategoria, ComponentePortal... componentes) {
        super(nombre, componentes);
        this.posicionCategoria = posicionCategoria;
    }

    @Override
    public String tipo() {
        return "Sección";
    }

    @Override
    public String getCategoria() {
        return (posicionCategoria > 0) ? categoriaDesdePosicion(posicionCategoria) : "sin definir";
    }

    public void setPosicionCategoria(int posicionCategoria) {
        this.posicionCategoria = posicionCategoria;
    }
}
