package com.epam.nb.logic;

public class LogicException extends Exception {
	public LogicException(String messString) {
		super(messString);
	}
	public LogicException(String messString, Exception e) {
		super(messString, e);
	}
}
