package dto;

import java.util.List;

import model.Article;

public class LigneCommandeArticle {
	
	private int article;
	private int commande;
	private int quantiteCommande;
	private int quantiteTraitee;
	
	public LigneCommandeArticle(int article, int commande, int quantiteCommande, int quantiteTraitee) {
		super();
		this.article = article;
		this.commande = commande;
		this.quantiteCommande = quantiteCommande;
		this.quantiteTraitee = quantiteTraitee;
	}
	
	public int getArticle() {
		return article;
	}
	public void setArticle(int article) {
		this.article = article;
	}
	public int getCommande() {
		return commande;
	}

	public void setCommande(int commande) {
		this.commande = commande;
	}
	public int getQuantiteCommande() {
		return quantiteCommande;
	}
	public void setQuantiteCommande(int quantiteCommande) {
		this.quantiteCommande = quantiteCommande;
	}
	public int getQuantiteTraitee() {
		return quantiteTraitee;
	}
	public void setQuantiteTraitee(int quantiteTraitee) {
		this.quantiteTraitee = quantiteTraitee;
	}
	
	public static Article getArticleFromId(int id, List<Article> la) {
		for (Article article : la) {
			if (article.getIdentifiant() == id) {
				return article;
			}
		}
		return null;
	}
}
