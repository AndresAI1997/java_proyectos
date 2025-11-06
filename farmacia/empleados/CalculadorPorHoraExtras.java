package empleados;

public class CalculadorPorHoraExtras extends CalculadorDeSueldo {

	private int horasTrabajas;
	private double valorHora;
	
	public CalculadorPorHoraExtras(double sueldoFijo, int horas, double valor) {
		super(sueldoFijo);
		this.horasTrabajas = horas;
		this.valorHora = valor;
	}
	
	@Override
	public double calcularSueldo() {
		// TODO Auto-generated method stub
		return super.calcularSueldo() + this.valorHora * this.horasTrabajas;
	}
	
	

}
