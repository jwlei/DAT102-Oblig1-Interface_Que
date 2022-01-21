package no.hvl.dat102;

import no.hvl.dat102.adt.FilmarkivADT;

public class Filmarkiv2 implements FilmarkivADT {

	private int antall;
	private LinearNode<Film> start;

	@Override
	public Film[] hentFilmTabell() {
		return null;
	}

	@Override
	public void leggTilFilm(Film nyFilm) {
		LinearNode<Film> nyNode = new LinearNode<>(nyFilm);
		nyNode.setNeste(start);
		start = nyNode;
		antall++;

	}

	@Override
	public boolean slettFilm(int filmNr) {
		LinearNode<Film> peker = start;
		LinearNode<Film> forrige = null;
		boolean funnet = false;
		if (start != null && start.getElement().getFilmnr() == filmNr) {
			start = start.getNeste();
			funnet = true;
			antall--;
		}
		while (!funnet && peker.getNeste() != null) {
			forrige = peker;
			peker = peker.getNeste();
			if (peker.getElement().getFilmnr() == filmNr) {
				forrige.setNeste(peker.getNeste());
				funnet = true;
				antall--;
			}
		}
		return funnet;
	}

	@Override
	public Film[] sokTittel(String delstreng) {
		LinearNode<Film> peker = start;
		Film[] hjelpetabell = new Film[antall];
		int i = 0;

		while (peker.getNeste() != null) {
			if (peker.getElement().getFilmtittel().equals(delstreng)) {
				hjelpetabell[i] = peker.getElement();
				i++;
			}
			peker = peker.getNeste();
		}
		hjelpetabell = trimTab(hjelpetabell, i);
		return hjelpetabell;
	}

	@Override
	public Film[] sokProdusent(String delstreng) {
		LinearNode<Film> peker = start;
		Film[] hjelpetabell = new Film[antall];
		int i = 0;

		while (peker.getNeste() != null) {
			if (peker.getElement().getProdusent().equals(delstreng)) {
				hjelpetabell[i] = peker.getElement();
				i++;
			}
			peker = peker.getNeste();
		}
		hjelpetabell = trimTab(hjelpetabell, i);
		return hjelpetabell;
	}

	@Override
	public int antallSjanger(FilmSjanger sjanger) {
		LinearNode<Film> peker = start;
		int i = 0;
		while (peker != null) {
			if (peker.getElement().getSjanger().equals(sjanger)) {
				i++;
			}
		}
		return i;
	}

	@Override
	public int antall() {
		return antall;
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
