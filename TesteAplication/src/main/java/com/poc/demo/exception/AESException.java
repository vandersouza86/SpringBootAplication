package com.poc.demo.exception;

public class AESException extends RuntimeException {

	private static final long serialVersionUID = -4455905202713291812L;

	public AESException(final Exception e) {
		super(e);
	}
}
