/*
* Class: COP3330
* Section: CMB14-Fall
* Author's name: Nathan Guenther
* Instructor: McAlpin
* Date Submitted: 09/01/14
* Assignment Description: Assignment 1
* Commentary: 
* Your comments that explain your approach, objectives, and results.
* To wit:
* Approach:
*   Oblah de oblah da
* Objectives:
*   Find the walrus.
* Results:
*   Walrus found singing really old music.
*
* Problems found: (IF NECESSARY)
* Author comments: (AS APPROPRIATE)
*/

import java.util.Scanner;

public class Assignment1
{
    // Main method
    public static void main(String [ ] args)
    {
        // Setup scanner
        Scanner input = new Scanner(System.in);

        // Initialize Variables
        int temp;
        int num1, num2, num3, num4, num5;
        int pos = 0, neg = 0, zero = 0;

        // User input 1
        System.out.printf("Enter first integer: "); 
        temp = input.nextInt(); 

        // Calculations
        if(temp > 0)
        {
            pos++;
        }

        else if(temp < 0)
        {
            neg++;
        }

        else if(temp == 0)
        {
            zero++;
        }


        // User input 2
        System.out.printf("Enter second integer: "); 
        temp = input.nextInt(); 

        // Calculations
        if(temp > 0)
        {
            pos++;
        }

        else if(temp < 0)
        {
            neg++;
        }

        else if(temp == 0)
        {
            zero++;
        }

        // User input 3
        System.out.printf("Enter third integer: "); 
        temp = input.nextInt(); 

        // Calculations
        if(temp > 0)
        {
            pos++;
        }

        else if(temp < 0)
        {
            neg++;
        }

        else if(temp == 0)
        {
            zero++;
        }

        // User input 4
        System.out.printf("Enter fourth integer: "); 
        temp = input.nextInt(); 

        // Calculations
        if(temp > 0)
        {
            pos++;
        }

        else if(temp < 0)
        {
            neg++;
        }

        else if(temp == 0)
        {
            zero++;
        }

        // User input 5
        System.out.printf("Enter fifth integer: "); 
        temp = input.nextInt(); 

        // Calculations
        if(temp > 0)
        {
            pos++;
        }

        else if(temp < 0)
        {
            neg++;
        }

        else if(temp == 0)
        {
            zero++;
        }

        // Output corresponding with results
        if(pos > 1)
        {
            System.out.printf("There were %d Positive input numbers.%n", pos);
        }
        else
        {
            System.out.printf("There was %d Positive input numbers.%n", pos);
        }

        if(zero > 1)
        {
            System.out.printf("There were %d Zero input numbers.%n", zero);
        }
        else
        {
            System.out.printf("There was %d Zero input numbers.%n", zero);
        }

        if(neg > 1)
        {
            System.out.printf("There were %d Negative input numbers.%n", neg);
        }
        else
        {
            System.out.printf("There was %d Negative input numbers.%n", neg);
        }
        
    }
}
