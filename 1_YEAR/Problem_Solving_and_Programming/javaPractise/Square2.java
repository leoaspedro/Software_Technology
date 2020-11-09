package javatest;

import java.util.Scanner;

public class Square2 {
public static void main(String[]args) {
	Scanner sc = new Scanner(System.in);
	System.out.print("Provide an integer: ");
	int integer = sc.nextInt();
	sc.close();
	if(integer<3) {
	System.err.print("Provide an integer higher or equal to 3.");
	}
	
	else {
		String stars ="";
		for(int i = 0;i<integer;i++)
			stars += "*";
			System.out.println(stars);
		
			
		for(int j = 0;j<integer-2;j++) {
		String space ="*";
		for(int i =0;i<integer-2;i++)
			space += " ";
		space = space +"*";
		System.out.println(space);
		}
		
		String star ="";
		for(int i = 0;i<integer;i++)
			star += "*";
			System.out.println(star);
	}
	
	
	
		
}
}
