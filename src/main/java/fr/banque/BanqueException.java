package fr.banque;

public class BanqueException extends Exception {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public BanqueException() {
		this("Alèd ! On a un problème");
	}

	public BanqueException(String message) {
		this(message, new Throwable());
	}

	public BanqueException(Throwable cause) {
		this("Alèd y'a un problème", cause);
	}

	public BanqueException(String message, Throwable cause) {
		super(message, cause);
	}

}
