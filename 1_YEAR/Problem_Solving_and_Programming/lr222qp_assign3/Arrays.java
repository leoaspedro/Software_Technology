package lr222qp_assign3;

public class Arrays {


private static int sum(int[] arr) {
int total = 0;
for(int i = 0; i<arr.length;total = total + arr[i++]);
return total;
}
private static String toString(int[]arr) {	
int length = arr.length;
String Print = "";
for(int i = 0;i<length;i++) {
	Print += arr[i]+" ";
}
return Print;
}
private static int[] addN(int[] arr, int n) {
	int length = arr.length;
	int[] addN = new int[length];
	for (int i=0;i<length;i++) {
		addN [i]= arr[i]+ n;
	}
	
return addN;
}
private static int[] reverse(int[] arr ) {
	int length = arr.length;
	int [] reverse = new int [length];
	for(int i =0;i<length;i++) {
		reverse[i]=arr[(length-1)-i];
	
	}
	
	return reverse;
}	
	
private static  boolean hasN(int[] arr, int n) {
	int length = arr.length;
	boolean hasN = false;
	for(int i=0;i<length;i++) {
		if(arr[i]==n) {
		hasN =  true;
		}
		else {
		hasN =false;
	}
	}
	return hasN;
}
private static void replaceAll(int[] arr, int old, int nw) {
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==old) {
				arr[i]=nw;
				}
	}
	}

private static int[]sort(int[] arr) {
	int[]sort1= arr.clone();
	for (int i = 0; i < sort1.length-1; i++){
		//System.out.println("i: "+i);
		int lowIndex = i;
		
		for(int i2 = i+1; i2<sort1.length;i2++) {
			//System.out.println("i2: "+i2);
			if(sort1[i2]<sort1[i]) {
				lowIndex = i2;
			//System.out.println("new lowIndex: "+lowIndex);
			}
			}
		if(i!=lowIndex) {
		//System.out.println("Swapped :"+sort1[i]+" and "+sort1[lowIndex]);
		int temp = sort1[lowIndex];
		sort1[lowIndex]=sort1[i];
		sort1[i]=temp;
		}
		}
	return sort1;
}
	

public static void main (String[]args) {
	int[] arr = {2,1,8,4,3};
	int n =5;
	int nw = 100;
	int old = 8;
	System.out.println("Ex.1\nSum = " + sum(arr));
	System.out.println("Ex.2\nn = "+ toString(arr));
	System.out.println("Ex.3\nAdded n to every number in the Array: "+toString(addN(arr, n)));
	System.out.println("Ex.4\nReversed order of the Array: "+toString(reverse(arr)));
	System.out.println("Ex.5\n"+hasN(arr,n));
	replaceAll(arr, old, nw);
	System.out.println("Ex.6\nReplacing all occurences of old with nw in arr : "+toString(arr));
	System.out.println("Ex.7\nA new array sorted (increasing order): "+toString(sort(arr)));
	
	

	
	
	
	
}





}
