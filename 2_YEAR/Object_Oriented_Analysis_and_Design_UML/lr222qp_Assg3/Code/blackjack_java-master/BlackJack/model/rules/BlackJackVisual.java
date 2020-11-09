package BlackJack.model.rules;

import java.util.ArrayList;

public abstract class BlackJackVisual {


    private ArrayList<BJ_Interface> observers = new ArrayList<BJ_Interface>();

    public void add(BJ_Interface gameObserver){

        observers.add(gameObserver);
    }

    public void remove(BJ_Interface gameObserver){

        observers.remove(gameObserver);
    }

    public void notifications(){
        for(int i=0;i<observers.size();i++){
            observers.get(i).updateObservers();
        }
    }
}

