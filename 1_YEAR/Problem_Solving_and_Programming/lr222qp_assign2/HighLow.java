package lr222qp_assign2;
import java.util.Scanner;
import java.util.Random;
public class HighLow {
public static void main(String[]args) {
	Scanner sc = new Scanner(System.in);

      Random rand = new Random();
      
      int correctNum = rand.nextInt(100)+1;
for (int count = 1;count <= 10 || count == correctNum;count++) {
	
      System.out.print("Guess "+count+ ":");
      int g1 = sc.nextInt();

      if(g1 < correctNum){
          System.out.println("higher");
      }
      else if(g1 > correctNum){
          System.out.println("lower");
      }
      else if(g1 == correctNum){
          System.out.println("Correct answer after only "+count+ " guesses – Excellent!");
          count=correctNum;
          
          }
        
{
	if (count == 10) {
		  System.out.print("Game over");
}
}
}
sc.close();
}
}

