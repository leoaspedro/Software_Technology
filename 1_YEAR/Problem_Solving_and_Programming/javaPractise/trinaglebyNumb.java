package javatest;

import java.util.Scanner;

public class trinaglebyNumb {
	public static void main(String[]args) {
		int Stars =0;
		int k =0;
		int star =0;
		
		System.out.print("Input number of rows: ");
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		sc.close();
		for(star=0;star<=n;star++)
			{
		for(Stars=0;Stars<star;Stars++)
	   	System.out.print(k++);
		System.out.println("");
	}
	}
	}
