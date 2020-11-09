package lr222qp_assign2;

import java.util.Random;
import java.util.Scanner;

public class HighhLow {
	
public static void main(String []args) {
	
	Random rand = new Random();
	int numb = rand.nextInt(100)+1;
	Scanner sc = new Scanner(System.in);
	for(int i =1;i<11 || i == numb;i++) {
	
	System.out.print("Guess "+i+":");
	int guess = sc.nextInt();
	if(guess==numb) {
		System.out.println("U GOT IT!!");
		System.out.print("You got the secret number at "+i+"th guess");
		break;
	}
	if(guess<numb) {
		System.out.println("Higher");
	}
	 if(guess>numb) {
		System.out.println("Lower");
	}
	
}
sc.close();

}

}

