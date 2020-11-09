package View;

import Model.Boat;
import Model.BoatLength;
import Model.Member;

import java.util.ArrayList;
import java.util.Scanner;

public class English_View implements View_Interface{
    public English_View(){

    }

    public Menu_View.ViewMethods ViewMenu(){

        Scanner sc = new Scanner(System.in);

        System.out.println(" _________________________________");
        System.out.println("|       Choose from bellow:       |");
        System.out.println("|                                 |");
        System.out.println("| 1.Add new Member                |");
        System.out.println("| 2.Update Member                 |");
        System.out.println("| 3.Delete Member                 |");
        System.out.println("| 4.Add new Boat                  |");
        System.out.println("| 5.Update Boat                   |");
        System.out.println("| 6.Delete Boat                   |");
        System.out.println("| 7.Verbose List                  |");
        System.out.println("| 8.Compact List                  |");
        System.out.println("|                                 |");
        System.out.println("| 9.Exit                          |");
        System.out.println("|_________________________________|");
        System.out.println("Input the desired number: ");
        try {
            int userInput = sc.nextInt();

        if(userInput == 1){
            return Menu_View.ViewMethods.ViewAddMember;
        }
        if(userInput == 2){
            return Menu_View.ViewMethods.ViewUpdateMember;
        }
        if(userInput == 3){
            return Menu_View.ViewMethods.ViewDeleteMember;
        }
        if(userInput == 4 ){
            return Menu_View.ViewMethods.ViewAddBoat;
        }
        if(userInput == 5){
            return Menu_View.ViewMethods.ViewUpdateBoat;
        }
        if(userInput == 6){
            return Menu_View.ViewMethods.ViewDeleteBoat;
        }
        if(userInput == 7){
            return Menu_View.ViewMethods.ViewVerboseList;
        }
        if(userInput == 8){
            return Menu_View.ViewMethods.ViewCompactList;
        }
        if(userInput == 9){
            return Menu_View.ViewMethods.ViewExit;
        }
        if (userInput == 20) {
            System.out.flush();//clear console
            return ViewMenu();
            }
        else {
            return Menu_View.ViewMethods.ViewInvalid;

        }
        }catch (Exception e ){
            return Menu_View.ViewMethods.ViewInvalid;
        }

    }

    @Override
    public Member ViewAddMember() {

        String fName;
        String lName;
        String Pn;
        Scanner sc = new Scanner(System.in);
        System.out.println(" ________________________________________");
        System.out.println("|            Add a new Member            |");
        System.out.println("|                                        |");
        System.out.println("| First Name:                            |");
        fName = sc.nextLine();
        System.out.println("| Last Name:                             |");
        lName = sc.nextLine();
        System.out.println("| Personal Number:                       |");
        Pn = sc.nextLine();
        System.out.println("|                                        |");
        System.out.println("| 20. Back to Menu                       |");
        System.out.println("|________________________________________|");


        return new Member(fName,lName,Pn);

     }

    @Override
    public String ViewDeleteMember() {
        String Pn;
        Scanner sc = new Scanner(System.in);
        System.out.println(" __________________________________");
        System.out.println("|         Delete Member            |");
        System.out.println("| Personal Number:                 |");
        Pn = sc.nextLine();
        System.out.println("|                                  |");
        System.out.println("| 20. Back to Menu                  |");
        System.out.println("|__________________________________|");



        return Pn;
    }

    @Override
    public String ViewUpdateMember() {

        String Pn;

        Scanner sc = new Scanner(System.in);
        System.out.println(" __________________________________");
        System.out.println("|         Update a Member          |");
        System.out.println("|                                  |");
        System.out.println("| Personal Number:                 |");
        System.out.println("|                                  |");
        System.out.println("| 20. Back to Menu                 |");
        System.out.println("|__________________________________|");
        Pn = sc.nextLine();


        return Pn;

    }
    @Override
    public Member ViewUPDATINGMember(Member member) {
        String fName;
        String lName;
        Scanner sc = new Scanner(System.in);

        System.out.println("| First Name:                      |");
        fName = sc.nextLine();
        System.out.println("| Last Name:                       |");
        lName = sc.nextLine();

        System.out.println("| 20. Back to Menu                  |");
        System.out.println("|__________________________________|");


        member.setFirstName(fName);
        member.setLastName(lName);
        return member;
    }
    @Override
    public String ViewAddBoatFirstSTep() {
        Scanner sc = new Scanner(System.in);
        String personalNumber;

        System.out.println(" _______________________________________________________");
        System.out.println("|                      Add a Boat                       |");
        System.out.println("|                                                       |");
        System.out.println("| Personal Number:                                      |");
        System.out.println("|                                                       |");
        System.out.println("| 20. Back to Menu                                      |");
        personalNumber = sc.nextLine();



        return personalNumber;

    }

    @Override
    public Boat ViewAddBoat() {
        Scanner sc = new Scanner(System.in);
                 int type;
                 int Size;
                 int UnitType;

                 System.out.println("| Type:  SailBoat [0],MotorBoat [1], Kayak[2], Other[3] |");
                 System.out.println("|Please enter a number (0-3):                           |");
                 type = sc.nextInt();
                 sc.nextLine();
                 System.out.println("| Measurement Unit? Meter [0],Feet [1]                  |");
                 System.out.println("|Please enter a number (0 or 1):                        |");
                 UnitType = sc.nextInt();
                 System.out.println("| Size:                                                 |");
                 Size = sc.nextInt();
                 System.out.println("|                                                       |");
                 System.out.println("| 20. Back to Menu                                       |");
                 System.out.println("|_______________________________________________________|");

                return new Boat(Boat.BoatType.values()[type], new BoatLength(Size, BoatLength.ValueType.values()[UnitType])) ;


    }

    @Override
    public String ViewDeleteBoatFirstStep() {

            Scanner sc = new Scanner(System.in);
            String Pn;


            System.out.println(" __________________________________");
            System.out.println("|            Delete Boat           |");
            System.out.println("|                                  |");
            System.out.println("| Personal Number:                 |");
            System.out.println("|                                  |");
            System.out.println("| 20. Back to Menu                 |");
            System.out.println("|__________________________________|");
            Pn = sc.nextLine();


            return Pn;

        }

    @Override
    public Boat ViewDeleteBoat(ArrayList<Boat> Boats) {
        Scanner sc = new Scanner(System.in);
        int index;
        System.out.println(" _____________________________________________");
        System.out.println("|         Choose Boat To Delete (index)?      |");
        for(int i = 0;i<Boats.size();i++){
            System.out.println("| Index: "+i+"| Boat Type: " +Boats.get(i).getBoatType() +"| Boat Size: "+ Boats.get(i).getBoatSize().getValue() +" "+ Boats.get(i).getBoatSize().getValueType()+"|");
        }
        System.out.println("|                                             |");
        System.out.println("|                                             |");
        System.out.println("|  index:                                     |");
        System.out.println("|                                             |");
        System.out.println("| 20. Back to Menu                             |");
        System.out.println("|_____________________________________________|");
        index = sc.nextInt();


        return Boats.get(index);
    }


    @Override
    public String ViewUpdateBoat() {
        String Pn;
        Scanner sc  = new Scanner(System.in);
                 System.out.println(" __________________________________");
                 System.out.println("|            Update Boat           |");
                 System.out.println("|                                  |");
                 System.out.println("| Personal Number:                 |");
                System.out.println(" |                                  |");
                 System.out.println("| 20. Back to Menu                  |");
                 System.out.println("|__________________________________|");
                 Pn = sc.nextLine();

                 return Pn;

    }

    @Override
    public Boat ViewUpdatingBoatSecondSTep(ArrayList<Boat> Boats) {
        Scanner sc = new Scanner(System.in);
        int index;
        System.out.println(" ___________________________________________________________________");
        System.out.println("|                   Choose Boat To Update (index)?                  |");
        for(int i = 0;i<Boats.size();i++){
            System.out.println("| Index: "+i+"| Boat Type: " +Boats.get(i).getBoatType() +"| Boat Size: "+ Boats.get(i).getBoatSize().getValue() +" "+ Boats.get(i).getBoatSize().getValueType()+"|");
        }
        System.out.println("|                                                                   |");
        System.out.println("|                                                                   |");
        System.out.println("|  index:                                                           |");
        System.out.println("|                                                                   |");
        System.out.println("| 20. Back to Menu                                                   |");
        System.out.println("|___________________________________________________________________|");
        index = sc.nextInt();


        return Boats.get(index);
    }

    @Override
    public Boat ViewUpdateBoatTHIRDStep(Boat boat) {
        int type;
        int UnitType;
        int Size;
        Scanner sc =new Scanner(System.in);

        System.out.println(" _______________________________________________________");
        System.out.println("| Type: SailBoat [0],MotorBoat [1], Kayak[2], Other[3]  |");
        System.out.println(("|Please enter a number (0-3):                          |"));
        type = sc.nextInt();
        System.out.println("| Measurement Unit? Meter [0],Feet [1]                  |");
        System.out.println("|Please enter a number (0 or 1):                        |");
        UnitType = sc.nextInt();
        System.out.println("| Size:                                                 |");
        Size = sc.nextInt();
        System.out.println("| 20. Back to Menu                                       |");
        System.out.println("|_______________________________________________________|");

        boat.setBoatType(Boat.BoatType.values()[type]);
        boat.setBoatSize(new BoatLength(Size, BoatLength.ValueType.values()[UnitType]));


        return boat;

    }

    @Override
    public void ViewCompactList(ArrayList<Member> All) {
        System.out.println("===================== COMPACT LIST =======================");

                for(int i=0;i<All.size();i++) {
                    System.out.println(" | " + All.get(i).getFirstName() + " | " + All.get(i).getLastName() + " | " + "Nº Boats: " + All.get(i).getBoats().size() + " | ID: " + All.get(i).getID());

                }
        System.out.println("==========================================================");
            }


    @Override
    public void ViewVerboseList(ArrayList<Member> All) {
        System.out.println("=============================== VERBOSE LIST ==================================");

        for (int i = 0; i < All.size(); i++) {
            System.out.print(" | " + "First Name: " + All.get(i).getFirstName() + " | " + "Last Name: " + All.get(i).getLastName() + " | " + "Personal Number: " + All.get(i).getPN() + " | " + "Id: " + All.get(i).getID());
            ArrayList<Boat> boats = All.get(i).getBoats();
            if (boats.size() != 0) {
                for (int j = 0; j < boats.size(); j++) {
                    System.out.print(" | " + "Boat Type: " + boats.get(j).getBoatType() + " | " + "Boat Size: " + boats.get(j).getBoatSize().getValue() + " " + boats.get(j).getBoatSize().getValueType() + " | ");
                }

            }
            System.out.println();

        }System.out.println("============================================================================");
    }

    @Override
    public void ViewExit() {
        System.out.println(" ___________________________________________");
        System.out.println("|                                           |");
        System.out.println("| Shutting down in 3...2...1                |");
        System.out.println("|___________________________________________|");
    }

    @Override
    public void ViewSucceful() {
        System.out.println(" ___________________________________________");
        System.out.println("|                                           |");
        System.out.println("| Operation completed successfully !        |");
        System.out.println("|___________________________________________|");
    }

    @Override
    public void ViewUnsucceful() {
        System.out.println(" ______________________________________________________________________________");
        System.out.println("|                                                                              |");
        System.out.println("| Something went wrong! Please try again and check if all the input is correct.|");
        System.out.println("|______________________________________________________________________________|");
    }

    @Override
    public void ViewInvalid() {
        System.out.println(" ___________________________________");
        System.out.println("|                                   |");
        System.out.println("| Invalid input, please try again   |");
        System.out.println("|___________________________________|");
    }


}


















