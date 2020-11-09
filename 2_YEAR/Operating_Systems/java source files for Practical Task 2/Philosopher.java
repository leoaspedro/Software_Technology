/*
 * File:	Philosopher.java
 * Course: 	Operating Systems
 * Code: 	1DV512
 * Author: 	Suejb Memeti (modified by Kostiantyn Kucher)
 * Date: 	November 2019
 */

import java.util.Random;

public class Philosopher implements Runnable {
	
	/*
	 * Controls whether logs should be shown on the console or not.
	 * Logs should print events such as: state of the philosopher, and state of the chopstick
	 * 		for example: philosopher # is eating;
	 * 		philosopher # picked up the left chopstick (chopstick #)
	 */
	public boolean DEBUG = false;
	
	private int id;
	protected volatile boolean stopThreads = false;
	private final Chopstick leftChopstick;
	private final Chopstick rightChopstick;
	
	private Random randomGenerator = new Random();
	
	private int numberOfEatingTurns = 0;
	private int numberOfThinkingTurns = 0;
	private int numberOfHungryTurns = 0;

	private double thinkingTime = 0;
	private double eatingTime = 0;
	private double hungryTime = 0;
	private boolean HungryState = false;

	public Philosopher(int id, Chopstick leftChopstick, Chopstick rightChopstick, int seed, boolean debug) {
		this.id = id;
		this.leftChopstick = leftChopstick;
		this.rightChopstick = rightChopstick;
		
		this.DEBUG = debug;
		
		/*
		 * set the seed for this philosopher. To differentiate the seed from the other philosophers, we add the philosopher id to the seed.
		 * the seed makes sure that the random numbers are the same every time the application is executed
		 * the random number is not the same between multiple calls within the same program execution 
		 
		 * NOTE
		 * In order to get the same average values use the seed 100, and set the id of the philosopher starting from 0 to 4 (0,1,2,3,4). 
		 * Each philosopher sets the seed to the random number generator as seed+id. 
		 * The seed for each philosopher is as follows:
		 * 	 	P0.seed = 100 + P0.id = 100 + 0 = 100
		 * 		P1.seed = 100 + P1.id = 100 + 1 = 101
		 * 		P2.seed = 100 + P2.id = 100 + 2 = 102
		 * 		P3.seed = 100 + P3.id = 100 + 3 = 103
		 * 		P4.seed = 100 + P4.id = 100 + 4 = 104
		 * Therefore, if the ids of the philosophers are not 0,1,2,3,4 then different random numbers will be generated.
		 */
		
		randomGenerator.setSeed(id+seed);
	}
	public int getId() {
		return id;
	}

	public double getAverageThinkingTime() {
		return getTotalThinkingTime() / getNumberOfThinkingTurns();
	}

	public double getAverageEatingTime() {
		return getTotalEatingTime()/getNumberOfEatingTurns();
	}

	public double getAverageHungryTime() {
		return getTotalHungryTime()/getNumberOfHungryTurns();
	}
	
	public int getNumberOfThinkingTurns() {
		return numberOfThinkingTurns;
	}
	
	public int getNumberOfEatingTurns() {
		return numberOfEatingTurns;
	}
	
	public int getNumberOfHungryTurns() {
		return numberOfHungryTurns;
	}

	public double getTotalThinkingTime() {
		return thinkingTime;
	}

	public double getTotalEatingTime() {
		return eatingTime;
	}

	public double getTotalHungryTime() {
		return hungryTime;
	}

	public double Hunger_Start_Time;
	public double Hunger_End_Time;

	@Override
	public void run() {
		while (stopThreads == false) {
			setThinkingState();

			if(DEBUG == true){
				System.out.println("Philosopher "+getId()+" is thinking.");
			}
			numberOfHungryTurns++;
			Hunger_Start_Time = System.currentTimeMillis();

			setPickUpChopsticks();
			Hunger_End_Time = System.currentTimeMillis();




			hungryTime += Hunger_End_Time - Hunger_Start_Time;

			if (stopThreads == true){
				setDropChopsticks();
				break;
			}

			setPickUpChopsticks();


			setEatingState();
			setDropChopsticks();




		}
		}


	public void setEatingState(){
			int RandomGen = randomGenerator.nextInt(1000);
			numberOfEatingTurns++;
			try {
				Thread.sleep(RandomGen);
				eatingTime += RandomGen;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(DEBUG == true){
				System.out.println("Philosopher "+getId()+" is eating");
			}
		}

		public void setThinkingState(){
			int RandomGen1 = randomGenerator.nextInt(1000);
			numberOfThinkingTurns++;
			try {
				Thread.sleep(RandomGen1);
				thinkingTime+= RandomGen1;
				HungryState = true;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(DEBUG == true){
				System.out.println("Philosopher "+getId()+" is thinking.");
			}
		}

		public void setDropChopsticks() {

			leftChopstick.getLock().unlock();
			rightChopstick.getLock().unlock();

			if (DEBUG == true){
				System.out.println("Philosopher "+ getId() +" drops both chopsticks ");

				}
			}


		public void setPickUpChopsticks(){
			while(HungryState) {
				synchronized (this) {
					if (leftChopstick.getLock().tryLock()) {
						if (rightChopstick.getLock().tryLock()) {
							HungryState=false;
						} else {
							leftChopstick.getLock().unlock();
						}
					}
				}
			}


		}

}


