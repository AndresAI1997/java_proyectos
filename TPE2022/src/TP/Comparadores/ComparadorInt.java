package TP.Comparadores;

import java.util.Comparator;

public class ComparadorInt implements Comparator<Integer> {

	public ComparadorInt() {

	}

	@Override
	public int compare(Integer o1, Integer o2) {
		return o1 - o2;
	}

}
