package fr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.banque.BanqueException;
import fr.banque.Compte;
import fr.banque.CompteASeuil;
import fr.banque.CompteASeuilRemunere;
import fr.banque.CompteRemunere;

public class TestDB03 {
	public static void main(String[] args) throws BanqueException {
		final String dbDriver = "com.mysql.jdbc.Driver";
		final String dbUrl = "jdbc:mysql://localhost/banque";
		final String dbLogin = "root";
		final String dbPwd = "root";

		List<Compte> listeComptes = new ArrayList<>();

		try {
			Class.forName(dbDriver);
		} catch (Exception e) {
			e.printStackTrace();
		}

		Connection connection = null;
		Statement request = null;
		ResultSet resultat = null;

		try {
			connection = DriverManager.getConnection(dbUrl, dbLogin, dbPwd);
			request = connection.createStatement();
			resultat = request.executeQuery("select * from banque.compte;");
			while (resultat.next()) {
				String id = resultat.getString("id");
				String solde = resultat.getString("solde");

				Compte compte = new Compte(Integer.parseInt(id), Double.parseDouble(solde));

				if (resultat.getString("taux") != null) {
					double taux = Double.parseDouble(resultat.getString("taux"));
					compte = new CompteRemunere(compte.getNumero(), compte.getSolde(), taux);
				}

				if (resultat.getString("decouvert") != null) {
					double decouvert = Double.parseDouble(resultat.getString("decouvert"));
					compte = new CompteASeuil(compte.getNumero(), compte.getSolde(), decouvert);
				}

				if (resultat.getString("taux") != null && resultat.getString("decouvert") != null) {
					double decouvert = Double.parseDouble(resultat.getString("decouvert"));
					double taux = Double.parseDouble(resultat.getString("taux"));
					compte = new CompteASeuilRemunere(compte.getNumero(), compte.getSolde(), taux, decouvert);
				}

				// String libelle = resultat.getString("libelle");
				// int utilisateurId = Integer.parseInt(resultat.getString("utilisateurId"));

				listeComptes.add(compte);

				System.out.println(listeComptes.get(listeComptes.size() - 1));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (resultat != null) {
				try {
					resultat.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (request != null) {
				try {
					request.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
