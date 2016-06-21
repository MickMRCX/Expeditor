package model;

public class Article {
	
	private int identifiant;
	private int libelle;
	private int poids;
	
	public Article(int libelle, int poids) {
		super();
		this.libelle = libelle;
		this.poids = poids;
	}
	
	public Article(int identifiant, int libelle, int poids) {
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
	
	public int getLibelle() {
		return libelle;
	}
	
	public void setLibelle(int libelle) {
		this.libelle = libelle;
	}
	
	public int getPoids() {
		return poids;
	}
	
	public void setPoids(int poids) {
		this.poids = poids;
	}
}
