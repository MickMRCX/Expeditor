package dal.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dal.AccesBase;
import dal.IArticleDAL;
import model.Article;
import model.Utilisateur;

public class ArticleDAL implements IArticleDAL{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2091775112324635896L;
	
	private final String SELECT_BY_ID = "SELECT Identifiant, Libelle, Poids "
			+ "FROM Articles WHERE Identifiant = ?";

	private final String SELECT_BY_LIBELLE = "SELECT Identifiant, Libelle, Poids "
			+ "FROM Articles WHERE Libelle = ?";

	private final String SELECT_ALL = "SELECT Identifiant, Libelle, Poids " + "FROM Articles";

	private final String INSERT = "INSERT INTO Articles VALUES(?,?)";

	private final String UPDATE = "UPDATE Articles SET Libelle = ?, Poids = ? "
			+ "WHERE Identifiant = ?";

	private final String DELETE = "DELETE FROM Articles WHERE Identifiant = ?";
	
	
	ArticleDAL(){
		
	}

	@Override
	public Article getOneByID(int id) {
		Article retour = null;
		Connection cnx = null;
		try {
			cnx = AccesBase.getConnection();
			PreparedStatement requete = cnx.prepareStatement(SELECT_BY_ID);
			requete.setInt(1, id);
			ResultSet resultat = requete.executeQuery();
			while (resultat.next()) {
				int identifiant = resultat.getInt("Identifiant");
				String libelle = resultat.getString("Libelle");
				int poids = resultat.getInt("Poids");
				retour = new Article(identifiant, libelle, poids);
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
	public List<Article> getAll() {
		List<Article> retour = null;
		Connection cnx = null;
		try {
			cnx = AccesBase.getConnection();
			PreparedStatement requete = cnx.prepareStatement(SELECT_ALL);
			ResultSet resultat = requete.executeQuery();
			retour = new ArrayList<>();
			while (resultat.next()) {
				int identifiant = resultat.getInt("Identifiant");
				String libelle = resultat.getString("Libelle");
				int poids = resultat.getInt("Poids");
				Article u = new Article(identifiant, libelle, poids);
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
	public Article insert(Article obj) {
		Connection cnx = null;
		try {
			if (obj != null) {
				cnx = AccesBase.getConnection();
				PreparedStatement requete = cnx.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
				requete.setString(1, obj.getLibelle());
				requete.setInt(2, obj.getPoids());
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
	public Article update(Article obj) {
		Connection cnx = null;
		try {
			if (obj != null) {
				cnx = AccesBase.getConnection();
				PreparedStatement requete = cnx.prepareStatement(UPDATE, Statement.RETURN_GENERATED_KEYS);
				requete.setString(1, obj.getLibelle());
				requete.setInt(2, obj.getPoids());
				requete.setInt(3, obj.getIdentifiant());
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

}
