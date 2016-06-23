package dto;

public class LigneStatistiques {
	
	private String nomEmploye;
	private int nbCommandes;
	
	public String getNomEmploye() {
		return nomEmploye;
	}
	public void setNomEmploye(String nomEmploye) {
		this.nomEmploye = nomEmploye;
	}
	public int getNbCommandes() {
		return nbCommandes;
	}
	public void setNbCommandes(int nbCommandes) {
		this.nbCommandes = nbCommandes;
	}
	public LigneStatistiques(String nomEmploye, int nbCommandes) {
		super();
		this.nomEmploye = nomEmploye;
		this.nbCommandes = nbCommandes;
	}
		
}
