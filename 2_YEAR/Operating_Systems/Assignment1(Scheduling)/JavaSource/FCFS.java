/*
 * File:	Process.java
 * Course: 	Operating Systems
 * Code: 	1DV512
 * Author: 	Suejb Memeti
 * Date: 	November, 2018
 */

import jdk.swing.interop.SwingInterOpUtils;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;

public class FCFS {

	// The list of processes to be scheduled
	public ArrayList<Process> processes;

	// Class constructor
	public FCFS(ArrayList<Process> processes) {
		this.processes = processes;
	}

	public void run() {
		processes = Sorting(processes);
	for(int i = 0;i<processes.size();i++){
		Process help = processes.get(i);
		help.setCompletedTime(getCT(processes,i+1));
		help.setTurnaroundTime(getTAT(help));
		help.setWaitingTime(getWT(help));

	}



	}

	public void printTable() {
		System.out.println("-----------------------------");
		System.out.println("PID   AT   BT   CT   TAT   WT");

		for (int i = 0; i < processes.size(); i++) {
		System.out.println(" "+processes.get(i).getProcessId()+"    "+ processes.get(i).getArrivalTime()+"    " + processes.get(i).getBurstTime()+"   " + processes.get(i).getCompletedTime()+"     " + processes.get(i).getTurnaroundTime()+"    " + processes.get(i).getWaitingTime());
		}
		System.out.println("-----------------------------");
	}

	public void printGanttChart() {
		System.out.println("\n");
		System.out.println("&&&&&&&&&&& GANTT CHART &&&&&&&&&&&");
		for (int a = 0; a < processes.size() * 10 ; a++) {

			System.out.print("=");
		}
		System.out.println("");
		boolean anyStars = false;

		int HowManyProcesses = processes.size() - 1;
		System.out.print("|");
		for (int i = 0; i < processes.size(); i++) {

			if (i >0) {
				if (processes.get(i-1).getCompletedTime() < processes.get(i).getArrivalTime()) {
						System.out.print("***|");
						//anyStars = true;


				}
			}
			System.out.print("  P" + processes.get(i).processId + "  |");


		}
		System.out.println("");
		for (int a = 0; a < processes.size() * 10; a++) {
			System.out.print("=");
		}

		System.out.println("");

		System.out.print("0");

		for(int i  = 0;i<processes.size();i++) {


			if (i == 0) {
				System.out.print("     " + processes.get(i).getCompletedTime());
				continue;
			} else if (processes.get(i - 1).getCompletedTime() < processes.get(i).getArrivalTime()) {

				anyStars = true;


			}
			if (anyStars == true) {
				System.out.print("   " + processes.get(i).getArrivalTime());
				anyStars = false;
				System.out.print("     " + processes.get(i).getCompletedTime());
			} else {
				System.out.print("     " + processes.get(i).getCompletedTime());
			}
		}
		System.out.println("\n \n* indicates the CPU idle time");
			}




	private int getCT (ArrayList<Process> processesXY , int index){
		int help1 = 0;
		for(int i = 0;i<index;i++){
			Process help = processesXY.get(i);
			if(help1<help.getArrivalTime()){
				help1 = help.getArrivalTime() + help.getBurstTime();
			}
			else{
				help1 += help.getBurstTime();
			}


		}
		return help1;
	}

	private int getTAT(Process ProX) {
		// TAT = CT – AT (Turnaround Time)
		int TAT =ProX.getCompletedTime() - ProX.getArrivalTime();
		return TAT;
	}
	private int getWT(Process ProX) {
		// WT = TAT – BT (Waiting Time)
		int WT =ProX.getTurnaroundTime() - ProX.getBurstTime();
		return WT;
	}

	private ArrayList<Process> Sorting (ArrayList<Process> SortedArrayList){

		for(int i = 0;i<SortedArrayList.size()-1;i++) {
			Process one = SortedArrayList.get(i);
			Process two = SortedArrayList.get(i + 1);

			int help = one.getArrivalTime();
			int help1 = two.getArrivalTime();

			if (help > help1) {
				Collections.swap(SortedArrayList, i, i + 1);
			}

		}

		return SortedArrayList;
	}

















}