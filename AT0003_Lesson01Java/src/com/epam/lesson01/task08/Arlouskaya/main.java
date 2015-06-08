package com.epam.lesson01.task08.Arlouskaya;

public class main {
	public static void main(String[] args) {
		int [] arrayInt = {1,4,6,4,5,6,8,15,2};
		int k=2;
		int sum=0;
		for (int i = 0; i < arrayInt.length; i++) {
			if (arrayInt[i]%k==0){
				sum=sum+arrayInt[i];
			}
		}
		System.out.println("Sum="+sum);
	}
}
