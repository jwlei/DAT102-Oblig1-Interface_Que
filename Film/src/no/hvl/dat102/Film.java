package no.hvl.dat102;

public class Film {

	private int filmnr;
	private String produsent;
	private String filmtittel;
	private int filmaar;
	private FilmSjanger sjanger;
	private String filmselskap;

	public Film() {
		this(0, "", "", 0, null, "");

	}

	public Film(int filmnr, String produsent, String filmtittel, int filmaar, FilmSjanger sjanger, String filmselskap) {
		this.filmnr = filmnr;
		this.filmselskap = filmselskap;
		this.filmtittel = filmtittel;
		this.filmaar = filmaar;
		this.sjanger = sjanger;
		this.filmselskap = filmselskap;

	}

	public int getFilmnr() {
		return filmnr;
	}

	public void setFilmnr(int filmnr) {
		this.filmnr = filmnr;
	}

	public String getProdusent() {
		return produsent;
	}

	public void setProdusent(String produsent) {
		this.produsent = produsent;
	}

	public String getFilmtittel() {
		return filmtittel;
	}

	public void setFilmtittel(String filmtittel) {
		this.filmtittel = filmtittel;
	}

	public int getFilmaar() {
		return filmaar;
	}

	public void setFilmaar(int filmaar) {
		this.filmaar = filmaar;
	}

	public FilmSjanger getSjanger() {
		return sjanger;
	}

	public void setSjanger(FilmSjanger sjanger) {
		this.sjanger = sjanger;
	}

	public String getFilmselskap() {
		return filmselskap;
	}

	public void setFilmselskap(String filmselskap) {
		this.filmselskap = filmselskap;
	}

	@Override
	public String toString() {
		return String.format("%6d%10s%6.2%6d",filmnr,produsent,filmtittel,filmaar,sjanger,filmselskap);
	}

}
