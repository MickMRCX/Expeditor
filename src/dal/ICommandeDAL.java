package dal;

import java.util.List;

import dto.LigneCommandeManager;
import dto.Statistiques;
import model.Commande;

public interface ICommandeDAL extends IRepository<Commande> {
	List<LigneCommandeManager> getDisplayList();
	Statistiques getStatistiques();
	Commande getByEmploye(int idEmploye);
}
