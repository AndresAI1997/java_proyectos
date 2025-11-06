package empleadosFinal;

public class CalculadorCompuesto extends CalculadorDeSueldo {
	
	private CalculadorDeSueldo calculador1;
	private CalculadorDeSueldo cal2;
	
	public CalculadorCompuesto(CalculadorDeSueldo cal1, CalculadorDeSueldo cal2) {
		this.calculador1 = cal1;
		this.cal2 = cal2;
	}

	@Override
	public double calcularSueldo() {
		return this.calculador1.calcularSueldo() + this.cal2.calcularSueldo();
	}

}
