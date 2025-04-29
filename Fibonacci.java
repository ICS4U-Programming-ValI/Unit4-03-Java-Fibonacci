import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;




/**
 * This is the package for Fibonacci.java
 *
 * The Fibonacci program reads an int from a file
 * calculates the fibonacci of the int
 * using recursion
 * then writes the result to a file.
 *
 * <p>This class satisfies style checkers.</p>
 *
 * @author Val Ijaola
 * @version 1.0
 * @since 2025-04-25
 */


public final class Fibonacci {


    private Fibonacci() {
        throw new IllegalStateException("Utility class");
    }
    /**
     * This method calculates fibonacci using recursion.
     *
     * @param num
     * @return the fibonacci of the int
     */
    public static int fibonacci(final int num) {
        if (num == 0) {
            return 0;
        } else if (num == 1) {
            return 1;
        }
        return fibonacci(num - 1) + fibonacci(num - 2);
    }


    /**
     * This is the main method.
     *
     * @param args the command line arguments
     */
    public static void main(final String[] args) {
        try {
            // Specify the file paths
            String filePath = "input.txt";
            File outputFile = new File("output.txt");


            // Create a FileWriter and PrintWriter for the output file
            FileWriter fileWriter = new FileWriter(outputFile);
            PrintWriter printWriter = new PrintWriter(fileWriter);


            // Read the word from the input file
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);


            while (scanner.hasNextLine()) {
                String word = scanner.nextLine();

                // Convert the string to an int
                try {
                    int number = Integer.parseInt(word);

                    if (number < 0) {
                        printWriter.println("Number is negative.");
                    } else if (number > 20) {
                        printWriter.println("Fibonacci is too large.");
                    } else {
                        int fibonacciValue = fibonacci(number);
                        printWriter.println("Fibonacci = " + fibonacciValue);
                    }

                } catch (NumberFormatException ex) {
                    printWriter.println(word + " is not a valid integer.");
                }
            }


            // Close the scanner and writer
            scanner.close();
            printWriter.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Error reading the file: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error writing to the file: " + ex.getMessage());
        }
    }
}
