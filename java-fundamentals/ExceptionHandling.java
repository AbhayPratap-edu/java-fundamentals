
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionHandling
    //Exception Handling handle Runtime Errors , prevents from crashing the programme

{
    public static void main(String[] args)
    {
        //Basic try-catch syntax
        try
        {
            //code that might cause an exception//
        }
        catch (ArrayStoreException e)//catch (AnotherExceptionType objName)
        {
            // Code to handle the exception
        }
        catch (ArithmeticException e)//catch (AnotherExceptionType e)
        {
            // Handle different exception type
        }
        finally
        {
            // Code that always runs (optional)
        }

        //         Example 1: Division by zero
        System.out.println("=== DIVISION EXAMPLE ===");
        try
        {
            int a = 10;
            int b = 0;
            int result = a/b;//This will cause ArithmeticException
            System.out.println("Result: " + result);
        }
        catch (ArithmeticException exception)
        {
            System.out.println("Error: cannot divide by zero");
            System.out.println("Exception message: " + exception.getMessage());
        }

        //      Example 2: Array index out of bounds
        System.out.println("\n===Array Access Example===");
        try
        {
            String[] arrayOfNames = {"alice","bob","charlie"};
            System.out.println("Name at index 5: " + arrayOfNames[5]);//out of index
        }
        catch (ArrayIndexOutOfBoundsException exception)
        {
            System.out.println("Error:Array index out of bounds");
            System.out.println("Exception message: " + exception);// Prints exception type and index info

        }

        //      Example 3: Number format exception
        System.out.println("\n=== STRING CONVERSION EXAMPLE ===");
        try
        {
        String invalidNumber = "abc123";
        int number = Integer.parseInt(invalidNumber);//Causes NumberFormatException
        System.out.println("Converted number: " + number);
        }
        catch (NumberFormatException e)
        {
            System.out.println("❌ Error: Cannot convert '" + "abc123" + "' to a number!");
        }
        //The finally Block
        // contains code that always executes,
        //used for cleanup operations like closing files, database connections, or releasing resources
        finally
        {
            System.out.println("🔄 Finally block: This always executes!");
        }

        //checked exception example
        System.out.println("checked exception example");
        try
        {
            readFile("example.txt");//readFile() can throw IOException
        }
        catch (IOException e)
        {
            System.out.println("❌ File operation failed: " + e.getMessage());
        }

        //demonstrating THROW AND THROWS KEYWORD (CUSTOM EXCEPTION)
        System.out.println("demonstrating throw and throw keyword also custom exception");
        try
        {
            validateAge(18);//this will throw InvalidAgeException
        }
        catch (Exception e)
        {
            System.out.println("caught exception: " + e.getMessage());
        }

        //TRY-WITH-RESOURCES EXAMPLE
        System.out.println("Try-with-resources");
        readFileModern("example.txt");


    }


    //method declares it might throw an custom exception using 'throws'
    //	used In method signature to declare the exception - throws Exception
    // method with custom exception
    public static void validateAge(int age) throws InvalidAgeException
    {
        if(age<19)
        {
            //manually throw an exception using "throw"
            //used Inside method body to actually throw the exception
            throw new InvalidAgeException("Age must be greater than 19");
        }
    }


    // Method that throws checked exception
    public static void readFile(String fileName) throws IOException
    {
        FileReader file = new FileReader(fileName);//Checked exception
        BufferedReader reader = new BufferedReader(file);

        try
        {
            String line = reader.readLine();
            System.out.println("First line: " + line);
        }
        finally
        {
            reader.close();//Always close resources
        }
    }

    // Define the custom exception class
    public static class InvalidAgeException extends Exception //Custom checked exception (extends Exception)
    {
        //constructor with custom message
        public InvalidAgeException(String message)
        {
            super(message);//pass message to Exception class
        }

    }

    //Try-with-Resources
    //Modern approach for automatic resource management:
    public static void readFileModern(String fileName)
    {
        try (FileReader reader = new FileReader(fileName);          // Resource 1
             BufferedReader bfReader = new BufferedReader(reader))  // Resource 2
        {
            String line;
            while ((line = bfReader.readLine()) != null)
            {
                System.out.println(line);
            }
        }
        catch (IOException e)
        {
            System.out.println("Error reading file: " + e.getMessage());
        }
        //No finally block needed - resources auto-closed!

    }



}
//Exception Handling Keywords
//Keyword	    Purpose	                                        Usage
//try	        Contains code that might throw an exception	    try { risky_code; }
//catch	        Handles specific exception types	            catch (ExceptionType e) { handle; }
//finally	    Code that always executes	                    finally { cleanup_code; }
//throw	        Manually throws an exception	                throw new Exception("error");
//throws	    Declares that a method can throw exceptions	    void method() throws IOException

//Types of Exceptions
//Type	        Description	                        Handling Required	    Examples
//Checked	    Must be handled at 	compile time    ✅ Yes	                IOException, SQLException,
//                                                                           FileNotFoundException

//Unchecked	    Runtime exceptions,	                ❌ No	                NullPointerException, ArithmeticException,
//               handling optional                                          ArrayIndexOutOfBoundsException

//Java Exception Hierarchy (Simplified)

//    Object
//      |
//  Throwable
//      |
//   +--Error (System errors - usually not caught)
//   |    |
//   |    +--OutOfMemoryError
//   |    +--StackOverflowError
//   |
//   +--Exception
//        |
//        +--Checked Exceptions (must be handled)
//        |    |
//        |    +--IOException
//        |    +--SQLException
//        |    +--FileNotFoundException
//        |
//        +--RuntimeException (Unchecked)
//             |
//             +--NullPointerException
//             +--ArithmeticException
//             +--ArrayIndexOutOfBoundsException
//             +--IllegalArgumentException
