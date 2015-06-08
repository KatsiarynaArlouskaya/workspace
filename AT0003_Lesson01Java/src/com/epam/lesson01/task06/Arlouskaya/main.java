package com.epam.lesson01.task06.Arlouskaya;

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
			double min, max;
			min = (a<b)? a: b;
			min = (min<c)? min: c;
			max = (a>b)? a: b;
			max = (max>c)? max: c;
			double sum=max+min;
			System.out.print("sum= "+sum);
		}
	}


}
