package TP;

import java.util.Iterator;
import java.util.Comparator;

public class Listavinculada<T> {
	Nodo<T> primernodo;
	Comparator<T> compara;
	boolean ordenInvertido = false;

	public Listavinculada(Comparator<T> compara, boolean ordenInvertido) {
		this.compara = compara;
		this.ordenInvertido = ordenInvertido;
	}

	public Nodo<T> getPrimernodo() {
		return primernodo;
	}

	public void setPrimernodo(Nodo<T> primernodo) {
		this.primernodo = primernodo;
	}

	public Comparator<T> getCompara() {
		return compara;
	}

	public void setCompara(Comparator<T> compara) {
		this.compara = compara;
	}

	public String toString() {
		String string = " ";
		Miterador<T> iterador = new Miterador<T>(this);
		while (iterador.hasNext()) {
			string += "\n" + (iterador.next().elemento.toString());
		}
		return "[" + string + "]";
	}

	public Listavinculada<T> eliminarenpos(Listavinculada<T> lista, Integer pos) {
		Miterador<T> iterador = new Miterador<T>(lista);
		Nodo<T> aux;
		Integer contador;
		contador = 0;
		while ((contador < pos - 1) && (iterador.cursor.nodosig != null)) {
			contador++;
			iterador.next();
		}

		aux = iterador.cursor.nodosig.nodosig;
		iterador.cursor.nodosig.nodosig = null;
		iterador.cursor.nodosig = aux;
		return lista;
	}

	public void insertar(T nuevo) {
		this.primernodo = this.insertarOrdenado(this.primernodo, nuevo);
	}

	public Nodo<T> insertarOrdenado(Nodo<T> actual, T nuevo) {
		if (actual == null) {
			return new Nodo<T>(nuevo, null);
		} else {
			if (this.ordenInvertido) {
				if (compara.compare(actual.elemento, nuevo) < 0) {
					return new Nodo<T>(nuevo, actual);
				}
			} else {
				if (compara.compare(actual.elemento, nuevo) > 0) {
					return new Nodo<T>(nuevo, actual);
				}
			}
			actual.nodosig = insertarOrdenado(actual.nodosig, nuevo);
			return actual;
		}
	}

	public void eliminarOcurrencia(T ocurrencia) {
		Miterador<T> iterador = new Miterador<T>(this);
		Nodo<T> actual;
		actual = null;
		Nodo<T> previo;
		while (iterador.hasNext()) {
			previo = actual;
			actual = iterador.next();
			if (compara.compare(actual.elemento, ocurrencia) == 0) {
				if (previo == null) {
					this.primernodo = actual.nodosig;
				} else {
					previo.nodosig = actual.nodosig;
				}
			}
		}

	}

	public Integer encontrarOcurrencia(T ocurrencia) {
		Miterador<T> iterador = new Miterador<T>(this);
		Integer contador;
		contador = 0;
		while (iterador.hasNext()) {
			if (compara.compare(iterador.next().elemento, ocurrencia) == 0) {

				return contador;
			}
			contador++;
		}
		return -1;

	}

	public void invertirOrden() {
		this.ordenInvertido = !this.ordenInvertido;
		Listavinculada<T> lista = new Listavinculada<T>(compara, ordenInvertido);
		Miterador<T> iterador = new Miterador<T>(this);
		while (iterador.hasNext()) {
			lista.insertar(iterador.next().elemento);
		}
		this.primernodo = lista.primernodo;
	}
}