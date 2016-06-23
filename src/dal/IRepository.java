package dal;

import java.io.Serializable;
import java.util.List;

public interface IRepository<T> extends Serializable {

	/**
	 * Obtient un objet correspondant à l'id.
	 * 
	 * @param id
	 *            identifiant de la ligne en base.
	 * @return objet correspondant à la ligne en base.
	 */
	T getOneByID(int id);

	/**
	 * Obtient une liste d'objets.
	 * 
	 * @return liste des objets de la base.
	 */
	List<T> getAll();

	/**
	 * Insert un objet en base.
	 * 
	 * @param obj
	 *            l'objet à insérer.
	 * @return l'objet avec l'id mis à jour.
	 */
	T insert(T obj);

	/**
	 * Met à jour un objet en base.
	 * 
	 * @param obj
	 *            l'objet à mettre à jour.
	 * @return l'objet mis à jour.
	 */
	T update(T obj);

	/**
	 * Supprime un enregistrement en base.
	 * 
	 * @param identifiant
	 *            id de l'objet à supprimer.
	 */
	void delete(int identifiant);
}
