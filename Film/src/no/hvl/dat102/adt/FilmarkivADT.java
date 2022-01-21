package no.hvl.dat102.adt;

import no.hvl.dat102.Film;
import no.hvl.dat102.FilmSjanger;

public interface FilmarkivADT {

	Film[] hentFilmTabell();

	void leggTilFilm(Film nyFilm);

	boolean slettFilm(int filmNr);

	Film[] sokTittel(String delstreng);

	Film[] sokProdusent(String delstreng);

	int antallSjanger(FilmSjanger sjanger);

	int antall();
}

