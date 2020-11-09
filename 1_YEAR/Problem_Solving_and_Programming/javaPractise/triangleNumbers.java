package javatest;

import java.util.Scanner;

public class triangleNumbers {
public static void main(String[]args) {
	int j =0;
	int k =0;
	int i =0;
	
	System.out.print("Input number of rows: ");
	Scanner sc = new Scanner(System.in);
	int n =sc.nextInt();
	sc.close();
	for(i=0;i<=n;i++)
		{
	for(j=0;j<i;j++)
   	System.out.print(k++);
	System.out.println("");
}
}
}