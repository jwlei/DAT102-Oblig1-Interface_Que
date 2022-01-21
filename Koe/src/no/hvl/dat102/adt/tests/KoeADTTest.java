package no.hvl.dat102.adt.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import no.hvl.dat102.adt.KoeADT;
import no.hvl.dat102.exception.EmptyCollectionException;

public abstract class KoeADTTest {

	private KoeADT<Integer> koe;

	private Integer e0 = 1;
	private Integer e1 = 2;
	private Integer e2 = 3;
	private Integer e3 = 4;
	private Integer e4 = 5;

	protected abstract KoeADT<Integer> reset();

	@Before
	public void setup() {
		koe = reset();
	}

	@Test
	public void antallTest() {
		koe.innKoe(e0);
		koe.innKoe(e1);
		koe.innKoe(e2);
		assertEquals(3, koe.antall());
	}

	@Test
	public void testToString() {
	}

	@Test
	public void innogutKoe() {
		koe.innKoe(e0);
		koe.innKoe(e1);
		koe.innKoe(e2);
		koe.innKoe(e3);
		koe.innKoe(e4);

		try {
			assertEquals(1, (int) koe.utKoe());
			assertEquals(2, (int) koe.utKoe());
			assertEquals(3, (int) koe.utKoe());
			assertEquals(4, (int) koe.utKoe());
			assertEquals(5, (int) koe.utKoe());
		} catch (EmptyCollectionException e) {
			fail("Feil ved utko " + e.getMessage());
		}
	}

	@Test
	public void InnkoeOgUtkoeMedGjentakelser() {
		koe.innKoe(e0);
		koe.innKoe(e0);
		koe.innKoe(e2);
		koe.innKoe(e2);
		koe.innKoe(e2);

		try {
			assertEquals(1, (int) koe.utKoe());
			assertEquals(1, (int) koe.utKoe());
			assertEquals(3, (int) koe.utKoe());
			assertEquals(3, (int) koe.utKoe());
			assertEquals(3, (int) koe.utKoe());
		} catch (EmptyCollectionException e) {
			fail("Feil ved utko " + e.getMessage());
		}
	}

	@Test
	public void InnOgUtKoeForst() {
		try {
			koe.innKoe(e0);
			koe.utKoe();
			koe.innKoe(e1);
			koe.innKoe(e2);
			koe.utKoe();
			assertEquals(3, (int) koe.foerste());
		} catch (EmptyCollectionException e) {
			fail("Feil ved inn- og utko " + e.getMessage());
		}
	}

	@Test
	public void erTom() {
		koe.innKoe(e0);
		koe.innKoe(e1);
		assertFalse(koe.erTom());
	}

	@Test
	public void InnkoeUtkoeerTom() {
		try {
			koe.innKoe(e0);
			koe.utKoe();
			assertTrue(koe.erTom());
		} catch (EmptyCollectionException e) {
			fail("Inn eller utko er tom eller uventet feil " + e.getMessage());
		}
	}

	@Test
	public void UtkoeErTom() {
		Assert.assertThrows(EmptyCollectionException.class, () -> koe.utKoe());
	}
}