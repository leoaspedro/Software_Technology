package BlackJack.model.rules;

public class RulesFactory {

  public IHitStrategy GetHitRule() {

    return new BasicHitStrategy();
  }

  public INewGameStrategy GetNewGameRule() {

    return new AmericanNewGameStrategy();
  }

  public IHitStrategy GetSoft17(){

    return new Soft17();
  }

  public playerWorL getPlayerWin(){

    return new playerWorL();
  }

  public dealerWorL getDealerWin(){

    return new dealerWorL();
  }
}