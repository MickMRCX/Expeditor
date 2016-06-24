package model;

public class Article {
	
	private int identifiant;
	private String libelle;
	private int poids;
	private boolean archive;
	
	public Article(int identifiant, String libelle, int poids, boolean archive) {
		super();
		this.identifiant = identifiant;
		this.libelle = libelle;
		this.poids = poids;
		this.archive = archive;
	}

	public Article(String libelle, int poids) {
		super();
		this.libelle = libelle;
		this.poids = poids;
		this.archive = false;
	}
	
	public Article(int identifiant, String libelle, int poids) {
		super();
		this.identifiant = identifiant;
		this.libelle = libelle;
		this.poids = poids;
		this.archive = false;
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

	public boolean isArchive() {
		return archive;
	}

	public void setArchive(boolean archive) {
		this.archive = archive;
	}
}
