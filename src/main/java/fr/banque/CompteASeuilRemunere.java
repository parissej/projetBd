package fr.banque;

public class CompteASeuilRemunere extends CompteRemunere implements IComptASeuil {

	private double seuil;

	public CompteASeuilRemunere(int pUnNumero, double pUnSoldeInitial, double pTaux, double pSeuil) {
		super(pUnNumero, pUnSoldeInitial, pTaux);
		this.setSeuil(pSeuil);
	}

	public CompteASeuilRemunere() {
		this(0, 0, 0, 0);
	}

	@Override
	public double getSeuil() {
		return this.seuil;
	}

	@Override
	public void setSeuil(double pUnSeuil) {
		this.seuil = pUnSeuil;
	}

	@Override
	public String toString() {
		return super.toString() + ", seuil = " + this.getSeuil();
	}

}
