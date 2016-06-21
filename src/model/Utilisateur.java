package model;

public class Utilisateur {

	private int identifiant;
	private String nom;
	private String login;
	private String motDePasse;
	
	public Utilisateur(String nom, String login, String motDePasse) {
		super();
		this.nom = nom;
		this.login = login;
		this.motDePasse = motDePasse;
	}

	public Utilisateur(int identifiant, String nom, String login, String motDePasse) {
		super();
		this.identifiant = identifiant;
		this.nom = nom;
		this.login = login;
		this.motDePasse = motDePasse;
	}

	public int getIdentifiant() {
		return identifiant;
	}
	
	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getMotDePasse() {
		return motDePasse;
	}
	
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
}
