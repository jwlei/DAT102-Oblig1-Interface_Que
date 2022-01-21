package no.hvl.dat102;

import no.hvl.dat102.adt.KoeADT;
import no.hvl.dat102.exception.EmptyCollectionException;



public class TabellKoe<T> implements KoeADT<T> {
	private final static int STDK = 100;
	private int bak;
	private T[] koe;


	public TabellKoe() {
		this(STDK);
	}


	public TabellKoe(int startKapasitet) {
		bak = 0;
		koe = (T[]) (new Object[startKapasitet]);
	}

	@Override
	public void innKoe(T element) {
		if (antall() == koe.length)
			utvidKapasitet();

		koe[bak] = element;
		bak++;

	}

	private void utvidKapasitet() {
		T[] larger = (T[]) (new Object[koe.length * 2]);

		for (int sok = 0; sok < koe.length; sok++)
			larger[sok] = koe[sok];

		koe = larger;
	}

	@Override
	public T utKoe() throws EmptyCollectionException {
		if (erTom())
			throw new EmptyCollectionException("koe");
		T resultat = koe[0];
		bak--;
		for (int sok = 0; sok < bak; sok++)
			koe[sok] = koe[sok + 1];
		koe[bak] = null;
		return resultat;

	}

	@Override
	public T foerste() throws EmptyCollectionException {
		if (erTom())
			throw new EmptyCollectionException("koe");
		return koe[0];
	}

	@Override
	public boolean erTom() {
		return bak == 0;
	}

	@Override
	public int antall() {
		return bak;
	}
	@Override
	public String toString() {
		String resultat = "";

		for (int sok = 0; sok < bak; sok++)
			resultat = resultat + koe[sok].toString() + "\n";

		return resultat;

	}
}// class
