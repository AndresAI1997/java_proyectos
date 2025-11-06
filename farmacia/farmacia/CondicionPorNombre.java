package farmacia;

public class CondicionPorNombre extends CondicionDeBusqueda {
	
	private String nombre;
	
	public CondicionPorNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public boolean cumple(Medicamento medicamento) {
		//return medicamento.getNombre().equals(this.nombre);
		return medicamento.getNombre().contains(nombre);
	}

}
