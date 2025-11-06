package farmacia;

public class Medicamento {
	
	private String nombre;
	private String lab;
	private double precio;
	
	public Medicamento(String nombre, String lab, double precio) {
		super();
		this.nombre = nombre;
		this.lab = lab;
		this.precio = precio;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getLab() {
		return lab;
	}
	public void setLab(String lab) {
		this.lab = lab;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	@Override
	public String toString() {
		return "(" + this.getNombre() + "-" + this.getLab() + "-" + this.getPrecio() + ")";
	}
	
	

}
