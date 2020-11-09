package lr222qp_assign1;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Distance {
public static void main(String[]args) {
	Scanner sc = new Scanner(System.in);
	
	double x1 = sc.nextDouble();	
	double x2 = sc.nextDouble();
	double y1 = sc.nextDouble();
	double y2 = sc.nextDouble();
	sc.close();
	System.out.print("X = ("+x1+";"+x2+")"+"\rY = ("+y1+";"+y2+")");
	
	double distance = Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1));

	DecimalFormat result = new DecimalFormat("0.###");
	String three_decimals = result.format(distance);
	System.out.println("\r\rDistance = "+three_decimals);

}

}
