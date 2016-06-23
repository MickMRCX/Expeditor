package dto;

import model.Etats;

public class LigneCommandeManager {
	
	private String identifiant;
	private String etat;
	private String nomEmploye;
	
	public String getIdentifiant() {
		return identifiant;
	}
	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public String getNomEmploye() {
		return nomEmploye;
	}
	public void setNomEmploye(String nomEmploye) {
		this.nomEmploye = nomEmploye;
	}
	public LigneCommandeManager(Integer idCommande, Etats etat, String nomEmploye) {
		super();
		this.identifiant = idCommande.toString();
		this.etat = etat.toString();
		this.nomEmploye = nomEmploye;
	}

}
