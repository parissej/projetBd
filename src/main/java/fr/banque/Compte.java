package fr.banque;

public class Compte implements ICompte {

	private double solde;
	private int numeroCompte;

	public Compte() {
		this(0, 0);
	}

	public Compte(int unNumero, double unSoldeInitial) {
		this.setSolde(unSoldeInitial);
		this.setNumero(unNumero);
	}

	@Override
	public double getSolde() {
		return this.solde;
	}

	@Override
	public void setSolde(double unSolde) {
		this.solde = unSolde;
	}

	@Override
	public int getNumero() {
		return this.numeroCompte;
	}

	public void setNumero(int unNumero) {
		this.numeroCompte = unNumero;
	}

	@Override
	public String toString() {
		return "solde = " + this.getSolde() + ", numero = " + this.getNumero();
	}

}
