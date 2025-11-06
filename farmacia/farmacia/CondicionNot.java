package farmacia;

public class CondicionNot extends CondicionDeBusqueda {
	
	private CondicionDeBusqueda c1;
	
	public CondicionNot(CondicionDeBusqueda c1) {
		this.c1 = c1;
	}
	
	@Override
	public boolean cumple(Medicamento medicamento) {
		return !c1.cumple(medicamento);
	}

}
