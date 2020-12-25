/**
This class is a demonstration class created in order to use the Wheel class.
*/

import java.util.Random;
import java.util.Scanner;

public class WheelDemo {
	public static final int TOTAL = 20;
	public static final int MAX_ATTEMPTS = 1000;
    
	/** 
	   This method uses a form of bruteforce genetic algorithm to find a maximum efficiency solution.
	   WheelDemo algorithms by: Dr Edmund Sadgrove, University of New England, Armidale, esadgro2@une.edu.au.
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
			Wheel test = new Wheel(optimal);
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
		Main method prompts used input for the char array and calculates efficiency.
	*/
	public static void main(String[] args){
		
		
		System.out.println("The Wheel Efficiency Tool.");
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
		Wheel myWheel = new Wheel(cycle);
		boolean test = myWheel.simulateWheel();
		if (test)
			System.out.println("\nThe wheel did not drop below maximum efficiency.");
		else
			System.out.println("\nThe wheel dropped below maximum efficiency.");
		System.out.printf("Estimated battery charge: %.2f%%\n",myWheel.estimateCharge());
		int[] totals = myWheel.cycleTotal();
		System.out.println("This included: " 
		                   + totals[0] + " motivation cycles, " 
						   + totals[1] + " hydration cycles and "   
						   + totals[2] + " feeding cycles.");
						 
	}
}
