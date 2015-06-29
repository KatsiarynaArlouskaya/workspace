package com.epam.nb.logic;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.nb.view.main;

public class LogicException extends Exception {
	private static final Logger logger = LogManager.getLogger(LogicException.class.getName());
	public LogicException(String messString) {
		super(messString);
		logger.error(messString);
	}
	public LogicException(String messString, Exception e) {
		super(messString, e);
		logger.error(messString +": " + e.getMessage());
		
	}
}
