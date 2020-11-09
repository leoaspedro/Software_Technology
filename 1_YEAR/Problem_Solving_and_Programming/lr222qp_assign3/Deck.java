package lr222qp_assign3;

import java.util.ArrayList;
import java.util.Random;
import lr222qp_assign3.Card.rank;
import lr222qp_assign3.Card.suite;

public class Deck {
private ArrayList<String>DeckOfCard = new ArrayList<String>();
private int HowManyCards;
private ArrayList<String>DealtCard = new ArrayList<String>();

public Deck() {
	HowManyCards=52;
}
public void CreateDeckOfCard() {
	HowManyCards = 52;
	int count = 0;
	for(int i = 1;i<=4;i++) {
		for(int j =1;j<=13;j++) {
			String help1 = suite.getSuiteName(i);
			String help2 = rank.getRankName(j);
			String Card = help2+" "+help1;
			DeckOfCard.add(count, Card);
			count++;
		}
	}
}
public String toString() {
	String text ="";
	for(int i = 0;i<DeckOfCard.size();i++) {
		text = text + DeckOfCard.get(i)+" ";
	}
	return text;
}
public String DealACard() {
	Random rd = new Random();
	int Random = rd.nextInt(52);
	String Print = DeckOfCard.get(Random);
	
	DeckOfCard.remove(Random);
	DealtCard.add(Print);
	HowManyCards--;
	return Print;
}
public void ShuffleDeck() {
	if(HowManyCards == 52) {
		Random rd2 = new Random();
		for(int i =0;i<52;i++) {
			int randomPosition = rd2.nextInt(DeckOfCard.size());
			String temp = DeckOfCard.get(i);
			
			DeckOfCard.add(i,DeckOfCard.get(randomPosition));
			DeckOfCard.add(randomPosition, temp);
		}
	}
	else {
		System.out.println("The deck is not with all cards,in that way i cant shuffle.");
		
	}
}
	public void getAmountOfCard() {
		System.out.println("There is " + HowManyCards+" cards remaining int he deck.");
	}
	public ArrayList<String>getDealtCard(){
		System.out.println("This is the dealt card: ");
		return DealtCard;
	}

}

