package util;

import model.Etats;

public class Utilities {

	public static Etats getEtat(int numEtat){
		switch (numEtat) {
		case 0:
			return Etats.AFFECTABLE;
		case 1:
			return Etats.AFFECTEE;
		case 2:
			return Etats.EXPEDIEE;			
		case 3:
			return Etats.REAFFECTABLE;
		default:
			return null;
		}
	}
	

}
