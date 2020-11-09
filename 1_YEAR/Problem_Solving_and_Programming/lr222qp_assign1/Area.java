package lr222qp_assign1;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Area {
public static void main(String[]args) {
	Scanner sc = new Scanner(System.in);
	System.out.print("Provide the radius:");
	float radius = sc.nextFloat();
	sc.close();
	
	double area = Math.PI*Math.pow(radius, 2);
	DecimalFormat result = new DecimalFormat("0.#");
	String one_decimal = result.format(area);
	
	System.out.print("Corresponding area:"+one_decimal);
	}
}
