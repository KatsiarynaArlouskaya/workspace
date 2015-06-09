package com.epam.lesson01.task03.Arlouskaya;

import java.util.InputMismatchException;
import java.util.Scanner;

public class main {
	static double a, b;

	public static void main(String[] args) {
		Boolean isNumbers = getDate();
		if (isNumbers) {
			System.out.println("Perimeter=" + getPerimetr(a, b));
			System.out.println("Area=" + getArea(a, b));
		}
	}

	public static double getPerimetr(double a, double b) {
		return a + b + Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
	}

	public static double getArea(double a, double b) {
		return a * b / 2;
	}

	private static Boolean getDate() {
		Scanner in = new Scanner(System.in);
		Boolean isNumbers = true;
		try {
			System.out.print("a=");
			a = in.nextDouble();
			System.out.print("b=");
			b = in.nextDouble();
		} catch (InputMismatchException e) {
			System.err.print("Input is not a number");
			isNumbers = false;
		}
		in.close();
		if ((a <= 0) || (b <= 0)) {
			isNumbers = false;
			System.err.print("Inputs are not a positive number");
		}
		return isNumbers;
	}

}
