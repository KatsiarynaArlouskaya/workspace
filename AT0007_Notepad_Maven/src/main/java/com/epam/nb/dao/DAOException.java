package com.epam.nb.dao;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.nb.logic.LogicException;

public class DAOException extends Exception{
	public DAOException(String messString) {
		super(messString);
	}
	public DAOException(String messString, Exception e) {
		super(messString+ "/n"+e.toString(), e);
	}
}
