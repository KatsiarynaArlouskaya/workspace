package com.epam.lesson01.task09.Arlouskaya;

public class main {

	public static void main(String[] args) {
		int[] arrayInt1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int[] arrayInt2 = { 0, 0, 0, 0 };
		int[] arrayInt3;
		int k = 3;
		arrayInt3 = new int[arrayInt1.length + arrayInt2.length];
		for (int i = 0; i < k; i++) {
			arrayInt3[i] = arrayInt1[i];
		}
		for (int i = k; i < k + arrayInt2.length; i++) {
			arrayInt3[i] = arrayInt2[i - k];
		}
		for (int i = k + arrayInt2.length; i < arrayInt3.length; i++) {
			arrayInt3[i] = arrayInt1[i - arrayInt2.length];
		}
		for (int i = 0; i < arrayInt3.length; i++) {
			System.out.print(arrayInt3[i] + " ");
		}
	}
}
