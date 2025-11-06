package empleados;

// Todos tienen sueldo fijo, y no permite otras combinaciones
public class CalculadorDeSueldo {
	
	private double sueldoFijo;
	
	public CalculadorDeSueldo(double sueldoFijo) {
		this.sueldoFijo = sueldoFijo;
	}

	public double calcularSueldo() {
		return this.sueldoFijo;
	}

}
