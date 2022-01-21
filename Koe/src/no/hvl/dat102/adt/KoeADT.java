package no.hvl.dat102.adt;

public interface KoeADT<T> {

	public void innKoe(T element);

	public T utKoe();

	public T foerste();

	public boolean erTom();

	public int antall();
	
	public String toString();

}
