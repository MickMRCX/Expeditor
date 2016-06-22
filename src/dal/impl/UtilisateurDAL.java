package dal.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dal.AccesBase;
import dal.IUtilisateurDAL;
import model.Utilisateur;

public class UtilisateurDAL implements IUtilisateurDAL {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4501643423779172225L;

	private final String SELECT_BY_ID = "SELECT Identifiant, Nom, Login, MotDePasse "
			+ "FROM Utilisateurs WHERE Identifiant = ?";

	private final String SELECT_BY_LOGIN = "SELECT Identifiant, Nom, Login, MotDePasse "
			+ "FROM Utilisateurs WHERE Login = ?";

	private final String SELECT_ALL = "SELECT Identifiant, Nom, Login, MotDePasse " + "FROM Utilisateurs";

	private final String INSERT = "INSERT INTO Utilisateurs VALUES(?,?,?)";

	private final String UPDATE = "UPDATE Utilisateurs SET Nom = ?, Login = ?, MotDePasse = ? "
			+ "WHERE Identifiant = ?";

	private final String DELETE = "DELETE FROM Utilisateurs WHERE Identifiant = ?";
	
	UtilisateurDAL() {
		
	}
	
	@Override
	public Utilisateur getOneByID(int id) {
		Utilisateur retour = null;
		Connection cnx = null;
		try {
			cnx = AccesBase.getConnection();
			PreparedStatement requete = cnx.prepareStatement(SELECT_BY_ID);
			requete.setInt(1, id);
			ResultSet resultat = requete.executeQuery();
			while (resultat.next()) {
				int identifiant = resultat.getInt("Identifiant");
				String nom = resultat.getString("Nom");
				String login = resultat.getString("Login");
				String mdp = resultat.getString("MotDePasse");
				retour = new Utilisateur(identifiant, nom, login, mdp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (cnx != null && !cnx.isClosed()) {
					cnx.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return retour;
	}

	@Override
	public List<Utilisateur> getAll() {
		List<Utilisateur> retour = null;
		Connection cnx = null;
		try {
			cnx = AccesBase.getConnection();
			PreparedStatement requete = cnx.prepareStatement(SELECT_ALL);
			ResultSet resultat = requete.executeQuery();
			retour = new ArrayList<>();
			while (resultat.next()) {
				int identifiant = resultat.getInt("Identifiant");
				String nom = resultat.getString("Nom");
				String login = resultat.getString("Login");
				String mdp = resultat.getString("MotDePasse");
				Utilisateur u = new Utilisateur(identifiant, nom, login, mdp);
				retour.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (cnx != null && !cnx.isClosed()) {
					cnx.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return retour;
	}

	@Override
	public Utilisateur insert(Utilisateur obj) {
		Connection cnx = null;
		try {
			if (obj != null) {
				cnx = AccesBase.getConnection();
				PreparedStatement requete = cnx.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
				requete.setString(1, obj.getNom());
				requete.setString(2, obj.getLogin());
				requete.setString(3, obj.getMotDePasse());
				requete.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (cnx != null && !cnx.isClosed()) {
					cnx.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return obj;
	}

	@Override
	public Utilisateur update(Utilisateur obj) {
		Connection cnx = null;
		try {
			if (obj != null) {
				cnx = AccesBase.getConnection();
				PreparedStatement requete = cnx.prepareStatement(UPDATE, Statement.RETURN_GENERATED_KEYS);
				requete.setString(1, obj.getNom());
				requete.setString(2, obj.getLogin());
				requete.setString(3, obj.getMotDePasse());
				requete.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (cnx != null && !cnx.isClosed()) {
					cnx.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return obj;
	}

	@Override
	public void delete(int identifiant) {
		Connection cnx = null;
		try {
			cnx = AccesBase.getConnection();
			PreparedStatement requete = cnx.prepareStatement(DELETE);
			requete.setInt(1, identifiant);
			requete.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (cnx != null && !cnx.isClosed()) {
					cnx.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public Utilisateur getOneByLogin(String login) {
		Utilisateur retour = null;
		Connection cnx = null;
		try {
			cnx = AccesBase.getConnection();
			PreparedStatement requete = cnx.prepareStatement(SELECT_BY_LOGIN);
			requete.setString(1, login);
			ResultSet resultat = requete.executeQuery();
			while (resultat.next()) {
				int identifiant = resultat.getInt("Identifiant");
				String nom = resultat.getString("Nom");
				String mdp = resultat.getString("MotDePasse");
				retour = new Utilisateur(identifiant, nom, login, mdp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (cnx != null && !cnx.isClosed()) {
					cnx.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return retour;
	}

}
