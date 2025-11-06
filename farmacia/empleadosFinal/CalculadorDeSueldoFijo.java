package empleadosFinal;

public class CalculadorDeSueldoFijo extends CalculadorDeSueldo {
	
	private double sueldoFijo;
	
	public CalculadorDeSueldoFijo(double sueldoFijo) {
		this.sueldoFijo = sueldoFijo;
	}

	public double calcularSueldo() {
		return this.sueldoFijo;
	}

}
