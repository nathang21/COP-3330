/**
 * Author: Nathan Guenther
 * Assignment: 4a
 * Date: 2014/10/13
 *
 * Inputs: Number of Random Integers to Generate & Limit Range of Integrs
 * Processes: Allocates exact array length, Generates neccessary integers, and assings them into array.    
 * Outputs: Loops through array printing all integers.

 * Class name: COP 3330 Object Oriented Programming

 * Expected grade: A: All requirements are met, command line parameters working correctly.
 */

import java.util.Scanner;
import java.security.SecureRandom;


 public class Assignment4a
 {

    public static void main(String [ ] args)
    {
        // Check for valid input
        if (args.length != 2)
            System.out.printf("Error: Please re-enter the entire command, including%n" + "the number of intergers, and a random integer upper limit.%n");

        else
        {
            // Initiailize Variables
            int num, limit;
            Scanner input = new Scanner(System.in);
            SecureRandom ranNum = new SecureRandom();

            // User Input - Integer Limit
            limit = Integer.parseInt(args[0]);

            // User Input - Number of Integers to Enter
            num = Integer.parseInt(args[1]);

            // Allocate Array length
            int[] array = new int[num];

            // Generate Numbers and input into Array
            for (int i = 0; i < num; i++)
                array[i] = ranNum.nextInt(limit);

            // Print our array of integers
            for (int i = 0; i < num; i++)
                System.out.printf("%d%n", array[i]);
        }            
    }
 }
