package dal.impl;

import dal.IUtilisateurDAL;

public class DALFactory {
	
	public static IUtilisateurDAL getUtilisateurDAL(){
		return new UtilisateurDAL();
	}
	
}
