package Controller;

import Model.Boat;
import Model.BoatLength;
import Model.Data_Base;
import Model.Member;
import View.Menu_View;
import View.View_Interface;

import java.util.ArrayList;
import java.util.Scanner;


public class Controller_Class {



    //private Print_View view;
    private Data_Base data_base;

    public Controller_Class(Data_Base data_base) {
        //this.view=view;
        this.data_base = data_base;
    }

    public boolean RunningMachine(View_Interface language){
        Menu_View.ViewMethods choice =language.ViewMenu();

        switch (choice){
            case ViewAddMember:
                addMember(language);
                return true;
            case ViewDeleteMember:
                removeMember(language);
                return true;
            case ViewUpdateMember:
                updateMember(language);
                return true;
            case ViewAddBoat:
                addBoat(language);
                return true;
            case ViewDeleteBoat:
                removeBoat(language);
                return true;
            case ViewUpdateBoat:
                updateBoat(language);
                return true;
            case ViewCompactList:
                language.ViewCompactList(data_base.getMember_List());
                return true;
            case ViewVerboseList:
                language.ViewVerboseList(data_base.getMember_List());
                return true;
            case ViewExit:
                language.ViewExit();
                return false;
            case ViewInvalid:
                language.ViewInvalid();
            return true;
        }
        return false;
        }


    public void addMember(View_Interface language) {
        Member member = language.ViewAddMember();

        if (specificMember(member.getPN()) == null){
            language.ViewSucceful();
            data_base.addMember(member);
        }else{
            language.ViewUnsucceful();
        }

    }

    public void removeMember(View_Interface language) {
        Member member = data_base.specificMember(language.ViewDeleteMember());
        if (member == null){
            language.ViewUnsucceful();
        }else{
            language.ViewSucceful();
            data_base.deleteMember(member);
        }
    }

    public void updateMember(View_Interface language) {

        Member member = data_base.specificMember(language.ViewUpdateMember());

        if(member==null){
            language.ViewUnsucceful();
        }else{

            int index = data_base.getMember_List().indexOf(data_base.specificMember(member.getPN()));


            data_base.updateMember(index, language.ViewUPDATINGMember(member));
            language.ViewSucceful();
        }


    }

    public void addBoat(View_Interface language) {

      Member member = data_base.specificMember(language.ViewAddBoatFirstSTep());

        if(member==null){
            language.ViewUnsucceful();
        }else{

           // int index = data_base.getMember_List().indexOf(data_base.specificMember(member.getPN()));

            Boat Boat = language.ViewAddBoat();

            data_base.addBoat(Boat, member);

            //data_base.addBoat(index, language.ViewAddBoat(member));

            language.ViewSucceful();
        }

    }

    public void removeBoat(View_Interface language) {
        Member member = data_base.specificMember(language.ViewDeleteBoatFirstStep());
        if (member == null || member.getBoats() == null){
            language.ViewUnsucceful();
        }else{
            data_base.deleteBoat(language.ViewDeleteBoat(member.getBoats()), member);

            language.ViewSucceful();
        }


    }

    public void updateBoat(View_Interface language) {
        Member member = data_base.specificMember(language.ViewUpdateBoat());

        if(member==null || member.getBoats() == null){
            language.ViewUnsucceful();
        }else{
            Boat notUpdatedBoat = language.ViewUpdatingBoatSecondSTep(member.getBoats());
            int index = member.getBoats().indexOf(notUpdatedBoat);

            Boat updatedBoat = language.ViewUpdateBoatTHIRDStep(notUpdatedBoat);
             data_base.updateBoat(index,member, updatedBoat);

        }




    }

    public Member specificMember(String personalNumber) {
        return data_base.specificMember(personalNumber);
    }


    public ArrayList<Member> PrintCompactList() {
        return data_base.getMember_List();
    }

}