package dal.impl;

import dal.IArticleDAL;
import dal.IRepository;
import dal.IUtilisateurDAL;

public class DALFactory {
	
	public static IUtilisateurDAL getUtilisateurDAL(){
		return getDAL(UtilisateurDAL.class);
	}
	
	public static IArticleDAL getArticleDAL(){
		return getDAL(ArticleDAL.class);
	}
	
	private static <T extends IRepository<?>> T getDAL(Class<T> loader){
		T dal = null;
		if (loader != null) {
			try {
				dal = loader.newInstance();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return dal;
	}
	
}
