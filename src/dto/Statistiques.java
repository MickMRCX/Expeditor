package dto;

import java.util.ArrayList;
import java.util.List;

public class Statistiques {
	private int nbCommandesTotal;
	private List<LigneStatistiques> lignes;
	
	public int getNbCommandesTotal() {
		return nbCommandesTotal;
	}
	public void setNbCommandesTotal(int nbCommandesTotal) {
		this.nbCommandesTotal = nbCommandesTotal;
	}
	public List<LigneStatistiques> getLignes() {
		if (lignes == null) {
			lignes = new ArrayList<LigneStatistiques>();
		}
		return lignes;
	}
	
	
}
