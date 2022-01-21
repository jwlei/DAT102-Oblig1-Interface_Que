package no.hvl.dat102;

import no.hvl.dat102.adt.KoeADT;
import no.hvl.dat102.exception.EmptyCollectionException;



public class KjedetKoe<T> implements KoeADT<T> {
	private int antall;
	private LinearNode<T> front, bak;
	// ....

	@Override
	public void innKoe(T element) {
		LinearNode<T> nyNode = new LinearNode<T>(element);
		if (erTom()) {
			front = nyNode;
		} else {
			bak.setNeste(nyNode);
		}
		bak = nyNode;
		antall++;
	}

	@Override
	public T utKoe() {
		if (erTom())
			throw new EmptyCollectionException("koe");
		T resultat = front.getElement();
		front = front.getNeste();
		antall--;
		if (erTom()) {
			bak = null;
		}
		return resultat;
	}

	@Override
	public T foerste() {
		if (erTom())
			throw new EmptyCollectionException("koe");
		T resultat = front.getElement();
		return resultat;
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
		{
			String resultat = "";
			LinearNode<T> current = front;

			while (current != null) {
				resultat = resultat + (current.getElement()).toString() + "\n";
				current = current.getNeste();
			}

			return resultat;
		}
	}

}// class
