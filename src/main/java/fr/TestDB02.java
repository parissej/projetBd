package fr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import fr.banque.Client;

public class TestDB02 {
	public static void main(String[] args) {
		final String dbDriver = "com.mysql.jdbc.Driver";
		final String dbUrl = "jdbc:mysql://localhost/banque";
		final String dbLogin = "root";
		final String dbPwd = "root";

		List<Client> listeClient = new ArrayList<>();

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
			resultat = request.executeQuery("select * from banque.utilisateur;");
			while (resultat.next()) {
				String nom = resultat.getString("nom");
				String prenom = resultat.getString("prenom");
				String naissance = resultat.getString("dateDeNaissance");
				LocalDate dateDeNaissance;
				int age;
				if (naissance != null) {
					dateDeNaissance = LocalDate.parse(naissance);
					age = Period.between(dateDeNaissance, LocalDate.now()).getYears();
				} else {
					age = -1;
				}

				int numero = Integer.parseInt(resultat.getString("id"));
				listeClient.add(new Client(numero, nom, prenom, age));
			}
			System.out.println(listeClient);
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
