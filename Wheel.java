public class Wheel {

    /**
        This program simulates a hamster wheel and provides methods for calculating the efficiency, charge and total count for a given char array input by the user.
        @param ARRAY_LENGTH a final integer value to set array length.
        @param cycle a char array to hold a copied array with values determined by user input.
        @param motivation an integer value to represent motivation level.
        @param hydration an integer value to represent hydration level.
        @param feeding an integer value to represent satiety level.
     */

    final int ARRAY_LENGTH = 20;
    char[] cycle = new char[ARRAY_LENGTH];
    int motivation;
    int hydration;
    int feeding;  

    /**  
        The Constructor accepts an array of chars.
    */

    public Wheel(char[] inputArray){
        cycle = inputArray;
        int motivation = 100;  // Initialising motivation level.
        int hydration = 100;  // Initialising hydration level. 
        int feeding = 100;  // Initialising feeding level.
    }

    /**  
        The min method returns the minimum value of three integers.
        If else statements are used to compare the values for each variable.
        @param x represents an integer value to be compared.
        @param y represents an integer value to be compared.
        @param z represents an integer value to be compared.
    */

    public int min(int x, int y, int z){
        if (x < y && x < z)
            return x;
        else if (y < x && y < z)
            return y;
        else
            return z;
    }

    /**  
        The simulateWheel method returns the boolean value true if efficiency is maintained, else false.
        @param efficiencyMaintained a boolean value returned as true if efficiency is maintained, else false.
        @param efficiency an integer value representing efficiency as the minimum value of three integers given in each index of the array cycle.
    */

    public boolean simulateWheel(){
        motivation = 100;
        hydration = 100;
        feeding = 100; 
        boolean efficiencyMaintained = true;

        for (int i = 0; i < cycle.length; i++){
            motivation -= 10;
            hydration -= 15;
            feeding -= 10;

            if (cycle[i] == 'm'){
                motivation += 35;
            }
            else if (cycle[i] == 'h'){
                hydration += 25;
            }
            else if (cycle[i] == 'f'){
                feeding += 35;
            }
            else if ((cycle[i] != 'm') && (cycle[i] != 'h') && (cycle[i] != 'f')){
                System.out.println();
                System.out.println("Unrecognized cycle " + cycle[i] + " in simulation.");
                // TODO: Error handling should be added to improve functionality.
            } 

            int efficiency = min(motivation, hydration, feeding);
            if (efficiency < 50){
                efficiencyMaintained = false;
            }
        } 
        return efficiencyMaintained;
    }

    /**
        The estimateCharge method calculates the charge over the array and returns a double prevision floating point value.
        @param charge a float representing the charge calculated for the given array cycle, being the sum of efficiency for each index in the cycle.
        @param efficiency a float representing efficiency calculated to hold the lowest value of three integers.
    */

    public float estimateCharge(){
        motivation = 100;
        hydration = 100;
        feeding = 100;
        float charge = 0;

        for (int i = 0; i < cycle.length; i++){
            motivation -= 10;
            hydration -= 15;
            feeding -= 10;
            
            if (cycle[i] == 'm'){
                motivation += 35;
            }
            else if (cycle[i] == 'h'){
                hydration += 25;
            }
            else if (cycle[i] == 'f'){
                feeding += 35;
            }

            float efficiency = min(motivation, hydration, feeding);

            if (efficiency < 0){
                charge += 0;
            }
            else if (efficiency > 50){
                charge += 50;
            }
            else {
                charge += efficiency;
            }
        }
        return (charge / 10);
    }

    /**  
        Returns an array of counts for the occurence of three different character values in the cycle array.
        @param totals an array of integer values used represent the total count for each of the three character values.
    */

    public int[] cycleTotal(){
        int[] totals = {0, 0, 0};  // Creating and initialising array to count totals.

        for (int i = 0; i < cycle.length; i++){
            if (cycle[i] == 'm')
                totals[0] += 1;
            else if (cycle[i] == 'h')
                totals[1] += 1;
            else if (cycle[i] == 'f')
                totals[2] += 1;
        }
        return totals;
    }

}
