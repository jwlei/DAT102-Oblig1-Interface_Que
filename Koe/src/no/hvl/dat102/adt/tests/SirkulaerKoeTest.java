package no.hvl.dat102.adt.tests;

import no.hvl.dat102.SirkulaerKoe;
import no.hvl.dat102.adt.KoeADT;

public class SirkulaerKoeTest extends KoeADTTest {

	@Override
	protected KoeADT<Integer> reset() {
		return new SirkulaerKoe<Integer>();
	}
}
