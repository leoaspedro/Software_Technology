package javatest;
import java.util.Scanner;
public class Square {
public static void main(String[]args) {
	Scanner sc = new Scanner(System.in);
	System.out.print("Provide and integer: ");
	int integer = sc.nextInt();
	sc.close();
	
	if(integer<3) {
	System.err.println("Provide an integer higher or equal to 3");	
	}
	else {
		//Build rows stars and space
		String stars ="";
		for ( int i = 0;i<integer;i++) 
		stars = stars + "*";
		//System.out.print(stars);
		
		String space = "*";
		for ( int i =0; i<integer-2;i++) 
		space = space + " ";
		space = space+ "*";
		//System.out.print(space);
		
		
		//Print square
		System.out.println("\n" + stars);
		for(int i = 0; i<integer-2;i++)
		System.out.println(space);
		System.out.println(stars);			
		}
	}
}


