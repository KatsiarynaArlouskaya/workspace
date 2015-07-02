package com.epam.nb.view;

import java.util.Locale;
import java.util.Scanner;

public class LocaleNotebook {
	private final static LocaleNotebook instance = new LocaleNotebook();
	public static final String EN = "en";
	public static final String FR = "fr";
	public static final String RU = "ru";
	private Locale locale;
	private LocaleNotebook(){
		this.locale=Locale.getDefault();
	}
	public static LocaleNotebook getInstance() {
		return instance;
	}
	
	public void setLocale(String country){
		switch (country) {
		case EN:
			locale = Locale.ENGLISH;
			break;
		case FR:
			locale = Locale.FRANCE;
			break;
		case RU:
			locale = new Locale("ru");
			break;
		default:
			System.out.println("Enter, please, valid locale");
			Scanner sc = new Scanner(System.in);
			country = sc.next();
			setLocale(country);
			break;
		}
	}
	
	public Locale getLocale() {
		return this.locale;
	}

}
