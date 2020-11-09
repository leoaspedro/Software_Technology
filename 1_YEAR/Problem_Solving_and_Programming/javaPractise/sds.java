package javatest;

public class sds {
	public static void main(String[]args) {
		int []arr = {1,2,3,4};
		System.out.print("This array contains duplicate elements :"+hasDuplicates(arr));
	}
	private static boolean hasDuplicates(int[] arr) {
	  for (int i = 0; i < arr.length; i++)
	    {
		for (int j = i + 1; j < arr.length; j++)
		{
		    if (arr[i] == arr[j]) return true;
		}
	    }
	    return false;
	}
}
