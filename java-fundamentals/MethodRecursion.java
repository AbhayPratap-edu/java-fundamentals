public class MethodRecursion
{
    public  static void main(String[] args)//main method - entry point of programme,only one main per class
            //method without return values(void)
            //Just executes, no return value
    {
        //methodUsage for static method

        //Static methods are typically called using: ClassName.methodName()
        int resultAdd = MethodRecursion.addNumbers(9,6);
        System.out.println(resultAdd);//output 15

        //static method Exception: Same Class Calling
        //static method called within same class,can omit the class name:
        int resultAdd1 = addNumbers(5,6);// calls the method
        System.out.println("static method result1" +resultAdd1);//output 11

        //methodUsage for instance method
        MethodRecursion subAb = new MethodRecursion();// create object subAb instance from class
        int differenceAb = subAb.subtract(10,5); //called instance method using object reference
        System.out.println("Instance method result: " + differenceAb); // Output: 5

        //method overLoading usage
        int resultAdd2 = addNumbers(3,6,7);//static method overloading
        double resultAdd3 = addNumbers(3.4,5.6);//static method overloading
        System.out.println("static method overloading result2:" +resultAdd2 + ", result3: " + resultAdd3);

        //Recursion usage
        countdown(10);//countdown recursion use

        System.out.println(factorial(5));//factorial recursion usage

    }

    //What are Methods
    //A method in Java is a block of code that performs a specific task.
    // Think of it as a mini-program within your program that you can call whenever you need it.

    public static int addNumbers(int a ,int b)
    //MethodDefinition : accessModifiers static returnType methodName(parameterType parameter)
    //static - Can be called without creating an object
    //static method:called using ClassName
    //method with return values - int
    {
        return a + b;//logic / statements - add two numbers and return when called
    }

    public int subtract(int a,int b)//instance method
    {
        return a - b;
    }

    //MethodOverloading
    //multiple methods with same name but different parameters/parameter order in same class

    public static int addNumbers(int a,int b,int c){ return a + b + c; }//method overloading
    public static double addNumbers(double a,double b) {return a + b;}//method overloading


    //RECURSION-method calls itself

    //important rule
    //Always have a base case - or will go infinite recursion
    //Move towards the base case - parameters should change each call

    //use case - Mathematical calculations (factorial, Fibonacci),Searching and sorting algorithms,Tree/hierarchical data structures

    //Eg1 method countdown recursive
    public static void countdown(int numberCountdown)
    {
        if (numberCountdown==0)//Base case : stops when number reaches 0
        {
            System.out.println("Blass off");
            return;
        }

        System.out.println("numberCountdown:" +numberCountdown);//print number
        countdown(numberCountdown-1);//Recursive case : call itself with number-1
    }
    //Eg2 method factorial :recursion
    public  static int factorial(int factOf)
    {
        if(factOf==0 || factOf==1) { return 1; }//Base case : returns 1 when recursion reaches to base case

        return factOf*factorial(factOf-1);//Recursive call
    }

}
