package com.cmr.dev.business.exception;

public class Spb3BusinessException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Spb3BusinessException(String message, Throwable cause) {
		super(message, cause);
	}

	public Spb3BusinessException(String message) {

		super(message);
	}
}