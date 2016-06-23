package dal;

import model.Article;

public interface IArticleDAL extends IRepository<Article> {
	public Article getOneByLibelle(String lbl);
}
