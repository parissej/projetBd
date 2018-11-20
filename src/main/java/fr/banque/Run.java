package fr.banque;

public class Run {

	public static void main(String[] args) throws BanqueException {

		Client client = new Client(240218, "PARISSEAUX", "Juliette", 20);

		Compte c1 = new Compte(2401, 50);
		Compte c2 = new Compte(5077, 6.75);

		client.ajouterComptes(c1);
		client.ajouterComptes(c2);

		client.afficher();
		System.out.println();

		client.ajouter(20, client.getCompte(2401));
		client.retirer(30.5, client.getCompte(5077));

		client.afficher();
		System.out.println();

		CompteRemunere c3 = new CompteRemunere(2513, 40, 0.7);
		CompteASeuil c4 = new CompteASeuil(6842, 13.7, 10);

		try {
			client.ajouterComptes(c3);
			client.ajouterComptes(c4);
		} catch (BanqueException e) {
			e.printStackTrace();
		}

		client.afficher();
		System.out.println();

		c3.verserInterets();
		c4.retirer(3);

		client.afficher();
		System.out.println();

		CompteASeuilRemunere casr = new CompteASeuilRemunere(65465, 50, 0.2, 0);

		client.ajouterComptes(casr);
		client.afficher();
		System.out.println();

		casr.verserInterets();
		casr.retirer(5);

		client.afficher();
		System.out.println();

	}

}
