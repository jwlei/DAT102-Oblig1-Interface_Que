package no.hvl.dat102.adt.tests;

import no.hvl.dat102.KjedetKoe;
import no.hvl.dat102.adt.KoeADT;

public class KjedetKoeTest extends KoeADTTest {
	
	@Override
	protected KoeADT<Integer> reset() {
		return new KjedetKoe<Integer>();
	}
}