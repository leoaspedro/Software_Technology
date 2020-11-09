package lr222qp_assign1;
import java.util.Scanner;

public class Quote {
public static void main (String[]args) {
Scanner sc = new Scanner (System.in);

//print 
System.out.print("Write a line of text:");

String text = sc.nextLine();
System.out.println("Quote:"+"\""+text+"\"" );

sc.close();
}
}