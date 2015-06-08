package com.epam.lesson01.task03.Arlouskaya;

import java.util.InputMismatchException;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		double a = 0, b = 0;
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
		if (isNumbers) {
			if ((a > 0) && (b > 0)) {
				double perimeter = a + b
						+ Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
				System.out.println("Perimeter=" + perimeter);
				double area = a * b / 2;
				System.out.println("Area=" + area);
			} else {
				System.err.print("Inputs are not a positive number");
			}
		}

	}

}
