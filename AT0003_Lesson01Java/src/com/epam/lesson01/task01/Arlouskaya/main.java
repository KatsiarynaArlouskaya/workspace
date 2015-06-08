package com.epam.lesson01.task01.Arlouskaya;

import java.util.Scanner;



public class main {
		final static Integer CORRECT_LENGTH = 4; 
		
	public static void main(String[] args) {
		System.out.println("Enter a number");
		Scanner in = new Scanner(System.in);
		String number = in.nextLine();
		int lengthNumber = number.length();
		boolean isDigit = true;
		if (lengthNumber==CORRECT_LENGTH){
			for (int i=0; i<CORRECT_LENGTH; i++){
				if (!Character.isDigit(number.charAt(i))){
					isDigit = false;
				}
			}
			if (isDigit){
				if (number.charAt(0)+number.charAt(1)==number.charAt(2)+number.charAt(3)){
					System.out.println("true");
				}
				else {
					System.out.println("false");
				}
			}
			else {
				System.out.println("It is not a number");
			}				
		}
		else {
			System.out.println("The length of the input is not correct");
		}				
		in.close();
	}

}
