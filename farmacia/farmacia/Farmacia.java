package farmacia;

import java.util.ArrayList;

public class Farmacia {

	private ArrayList<Medicamento> medicamentos;

	public Farmacia() {
		this.medicamentos = new ArrayList<>();
	}

	public void addMedicamento(Medicamento m) {
		this.medicamentos.add(m);
	}

	public ArrayList<Medicamento> listarMedicamentos
								(CondicionDeBusqueda condicion) {
		ArrayList<Medicamento> resultado = new ArrayList<>();
		for (int i = 0; i < this.medicamentos.size(); i++) {
			Medicamento mi = this.medicamentos.get(i);
			if (condicion.cumple(mi))
				resultado.add(mi);
		}
		return resultado;
	}
}
