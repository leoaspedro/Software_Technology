package lr222qp_assign3;

public class PlayCardMain {
public static void main(String[]args) {
	Deck  d1 = new Deck();
	d1.CreateDeckOfCard();
	
	System.out.println(d1.toString());
	d1.ShuffleDeck();
	System.out.println(d1.toString());
	
	System.out.println(d1.DealACard());
	d1.getAmountOfCard();
	System.out.println(d1.DealACard());
	System.out.println(d1.DealACard());
	System.out.println(d1.DealACard());
	System.out.println(d1.DealACard());
	
	System.out.println(d1.getDealtCard());
	d1.getAmountOfCard();
	
	
	
	
}
}
