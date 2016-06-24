package dal;

import model.Article;
import util.ArticlesCouple;

public interface IArticleDAL extends IRepository<Article> {
	public Article getOneByLibelle(String lbl);
	ArticlesCouple getArticlesByCommande(int idCommande);
}
