package farmacia;

public class CondicionPorPrecio extends CondicionDeBusqueda {

	private double precio;
	
	public CondicionPorPrecio(double precio) {
		this.precio = precio;
	}
	
	@Override
	public boolean cumple(Medicamento medicamento) {
		return medicamento.getPrecio() <= precio;
	}

}
