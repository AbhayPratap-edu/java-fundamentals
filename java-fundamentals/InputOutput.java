import java.io.BufferedReader;
import java.io.Console;//import console class
import java.io.InputStreamReader;
import java.util.Scanner;  // Import Scanner class

public class InputOutput
{
    public static void main(String[] args)
    {
        //scanner methods
        Scanner inputScanner = new Scanner(System.in);//ScannerClass ClassName = new ScannerClass(System.in);
        //Scanner(System.in) - Creates a Scanner that reads from the keyboard

        //getting different types of inputScanner
        System.out.print("Enter your nameInput: ");//
        String nameInput = inputScanner.nextLine();// dataType variableName = scannerClassName.scannerMethod()

        System.out.print("Enter your ageInput: ");
        int ageInput = inputScanner.nextInt();//dataType variableName = scannerClassName.scannerMethod()

        System.out.print("Enter your GPA: ");
        double gpaInput = inputScanner.nextDouble();//dataType variableName = scannerClassName.scannerMethod()

        //ScannerMethods
        //Method	        Reads	            Example
        //nextInt()	        Whole numbers	    int age = scanner.nextInt();
        //nextDouble()	    Decimal numbers	    double price = scanner.nextDouble();
        //next()	        Single word	        String name = scanner.next();
        //nextLine()	    Entire line	        String sentence = scanner.nextLine();
        //nextBoolean()	    true/false	        boolean isActive = scanner.nextBoolean();
        //nextFloat()       float numbers       float value = scanner.nextFloat();
        //nextLong()        large numbers       long number = scanner.nextLong();

        //Method	            Purpose	                            Example
        //hasNextInt()	        Checks if next input is integer	    if (scanner.hasNextInt())
        //hasNextDouble()	    Checks if next input is double	    if (scanner.hasNextDouble())
        //hasNextLine()	        Checks if there's another line	    while (scanner.hasNextLine())
        //hasNext()	            Checks if there's any input	        while (scanner.hasNext())

        // // Common Pitfall: nextLine() after nextInt()
        // int age = scanner.nextInt(); this will skip the nextLine
        // Solution: Add extra nextLine()
        //scanner.nextLine();   Consume the leftover newline , then use .nextLine to take input

        //Output methods
        //Method	    Purpose	                    Example
        //print()	    Print without new line	    System.out.print("Hello");
        //println()	    Print with new line	        System.out.println("Hello");
        //printf()	    Formatted printing	        System.out.printf("Age: %d", 25);
        System.out.print("Input Info");//Simple Output without new line
        System.out.println("Name: " + nameInput);//variable output with new line
        System.out.println("Age: " + ageInput);//variable output with new line
        System.out.println("GPA: " + gpaInput);//variable output with new line
        System.out.println("Hello " + nameInput + ", you are " + ageInput + " years old");//combine output
        System.out.printf("Name: %s%n",nameInput); //formated output %s = string
        System.out.printf("Age: %d%n", ageInput);// formated output %d = integer
        System.out.printf("GPA: %.2f%n",gpaInput); //formated output %.2f = 2 decimal places

        inputScanner.close();//close scanner when done

        //console class (command line)
        Console console = System.console();
        String inputConsole = console.readLine("Enter text: ");

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //int N = Integer.parseInt(bufferedReader.readLine().trim());
        //readLine - take input in stream format
        //Integer.parseInt - convert string to Integer

        //BufferReader reads from resources
        //bufferedReader.close();

        //output methods




    }
}


