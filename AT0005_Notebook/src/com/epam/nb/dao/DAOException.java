package com.epam.nb.dao;

public class DAOException extends Exception{
	public DAOException(String messString) {
		super(messString);
	}
	public DAOException(String messString, Exception e) {
		super(messString, e);
	}
}
