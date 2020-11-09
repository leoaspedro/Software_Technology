package lr222qp_assign1;
import  java.util.Scanner;

public class Fahrenheit {
	public static void main (String[]args) {
Scanner sc = new Scanner(System.in);
System.out.print("Please enter Fahrenheit value:");
double fahrenheit = sc.nextDouble();
double celsius = ((-32+fahrenheit)/1.8 );
System.out.print("Celsius: " + celsius);

	sc.close();
	
	}
}
