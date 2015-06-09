package com.epam.lesson01.task03.Arlouskaya;

import java.util.InputMismatchException;
import java.util.Scanner;

public class main {
	static double a, b;

	public static void main(String[] args) {
		Boolean isNumbers = getDate();
		if (isNumbers) {
			getPerimetr();
			getArea();
		}

	}

	private static void getPerimetr() {
		double perimeter = a + b + Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
		System.out.println("Perimeter=" + perimeter);
	}

	private static void getArea() {
		double area = a * b / 2;
		System.out.println("Area=" + area);
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
