package fr.banque;

import java.util.Hashtable;
import java.util.Map;

public class Client {

	private String nom, prenom;
	private int age, numeroClient;
	private Map<Integer, Compte> listeCompte = new Hashtable<Integer, Compte>();

	public Client() {
		this(0, "TEST", "Test", 0);
	}

	public Client(int unNumero, String unNom, String unPrenom, int unAge) {
		this.setAge(unAge);
		this.setNom(unNom);
		this.setPrenom(unPrenom);
		this.setNumero(unNumero);
	}

	public int getAge() {
		return this.age;
	}

	public String getNom() {
		return this.nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setNumero(int numero) {
		this.numeroClient = numero;
	}

	public int getNumero() {
		return this.numeroClient;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Compte[] getComptes() {
		return this.listeCompte.values().toArray(new Compte[this.listeCompte.size()]);
	}

	public Compte getCompte(int unNumero) {

		for (Compte compte : this.getComptes()) {
			if (compte.getNumero() == unNumero) {
				return compte;
			}
		}
		return null;
	}

	public void setCompte(int unNumero, Compte unCompte) {
		this.listeCompte.put(unNumero, unCompte);
	}

	/**
	 * @param unCompte à ajouter
	 * @return true si le compte à été ajouté
	 * @throws BanqueException si il n'y a plus de place dans les comptes
	 */
	public boolean ajouterComptes(Compte unCompte) throws BanqueException {

		if (this.getComptes().length > 5) {
			throw new BanqueException("Plus de place dans le tableau.");
		}

		this.setCompte(unCompte.getNumero(), unCompte);
		return true;
	}

	public String toStringComptes() {
		String toString = "";

		for (Compte compte : this.getComptes()) {
			if (compte != null) {
				toString += compte.toString() + "\n";
			}
		}

		return toString;

	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " : [" + this.getNumero() + "] " + this.getNom() + " "
				+ this.getPrenom() + " (" + this.getAge() + " ans)";
	}

	public void afficher() {
		System.out.println(this.toString());
		for (Compte compte : this.getComptes()) {
			if (compte != null) {
				compte.afficher();
			}
		}
	}

	public void ajouter(double unMontant, Compte unCompte) {
		unCompte.ajouter(unMontant);
	}

	public void retirer(double unMontant, Compte unCompte) {
		unCompte.retirer(unMontant);
	}

}
