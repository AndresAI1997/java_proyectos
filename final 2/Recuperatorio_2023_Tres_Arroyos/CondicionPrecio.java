public class CondicionPrecio {
    private double precioMax;

    public CondicionPrecio(double precioMax){
        this.precioMax = precioMax;
    }

    public boolean cumple(ElementoEducativo e){
        return e.getPrecio() < precioMax;
    }
}
