package no.hvl.dat102;

import no.hvl.dat102.adt.KoeADT;
import no.hvl.dat102.exception.EmptyCollectionException;

public class SirkulaerKoe<T> implements KoeADT<T> {

	private final static int STDK = 100;
	private int front, bak, antall;
	private T[] koe;

	public SirkulaerKoe() {
		this(STDK);
	}

	public SirkulaerKoe(int startKapasitet) {
		front = bak = antall = 0;
		koe = ((T[]) (new Object[startKapasitet]));
	}
	@Override
	public void innKoe(T element) {
		if (antall() == koe.length) {
			utvid();
		}
		koe[bak] = element;
		bak = (bak + 1) % koe.length;
		antall++;
	}
	@Override
	public T utKoe() {
		if (erTom())
			throw new EmptyCollectionException("koe");
		T resultat = koe[front];
		koe[front] = null;
		front = (front + 1) % koe.length;
		antall--;
		return resultat;
	}

	private void utvid() {
		T[] hjelpetabell = (T[]) (new Object[koe.length * 2]);
		for (int sok = 0; sok < antall; sok++) {
			hjelpetabell[sok] = koe[front];
			front = (front + 1) % koe.length;
		}
		front = 0;
		bak = antall;
		koe = hjelpetabell;
	}

	@Override
	public T foerste() throws EmptyCollectionException {
		if (erTom())
			throw new EmptyCollectionException("koe");

		return koe[front];
	}

	@Override
	public boolean erTom() {
		return antall == 0;
	}

	@Override
	public int antall() {
		return antall;
	}
	@Override
	public String toString() {
		String resultat = "";
		int sok = 0;

		while (sok < antall) {
			if (koe[sok] != null) {
				resultat += koe[sok].toString() + "\n";
			}
			sok++;
		}

		return resultat;

	}
}
// class
