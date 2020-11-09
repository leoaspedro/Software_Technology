package lr222qp_assign1;
import java.util.Scanner;

public class Time {
public static void main(String[]args) {
	Scanner sc = new Scanner(System.in);
	
	System.out.print("Give number of seconds:");
	int seconds = sc.nextInt();
	int minutes = seconds /60;
	int hours = seconds / 60 / 60;
	
	seconds-= minutes*60;
	minutes-= hours*60;  //minutes=minutes-hours*60
	
	
			
	System.out.print("This corresponds to:"+ hours+" hours, "+minutes+" minutes, "+ seconds+" seconds .");
	
	
sc.close();	
	
}
}
