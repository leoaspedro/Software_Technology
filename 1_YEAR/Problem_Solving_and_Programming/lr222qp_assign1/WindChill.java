package lr222qp_assign1;
import java.util.Scanner;
import java.lang.Math;
import java.text.DecimalFormat;
public class WindChill {
public static void main(String[]args) {
	Scanner sc = new Scanner(System.in);
	//ask for C
	System.out.print("Temperature (C): ");
	double Celsius = sc.nextDouble();
	
	//ask for Windspeed
	System.out.print("Wind speed (m/s): ");
	double Speed = sc.nextDouble();
	double speed = Speed*3.6;
	//Result
	double V = Math.pow(speed, 0.16);
	double result = 13.12 + 0.6215*Celsius - (11.37)*V +( 0.3965*Celsius)*V;
	DecimalFormat finalresult = new DecimalFormat("0.#");
	String one_decimal = finalresult.format(result);
	System.out.print("Wind Chill Temperature (C): "+one_decimal);
	
	
sc.close();
	
}
}
