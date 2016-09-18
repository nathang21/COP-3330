/**
 * Author: Nathan Guenther
 * Assignment: 6
 * Date: 2014/12/01
 *
 * Inputs: Assignment6Input.txt (Single line of text wrapped)
 * Processes: | (pipes) to represent new lines
 * Outputs: Assignment6Results.txt (Formated text)

 * Class name: COP 3330 Object Oriented Programming

 * Expected grade: A: All requirements are met, output matches sample
 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.FileNotFoundException;
import java.lang.SecurityException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

  public class Assignment6
{
    // Private objects
    private static Formatter output; 
    private static String text;
    private static char[] chars;
    private static String fileName;

    // Simple Main
    public static void main(String[] args)
    {   
        // Ensure valid input
        if (args.length != 1)
            System.out.printf("Error: please re-enter the entire command inluding the input file name.");
            
        // Store command parameter for use later
        fileName = args[0];
        
        readFile();
        writeFile();
        closeFile();
    }

    // Read file into string + convert to char array
    public static void readFile()
    {
        //
        try
        {
            // Store input file in string
            text = new String(Files.readAllBytes(Paths.get(fileName)));
            
            // Convert to Char Array
            chars = text.toCharArray();
        }
        catch (IOException iOException)
        {
            System.err.println("Error processing file. Exiting.");
            System.exit(1);
        }
    }

    // Process text and write to new file
    public static void writeFile()
    {
        try
        {
            // Prepare output file (create if does not exist)
            output = new Formatter("Assignment6Results.txt");
        }
        catch (SecurityException securityException)
        {
            System.err.println("Write permission denied. Exiting.");
            System.exit(1);
        }
        catch (FileNotFoundException fileNotFoundException)
        {
            System.err.println("Error opening file. Exiting.");
            System.exit(1);
        }

        // Loop through text (individual characters) and format
        int i = 0;
        while (i < chars.length)
        {
            try
            {
                // Check for line break
                if (chars[i] == '|')
                {
                    // New line, incrememnt to next character index
                    output.format("%n");
                    i++;
                    continue;
                }
                    
                // Output corresponding character
                output.format("%c", chars[i]);
            }
            catch (FormatterClosedException formatterClosedException)
            {
                System.err.println("Error writing to file. Exiting.");
            System.exit(1);
            }
            catch (NoSuchElementException elementException)
            {
                System.err.println("Invalid input. Please try again.");
            System.exit(1);
            }

            // Increment array
            i++;
        }

        // Prepare footer
        String name = new String("(This text processed by Nathan Guenther.)");
        char[] footer = name.toCharArray();
        output.format("%n");

        // Reset counter
        i = 0;

        // Add footer text
        while (i < footer.length)
        {
            // Apend footer to end of file.
            output.format("%c", footer[i]);
            i++;
        }   
    }

    // Close leftover file IO before termination
    public static void closeFile()
    {
        // Cleanup file if needed.
        if (output != null)
            output.close();
    }
    
}
