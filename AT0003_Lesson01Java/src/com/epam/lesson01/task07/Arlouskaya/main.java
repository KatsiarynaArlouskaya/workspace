package com.epam.lesson01.task07.Arlouskaya;

import java.util.InputMismatchException;
import java.util.Scanner;

public class main {
	
	public static void main(String[] args) {
		double a = 0, b = 0, h=0, f=0;
		Scanner in = new Scanner(System.in);
		Boolean isNumbers=true;
		try {				
			System.out.print("a=");
			a = in.nextDouble();
			System.out.print("b=");
			b = in.nextDouble();
			System.out.print("h=");
			h = in.nextDouble();
		} catch (InputMismatchException e) {
			System.err.print("Input is not a number");
			isNumbers=false;
		}
		
		in.close();		
		if (isNumbers){
			for (double x = a; x <= b; x=x+h) {
				f = Math.pow(Math.sin(x), 2)- Math.cos(2*x);
				System.out.format("%10.3f%10.3f%n", x, f);
			}

		}
	}

}
