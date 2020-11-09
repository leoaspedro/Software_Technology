package lr222qp.assign1;

public class PrintRecursive {
	public static void main(String[] args) {
		   String str = "Hello Everyone!";
				
		   print(str, 0);
		   System.out.println(); // Line break
		   printReverse(str, 0);
		}
	
	public static void  print(String str, int pos) {
		if(pos == str.length()) {	//stop statement
		}
		else {
			System.out.print(str.charAt(pos));
			print(str,pos+1);
		}
	
	}

	
	public static void printReverse(String str, int pos ) {
		if(pos == str.length()) {
	}
	else {
		System.out.print(str.charAt((str.length()-1)-pos));
		printReverse(str,pos+1);
	}
	}
}

