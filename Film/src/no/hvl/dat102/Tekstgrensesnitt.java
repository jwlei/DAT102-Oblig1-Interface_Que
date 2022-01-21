package no.hvl.dat102;

import no.hvl.dat102.adt.FilmarkivADT;
import no.hvl.dat102.Filmarkiv;
import java.util.Scanner;

public class Tekstgrensesnitt {
	private FilmarkivADT filma;

	public Tekstgrensesnitt(FilmarkivADT filma) {
		this.filma = filma;

	}

	// lese opplysningene om en FILM fra tastatur
	public Film lesFilm() {

		Scanner keyboard = new Scanner(System.in);
		System.out.println("Vi skal nå legge til en film i arkivet.");

		System.out.println("Hva heter filmen?");
		String filmtittel = keyboard.nextLine();

		System.out.println("Hvem er produsenten??");
		String produsent = keyboard.nextLine();

		System.out.println("Utvigelsesaar?");
		int filmaar = keyboard.nextInt();

		System.out.println("Hvilket nummer er filmen?");
		int filmnr = keyboard.nextInt();

		System.out.println("Hvilken sjanger?");
		System.out.println("ACTION, DRAMA, HISTORY, SCIFI");
		String txtsjanger = keyboard.nextLine();

		System.out.println("Hvilket filmselskap?");
		String filmselskap = keyboard.nextLine();


		FilmSjanger sjanger = FilmSjanger.finnSjanger(txtsjanger);
		Film nyfilm = new Film(filmnr, produsent, filmtittel, filmaar, sjanger, filmselskap);
		keyboard.close();

		return nyfilm;

	}

	public void visFilm(Film film) {
		System.out.println(film.toString());

	}

	public void skrivUtFilmDelstrengITittel(FilmarkivADT filma, String delstreng) {
		Film[] arkiv = filma.sokTittel(delstreng);

		for (int i = 0; i < arkiv.length; i++) {
			System.out.println(arkiv[i].toString());
		}

	}

	public void skrivUtFilmProdusent(FilmarkivADT filma, String delstreng) {
		Film[] arkiv = filma.sokProdusent(delstreng);

		for (int i = 0; i < arkiv.length; i++) {
			System.out.println(arkiv[i].toString());
		}

	}


	public void skrivUtStatistikk(FilmarkivADT filma) {
		System.out.println("Antall Filmer :" + filma.antall());
		FilmSjanger[] sjanger = FilmSjanger.values();

		for (int i = 0; i < sjanger.length; i++) {
			System.out.println(sjanger[i] + " " + filma.antallSjanger(sjanger[i]));
		}
	}
}


