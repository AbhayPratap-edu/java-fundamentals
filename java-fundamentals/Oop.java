import java.lang.String;

public class Oop//Class names follow  CamelCase convention
{
    public static void main(String[] args)//main method
    {
        //create object of a class to call the method of that class - objOfClass.methodOfClass();

        //1st method for object from class pet (constructor)
        Pet myDog = new Pet("Buddy",3,75);//objects initiation:ClassName objectName = new ClassName();
        myDog.feed();//Calls instance method to perform:ObjectName.method
        System.out.println(myDog.getHealthStatus());//output

        //2nd method for object from class mobile
        Mobile object = new Mobile();
        object.brandMobile= "samsung";
        object.priceMobile = 20000;
        Mobile.nameMobile = "galaxy";

        new Mobile();//anonymous object created | object does not have any reference
        // objMobile , object are references stored in stack memory

        //instance method call
        object.show();
        //static method call
        Mobile.showS();
        //static method call with instance variable
        Mobile.showSI(object);

        //class Person (Encapsulation)
        Person personA = new Person("Ram",14,1000);// object creation with constructor

        Person personB = new Person();//object creation without constructor parameter
         personB.setName("Bharat");
        personB.setAge(13);
        personB.setSalary(8000.89);
        //setter method done class person

        //getter method class person
        System.out.println(personA.getName() + ":" + personA.getAge() + ":"+ personA.getSalaryPerson());
        System.out.println(personB.getName() + ":" + personB.getAge() + ":" + personB.getSalaryPerson());
    }
}

// First class Pet for general demonstration
class Pet // scope class className
{
    // attributes data
    String namePet; // dataType attribute_name
    int agePet;
    double healthPet;

    //constructor (special method of initialization)
    public Pet(String petName,int petAge,double initialHealth)// scope className(parameters:type property)
    {
        namePet = petName;//parameter1
        agePet = petAge;//parameter2
        healthPet = initialHealth;//parameter3
    }

    // instance methods
    public void feed() // scope returnType methodName(parameters)
    {
        this.healthPet += 5;//logic
    }

    //method: get health status
    public String getHealthStatus() // scope returnType methodName(parameters)
    {
        if (healthPet >= 100) return "Excellent";//logic
        if (healthPet>=75) return "good";//logic
        return "needs care";
    }

}

// Second class Mobile for demonstration of instance and static variable,method
class Mobile
{
    String brandMobile;//instance variable
    int priceMobile;//instance variable
    static String nameMobile;//static variable
    // static variable will be same for all objects of mobile
    // static variable changed for 1 , it will change for every object
    // static variable is  common variable share by all objects
    // static variable should be called by ClassName not by object name

    //instance method
    public void show()
    {
        System.out.println(brandMobile + ":" + priceMobile + ":" + nameMobile);
    }

    //static method
    //static variable can be use inside static method
    // instance variable can not be used inside static method
    // for instance variable pass the specific object
    public static void showS()
    {
        System.out.println("static variable" + nameMobile);//using only static variable
    }

    public static void showSI(Mobile obj)// for using instance variable
    {
        System.out.println("instance variable" +obj.brandMobile +":" + obj.priceMobile);
    }

    // static block called one irrespective how many objects are created
    //static initialized once when class is loaded
    static
    {
        nameMobile = "phone";
    }
    //Only inner classes (i.e., classes defined inside another class) can be marked static.
    //Use static only for inner classes if they don’t depend on an outer class instance.
}

//What is Encapsulation
//control who can access them and how
//Hiding internal data (private fields)
//Providing controlled access through public methods

//accessModifier    Access Level	        Usage
//private	        Same class only	        Internal data, helper methods
//public	        Everywhere	            Interface methods, constructors
//protected	        Same package+subclasses	Inheritance scenarios
//Default	        Same package	        Package-level access

//class with concept of Encapsulation
//class for demonstration of constructor , setter and getter
class Person
{
    private String namePerson;//private variable
    private int agePerson;//private variable
    private double salaryPerson;//private variable (hidden form outside)
    //field name- namePerson , agePerson , salaryPerson

    //default constructor(no-argument)
    public Person()
    {
        //Initialize with default values or leave empty
    }

    //constructor(with-argument)/Parameterized constructor
    //it is useful to set initial/default value for all object.
    // It is called implicitly while creating object even not defined in class.

    public Person (String name,int age,double salary)// public className(parameterType parameter)
    {
        setName(name);
        setAge(age);
        setSalary(salary);
    }

    //getter method
    public String getName()//getter method  (read access)
    {
        return namePerson;
    }
    public int getAge()//getter method (read access)
    {
        return agePerson;
    }
    public double getSalaryPerson()//getter method (read access)
    {
        return salaryPerson;
    }

    //setter method
    public void setName(String name)//setter method (write access)
    {
        namePerson = name;
    }
    public void setAge(int age)//setter method (write access)
    {
        this.agePerson = age;//this.fieldName = parameterName;
    }
    //this = current object reference
    //Use when parameter names match field names
    //Optional when no name conflicts exist
    //this() will call the constructor of same class

    public void setSalary(double salaryPerson)
    {
        this.salaryPerson = salaryPerson;
    }

}//final keyword
//Use of final keyword -
//for variable - we can not change its value
//for method - we can not override method in child class
//for class -  we can not inherit the property of parent class(we are stopping the inheritance).

//Every class in Java implicitly extends the Object class.
//The Object class provides methods like equals, hashCode, toString, etc., even if not explicitly defined in a class.
