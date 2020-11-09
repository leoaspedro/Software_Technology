package View;

import Model.Boat;
import Model.Member;

import java.util.ArrayList;

public interface View_Interface {
    Menu_View.ViewMethods ViewMenu();
    Member ViewAddMember();
    String ViewDeleteMember();
    String ViewUpdateMember();

    String ViewAddBoatFirstSTep();

    Boat ViewAddBoat();

    String ViewDeleteBoatFirstStep();

    Boat ViewDeleteBoat(ArrayList<Boat>Boats);
    String ViewUpdateBoat();

    Boat ViewUpdatingBoatSecondSTep(ArrayList<Boat> Boats);

    Boat ViewUpdateBoatTHIRDStep(Boat boat);
    Member ViewUPDATINGMember(Member member);

    void ViewCompactList(ArrayList<Member> All);
    void ViewVerboseList(ArrayList<Member> All);
    void ViewExit();
    void ViewSucceful();
    void ViewUnsucceful();
    void ViewInvalid();
}
