package BlackJack.model.rules;


import BlackJack.model.Dealer;
import BlackJack.model.Player;

public class dealerWorL implements WinnerInterface {


    @Override
    public boolean DealerWins(Player a_player, Dealer a_dealer, int g_maxScore) {
        if (a_player.CalcScore() > g_maxScore) {
            return true;
        }
        if (a_dealer.CalcScore() > g_maxScore) {
            return false;
        }
        return a_dealer.CalcScore() >= a_player.CalcScore();
    }
}