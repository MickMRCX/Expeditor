package dal.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dal.AccesBase;
import dal.ICommandeDAL;
import dto.LigneCommandeArticle;
import dto.LigneCommandeManager;
import dto.LigneStatistiques;
import dto.Statistiques;
import model.Commande;
import model.Etats;
import util.Utilities;

public class CommandeDAL implements ICommandeDAL {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final String SELECT_BY_ID = "SELECT identifiant, date_Commande, nom_Client, adresse,etat "
			+ "FROM Commandes WHERE Identifiant = ?";

	private final String SELECT_ALL = "SELECT identifiant, date_Commande, nom_Client, adresse,etat " + "FROM Commandes";

	private final String INSERT = "INSERT INTO Commandes VALUES(?,?,?,?)";

	private final String UPDATE = "UPDATE Commandes SET date_Commande = ?, nom_Client = ?, adresse = ?, etat = ? "
			+ "WHERE Identifiant = ?";

	private final String DELETE = "DELETE FROM Commandes WHERE Identifiant = ?";
	
	private final String SELECT_DISPLAYLIST = "SELECT c.Identifiant, u.Nom,c.Etat_id FROM Commande_Traitee ct INNER JOIN Commande c ON ct.Commande_id = c.Identifiant INNER JOIN Utilisateurs u ON ct.Utilisateur_id = u.Identifiant ORDER BY c.Identifiant";
	
	private final String SELECT_STATS = "SELECT u.Nom,COUNT(DISTINCT c.Identifiant) as nbCommandes FROM Commande_Traitee ct INNER JOIN Commande c ON ct.Commande_id = c.Identifiant INNER JOIN Utilisateurs u ON ct.Utilisateur_id = u.Identifiant GROUP BY u.Identifiant,u.Nom";
	
	private final String SELECT_AFFECTABLE = "SELECT TOP 1 c.Identifiant ,c.Date_Commande ,c.Nom_Client       ,c.Adresse       ,c.Etat_id FROM Commande c WHERE c.Etat_id=1 ORDER BY Date_Commande DESC";

	private final String SELECT_AFFECTEE = "SELECT TOP 1 c.Identifiant ,c.Date_Commande ,c.Nom_Client       ,c.Adresse       ,c.Etat_id FROM Commande_Traitee ct INNER JOIN Commande c ON ct.Commande_id = c.Identifiant WHERE c.Etat_id=2 AND ct.Utilisateur_id=? ORDER BY c.Identifiant";

	
	@Override
	public Commande getOneByID(int id) {
		CommandeArticleDAL commandeArticleDAL = new CommandeArticleDAL();
		List<LigneCommandeArticle> lignes = new ArrayList<LigneCommandeArticle>();
		
		Commande retour = null;
		Connection cnx = null;
		try {
			cnx = AccesBase.getConnection();
			PreparedStatement requete = cnx.prepareStatement(SELECT_BY_ID);
			requete.setInt(1, id);
			ResultSet resultat = requete.executeQuery();
			while (resultat.next()) {
				int identifiant = resultat.getInt("identifiant");
				Date date_Commande = resultat.getDate("date_Commande");
				String nom_Client = resultat.getString("nom_Client");
				String adresse = resultat.getString("adresse");
				Etats etat = Utilities.getEtat(resultat.getInt("etat"));
				
				lignes = commandeArticleDAL.getAllByCommande(identifiant);
				
				retour = new Commande(identifiant, date_Commande, nom_Client, adresse, etat, lignes);
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
	public List<Commande> getAll() {
		CommandeArticleDAL commandeArticleDAL = new CommandeArticleDAL();
		List<LigneCommandeArticle> lignes = new ArrayList<LigneCommandeArticle>();
		
		List<Commande> retour = null;
		Connection cnx = null;
		try {
			cnx = AccesBase.getConnection();
			PreparedStatement requete = cnx.prepareStatement(SELECT_ALL);
			ResultSet resultat = requete.executeQuery();
			retour = new ArrayList<Commande>();
			while (resultat.next()) {
				int identifiant = resultat.getInt("identifiant");
				Date date_Commande = resultat.getDate("date_Commande");
				String nom_Client = resultat.getString("nom_Client");
				String adresse = resultat.getString("adresse");
				Etats etat = Utilities.getEtat(resultat.getInt("etat"));
				
				lignes = commandeArticleDAL.getAllByCommande(identifiant);
				
				Commande c = new Commande(identifiant, date_Commande, nom_Client, adresse, etat, lignes);
				retour.add(c);
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
	public Commande insert(Commande obj) {
		Connection cnx = null;
		try {
			if (obj != null) {
				cnx = AccesBase.getConnection();
				PreparedStatement requete = cnx.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
				requete.setDate(1, new java.sql.Date(obj.getDate_Commande().getTime()) );
				requete.setString(2, obj.getNom_Client());
				requete.setString(3, obj.getAdresse());
				requete.setInt(4, Utilities.getEtatInt(obj.getEtat()));
				requete.executeUpdate();
				
				ResultSet rs = requete.getGeneratedKeys();
				obj.setIdentifiant(rs.getInt(0));
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
	public Commande update(Commande obj) {
		Connection cnx = null;
		try {
			if (obj != null) {
				cnx = AccesBase.getConnection();
				PreparedStatement requete = cnx.prepareStatement(UPDATE);
				requete.setDate(1, new java.sql.Date(obj.getDate_Commande().getTime()) );
				requete.setString(2, obj.getNom_Client());
				requete.setString(3, obj.getAdresse());
				requete.setInt(4, Utilities.getEtatInt(obj.getEtat()));
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
	public void delete(int id) {
		Connection cnx = null;
		try {
			cnx = AccesBase.getConnection();
			PreparedStatement requete = cnx.prepareStatement(DELETE);
			requete.setInt(1, id);
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
	public List<LigneCommandeManager> getDisplayList() {
		List<LigneCommandeManager> retour = null;
		Connection cnx = null;
		try {
			cnx = AccesBase.getConnection();
			PreparedStatement requete = cnx.prepareStatement(SELECT_DISPLAYLIST);
			ResultSet resultat = requete.executeQuery();
			retour = new ArrayList<LigneCommandeManager>();
			while (resultat.next()) {
				
				Integer idCommande = resultat.getInt("identifiant");
				int tata = resultat.getInt("Etat_id");
				Etats etat = Utilities.getEtat(tata);
				String nomEmploye = resultat.getString("nom");
				LigneCommandeManager ligne = new LigneCommandeManager(idCommande, etat, nomEmploye);
				retour.add(ligne);
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
	public Statistiques getStatistiques() {		
		List<LigneStatistiques> lignes = null;
		int nbTotal = 0;
		Connection cnx = null;
		try {
			cnx = AccesBase.getConnection();
			PreparedStatement requete = cnx.prepareStatement(SELECT_STATS);
			ResultSet resultat = requete.executeQuery();
			lignes = new ArrayList<LigneStatistiques>();
			while (resultat.next()) {
				
				Integer nbCommandes = resultat.getInt("nbCommandes");
				String nomEmploye = resultat.getString("nom");
				LigneStatistiques ligne = new LigneStatistiques(nomEmploye, nbCommandes);
				lignes.add(ligne);
				nbTotal+=nbCommandes;
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
		return new Statistiques(nbTotal, lignes);
	}

	@Override
	public Commande getByEmploye(int idEmploye) {		
		Commande retour = null;
		Connection cnx = null;
		try {
			cnx = AccesBase.getConnection();
			PreparedStatement requete = cnx.prepareStatement(SELECT_AFFECTEE);
			requete.setInt(1, idEmploye);
			ResultSet resultat = requete.executeQuery();
			while (resultat.next()) {
				int identifiant = resultat.getInt("identifiant");
				Date date_Commande = resultat.getDate("date_Commande");
				String nom_Client = resultat.getString("nom_Client");
				String adresse = resultat.getString("adresse");
				Etats etat = Utilities.getEtat(resultat.getInt("etat"));				
				retour = new Commande(identifiant, date_Commande, nom_Client, adresse, etat);
			}
			
			if (retour ==null) {
				requete = cnx.prepareStatement(SELECT_AFFECTABLE);
				resultat = requete.executeQuery();
				while (resultat.next()) {
					int identifiant = resultat.getInt("identifiant");
					Date date_Commande = resultat.getDate("date_Commande");
					String nom_Client = resultat.getString("nom_Client");
					String adresse = resultat.getString("adresse");
					Etats etat = Utilities.getEtat(resultat.getInt("etat"));				
					retour = new Commande(identifiant, date_Commande, nom_Client, adresse, etat);
				}
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
