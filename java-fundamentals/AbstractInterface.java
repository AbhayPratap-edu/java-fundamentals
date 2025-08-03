public class AbstractInterface
{
    public static void main(String[] args)
    {
        //Abstract Implementation
        System.out.println("Implementing Abstraction");
        //create concrete child objects
        WildDog wildDogA = new WildDog("wildDogA",4);
        WildBird wildBirdA = new WildBird("wildBirdA",1);

        //Use Inherited concrete methods
        wildBirdA.sleep(); // From WildAnimal ( parent ) class
        wildDogA.sleep(); // From WildAnimal ( parent ) class

        //use Overridden abstract methods
        wildDogA.makeSound();
        wildDogA.move();//WildDog's Implementation

        wildBirdA.makeSound();//Bird's Implementation
        wildBirdA.move();

        //Polymorphism works with abstract classes
        WildAnimal[] wildAnimals = {wildBirdA,wildDogA};
        for(WildAnimal animal : wildAnimals)
        {
            animal.makeSound();
            animal.move();
        }

        //Interface Implementation
        System.out.println("Implementing Interface");
        //Create Objects of implementing classes
        AnimalInterface dogInterfaceA = new DogInterface("DogInterface");
        AnimalInterface catInterfaceA = new CatInterface("CatInterface");

        // Use interface reference with polymorphism
        AnimalInterface[] animalInterfaces = {dogInterfaceA,catInterfaceA};
        for(AnimalInterface animal : animalInterfaces)
        {
            animal.makeSound();  // Polymorphic call
            animal.move();
            animal.eat();
            System.out.println("Kingdom: " + AnimalInterface.KINGDOM);
            System.out.println();
        }

        //Lambda expression implementation

        //Traditional approach with anonymous class
        Calculator additionOld = new Calculator()
        {
            @Override
            public int calculate(int a, int b)
            {
                return a + b;
            }
        };

        //Lambda expression approach
        Calculator addition = (a,b) -> a + b;
        Calculator subtraction = (a,b) -> a - b;
        Calculator multiplication = (a , b) -> a * b;
        //with code block for complex operations
        Calculator division = (a,b) ->
        {
            if (b==0)
            {
                System.out.println("Cannot divide by zero");
                return 0;
            }
            return a / b;
        };
        //Using the lambda expressions
        System.out.println("Using the lambda expressions");
        System.out.println("Addition: " + addition.calculate(10,5));//15
        System.out.println("Substraction: " + subtraction.calculate(10,5));//5
        System.out.println("Multiplication: " + multiplication.calculate(10,5));//50
        System.out.println("Division: " + division.calculate(10,5));//2

    }
}
//ABSTRACT
//it's like to create a blueprint that defines what subclasses should do ,
//without fully implementing everything

//Abstract Class - A class that cannot be instantiated directly
//Abstract Method - A method declared without implementation

//Syntax - public abstract class ClassName {---}
abstract class WildAnimal
{
    // Can have instance variables and static members
    // Can have abstract methods
    // Cannot be instantiated i.e. Cannot create objects directly
    //Can have constructors (called by child classes)

    protected String animalName ;// Regular fields (concrete)
    protected int animalAge ;

    //Constructor
    public WildAnimal(String animalName,int animalAge)
    {
        this.animalName = animalName;
        this.animalAge = animalAge;
    }
    //Concrete method - has implementation
    public void sleep()
    {
        System.out.println(animalName + " is sleeping(Abstract)");
    }

    //Abstract methods - declared inside an abstract class (or interface)
    //Syntax - public abstract returnType methodName(parameters);
    // no implementation / just the method signature
    // All child classes MUST implement this
    //Cannot be private, static, or final
    public abstract void makeSound();// no method body
    public abstract void move();

}

// Concrete child class - must implement all abstract methods
class WildDog extends WildAnimal
{
    //constructor
    public WildDog(String name,int age)
    {
        super(name,age);//call parent constructor
    }
    //implementing abstract methods
    @Override
    public void makeSound()
    {
        System.out.println(animalName + " barks: woof!(Abstract)" );
    }
    @Override
    public void move()
    {
        System.out.println(animalName + " runs on four legs(Abstract)");
    }
}
class WildBird extends WildAnimal
{
    //constructor
    public WildBird(String name,int age)
    {
        super(name,age);
    }
    //Different implementation for same abstract method
    @Override
    public void makeSound()
    {
        System.out.println(animalName + " chirps: Tweet! Tweet! (Abstract)");
    }
    @Override
    public void move()
    {
        System.out.println(animalName + " flies through the sky(Abstract)");
    }

}
//                  Abstract Class              vs           Interface
//Feature       	Abstract Class              	         Interface
//Instantiation 	Cannot be instantiated              	Cannot be instantiated
//Methods       	Can have abstract + concrete methods	Abstract methods (+ default/static in Java 8+)
//Variables     	Can have instance variables         	Only public static final constants
//Constructors  	Can have constructors               	Cannot have constructors
//Inheritance   	Single inheritance (extends)    	    Multiple inheritance (implements)
//Access Modifiers	All access modifiers allowed            Methods are public by default

//INTERFACE
//An interface in Java is a reference type, similar to a class
// that contains only abstract methods , default methods , static methods and constants

//Key Points about Interfaces:
//By default, methods are public and abstract (unless they're default or static)
//By default, variables are public, static, and final (constants)

//Interface Definition
interface AnimalInterface
{
    //Constants ( public , static , final by default)
    String KINGDOM = "Animalia";

    //Abstract methods (public and abstract by default)
    // must be implemented by classes
    void makeSound();
    void move();
    void eat();
}

//class implementing the interface
class DogInterface implements AnimalInterface
{
    private String dogNameIN;

    public DogInterface(String name)//constructor
    {
        dogNameIN = name;
    }
    //must implement all interface methods
    @Override
    public void makeSound()
    {
        System.out.println(dogNameIN + " barks: Woof! Woof!(Interface)");
    }
    @Override
    public void eat()
    {
        System.out.println(dogNameIN + " eats dog food.(Interface");
    }
    @Override
    public void move()
    {
        System.out.println(dogNameIN + " runs on four legs.(Interface");
    }
}

class CatInterface implements AnimalInterface {
    private String catNameIN;

    public CatInterface(String name) {
        catNameIN = name;
    }

    @Override
    public void makeSound() {
        System.out.println(catNameIN + " meows: Meow! Meow!(Interface)");
    }

    @Override
    public void move() {
        System.out.println(catNameIN + " walks gracefully.(Interface)");
    }

    @Override
    public void eat() {
        System.out.println(catNameIN + " eats cat food.(Interface)");
    }
}

//INTERFACE BENEFITS -
//Benefit	            Description	                                     Example
//Multiple Inheritance	Class can implement multiple interfaces	         class Car implements Drivable, Maintainable
//Loose Coupling	    Classes depend on behavior, not implementation	 Method accepts List interface,
//                                                                       works with ArrayList, LinkedList
// Polymorphism	        Same interface, different implementations	     Animal[] pets = {dog, cat, bird}
//Contract Definition	Guarantees certain methods exist	             All Drawable objects have draw() method

// Lambda Expressions -
//Lambda expressions are anonymous functions
//concise way to implement functional interfaces (interfaces with exactly one abstract method)
//enable functional programming style

// Basic syntax
//(parameters) -> expression
//parameter -> expression | Single parameter (parentheses optional)

//(param1, param2) -> expression | With multiple parameters

//(parameters) ->
//  {
//    multiple statements
//    return value;
//  }
// With code block

//Functional Interfaces - The Bridge

@FunctionalInterface
interface Calculator
{
    int calculate(int a,int b);

    //can have default methods
    default void showResult(int result)
    {
        System.out.println("Result: " + result );
    }
}

//Lambda Expression Benefits -
//Benefit	                 Description	                            Example
//Concise Code	             Less boilerplate than anonymous classes	(x, y) -> x + y vs anonymous class
//Functional Programming     Enables functional style programming	    Stream operations, higher-order functions
//Better Performance	     More efficient than anonymous classes	    JVM optimizations for lambdas
//Improved Readability	     Code intent is clearer                     list.filter(x -> x > 10)


