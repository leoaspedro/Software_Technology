package lr222qp_assign2;
import java.util.Scanner;

public class Backwards {
public static void main(String[]args) {
	Scanner sc = new Scanner(System.in);
	
	System.out.print("Provide a line of text :");
	String text = sc.nextLine();
	sc.close();

	int length = text.length();
   
    String backwards ="";
    
    for (int i = length - 1 ; i >= 0 ; i--) {
       backwards = backwards + text.charAt(i);
    }
	System.out.print("Backwards: "+ backwards );
}
}
