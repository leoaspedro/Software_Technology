package Model;

import Model.Boat.BoatType;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;


public class Data_Base {


    private ArrayList<Member> member_List;
    private int UserID;
    private String filename;


    public Data_Base(String filename) {
        this.filename = filename;
        if(readMembers(filename).size()==0){
            this.member_List = new ArrayList<>();
            UserID = 1;
        }else{
            this.member_List = readMembers(filename);
            UserID = Integer.valueOf(this.member_List.get(this.member_List.size()-1).getID()+1);
        }
    }

    public void addMember(Member member) {
        member.setID(UserID++);
        this.member_List.add(member);
        writeToTextFile(filename);
    }

    public void deleteMember(Member member) {
        this.member_List.remove(member);
        writeToTextFile(filename);
    }

    public void updateMember(int index, Member member) {
        this.member_List.set(index, member);
        writeToTextFile(filename);
    }

    public void addBoat(Boat Boat, Member member) {
        member.addBoat(Boat);
        writeToTextFile(filename);
    }

    public void deleteBoat(Boat boat, Member member) {
        member.getBoats().remove(boat);
        writeToTextFile(filename);
    }

    public void updateBoat(int index, Member member, Boat boat) {
        int memberIndex = this.member_List.indexOf(member);
        member.getBoats().set(index, boat);

        this.member_List.set(memberIndex, member);
        writeToTextFile(filename);
    }

    public Member specificMember(String personalNumber) {
        for (Member member : member_List) {
            if (member.getPN().equals(personalNumber)) {
                return member;
            }
        }
        return null;
    }

    public ArrayList<Member> getMember_List() {
        return member_List;
    }

    private void writeToTextFile(String filename) {
        try {
            FileWriter writer = new FileWriter(filename);
            for (Member member : member_List) {

                writer.write(member.getFirstName() + ";" + member.getLastName() + ";" + member.getPN() + ";" + member.getID() + ";");
                if (member.getBoats().size() > 0) {

                    for (Boat boat : member.getBoats()) {
                        writer.write(boat.getBoatType() + ";" + boat.getBoatSize().getValue() + ";" +boat.getBoatSize().getValueType() +";");
                    }

                }
                writer.write("\n");
            }


            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    /**
     * Read the comma-separated list of member names from the text file
     */
    private ArrayList<Member> readMembers(String filename) {
        try {
            ArrayList<Member> MemberList = new ArrayList<>();


            BufferedReader reader = Files.newBufferedReader(Paths.get(filename));
            String line;
            int counter = 0;
            while ((line = reader.readLine()) != null) {
                String[] names = line.split(";");

                // Add the member to the list
                if (names.length > 2) {

                    MemberList.add(new Member(names[0], names[1], names[2]));
                    ArrayList<Boat> boats = new ArrayList<>();
                    for (int i = 0; i < (names.length - 3) / 3; i++) {
                        boats.add(new Boat(BoatType.valueOf(names[4 + (i * 3)]), new BoatLength(Double.valueOf(names[5 + (i * 3)]),BoatLength.ValueType.valueOf(names[6 + (i*3)]))));
                    }
                    MemberList.get(counter).setBoats(boats);
                    MemberList.get(counter).setID(Integer.valueOf(names[3]));

                    counter++;
                }

            }
            member_List = MemberList;
            return MemberList;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

