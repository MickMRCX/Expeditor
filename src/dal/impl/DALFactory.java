package dal.impl;

import dal.IArticleDAL;
import dal.ICommandeDAL;
import dal.IRepository;
import dal.IUtilisateurDAL;

public class DALFactory {
	
	public static IUtilisateurDAL getUtilisateurDAL(){
		return getDAL(UtilisateurDAL.class);
	}
	
	public static IArticleDAL getArticleDAL(){
		return getDAL(ArticleDAL.class);
	}
	
	public static ICommandeDAL getCommandeDAL(){
		return getDAL(CommandeDAL.class);
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
