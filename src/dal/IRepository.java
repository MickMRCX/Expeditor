package dal;

import java.io.Serializable;
import java.util.List;

public interface IRepository<T> extends Serializable {
	
	T getOneByID(int id);
	
	List<T> getAll();
	
	T insert(T obj);
	
	T update(T obj);
	
	void delete(int identifiant);
}
