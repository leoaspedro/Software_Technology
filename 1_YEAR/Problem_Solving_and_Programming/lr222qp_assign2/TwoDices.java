package lr222qp_assign2;
import java.util.Random;
public class TwoDices {
public static void main(String[]args) {
	Random rd = new Random();
	int[] Dices = {0,0,0,0,0,0,0,0,0,0,0,0,0};
	
	System.out.println("Frequency table (sum,count) for rolling two dices 10000 times");
	for(int i = 0;i<10000;i++) {
		int d1 = rd.nextInt(6)+1;
		int d2 = rd.nextInt(6)+1;
		int numb = d1+d2;
		
		for(int a = 2;a<13;a++) {
			if(numb==a)
				Dices[a]+=1;
				
		}
	}
	for (int i=2;i<13;i++) {
		System.out.println(i+"\t" +Dices[i]);
	}
}
}
