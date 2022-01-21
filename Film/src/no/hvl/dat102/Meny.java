package no.hvl.dat102;

import no.hvl.dat102.adt.FilmarkivADT;

public class Meny {

	private Tekstgrensesnitt tekstgr;
	private FilmarkivADT filma;

	public Meny(FilmarkivADT Filma) {
		tekstgr = new Tekstgrensesnitt(filma);
		this.filma = filma;
	}
	
	public void start () {
		filma.leggTilFilm(tekstgr.lesFilm());
		
		filma.hentFilmTabell();
	}

}
