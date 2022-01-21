package no.hvl.dat102.adt.tests;
import no.hvl.dat102.TabellKoe;
import no.hvl.dat102.adt.KoeADT;

public class TabellKoeTest extends KoeADTTest {

	@Override
	protected KoeADT<Integer> reset() {
		return new TabellKoe<Integer>();
	}
}
