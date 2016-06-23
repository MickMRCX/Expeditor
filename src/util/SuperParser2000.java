package util;

import java.util.Date;

public class SuperParser2000 {
	private Date date;
	private String numero;
	private String nom;
	private String adresse;
	private String articles;
	
	public SuperParser2000(Date date, String numero, String nom, String adresse, String articles) {
		super();
		this.date = date;
		this.numero = numero;
		this.nom = nom;
		this.adresse = adresse;
		this.articles = articles;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getArticles() {
		return articles;
	}
	public void setArticles(String articles) {
		this.articles = articles;
	}
}
