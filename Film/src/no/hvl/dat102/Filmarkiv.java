package no.hvl.dat102;

import no.hvl.dat102.adt.FilmarkivADT;

public class Filmarkiv implements FilmarkivADT{

	private Film[] filmTabell;
	private int antall;
	
	public Filmarkiv (int n) {
		this.filmTabell = new Film[n];
	}

	@Override
	public Film[] hentFilmTabell() {
		return filmTabell;
	}

	@Override
	public void leggTilFilm(Film nyFilm) {
		if (antall == filmTabell.length) {
			utvidKapasitet();
		}
		filmTabell[antall] = nyFilm;
		antall++;

	}

	@Override
	public boolean slettFilm(int filmnr) {

		boolean slettet = false;
		int indeks = 0;
		for (int i = 0; i < antall; i++) {
			if (filmTabell[i].getFilmnr() == filmnr) {
				indeks = i;
				slettet = true;
			}
		}

		antall--;
		while (indeks < antall) {
			filmTabell[indeks] = filmTabell[indeks + 1];
			indeks++;
		}

		filmTabell[antall] = null;

		return slettet;

	}

	@Override
	public Film[] sokTittel(String delstreng) {
		int indeks = 0;
		Film[] filmretur = new Film[filmTabell.length];
		for (int i = 0; i < filmTabell.length; i++) {
			if (filmTabell[i].getFilmtittel().indexOf(delstreng) >= 0)
				filmretur[indeks] = filmTabell[i];
		}
		return filmretur;
	}

	@Override
	public Film[] sokProdusent(String delstreng) {
		int indeks = 0;
		Film[] produsentretur = new Film[filmTabell.length];
		for (int i = 0; i < filmTabell.length; i++) {
			if (filmTabell[i].getProdusent().indexOf(delstreng) >= 0)
				produsentretur[indeks] = filmTabell[i];
		}
		return produsentretur;
	}

	@Override
	public int antallSjanger(FilmSjanger sjanger) {
		int antallSjanger = 0;
		for (int i = 0; i < antall; i++) {
			if (filmTabell[i].getSjanger() == sjanger) {
				antallSjanger++;
			}
		}
		return antallSjanger;
	}

	@Override
	public int antall() {
		return antall;
	}

	private void utvidKapasitet() {// eks. utvide 10%
		Film[] hjelpetabell = new Film[(int) Math.ceil(1.1 * filmTabell.length)];
		for (int i = 0; i < filmTabell.length; i++) {
			hjelpetabell[i] = filmTabell[i];
		}
		filmTabell = hjelpetabell;

	}

	private Film[] trimTab(Film[] filmTabell, int n) { // n = antall elementer
		Film[] filmtab2 = new Film[n];
		int i = 0;
		while (i < n) {
			filmtab2[i] = filmTabell[i];
			i++;
		} 
		return filmtab2;

	}
}
