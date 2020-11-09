package lr222qp_assign1;
import java.util.Scanner;

public class Interest {
public static void main(String[]args) {
	Scanner sc = new Scanner(System.in);
	//Savings S
	System.out.print("Initial savings:");
double s = sc.nextDouble();
   //Percentage P
System.out.print("Interest rate(in percentages):");
double p = sc.nextDouble();

double total =s *Math.pow(p/100+1,5);
int result = (int)Math.round(total);

System.out.print("The value of your savings after 5 years is: "+result);

//close scanner!!
sc.close();

}
}
