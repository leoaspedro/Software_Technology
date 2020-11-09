package lr222qp_assign1;

import java.util.Random;

public class RandomSum {
public static void main(String[]args) {
	//5 numbers
	Random rand = new Random();
	int first = rand.nextInt(100)+1;
	int second = rand.nextInt(100)+1;
	int third = rand.nextInt(100)+1;
	int fourth = rand.nextInt(100)+1;
	int fifth = rand.nextInt(100)+1;
	
	System.out.print("Five random numbers: "+first+" "+" "+second+" "+third+" "+fourth+" "+fifth);
	
	//Sum
	int total = (first+second+third+fourth+fifth);
	System.out.println("\r\rThe sum is: "+total);
	}

}
