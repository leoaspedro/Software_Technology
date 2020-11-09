package javatest;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex3LoicTest {
public static void main (String[]args) {
	
	
	ArrayList<Integer> Numbers = new ArrayList<Integer>();
	Scanner sc =new Scanner(System.in);
	
	
	boolean check = false;
	while (check==false) {
		System.out.print("Number : ");
		int num = sc.nextInt();
		
		for(int i=0;i<Numbers.size();i++) {
			if(num==Numbers.get(i)) {
				check = true;
				
				break;
			}
			else
				check = false;
		}
		if (check==false) {
			Numbers.add(num); 
			
		}
	}
	sc.close();
	
		
	
	
}
}
