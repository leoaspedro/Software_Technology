import Controller.Controller_Class;
import Model.Data_Base;
import View.Menu_View;
import View.Portuguese_View;
import View.English_View;
import View.View_Interface;

public class Main_Start  {

    public static  View_Interface language;
    public static void main(String[]args) {


        Data_Base dataBase = new Data_Base("Data_Sheet.txt");
        Controller_Class Controller = new Controller_Class(dataBase);

        boolean yes = true;
        Menu_View MV = new Menu_View();
        Menu_View.Language choice = MV.Main_Menu();

        switch(choice){

            case English:
                language = new English_View();
                break;
            case Portuguese:
                language = new Portuguese_View();
                break;

                //If  user put invalid input. the default language option is set to English
            case Invalid:
                language = new English_View();
                break;
        }

        while (Controller.RunningMachine(language)) {

//
        }



    }
}