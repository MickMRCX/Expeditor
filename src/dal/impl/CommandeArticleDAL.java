package dal.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dal.AccesBase;
import dal.IRepository;
import dto.LigneCommandeArticle;

public class CommandeArticleDAL implements IRepository<LigneCommandeArticle> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7346455250919052229L;

	private final String SELECT_BY_COMMANDE = "SELECT Article_id, Commande_id, Quantite_carton, Quantite_commandee"
			+ "FROM Commande_Article WHERE Commande_id = ?";
	
	private final String SELECT_ALL = "SELECT Article_id, Commande_id, Quantite_carton, Quantite_commandee " + "FROM Commande_Article";

	private final String INSERT = "INSERT INTO Commande_Article VALUES(?,?,?,?)";

	private final String UPDATE = "UPDATE Commande_Article SET Quantite_carton = ?, Quantite_commandee = ? "
			+ "WHERE Commande_id = ? AND Article_id = ?";
	
	private final String DELETE_BY_COMMANDE = "DELETE FROM Commande_Article WHERE = Commande_id = ?";

	/**
	 * DO NOT USE
	 * 
	 * Une Ligne Commande Article n'a pas d'identifiant propre
	 * 
	 * Rechercher les lignes en utilisant getAllByCommande(Commande commande)
	 */
	@Override
	public LigneCommandeArticle getOneByID(int id) {
		LigneCommandeArticle retour = null;
		Connection cnx = null;
		try {
			cnx = AccesBase.getConnection();
			PreparedStatement requete = cnx.prepareStatement(SELECT_BY_COMMANDE);
			requete.setInt(1, id);
			ResultSet resultat = requete.executeQuery();
			while (resultat.next()) {
				int article_id = resultat.getInt("Article_id");
				int commande_id = resultat.getInt("Commande_id");
				int quantite_carton = resultat.getInt("Quantite_carton");
				int quantite_commandee = resultat.getInt("Quantite_commandee");
				
				retour = new LigneCommandeArticle(article_id, commande_id, quantite_commandee, quantite_carton);
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
	
	public List<LigneCommandeArticle> getAllByCommande(int id){
		List<LigneCommandeArticle> retour = new ArrayList<LigneCommandeArticle>();
		Connection cnx = null;
		try {
			cnx = AccesBase.getConnection();
			PreparedStatement requete = cnx.prepareStatement(SELECT_BY_COMMANDE);
			requete.setInt(1, id);
			ResultSet resultat = requete.executeQuery();
			while (resultat.next()) {
				int article_id = resultat.getInt("Article_id");
				int commande_id = resultat.getInt("Commande_id");
				int quantite_carton = resultat.getInt("Quantite_carton");
				int quantite_commandee = resultat.getInt("Quantite_commandee");
				
				retour.add(new LigneCommandeArticle(article_id, commande_id, quantite_commandee, quantite_carton));
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
	public List<LigneCommandeArticle> getAll() {
		List<LigneCommandeArticle> retour = new ArrayList<LigneCommandeArticle>();
		Connection cnx = null;
		try {
			cnx = AccesBase.getConnection();
			PreparedStatement requete = cnx.prepareStatement(SELECT_ALL);
			ResultSet resultat = requete.executeQuery();
			while (resultat.next()) {
				int article_id = resultat.getInt("Article_id");
				int commande_id = resultat.getInt("Commande_id");
				int quantite_carton = resultat.getInt("Quantite_carton");
				int quantite_commandee = resultat.getInt("Quantite_commandee");
				
				retour.add(new LigneCommandeArticle(article_id, commande_id, quantite_commandee, quantite_carton));
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
	public LigneCommandeArticle insert(LigneCommandeArticle obj) {
		Connection cnx = null;
		try {
			if (obj != null) {
				cnx = AccesBase.getConnection();
				PreparedStatement requete = cnx.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
				requete.setInt(1, obj.getArticle());
				requete.setInt(2, obj.getCommande());
				requete.setInt(3, obj.getQuantiteCommande());
				requete.setInt(4, obj.getQuantiteTraitee());
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
	public LigneCommandeArticle update(LigneCommandeArticle obj) {
		Connection cnx = null;
		try {
			if (obj != null) {
				cnx = AccesBase.getConnection();
				PreparedStatement requete = cnx.prepareStatement(UPDATE);
				requete.setInt(1, obj.getQuantiteCommande());
				requete.setInt(2, obj.getQuantiteTraitee());
				requete.setInt(3, obj.getCommande());
				requete.setInt(4, obj.getArticle());
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
			PreparedStatement requete = cnx.prepareStatement(DELETE_BY_COMMANDE);
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
