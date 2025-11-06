package empleados;

public class CalculadorPorComision extends CalculadorDeSueldo {

	private double ventas;
	private double comision;
	
	public CalculadorPorComision(double sueldoFijo, double ventas, double comision) {
		super(sueldoFijo);
		this.ventas = ventas;
		this.comision = comision;
	}
	
	@Override
	public double calcularSueldo() {
		return super.calcularSueldo() +  this.ventas * this.comision;
	}
	
	

}
