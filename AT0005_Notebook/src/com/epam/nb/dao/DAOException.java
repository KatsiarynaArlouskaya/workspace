package com.epam.nb.dao;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.epam.nb.logic.LogicException;

public class DAOException extends Exception{
	private static final Logger logger = LogManager.getLogger(DAOException.class.getName());
	public DAOException(String messString) {
		super(messString);
		logger.error(messString);
	}
	public DAOException(String messString, Exception e) {
		super(messString, e);
		logger.error(messString +": " + e.getMessage());
	}
}
