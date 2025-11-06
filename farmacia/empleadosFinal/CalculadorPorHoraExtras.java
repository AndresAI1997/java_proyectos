package empleadosFinal;

public class CalculadorPorHoraExtras extends CalculadorDeSueldo {

	private int horasTrabajas;
	private double valorHora;
	
	public CalculadorPorHoraExtras(int horas, double valor) {
		this.horasTrabajas = horas;
		this.valorHora = valor;
	}
	
	@Override
	public double calcularSueldo() {
		return this.valorHora * this.horasTrabajas;
	}
	
	

}
