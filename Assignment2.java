/**
 * Author: Nathan Guenther
 * Assignment: 2 Page: 148 Problem: 4.23 (Find the two largest numbers)
 * Date: 2014/09/dd of submission
 *
 * Inputs: Takes 10 integers from user
 * Processes: Compares against other inputed values and determiens if larger.
 * Outputs: The two largest of the 10 integers.

 * Class name: COP 3330 Object Oriented Programming

 * Expected grade: A because all the required functions are implemented and output correctly when tested.
 */

 import java.util.Scanner;

 public class Assignment2
 {

    // Main method
    public static void main(String [ ] args)
    {
        // Setup Scanner
        Scanner input = new Scanner(System.in);

        // Initialize Variables
        int i = 0, j = 1;
        int temp, lrg1 = 0, lrg2 = 0;

        // Loop through 10 iterations hard coded
        while(i < 10)
        {
            // Prompt User
            System.out.printf("Enter integer %d: %n", j);
            
            // Scan in numbers from user
            temp = input.nextInt();

            // Check if first two numbers (allows negative integers to work)
            if (i < 2)
            {
                // Skip comparisons since NULL values
                switch(i)
                {
                    case 0:
                        // Initialize Largest 1
                        lrg1 = temp;
                    case 1:
                        // Initialize Largest 2
                        lrg2 = temp;
                }

                // Increment counter position
                i++;

                // Incremember counter for user prompt
                j++;
                
                // Move onto next iteration input
                continue;
            }

            // Check if larger than first
            if (temp > lrg1)
            {
                // Swap and add new
                lrg2 = lrg1;
                lrg1 = temp;
            }

            // Check if larger than second
            else if (temp > lrg2)
            {
                // Replace
                lrg2 = temp;
            }

            // Increment counter position
            i++;

            // Incremember counter for user prompt
            j++;
        }

        // Final output
        System.out.printf("%nThe two largest numbers out of the 10 inputed are: %d, and %d%n", lrg1, lrg2);
    }
 }
