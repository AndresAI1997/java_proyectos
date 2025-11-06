package empleadosFinal;

public class CalculadorPorComision extends CalculadorDeSueldo {

	private double ventas;
	private double comision;
	
	public CalculadorPorComision(double ventas, double comision) {
		this.ventas = ventas;
		this.comision = comision;
	}
	
	@Override
	public double calcularSueldo() {
		return this.ventas * this.comision;
	}
	
	

}
