package com.epam.lesson01.task04.Arlouskaya;

import java.util.InputMismatchException;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		double x = 0, y = 0;
		Scanner in = new Scanner(System.in);
		Boolean isNumbers = true;
		try {
			System.out.print("x=");
			x = in.nextDouble();
			System.out.print("y=");
			y = in.nextDouble();
		} catch (InputMismatchException e) {
			System.err.print("Input is not a number");
			isNumbers = false;
		}
		in.close();
		if (isNumbers) {
			if (((y > 0) && (y <= 4) && (x >= -2) && (x <= 2))
					|| ((y <= 0) && (y >= -3) && (x >= -4) && (x <= 4))) {
				System.out.print("true");
			} else {
				System.out.print("false");
			}
		}
	}

}
