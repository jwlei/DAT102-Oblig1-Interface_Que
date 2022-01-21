package no.hvl.dat102;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import no.hvl.dat102.adt.FilmarkivADT;


public class Fil {

	private static final String SKILLE = "#";

	public static Filmarkiv lesFraFil(String filnavn)  {
		Filmarkiv filmarkiv = null;
			try {
				FileReader ansFil = new FileReader(filnavn);
				BufferedReader innfil = new BufferedReader(ansFil);

				String linje = innfil.readLine();
				int n = Integer.parseInt(linje);
				filmarkiv = new Filmarkiv(n);


			for (int i = 0; i < n; i++) {
				String post = innfil.readLine();
				String[] felt = post.split(SKILLE);
				int nr = Integer.parseInt(felt[0]);
				String produsent = felt[1];
				String tittel = felt[2];
				int aar = Integer.parseInt(felt[3]);
				String sjStr = felt[4];
				FilmSjanger sj = FilmSjanger.finnSjanger(sjStr);
				String selskap = felt[5];

				Film film = new Film(nr, produsent, tittel, aar, sj, selskap);

				filmarkiv.leggTilFilm(film);
			}
			innfil.close();

		} catch (FileNotFoundException unntak) {

			System.out.println("Finner ikke filen " + filnavn);
		
		} catch (IOException e) {
			System.out.println("Feil ved lesing av fil: " + e);
			
		}
	return filmarkiv;
	}


	// metode
	public static void skrivTilFil(FilmarkivADT filma, String filnavn)  {
		try {

			FileWriter ansFil = new FileWriter(filnavn, false);

			PrintWriter utfil = new PrintWriter(ansFil);
			int antall = filma.antall();
			utfil.println(antall);
			Film[] tabell = filma.hentFilmTabell();
			for (int i = 0; i < antall; i++) {
				utfil.print(tabell[i].getFilmnr());
				utfil.print(SKILLE);
				utfil.print(tabell[i].getProdusent());
				utfil.print(SKILLE);
				utfil.print(tabell[i].getFilmtittel());
				utfil.print(SKILLE);
				utfil.print(tabell[i].getFilmaar());
				utfil.print(SKILLE);
				utfil.print(tabell[i].getSjanger());
				utfil.print(SKILLE);
				utfil.println(tabell[i].getFilmselskap());
			}

			utfil.close();
		}
		catch (IOException e) {
			System.out.println("Feil paa skriving til fil : " + e);
		}
	}
}
