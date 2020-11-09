package lr222qp_assign2;
import java.util.Scanner;

public class Triangle {
public static void main (String[]args) {
	Scanner sc = new Scanner(System.in);
	System.out.print("Provide an odd positive integer: ");
	int n = sc.nextInt();
	sc.close();
	int count = 0;
	char sign ='*',space =' ';
	
StringBuilder RAT = new StringBuilder();

if (n % 2 == 0 || n<0)
	System.out.print(" Restart!! Please make sure your number is an odd integer");
else { 
	while(count<n) {
		RAT.append(sign);
		count++;
	}
	count = 0;
	StringBuilder result = new StringBuilder();
	result.append(RAT);
	System.out.println("Righ-Angled Triangle: ");
	while (count<n) {
		RAT.setCharAt(space,(char) count);
		System.out.println(RAT);
		count++;
	}
	n = (n/2);
	int n2 = n-1;
	
	int test = 1;
			System.out.println("Isosceles Triangle: ");
	for (int i2 = 0;i2<n;i2++) {
		
		for(int k = n2;k>=i2;k--) {
			System.out.print(" ");
		}
			for(int j =0;j<test;j++) {
				System.out.print("*");
			}
			System.out.print("\n");
			test +=2;
		}
		System.out.println(result);
		
			}
			
	}

}
