package lr222qp_assign1;
import java.util.Scanner;

public class ShortName {
public static void main(String[]args) {
Scanner sc = new Scanner(System.in);
System.out.print("First name:");
String Fn = sc.nextLine();
System.out.print("Last name:");
String Ln = sc.nextLine();
//First letter from the FirstName
String Fl = Fn.substring(0,1);
//First 4 letter from the LastName
String Ll = Ln.substring(0,4);

System.out.print("Short name:"+Fl+". "+Ll);
sc.close();
	
	
	
	
	
}
}
