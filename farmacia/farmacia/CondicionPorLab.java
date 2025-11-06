package farmacia;

public class CondicionPorLab extends CondicionDeBusqueda {

	private String lab;
	
	public CondicionPorLab(String lab) {
		this.lab = lab;
	}
	
	@Override
	public boolean cumple(Medicamento medicamento) {
		return medicamento.getLab().equals(this.lab);
	}
	
	

}
