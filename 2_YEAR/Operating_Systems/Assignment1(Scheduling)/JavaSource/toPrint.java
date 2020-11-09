import java.util.ArrayList;

public class toPrint {

    public static void main (String[] args ){
        ArrayList<Process> listOfProcesses = new ArrayList<Process>();

//        listOfProcesses.add(new Process(1, 0, 4));
//        listOfProcesses.add(new Process(2, 2, 3));
//        listOfProcesses.add(new Process(3, 1, 1));
//        listOfProcesses.add(new Process(4, 3, 2));
//        listOfProcesses.add(new Process(5, 4, 5));

        listOfProcesses.add(new Process(1, 0, 18));
        listOfProcesses.add(new Process(2, 3, 2));
        listOfProcesses.add(new Process(3, 25, 5));
        listOfProcesses.add(new Process(4, 29, 2));
        listOfProcesses.add(new Process(5, 33, 7));

        FCFS Print = new FCFS (listOfProcesses);
        Print.run();
        Print.printTable();
        Print.printGanttChart();

    }






}
