package javatest;

public class xx {
	public static void main(String[]args) {
		int []arr = {1,2,2,4};
		System.out.print("This array contains duplicate elements :"+hasDuplicates(arr));
	}
	private static boolean hasDuplicates(int[] arr){
	    for (int i = 0; i < arr.length-1; i++) {
	        for (int j = i+1; j < arr.length; j++) {
	             if (arr[i] == arr[j]) {
	                 return false;
	             }
	        }
	    }              
	    return true;          
	}
}
