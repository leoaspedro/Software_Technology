package javatest;

import java.util.ArrayList;

public class ArrayTry {
public static void main(String[]args) {
	int[] original= {1,2,3,-1,-2,-3};
	String line = "XXdhd";
	System.out.println(allOddNumbers(original));
	System.out.println(hasTwoX(line));
	
}
public static ArrayList<Integer> allOddNumbers(int[]arr){
	ArrayList<Integer> oddA = new ArrayList<Integer>();
	for(int i =0;i<arr.length;i++) {
		int help = arr[i];
		if((help % 2 == 1) || (help  % 2 == -1))
		oddA.add(help);
	}
	return oddA;
	}
	

public static boolean hasTwoX(String str) {
	int count = 0;
	for(int i = 0;i<str.length();i++) {
		char text = str.charAt(i);
		if(text == 'X')
			count++;
	}
	if(count == 2)
		return true;
	else
		return false;
		
	
	
	
	
	
}



}


