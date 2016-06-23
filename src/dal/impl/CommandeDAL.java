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

	@Override
	public Commande getOneByID(int id) {
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
				retour = new Commande(identifiant, date_Commande, nom_Client, adresse, etat);
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
				Commande c = new Commande(identifiant, date_Commande, nom_Client, adresse, etat);
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
				Etats etat = Utilities.getEtat(resultat.getInt("etat"));
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
		Statistiques statistiques = new Statistiques();
		List<LigneCommandeManager> retour = null;
		Connection cnx = null;
		try {
			cnx = AccesBase.getConnection();
			PreparedStatement requete = cnx.prepareStatement(SELECT_DISPLAYLIST);
			ResultSet resultat = requete.executeQuery();
			retour = new ArrayList<LigneCommandeManager>();
			while (resultat.next()) {
				
				Integer idCommande = resultat.getInt("identifiant");
				Etats etat = Utilities.getEtat(resultat.getInt("etat"));
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
		return statistiques;
	}

	

}
