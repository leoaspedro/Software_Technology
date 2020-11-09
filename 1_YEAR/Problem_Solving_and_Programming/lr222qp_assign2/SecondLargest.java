package lr222qp_assign2;
import java.util.Scanner;

public class SecondLargest {

	public static void main(String[] Args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Provide 10 integers: ");		
		int L=0, SL=0, Integers = 10, num; 
		for (int i=0;i<Integers;i++) {
			num = sc.nextInt();
			
			
			if (num>L) {
				SL = L;
				L = num;
				continue;
			}
			else if ((num>SL) && (num<L)) {
				SL = num;
				continue;
			}
			
		}
		sc.close();
		System.out.println("The second largest is: "+SL);
	}
}






