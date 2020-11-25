/**
Demo class for Hamster class.
Designed for Assignment 2 - COSC120
By: Dr Edmumd Sadgrove
Required files: Hamster.java
Options: run with v to find optimal solution. 
		 e.g. java HamsterDemo.java v
*/

import java.util.Random;
import java.util.Scanner;

public class HamsterDemo {
	public static final int TOTAL = 20;
	public static final int MAX_ATTEMPTS = 1000;
    
	/** 
	   This method uses a form of bruteforce genetic algorithm 
	   to find a maximum efficiency solution.
	*/
	public static void findOptimal(){
		Random rn = new Random();
		char[] optimal = new char[TOTAL];
		int count = 0;
		while(true){
			for(int i=0; i<TOTAL; i++){
				int pick = rn.nextInt(3)+1;
				switch(pick){
					case 1:
						optimal[i] = 'h';
						break;
					case 2:
						optimal[i] = 'm';
						break;
					case 3:
						optimal[i] = 'f';
						break;
				}
			}
			Hamster test = new Hamster(optimal);
			count++;
			if(test.simulateWheel() || count > MAX_ATTEMPTS) break;
		}
		if (count < MAX_ATTEMPTS){
			System.out.print("Found optimal cycle: ");
			for(int i=0; i<TOTAL; i++) System.out.print(optimal[i] + " ");
			System.out.println();
		} else System.out.print("Did not find optimal cycle: ");
	}
	/**
		main method: call and report.
	*/
	public static void main(String[] args){
		
		
		System.out.println("The Hamster Efficiency Tool.");
		System.out.println("Options include: feed (f), hydrate (h) and motivate (m)");
		if(args.length > 0){
			if(args[0].charAt(0) == 'v') findOptimal(); 
		}
		
		System.out.println("\nPlease enter enter an option for each stage of the cycle.");
		
		Scanner input = new Scanner(System.in);
		char[] cycle = new char[TOTAL];
		for(int i=0; i<TOTAL; i++){
			System.out.print("Cycle " + (i+1) + ": ");
			cycle[i] = input.next().charAt(0);
		}
		Hamster myHamster = new Hamster(cycle);
		boolean test = myHamster.simulateWheel();
		if (test)
			System.out.println("\nThe hamster did not drop below maximum efficiency.");
		else
			System.out.println("\nThe hamster dropped below maximum efficiency.");
		System.out.printf("Estimated battery charge: %.2f%%\n",myHamster.estimateCharge());
		int[] totals = myHamster.cycleTotal();
		System.out.println("This included: " 
		                   + totals[0] + " motivation cycles, " 
						   + totals[1] + " hydration cycles and "   
						   + totals[2] + " feeding cycles.");
						 
	}
}
