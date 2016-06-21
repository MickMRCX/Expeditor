package dal;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class AccesBase {	
	public static Connection getConnection() throws SQLException{
		Connection cnx=null;

		// Charger l'annuaire JNDI
		InitialContext jndi = null;
		try {
			jndi = new InitialContext();
		} catch (NamingException ne) {
			ne.printStackTrace();
			throw new SQLException("Impossible d'atteindre l'arbre JNDI");
		}
		
				
		// Chercher le pool de connexions dans l'annuaire
		DataSource ds = null;
		try {
			ds=(DataSource) jndi.lookup("java:comp/env/jdbc/DataSourceExpeditor");
		} catch (NamingException ne) {
			ne.printStackTrace();
			throw new SQLException("Pool de connexion introuvable dans l'arbre jndi");
		}
		
		// Activer une connexion du pool
		cnx=ds.getConnection();
		
		return cnx;
	}
}
