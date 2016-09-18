/**
 * Author: Nathan Guenther
 * Assignment: 4b
 * Date: 2014/10/13
 *
 * Inputs: Upper limit range of integers, & Read in from Prompt or File. Stops when limit reached or file finished.
 * Processes: Creates array for counting integers up to limit. Loops through and increments corresponding elementa after reading in.
 * Outputs: Prints a table of 10 collumns that generates the correct placement (tens, hundreds etc.) including the counts of each integer within the limit from the array.

 * Class name: COP 3330 Object Oriented Programming

 * Expected grade: A: All requirements are met, command line parameters and file read in are working correctly.
 */

import java.util.Scanner;
import java.security.SecureRandom;

public class Assignment4b
{

   public static void main(String [ ] args)
   {
        // Check for valid input
        if (args.length != 1)
            System.out.printf("Error: Please re-enter the entire command, including%n" + "the random integer upper limit.%n");

        else
        {
            // Initiailize Variables
            int limit, temp;
            Scanner input = new Scanner(System.in);
            SecureRandom ranNum = new SecureRandom();

            // User Input
            limit = Integer.parseInt(args[0]);

            // Create count array to limit
            int[] count = new int[limit + 1];

            //System.out.printf("Please enter random integers within limit until finished: %n");

            // Collect Integers (Until End of File or User Breaches Limit)
            while (input.hasNext())
            {
                // Store random Number
                temp = input.nextInt();

                // Finish if input is greater than Limit
                if (temp > limit)
                    break;

                // Count the corresponding integer
                count[temp]++;
            }

            // Final output
            printStat(count);
        }
   }

   
   public static void printStat(int[] count)
   {
        // Initialize Variables
        int i = 1, length = count.length;
        int place = 1, counter = 0;
        char space = '-';

        // Output Begin
        System.out.printf("%nThe disribution for the randon numbers from 1 to %d is shown below:%n", (length - 1));
        // Print # Collumns
        System.out.printf("%n          ");
        for (i = 1; i < 11; i++)
            System.out.printf("%5d", i);

        System.out.printf("%n             -----------------------------------------------");
        System.out.printf("%nUnits:    ");    
        
        // Reset i before printing
        i = 1;

        // Loop to print out all Integer Counts
        while (i < length)
        {
            // Print Corresponding Count
            System.out.printf("%5d", count[i]);
            i++;
            counter++;

            // Drop line for next 10's place
            if (counter % 10 == 0)
            {
                // Last row check (break early)
                if (i == length)
                    break;
                    
                // Format Placements
                System.out.printf("%n%4d0s    ", place);
                place++;
                counter = 0;       
                continue;
            }
        }

        // Special case for last row complete
        if (counter == 0)
            counter = 10;
            
        // Fill in Empty Placements
        for (i = counter; i < 10; i++)
            System.out.printf("%4c%c", space, space);
        
   }
}
