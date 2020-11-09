package lr222qp_assign2;
import java.util.Scanner;

public class CountA {
public static void main(String[]args) {
	Scanner sc = new Scanner(System.in);
			System.out.print("Provide a line of text:");
			
	String text = sc.nextLine();
	sc.close();
int tl = text.length();
int count = 0;//count variable for the loop
int na = 0;//number of a
int NA = 0;//number of A

char a = 'a';
char A = 'A';
char c ;//

while (count<tl) {
	c = text.charAt(count);
	if (c == a) { 
		na++;

	}
	else if (c == A) { 
		NA++;
	}	
		count++;
	
}
	
	System.out.println("Number of 'a' :"+na);
	System.out.println("Number of 'A' : "+NA);
	
	
}


}
