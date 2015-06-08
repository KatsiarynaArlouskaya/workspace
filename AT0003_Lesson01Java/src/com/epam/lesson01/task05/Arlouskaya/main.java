package com.epam.lesson01.task05.Arlouskaya;

import java.util.InputMismatchException;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		double a = 0, b = 0, c=0;
		Scanner in = new Scanner(System.in);
		Boolean isNumbers=true;
		try {				
			System.out.print("a=");
			a = in.nextDouble();
			System.out.print("b=");
			b = in.nextDouble();
			System.out.print("c=");
			c = in.nextDouble();
		} catch (InputMismatchException e) {
			System.err.print("Input is not a number");
			isNumbers=false;
		}
		
		in.close();
		if (isNumbers){
			inPaw(a);
			inPaw(b);
			inPaw(c);				
		}
	}

	private static void inPaw(double a) {
		if (a<0){
			System.out.println(Math.pow(a, 4));				
		}
		else{
			System.out.println(Math.pow(a, 3));	
		}
		
	}

}
