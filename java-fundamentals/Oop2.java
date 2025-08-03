public class Oop2
{
    public static void main(String[] args)
    {
        //USING INHERITANCE
        System.out.println("USING INHERITANCE");
        //create object child classes
        Dog myDog = new Dog("Buddy", 3, 85.0, "Bull");
        System.out.println();//Blank line after constructor calls

        //USING INHERITED METHODS / PARENT METHODS
        myDog.eat(); // From Animal class
        myDog.sleep(); //From Animal class

        //USING OVERRIDDEN METHODS
        //Child class provides its own implementation of parent method
        myDog.makeSound();// Dog's version: "Buddy barks: Woof!" (overridden)

        //USING CHILD-SPECIFIC METHODS
        //that only exist in child class, not available in parent
        myDog.fetch();//Only Dog class has this method

        // USING INHERITED METHOD THAT WORKS FOR ChildClasses
        // Parent method that uses inherited data from child object
        System.out.println("Dog Info: " + myDog.getInfo());
        System.out.println("Dog Breed: " + myDog.getBreed());

        //using polymorphism (overridden methods)
        System.out.println("USING Polymorphism");
        Animal myPet = new Dog();
        myPet.makeSound();
        myPet = new Cat();
        myPet.makeSound();

        //Dynamic Method Dispatch
        System.out.println("JVM determines which method to call based on object type, not the reference type");
        //same reference type(Animal),different object types
        Animal[] zoo = {new Dog(), new Cat()};
        for (Animal animal : zoo)
        {
            animal.makeSound();//different output for each
        }

        //instanceof Operator -
        //check whether an object is an instance of a specific class or subclass (or implements an interface)
        //Syntax - object instanceof ClassName | Output - true/false
        // Check object type at runtime:
        System.out.println("instanceOf operator");
        Animal instanceDog = new Dog();
        System.out.println( instanceDog instanceof Cat);//false
        System.out.println(instanceDog instanceof Dog); // true
        System.out.println(instanceDog instanceof Animal); // true

        //upCasting and downCasting
        //Upcasting is converting a child class reference to a parent class reference
        Dog myDog1 = new Dog();
        Animal myDog2 =  myDog1;// automatic upcasting
        Animal myDog3 = new Dog();//automatic upcasting

        //DownCasting is converting a parent class reference to a child class reference.
         Dog  myDog4 = (Dog) myDog3;// manual downCasting
        // for downCasting object type should match - use instanceOf operator
        //if object which is to be downcast (myDog3) not matches with subclass (Dog) - get runtime error

        if ( myDog3 instanceof Cat) { Cat myCat1 = (Cat) myDog3;}//safe check



    }
}

//Inheritance
//children inherit traits from their parents but can also have their own unique characteristics.
//a child class (subclass) inherits attributes and methods from a parent class (superclass).

//parent class / SuperClass / Base Class
class Animal
{
    protected String name = "not specified";//private variable can be accessed and modify by childClass
    protected int age = 01;
    protected double health = 1.0;
    final private String privateStr = "childClass can not use private variable/methods";
    //keyword (final) make the variable / methods unchangeable (constant)

    //default constructor
    //Called automatically when child constructor uses super()
    public Animal(){System.out.println("ParentClass(Animal) default constructor");}

    //Constructor (parameterized)
    public Animal(String name, int age, double health)
    {
        this();// CONSTRUCTOR CHAINING: Calls default constructor first
        // this() must be FIRST line if used
        // Allows code reuse between constructors in same class
        //Cannot use both this() and super() in same constructor
        this.name = name;// Initialize instance variables
        this.age = age;
        this.health = health;
        System.out.println("🐾 Animal parameterized constructor called for:" +name);
    }

    //PARENT METHODS: Available to all child classes
    public void eat()
    {
        health +=5;
        System.out.println(name + " is eating and feeling better");
    }
    public void sleep()
    {
        health += 10;
        System.out.println(name + " is sleeping.");//
    }
    // METHOD TO BE OVERRIDDEN: Child classes will provide specific implementations
    public void makeSound()
    {
        System.out.println(name + " make a sound.");
    }
    // UTILITY METHOD: Returns formatted information about the animal
    public String getInfo()
    {
        return "Name: " + name + "Age: " +age +"Health: " + health;
    }
}
//child class
// Syntax - class ChildClass extends ParentClass
//"extends" keyword establishes IS-A relationship (Dog IS-A Animal) / inheritance
// child class Inherits all public/protected members from ParentClass
// Can add new members or override existing ones

//child classA
//1.SingleInheritance - one childClass extends one parentClass:
class Dog extends Animal
{
    // CHILD-SPECIFIC ATTRIBUTE: Only Dog class has breed
    private String breed = "bull";

    // DEFAULT CONSTRUCTOR
    public Dog()
    {
        super();//Calls Animal() - Explicit call to parent default constructor
        //  if not specified , super() is called implicitly
        System.out.println("Dog default constructor called");
    }
    //PARAMETERIZED CONSTRUCTOR
    public Dog(String name, int age, double health, String breed)
    {
        super(name, age, health);
        // keyword (super) refers to the parent class and use to -
        // super() Call parent constructor with matching parameter; | Call parent constructor MUST be first line
        // super() Ensures parent is properly initialized before child initialization
        //every constructor have super by default
        //Access parent methods: super.methodName();
        //Access parent variables: super.variableName;
        this.breed = breed;// Initialize child-specific attribute
        System.out.println("Dog parameterized constructor called ");
    }

    //method overriding - override parent method with specific behaviour
    //Method overriding allows child classes to provide specific implementations of parent methods:
    @Override//Annotation - indicating code intentions to compiler
    public void makeSound()
    {
        System.out.println(name + " barks: Woof!");
    }

    //new method specific to ChildClass (Dog)
    // methods defined under child class are specific to child class i.e. parent class can't use
    public void fetch()
    {
        System.out.println(name + " is fetching the bull");
    }
    //GETTER METHOD: Access private breed attribute
    public String getBreed() {
        return breed;
    }
}

//ChildClassB
class Cat extends Animal
{
    //default constructor
    public Cat() {} //
    //parameterized constructor
    public Cat(String name, int age, double health)
    {
        super(name, age, health);//calls animal constructor
        System.out.println("🐱 Cat constructor called");
    }

    @Override
    public void makeSound()
    {
        System.out.println(STR."\{name} meows: Meow! Meow! 🐱");
    }

    // Cat-specific methods
    public  void hunt()
    {
        System.out.println(STR."\{name} is hunting mice! 🐭");
    }
    public void climb()
    {
        System.out.println(STR."\{name} is climbing gracefully! 🌳");
    }
}
//2.MultilevelInheritance
//chain of Inheritance - child becomes parent for another class:
class Mammal extends Animal { } // Mammal -> Animal
class CatA extends Mammal {}// Cat -> Mammal -> Animal

//3.Hierarchical Inheritance
//Multiple child classes inherit from one parent class:
class Bird extends Animal {}
class lion extends Animal {}
//All inherit form parent class

//java doesn't support multiple inheritance (one class extending multiple classes)

// Access Modifiers in Inheritance
//Modifier	    ParentClass	 ChildClass	            OtherClasses
//public	    ✅ Yes	     ✅ Yes	                ✅ Yes
//protected	    ✅ Yes	     ✅ Yes	                ❌ No
//private	    ✅ Yes	     ❌ No	                ❌ No
//Default	    ✅ Yes	     ✅ Yes(same package)	❌ No

//1. Use Inheritance for "IS-A" Relationships
    //✅ GOOD: Dog IS-A Animal
    // ❌ BAD: House IS-NOT-A Person
//2. Prefer Composition for "HAS-A" Relationships
    // ✅ GOOD: Car HAS-A Engine (composition)
    // ❌ BAD: Car IS-NOT-AN Engine

//POLYMORPHISM
// it allows objects of different types to be treated as objects of a common base type,
// while still maintaining their specific behaviors.
//Same method name, different behaviors based on the object type.

//Types of Polymorphism
//1. Compile-Time Polymorphism (Static Polymorphism)
//Resolved during compilation
//Method Overloading - Multiple methods with the same name but different parameters:

//2. Runtime Polymorphism (Dynamic Polymorphism)
//Resolved during program execution. Achieved through:
//Method Overriding + inheritance - Child classes provide specific implementations of parent methods

//Dynamic Method Dispatch
// - to achieve runtime polymorphism
//JVM determines which method to call based on the actual object type, not the reference type.

// Reference Type vs Object Type
//Animal pet = new Dog(); | Reference Type : Animal | Object Type : Dog
//The reference type determines what methods are AVAILABLE
// The object type determines which implementation is CALLED
// Reference Type ( parent ) only parent methods are accessible
// Reference Type ( child ) both parent methods + child methods are accessible

//Same interface, different implementations - one method name, multiple behaviors

//polymorphism Common Mistakes to Avoid
//Mistake	                            Problem	                                    Solution
//Casting without checking	            ClassCastException at runtime	            Use instanceof before casting
//Calling child-specific methods	    Compilation error with parent reference	    Cast to child type or use parent interface
//Overriding with different signatures	Creates new method instead of overriding	Use @Override annotation
//Ignoring return type compatibility	Compilation error	                        Ensure return types are compatible


