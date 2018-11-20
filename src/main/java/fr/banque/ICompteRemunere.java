package fr.banque;

public interface ICompteRemunere extends ICompte {
	public double calculerInterets();

	public void verserInterets();

	public double getTaux();

	public void setTaux(double unTaux);
}
