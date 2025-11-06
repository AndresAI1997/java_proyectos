package TP.Comparadores;

import java.util.Comparator;

public class ComparadorString implements Comparator<String> {
	public ComparadorString() {

	}

	@Override
	public int compare(String o1, String o2) {
		return o1.compareTo(o2);
	}
}
