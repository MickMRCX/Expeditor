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
	
	public static int getEtatInt(Etats etat){
		switch (etat) {
		
		case AFFECTABLE:
			return 1;
		case AFFECTEE:
			return 2;
		case EXPEDIEE:
			return 3;
		case REAFFECTABLE:
			return 4;
		default:
			return 0;
		}
	}

}
