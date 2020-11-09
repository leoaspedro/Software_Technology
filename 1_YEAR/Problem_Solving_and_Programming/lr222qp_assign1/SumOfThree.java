package lr222qp_assign1;
import java.util.Scanner;

public class SumOfThree {
public static void main(String[]args) {
	Scanner sc = new Scanner(System.in);
	System.out.print("Provide a three digit number:");
	
	int num = sc.nextInt();
	// int sum = num / 100; // 483  sum = 4  
    //sum = sum + num % 100 / 10;//sum = 4+8
    //sum = sum + num % 10; // sum = 4+8+3
	int sum = (num/100)+(num%100/10)+(num %10);
   System.out.println("Sum of digits:"+sum);
	
	sc.close();
}
}
