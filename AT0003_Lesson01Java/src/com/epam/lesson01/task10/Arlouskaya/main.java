package com.epam.lesson01.task10.Arlouskaya;

import java.util.InputMismatchException;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		int n=0;
		Scanner in = new Scanner(System.in);
		Boolean isNumbers=true;
		try {
			System.out.print("n=");
			n=in.nextInt();
		} catch (InputMismatchException e) {
			System.err.print("Input is not a number");
			isNumbers=false;
		}
		in.close();		
		if (isNumbers){
			if (n%2==0){
				int matr[][]= new int [n][n];
				for (int i=0; i<n; i=i+2){
					matr[i] = new int[n];
					matr[i+1] = new int[n];
					for (int j = 0; j < n; j++) {
						matr[i][j]=j+1;
						matr[i+1][j]=n-j;
					}
				}
				for (int i = 0; i < matr.length; i++) {
					for (int j = 0; j < matr.length; j++) {
						System.out.print(matr[i][j]+" ");
					}
					System.out.println();
				}
			}
			else {
				System.out.println("n is odd");
			}
		}

	}

}
