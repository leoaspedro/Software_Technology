package BlackJack.model.rules;

import BlackJack.model.Dealer;
import BlackJack.model.Player;

public interface WinnerInterface {
    boolean DealerWins(Player a_player, Dealer a_dealer, int g_maxScore);
}
