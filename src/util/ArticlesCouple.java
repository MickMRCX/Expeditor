package util;

import java.util.ArrayList;
import java.util.List;

import dto.LigneCommandeArticle;
import model.Article;

public class ArticlesCouple {
	
	private List<Article> articles;
	private List<LigneCommandeArticle> lignesarticles;
	
	public List<Article> getArticles() {
		if (articles == null) {
			articles = new ArrayList<Article>();
		}
		return articles;
	}
	
	public List<LigneCommandeArticle> getLignesarticles() {
		if (lignesarticles == null) {
			lignesarticles = new ArrayList<LigneCommandeArticle>();
		}
		return lignesarticles;
	}

	public ArticlesCouple(List<Article> articles, List<LigneCommandeArticle> lignesarticles) {
		super();
		this.articles = articles;
		this.lignesarticles = lignesarticles;
	}
}
