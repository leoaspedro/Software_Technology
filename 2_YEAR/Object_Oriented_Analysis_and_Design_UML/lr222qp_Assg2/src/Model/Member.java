package Model;

import java.util.ArrayList;

public class Member {

    private  String firstName;
    private  String lastName;
    private  String PN;
    private  int ID;
    private ArrayList<Boat> Boats;



   public Member(String fName, String lName, String PN) {
       this.firstName = fName;
       this.lastName = lName;
       this.PN = PN;
       this.Boats = new ArrayList<>();


    }

    public String getFirstName() {
       return firstName;
    }
    public void setFirstName(String fName) {
       this.firstName = fName;
    }
    public String getLastName() {
       return lastName;
    }
    public void setLastName(String lName) {
       this.lastName = lName;
    }
    public String getPN() {
       return PN;
    }
    public void setPN(String PersonalN) {
       this.PN = PersonalN;
    }
    public int getID() {
       return ID;
    }
    public void setID(int UserID) {
       this.ID = UserID;
    }

    public void addBoat(Boat boat){this.Boats.add(boat);}

    public void removeBoat(Boat boat){this.Boats.remove(boat);}

    public ArrayList<Boat> getBoats(){return this.Boats;}
    public void setBoats(ArrayList<Boat> boats){this.Boats = boats;}


}



