package com.pborrego.hexagonalarchitecture.products.domain.exceptions;

public class ProductAlreadyExistsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProductAlreadyExistsException() {
		super();
	}

	public ProductAlreadyExistsException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ProductAlreadyExistsException(String message, Throwable cause) {
		super(message, cause);
	}

	public ProductAlreadyExistsException(String message) {
		super(message);
	}

	public ProductAlreadyExistsException(Throwable cause) {
		super(cause);
	}

}
