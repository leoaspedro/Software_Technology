package BlackJack.model.rules;


import BlackJack.model.Dealer;
import BlackJack.model.Player;

public class playerWorL implements WinnerInterface {

    @Override
    public boolean DealerWins(Player a_player, Dealer a_dealer, int g_maxScore) {
        if (a_player.CalcScore() > g_maxScore) {
            return false;
        }
        if (a_dealer.CalcScore() > g_maxScore) {
            return true;
        }
        return a_player.CalcScore() > a_dealer.CalcScore();
    }
}


