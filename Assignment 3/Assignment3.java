/**
 * Author: Nathan Guenther
 * Assignment: 3
 * Date: 2014/09/29
 *
 * Inputs: Takes four numbers from a file to prepare calculations
 * Processes: Calculates Compound Interest with annual additions, and contiues afterwards until specified year.
 * Outputs: Each years total deposited and earned as well as a final report of the results.

 * Class name: COP 3330 Object Oriented Programming

 * Expected grade: A because all the required functions are implemented and output correctly when tested reading in from input file
 */

 import java.util.*;
 import java.io.*;

 public class Assignment3
 {
    // Main Method
    public static void main(String [ ] args) throws FileNotFoundException
    {
        // Initialize Variables and Scanners
        int i;
        int yearsToDeposit, yearsToCalculate;
        float rate, percent;
        double ammount, current = 0.00, cumulative = 0.00;
        Scanner input = new Scanner(System.in);

        /*
        Guess not needed? It works but we never learned this
        Scanner input = new Scanner(new File("Asgn3Inputs.txt"));
        // User input from file
        yearsToCalculate = input.nextInt();
        yearsToDeposit = input.nextInt();
        rate = input.nextFloat();
        ammount = input.nextFloat();
        */

        // User Input (Removed print statements didn't see them mentioned in PDF)
        //System.out.printf("Please enter the number of years to caluclate compount interest: ");
        yearsToCalculate = input.nextInt();

        //System.out.printf("%nPlease enter the number of years to deposit for: ");
        yearsToDeposit = input.nextInt();

        //System.out.printf("%nPlease enter the Anuual Interest Rate Percentage: ");
        rate = input.nextFloat();
        
        //System.out.printf("%nPlease enter your Annual despoit: ");
        ammount = input.nextFloat();

        // Calculations
        // Loop to determine Compound Interest for deposit years
        for (i = 1; i <= yearsToDeposit; i++)
        {
            cumulative += ammount;
            
            // Interest Caluclation with Annual Additions
            current += calcAnnualInterest(ammount, rate, i);

           // Output
           System.out.printf("%nYear: %2d  ;  Deposited: %,10.0f | Earned: %,15.2f%n", i, cumulative, current);
        }

        // Loop to determine Compound Interest for projected years
        for (i = 1; i <= (yearsToCalculate - yearsToDeposit); i++)
        {

            // Interest Caluclation without Annual Additions
            current = calcAnnualInterest(current, rate, 1);

            // Output
           System.out.printf("%nYear: %2d  ;  Deposited: %,10.0f | Earned: %,15.2f%n", (10 + i), cumulative, current);
        }

        // Final Output
        percent = rate * 100;
        System.out.printf("%n%,.2f dollars were deposited over %d years. (%.0f per year)", cumulative, yearsToDeposit, ammount);
        System.out.printf("%n%nThose deposits earned %.2f percent interest for %d years.", percent, yearsToCalculate);
        
    }

    // Method to return interest for specific year
    public static double calcAnnualInterest(double ammount, float rate, int year)
    {
        // Initialize result
        double total;
        
        // Perform Compound Interest based on input data
        total = (ammount * Math.pow(1.0 + rate, year));
       
        // Return floating result
        return total;
    }
 }
