package empleados;

public class Empleado {
	
	private String nombre;
	private CalculadorDeSueldo calculador;
	
	public Empleado(String nombre, CalculadorDeSueldo calculador) {
		this.nombre = nombre;
		this.calculador = calculador;
	}
	
	public void setCalculador(CalculadorDeSueldo calculador) {
		this.calculador = calculador;
	}
	
	public double getSueldo() { // Candidato a moverse
		return calculador.calcularSueldo();
	}

}
