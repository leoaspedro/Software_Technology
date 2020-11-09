package View;

import Model.Boat;
import Model.BoatLength;
import Model.Member;

import java.util.ArrayList;
import java.util.Scanner;

public class Portuguese_View implements View_Interface {


    public Portuguese_View() {

    }

    public Menu_View.ViewMethods ViewMenu() {

        Scanner sc = new Scanner(System.in);

        System.out.println(" ______________________________________________ ");
        System.out.println("|       Selecione uma das opções abaixo:       |");
        System.out.println("|                                              |");
        System.out.println("| A.Lista Detalhada                            |");
        System.out.println("| B.Lista Compacta                             |");
        System.out.println("| C.Adicionar Membro                           |");
        System.out.println("| D.Atualizar Membro                           |");
        System.out.println("| E.Eliminar Membro                            |");
        System.out.println("| F.Adicionar Barco                            |");
        System.out.println("| G.Atualizar Barco                            |");
        System.out.println("| H.Eliminar Barco                             |");
        System.out.println("|                                              |");
        System.out.println("| I.Sair                                       |");
        System.out.println("|______________________________________________|");
        System.out.println("Introduza uma Letra (A-I) : ");
        String userInput = sc.nextLine();

        if (userInput.equals("C")) {
            return Menu_View.ViewMethods.ViewAddMember;
        }
        if (userInput.equals("D")) {
            return Menu_View.ViewMethods.ViewUpdateMember;
        }
        if (userInput.equals("E")) {
            return Menu_View.ViewMethods.ViewDeleteMember;
        }
        if (userInput.equals("F")) {
            return Menu_View.ViewMethods.ViewAddBoat;
        }
        if (userInput.equals("G")) {
            return Menu_View.ViewMethods.ViewUpdateBoat;
        }
        if (userInput.equals("H")) {
            return Menu_View.ViewMethods.ViewDeleteBoat;
        }
        if (userInput.equals("A")) {
            return Menu_View.ViewMethods.ViewVerboseList;
        }
        if (userInput.equals("B")) {
            return Menu_View.ViewMethods.ViewCompactList;
        }
        if (userInput.equals("I")) {
            return Menu_View.ViewMethods.ViewExit;
        }
        if (userInput.equals("R")) {
            System.out.flush();//clear console
            return ViewMenu();
        }
        else {
            return Menu_View.ViewMethods.ViewInvalid;

        }

    }

    @Override
    public Member ViewAddMember() {

        String fName;
        String lName;
        String Pn;
        Scanner sc = new Scanner(System.in);
        System.out.println(" __________________________________");
        System.out.println("|          Adicionar Membro        |");
        System.out.println("| Numero Pessoal:                  |");
        Pn = sc.nextLine();
        System.out.println("|                                  |");
        System.out.println("| Primeiro Nome:                   |");
        fName = sc.nextLine();
        System.out.println("| Apelido:                         |");
        lName = sc.nextLine();
        System.out.println("|                                  |");
        System.out.println("| R. Voltar ao Menu                |");
        System.out.println("|__________________________________|");

        return new Member(fName, lName, Pn);

    }

    @Override
    public String ViewDeleteMember() {
        String Pn;
        Scanner sc = new Scanner(System.in);
        System.out.println(" __________________________________");
        System.out.println("|           Eliminar Membro        |");
        System.out.println("|                                  |");
        System.out.println("| Numero Pessoal:                  |");
        Pn = sc.nextLine();
        System.out.println("|                                  |");
        System.out.println("| R. Voltar ao Menu                |");
        System.out.println("|__________________________________|");


        return Pn;
    }

    @Override
    public String ViewUpdateMember() {

        String Pn;
        Scanner sc = new Scanner(System.in);

        System.out.println(" __________________________________");
        System.out.println("|         Atualizar Membro         |");
        System.out.println("|                                  |");
        System.out.println("| Numero Pessoal:                  |");
        System.out.println("|                                  |");
        System.out.println("| R. Voltar ao Menu                |");
        System.out.println("|__________________________________|");
        Pn = sc.nextLine();


        return Pn;

    }

    @Override
    public Member ViewUPDATINGMember(Member member) {
        String fName;
        String lName;
        Scanner sc = new Scanner(System.in);

        System.out.println("| Primeiro Nome:                   |");
        fName = sc.nextLine();
        System.out.println("| Apelido:                         |");
        lName = sc.nextLine();
        System.out.println("|                                  |");
        System.out.println("| R. Voltar ao Menu                |");
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
        System.out.println("|                   Adicionar Membro                    |");
        System.out.println("|                                                       |");
        System.out.println("| Numero pessoal:                                       |");
        System.out.println("|                                                       |");
        System.out.println("| R. Voltar ao Menu                                     |");
        System.out.println("|_______________________________________________________|");
        personalNumber = sc.nextLine();


        return personalNumber;

    }

    @Override
    public Boat ViewAddBoat() {
        Scanner sc = new Scanner(System.in);
        int type;
        int Size;
        int UnitType;

        System.out.println("| Type:  Barco a Vela [0],Barco a Motor[1], Kayak[2], Outros[3] |");
        System.out.println("|Digite um numero (0-3):                                        |");
        type = sc.nextInt();
        sc.nextLine();
        System.out.println("| Unidade de Medição? Metro [0], Pé [1]                          |");
        System.out.println("| Digite um numero(0 or 1):                                |");
        UnitType = sc.nextInt();
        System.out.println("| Tamanho:                                                      |");
        Size = sc.nextInt();
        System.out.println("|                                                               |");
        System.out.println("| R. Voltar ao Menu                                             |");
        System.out.println("|_______________________________________________________________|");

        return new Boat(Boat.BoatType.values()[type], new BoatLength(Size, BoatLength.ValueType.values()[UnitType]));


    }

    @Override
    public String ViewDeleteBoatFirstStep() {

        Scanner sc = new Scanner(System.in);
        String Pn;

        System.out.println(" __________________________________");
        System.out.println("|           Eliminar Barco         |");
        System.out.println("|                                  |");
        System.out.println("| Numero Pessoal:                  |");
        Pn = sc.nextLine();
        System.out.println("|                                  |");
        System.out.println("| R. Voltar ao Menu                |");
        System.out.println("|__________________________________|");


        return Pn;

    }

    @Override
    public Boat ViewDeleteBoat(ArrayList<Boat> Boats) {
        Scanner sc = new Scanner(System.in);
        int index;

        System.out.println(" ________________________________________");
        System.out.println("|   Escolha Barco para eliminar (index)? |");
        for (int i = 0; i < Boats.size(); i++) {
            System.out.println("| Index: " + i + "| Tipo de Barco : " + Boats.get(i).getBoatType() + "| Tamanho do Barco: " + Boats.get(i).getBoatSize().getValue() + " " + Boats.get(i).getBoatSize().getValueType() + "|");
        }
        System.out.println("|                                        |");
        System.out.println("|  index:                                |");
        index = sc.nextInt();
        System.out.println("|                                        |");
        System.out.println("| R. Voltar ao Menu                      |");
        System.out.println("|________________________________________|");


        return Boats.get(index);
    }


    @Override
    public String ViewUpdateBoat() {
        String Pn;
        Scanner sc = new Scanner(System.in);
        System.out.println(" __________________________________");
        System.out.println("|          Atualizar Barco         |");
        System.out.println("|                                  |");
        System.out.println("| Numero Pessoal:                  |");
        System.out.println("|                                  |");
        System.out.println("| R. Voltar ao Menu                |");
        System.out.println("|__________________________________|");
        Pn = sc.nextLine();

        return Pn;

    }

    @Override
    public Boat ViewUpdatingBoatSecondSTep(ArrayList<Boat> Boats) {
        Scanner sc = new Scanner(System.in);
        int index;

        System.out.println(" _________________________________________");
        System.out.println("|   Escolha Barco para Atualizar (index)? |");
        for (int i = 0; i < Boats.size(); i++) {
            System.out.println("| Index: " + i + "| Tipo de Barco: " + Boats.get(i).getBoatType() + "| Tamanho do Barco: " + Boats.get(i).getBoatSize().getValue() + " " + Boats.get(i).getBoatSize().getValueType() + "|");
        }
        System.out.println("|                                         |");
        System.out.println("|  index:                                 |");
        System.out.println("|                                         |");
        System.out.println("| R. Voltar ao Menu                       |");
        System.out.println("|_________________________________________|");
        index = sc.nextInt();


        return Boats.get(index);
    }

    @Override
    public Boat ViewUpdateBoatTHIRDStep(Boat boat) {
        int type;
        int UnitType;
        int Size;
        Scanner sc = new Scanner(System.in);

        System.out.println("|                                                       |");
        System.out.println("| Tipo: SailBoat [0],MotorBoat [1], Kayak[2], Other[3]  |");
        System.out.println(("|Digite um numero (0-3):                               |"));
        type = sc.nextInt();
        System.out.println("| Unidade de Medição? Metro [0], Pé [1]                          |");
        System.out.println("| Digite um numero(0 or 1):                                |");
        UnitType = sc.nextInt();
        System.out.println("| Tamanho:                                              |");
        Size = sc.nextInt();
        System.out.println("| R. Voltar ao Menu                                     |");
        System.out.println("|_______________________________________________________|");
        boat.setBoatType(Boat.BoatType.values()[type]);
        boat.setBoatSize(new BoatLength(Size, BoatLength.ValueType.values()[UnitType]));


        return boat;

    }

    @Override
    public void ViewCompactList(ArrayList<Member> All) {
        System.out.println("=============== Lista Compacta  ===============");
        for (int i = 0; i < All.size(); i++) {
            System.out.println("| ID: " + All.get(i).getID() + " | Primeiro Nome: " + All.get(i).getFirstName() + " | Apelido: " + All.get(i).getLastName() + " | " + "Nº Barcos: " + All.get(i).getBoats().size() + " | ");
        }
        System.out.println("===============================================");
    }


    @Override
    public void ViewVerboseList(ArrayList<Member> All) {
        System.out.println("========================= Lista Detalhada =========================");
        for (int i = 0; i < All.size(); i++) {
            System.out.println("Numero Pessoal: " + All.get(i).getPN() + " | " + "Primerio Nome: " + All.get(i).getFirstName() + " | " + "Apelido: " + All.get(i).getLastName() + " | " + "ID: " + All.get(i).getID());
            ArrayList<Boat> boats = All.get(i).getBoats();
            if (boats.size() != 0) {
                for (int j = 0; j < boats.size(); j++) {
                    System.out.println("Tipo de Barco: " + boats.get(j).getBoatType() + " | " + "Tamanho do Barco: " +  + boats.get(j).getBoatSize().getValue() + " " + boats.get(j).getBoatSize().getValueType() + " | ");

                }

            }
            System.out.println();
        }
        System.out.println("===================================================================");

    }

    @Override
    public void ViewExit() {
        System.out.println(" ___________________________________________");
        System.out.println("|                                           |");
        System.out.println("| Encerrar em 3..2...1                      |");
        System.out.println("|___________________________________________|");
    }

    @Override
    public void ViewSucceful() {
        System.out.println(" ___________________________________________");
        System.out.println("|                                           |");
        System.out.println("| Operação completada com sucesso!          |");
        System.out.println("|___________________________________________|");
    }

    @Override
    public void ViewUnsucceful() {
        System.out.println(" ______________________________________________________________________________");
        System.out.println("|                                                                              |");
        System.out.println("| Algo de errado occoreu durante este passo. Por favor tente outra vez!        |");
        System.out.println("|______________________________________________________________________________|");
    }

    @Override
    public void ViewInvalid() {
        System.out.println(" ___________________________________________________");
        System.out.println("|                                                   |");
        System.out.println("| Informacão Inválida, por favor tente outra vez.   |");
        System.out.println("|___________________________________________________|");

    }
}






