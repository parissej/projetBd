package fr.banque;

public class CompteRemunere extends Compte implements ICompteRemunere {

	private double taux; // entre 0 et 1

	public CompteRemunere(int unNumero, double unSoldeInitial, double pTaux) {
		super(unNumero, unSoldeInitial);
		this.taux = pTaux;
	}

	public CompteRemunere() {
		this(0, 0, 0);
	}

	@Override
	public double getTaux() {
		return this.taux;
	}

	@Override
	public void setTaux(double pTaux) {
		this.taux = pTaux;
	}

	/**
	 * Calcule les intérêts du compte (taux*solde)
	 *
	 * @return les intérêts du compte
	 */
	@Override
	public double calculerInterets() {
		return this.getTaux() * this.getSolde();
	}

	/**
	 * Ajoute au solde la totalité des intérêts calculés
	 */
	@Override
	public void verserInterets() {
		this.ajouter(this.calculerInterets());
	}

	@Override
	public String toString() {
		return super.toString() + ", taux = " + this.getTaux();
	}

}
