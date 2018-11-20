package fr.banque;

public interface ICompte {

	public void setSolde(double pSolde);

	public double getSolde();

	public void setNumero(int pNumero);

	public int getNumero();

	public default void ajouter(double unMontant) {
		this.setSolde(this.getSolde() + unMontant);
	}

	public default void retirer(double unMontant) {
		this.setSolde(this.getSolde() - unMontant);
	}

	public default void afficher() {
		System.out.println(this.getClass().getSimpleName() + " [" + this.toString() + "]");
	}

}
