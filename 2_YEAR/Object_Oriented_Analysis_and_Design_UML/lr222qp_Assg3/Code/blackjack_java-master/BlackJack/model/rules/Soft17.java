package BlackJack.model.rules;

import BlackJack.model.Card;
import BlackJack.model.Player;



public class Soft17 implements IHitStrategy {

    private final int g_hitLimit = 17;

    @Override
    public boolean DoHit(Player a_dealer) {

        if (a_dealer.CalcScore() < g_hitLimit) {
            return true;
        }
        if (a_dealer.CalcScore() == g_hitLimit) {
            boolean ACE = false;

            for (Card c : a_dealer.GetHand()) {
                if (c.GetValue() == Card.Value.Ace) {
                    ACE = true;
                }
            }

            if (ACE) {
                return true;
            }

        }
        return false;
    }

}







