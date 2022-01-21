package no.hvl.dat102;


public enum FilmSjanger {
	
	ACTION, DRAMA, HISTORY, SCIFI;
	
	public static FilmSjanger finnSjanger(String navn) {
		FilmSjanger sjang = null;
		for (FilmSjanger sj : FilmSjanger.values()) {
			if (sj.toString().equals(navn.toUpperCase())) {
				sjang = sj;
				break;
			}
		}
		return sjang;

	}

	
}


