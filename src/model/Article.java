package model;

public class Article {
	
	private int identifiant;
	private String libelle;
	private int poids;
	
	public Article(String libelle, int poids) {
		super();
		this.libelle = libelle;
		this.poids = poids;
	}
	
	public Article(int identifiant, String libelle, int poids) {
		super();
		this.identifiant = identifiant;
		this.libelle = libelle;
		this.poids = poids;
	}
	
	public int getIdentifiant() {
		return identifiant;
	}
	
	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}
	
	public String getLibelle() {
		return libelle;
	}
	
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	public int getPoids() {
		return poids;
	}
	
	public void setPoids(int poids) {
		this.poids = poids;
	}
}
