package dal;

import java.util.List;

import model.Utilisateur;

public interface IUtilisateurDAL extends IRepository<Utilisateur>{
	
	Utilisateur getOneByLogin(String login);
	List<Utilisateur> getEmployes();
}
