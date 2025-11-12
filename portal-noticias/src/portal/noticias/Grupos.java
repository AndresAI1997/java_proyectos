package portal.noticias;

/** Grupo de componentes (similar a sección, con su propia categoría derivada). */
public class Grupos extends UnionNotis {
    private int posicionCategoria;

    public Grupos(String nombre) {
        super(nombre);
    }

    public Grupos(String nombre, ComponentePortal... componentes) {
        super(nombre, componentes);
    }

    public Grupos(String nombre, int posicionCategoria, ComponentePortal... componentes) {
        super(nombre, componentes);
        this.posicionCategoria = posicionCategoria;
    }

    @Override
    public String tipo() {
        return "Grupo";
    }

    @Override
    public String getCategoria() {
        return (posicionCategoria > 0) ? categoriaDesdePosicion(posicionCategoria) : "sin definir";
    }

    public void setPosicionCategoria(int posicionCategoria) {
        this.posicionCategoria = posicionCategoria;
    }
}
