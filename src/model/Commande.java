package model;

import java.util.Date;

public class Commande {
	private int identifiant;
	private Date date_Commande;
	private String nom_Client;
	private String adresse;
	private Etats etat;

	public Commande(Date date_Commande, String nom_Client, String adresse, Etats etat) {
		super();
		this.date_Commande = date_Commande;
		this.nom_Client = nom_Client;
		this.adresse = adresse;
		this.etat = etat;
	}

	public Commande(int identifiant, Date date_Commande, String nom_Client, String adresse, Etats etat) {
		super();
		this.identifiant = identifiant;
		this.date_Commande = date_Commande;
		this.nom_Client = nom_Client;
		this.adresse = adresse;
		this.etat = etat;
	}

	public int getIdentifiant() {
		return identifiant;
	}
	
	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}
	
	public Date getDate_Commande() {
		return date_Commande;
	}
	
	public void setDate_Commande(Date date_Commande) {
		this.date_Commande = date_Commande;
	}
	
	public String getNom_Client() {
		return nom_Client;
	}
	
	public void setNom_Client(String nom_Client) {
		this.nom_Client = nom_Client;
	}
	
	public String getAdresse() {
		return adresse;
	}
	
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	public Etats getEtat() {
		return etat;
	}

	public void setEtat(Etats etat) {
		this.etat = etat;
	}
}
