/**
 * Author: Nathan Guenther
 * Assignment: 5
 * Date: 2014/11/03
 *
 * Inputs: Static ENUM values
 * Processes: Calculations with BigDecimals for compound interest --> stores in 2D array
 * Outputs: Formated table based off 2D Array

 * Class name: COP 3330 Object Oriented Programming

 * Expected grade: A: All requirements are met, output matches sample
 */


import java.util.EnumSet;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Arrays;

 public class Assignment5
{
    public enum Family
    {
        // Static Input
        WILMA("Wilma", "Flintstone", 5000, 0.05, 10, 35),
        FRED("Fred", "Flintstone", 15000, 0.075, 7, 30),
        BETTY("Betty", "Rubble", 7500, 0.0375, 10, 25),
        BARNEY("Barney", "Rubble", 5000, 0.09, 10, 35);

        // Instance Fields
        private final String fName;
        private final String lName;
        private final int anDeposit;
        private final double intRate;
        private final int depoYears;
        private final int calcYears;

        // Constructor
        Family(String fName, String lName, int anDeposit, double intRate, int depoYears, int calcYears)
        {
            this.fName = fName;
            this.lName = lName;
            this.anDeposit = anDeposit;
            this.intRate = intRate;
            this.depoYears = depoYears;
            this.calcYears = calcYears;
        }
        
        // Accessor's
        public String getFName()
        {
            return fName;
        }
        
        public String getLName()
        {
            return lName;
        }
        
        public int getAnDeposit()
        {
            return anDeposit;
        }
        
        public double getIntRate()
        {
            return intRate;
        }
        
        public int getDepoYears()
        {
            return depoYears;
        }
        
        public int getCalcYears()
        {
            return calcYears;
        }
}

    public static void main(String [ ] args)
    {
        // Initialize variables
        int i, j = 0, length = 0, count = 0;

        // Get max (length) of total years
        for (Family fam: Family.values())
        {
            int temp = fam.getCalcYears();

            // Save largest
            if (temp > length)
                length = temp;

            // # of ENUM's counter
            count++;
        }

        // Create 2D Array to store Ammounts
        BigDecimal[][] ammounts = new BigDecimal[length + 1][count];
       
        // Loop through Enums
        for (Family fam : Family.values())
        {
            // Initializations for current Enum (Retieval)
            BigDecimal anDeposit = BigDecimal.valueOf(fam.getAnDeposit());
            BigDecimal intRate = BigDecimal.valueOf(fam.getIntRate());      
            BigDecimal depoYears = BigDecimal.valueOf(fam.getDepoYears());
            BigDecimal calcYears = BigDecimal.valueOf(fam.getCalcYears());

            // Calculation & Array Setup
            BigDecimal current = BigDecimal.ZERO;
            BigDecimal temp = BigDecimal.ZERO;
            double cumulative = 0.00;

   
            // Calculations Begin:
            // Loop through Deposit Years
            for (i = 1; i <= (fam.getDepoYears()); i++)
            {
                // Cave cumulaitve deposits
                cumulative += fam.getAnDeposit();

                // Calculate current adidtions
                current = calculate(anDeposit, intRate, i);

                // Add to total
                temp = temp.add(current);

                // Save ammount in array
                ammounts[i][j] = temp;
            }

            // Loop through Projected Years
            for (; i <= fam.getCalcYears(); i++)
            {
                // Calculate projected year --> save ammount to array
                ammounts[i][j] = calculate(ammounts[i - 1][j], intRate, 1);
            }

            // Fill in rest of array (to keep equivalent lengths)
            for (; i <= length; i++)
            {
                // Take previous year and save it in following.
                ammounts[i][j] = ammounts[i - 1][j];
            }

            // Increment to next Enum
            j++;
        }    

        // Output Begin:
        // Formating Initializtions
        NumberFormat decimalPercentage = NumberFormat.getPercentInstance();
        decimalPercentage.setMaximumFractionDigits(3);
        decimalPercentage.setMinimumFractionDigits(2);

        // Prepare table format info
        // Loop through all enums for each row
        System.out.printf("%8s", "First"); 
        for (Family fam : Family.values())
        {   
            System.out.printf("%17s", fam.fName);
        }
        
        System.out.printf("%n%8s", "Last"); 
        for (Family fam : Family.values())
        {   
            System.out.printf("%17s", fam.lName);
        }
        
        System.out.printf("%n%8s", "Deposit"); 
        for (Family fam : Family.values())
        {   
            System.out.printf("%17s", NumberFormat.getCurrencyInstance().format(fam.anDeposit));
        }
        
        System.out.printf("%n%8s", "Interest"); 
        for (Family fam : Family.values())
        {   
            System.out.printf("%17s", decimalPercentage.format(fam.intRate));
        }
        
        System.out.printf("%n%8s", "Deposit"); 
        for (Family fam : Family.values())
        {   
            System.out.printf("%17s", fam.depoYears);
        }
        
        System.out.printf("%n%8s", "Compound"); 
        for (Family fam : Family.values())
        {   
            System.out.printf("%17s", fam.calcYears);
        }   


        // Final Output: Print each ammount for corresponding year for each enum
        for (i = 1; i < length + 1; i++)
        {   
            j = 0;
            System.out.printf("%n%8d", i);

            // Loop through enums
            for (Family fam : Family.values())
            {
                // Print element
                System.out.printf("%17s", NumberFormat.getCurrencyInstance().format(ammounts[i][j]));
                j++;         
            }
        }
    }

    public static BigDecimal calculate(BigDecimal principle, BigDecimal rate, int year)
    {
        // Create BigDecimal to store calculation
        BigDecimal result = (principle.multiply(rate.add(BigDecimal.ONE).pow(year)));

        // Return Result into array
        return result;
    }
}
