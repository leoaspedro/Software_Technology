package View;

import java.util.Scanner;

public class Menu_View {
    public enum Language{
        English,
        Portuguese,
        Invalid
    }

    public enum ViewMethods{
        ViewAddMember,
        ViewDeleteMember,
        ViewUpdateMember,
        ViewAddBoat,
        ViewDeleteBoat,
        ViewUpdateBoat,
        ViewCompactList,
        ViewVerboseList,
        ViewExit,
        ViewInvalid
    }
    public Language Main_Menu(){
        Scanner sc = new Scanner(System.in);
        System.out.println(" ___________________________");
        System.out.println("|          WELCOME          |");
        System.out.println("| Choose language:          |");
        System.out.println("| 1.English                 |");
        System.out.println("| 2.Portuguese              |");
        System.out.println("|___________________________|");
        System.out.println("Input the desired number:");

        int number = sc.nextInt();

        if(number==1){
            return Language.English;
        }else if(number==2){
            return Language.Portuguese;
        }

        return Language.Invalid;

    }










}
