package lr222qp_assign2;

public class BirthdayCandles {
public static void main(String[]agrs) {
	int box = 0;
	int candles = 0;
	int newbox = 0;
	boolean print = false;
	
	for(int i=1;i<=100;i++) {
		if(candles<i);
		print = true;
		
	while (candles<i) {
		box++;
		newbox++;
		candles = candles+24;
	}
	if(print == true) {
		System.out.println("For "+i+" birthday, buy box(es): "+newbox);
		print = false;
	}
	newbox = 0;
	candles = candles-i;
	}
	System.out.println("Total number of boxes: "+box+", remaining number of candles: "+candles);	
	}
}

