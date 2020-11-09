package javatest;
import java.util.ArrayList;
public class TwoMethods {
	
public static void main(String[]args) {
int []arr = {1,2,3,4};
ArrayList<Double> Original =new ArrayList<Double>();
Original.add(7.4);
Original.add(2.3);

System.out.println(roundOff(Original));

System.out.print("This array contains duplicate elements :"+hasDuplicates(arr));
}

private static ArrayList<Integer> roundOff (ArrayList<Double> input){
	ArrayList<Integer> IntG = new ArrayList<Integer>();
	for (int i = 0;i<input.size();i++) {
		double help1 = input.get(i);
		int help2 = (int)help1;
		IntG.add(help2);
		
	}
	return IntG;
}

	private static boolean hasDuplicates(int[] arr) {
		  for (int i = 0; i < arr.length; i++){
			for (int j = i + 1; j < arr.length; j++){
			    if (arr[i] == arr[j]) 
			    	return true;
			}
		    }
		    return false;
		}
	
}


