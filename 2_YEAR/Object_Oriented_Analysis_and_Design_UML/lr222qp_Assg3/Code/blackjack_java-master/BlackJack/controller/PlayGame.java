package BlackJack.controller;

import BlackJack.model.rules.BJ_Interface;
import BlackJack.view.IView;
import BlackJack.model.Game;

public class PlayGame implements BJ_Interface {

  private Game game;
  private IView OVV;

  public boolean Play(Game a_game, IView a_view) {
    game = a_game;
    OVV = a_view;

    game.GameObserver(this);
    a_view.DisplayWelcomeMessage();

    a_view.DisplayDealerHand(a_game.GetDealerHand(), a_game.GetDealerScore());
    a_view.DisplayPlayerHand(a_game.GetPlayerHand(), a_game.GetPlayerScore());

    if (a_game.IsGameOver()) {
      a_view.DisplayGameOver(a_game.IsDealerWinner());
    }

    int input = a_view.GetInput();

    if (input == 1) {//p
      a_game.NewGame();
    } else if (input == 2) {// h
      a_game.Hit();
    } else if (input == 3) {//s
      a_game.Stand();
    } else if (input == 4) {
      System.exit(0); //q
    }

    return input != 4;
  }


  public void updateObservers() {
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    OVV.DisplayDealerHand(game.GetDealerHand(), game.GetDealerScore());
    OVV.DisplayPlayerHand(game.GetPlayerHand(), game.GetPlayerScore());


  }
}