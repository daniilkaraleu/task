package app.exceptions;

public class UncheckedFileNotFoundException extends RuntimeException{
	public UncheckedFileNotFoundException() {
		super();
	}

	public UncheckedFileNotFoundException(String message) {
		super(message);
	}

	public UncheckedFileNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public UncheckedFileNotFoundException(Throwable cause) {
		super(cause);
	}

	protected UncheckedFileNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
