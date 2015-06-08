package com.epam.lesson01.task02.Arlouskaya;

import java.util.InputMismatchException;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		double a = 0, b = 0, c = 0, d = 0;
		Scanner in = new Scanner(System.in);
		Boolean isNumbers = true;
		try {
			System.out.print("a=");
			a = in.nextDouble();
			System.out.print("b=");
			b = in.nextDouble();
			System.out.print("c=");
			c = in.nextDouble();
			System.out.print("d=");
			d = in.nextDouble();
		} catch (InputMismatchException e) {
			System.err.print("Input is not a number, try again");
			isNumbers = false;
		}
		in.close();
		if (isNumbers) {
			double express = (b + Math.sqrt(Math.pow(b, 2) + 4 * a * c))
					/ (2 * a) - Math.pow(a, 3) * c + Math.pow(b, -2);
			System.out.println(express);
		}
	}
}
