package dal;

import model.Utilisateur;

public interface IUtilisateurDAL extends IRepository<Utilisateur>{
	
	Utilisateur getOneByLogin(String login);
}
