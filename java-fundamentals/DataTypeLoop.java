import java.lang.String;

public class DataTypeLoop
{
    public static void main(String[] args)
  {
      // variable and data types

        // primitives

       // integers
        byte b = 127;// 8-bit -128 to 127 || -2^b to 2^b-1
        short s_int = -32_768; //16-bit -32,768 to 32,767
        int x = 2_147_483_647; // 32-bit -2,147,483,648 to 2,147,483,647
        long l_int = 3;// 64-bit -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807

        //float
        float f= 5.6f;// 32-bit -1.4e-45 to ±3.4e+38 (7 decimal digits)
        double exp = 11e11;//64-bit -4.9e-324 to 1.8e+308 (15 decimal digits)

        // character
        char ch = 'a';
        ch++; // ch=b

        // boolean
        boolean b1 = true;
        boolean b2 = false;

        //type conversion
        // explicit conversion/casting
        byte numByte = 127;
        int numInt = 45;
        float numFloat = 5.4f;
        byte num4 = (byte)numInt;//downCasting
        float num5 = (float)numInt;//upCasting

        //covert to string
        String sConvert = String.valueOf(numInt);// String s = String.valueOf(anyPrimitiveDataType
        //convert integer to string


       //wrapper type - here data types are objects
       // int->Integer , char->Character , double->Double

       Integer numInteger = 8;//

       Integer numIntegerB = numInt; // auto-boxing | primitive datatype store in class object
       int objToNum = numInteger.intValue();//unboxing | wrapper type converted to primitive type
       int objToNumB = numInteger;//autoUnboxing - recommended

      //covert string to int
      String sInt = "10";
      int strToNum = Integer.parseInt(sInt);



      //relational operators
        // <,>,==,!=,<=,>=

        //logical operators
        // &&,||,!

        //conditional statements
        //if-else
        boolean condition = false;
        if(condition)
        {
            System.out.println("statement1");
        }    
        else
        {  
            System.out.println("statement2");
        }

        //ternary operator
        //result = condition ? (if_true:statement3):(if_false:statement4);

        //switch statement
        int n = 1;

        switch(n)
        {
          case 1:
                System.out.println("Monday");//if a case is matched then all the case will execute after it ,i.e put break
                break;
          case 2:      
                System.out.println("Tuesday");
                break;
          case 3:      
                System.out.println("Wednesday");
                break;
          case 4:       
                System.out.println("Thursday");
                break;
          case 5:      
                System.out.println("Friday");
                break;
          case 6:                     
                System.out.println("Saturday");
                break;
          case 7:
                System.out.println("Sunday");
                break;
          default:
                System.out.println("if none case is match");            
        }

        //switch v1
        String day = "Monday";

        switch (day)
        {
          case "Sunday","Saturday":
              System.out.println("wake-7am");
              break;
          case "Monday":
              System.out.println("wake-6am");
              break;    
          default:
              System.out.println("wake-4am");
              break;
        }
       //switch v2
        String day1 = "Monday";
        String wakeup_time = "";

        switch (day1)
        {
          case "Sunday","Saturday" -> wakeup_time = "wake-7am";

          case "Monday" -> wakeup_time = "wake-6am";  

          default -> wakeup_time = "wake-4am";
              
        }        
        System.out.println(wakeup_time);   
        
       //switch v3
        String day3 = "Wednesday";
        String time = "";

        time = switch (day1)
        {
          case "Sunday","Saturday" -> "wake-7am";

          case "Monday" -> "wake-6am";  

          default -> "wake-4am";
              
        };        
        System.out.println(time);
        
        //loops-while,do-while,for
        
        //while-loop
        int i = 1;


        while(i<=5/*condition*/)
       {
            System.out.println("while_loop_hi" +i);

            i++;//increment

       }    
      //do-while loop
       
       int j = 1;//initialisation

       do
       {
            System.out.println("do_while_loop"+j);//statement

            j++;  // increment/decrement

       }while(j<5);//condition

      //for-loop

       for(int k=10;k>5;k--)//(initialisation;condition;decrement)
       {
            System.out.println("for_loop" );//statements

       }

       //Enhanced For Loop (For-Each):
      int[] numbers = {5, 10, 15, 20};
      for(int num : numbers)//for(int i : range){ println(i);}
      {
          System.out.println(num);
      }


   }
}

//Naming Convention in Java

//ClassName convention
//Rule: Use PascalCase (also called CamelCase with capital first letter)
//Start with uppercase letter | Capitalize first letter of each word
//Eg  public class Student { } | public class DatabaseConnection { }

//InterfaceNamesConvention
//Rule: Use PascalCase (same as classes)
//Often use adjectives ending in "-able" or "-ible" | Or use nouns describing capability
//public interface Readable { } | public interface EventListener { } | public interface DatabaseConnection { }

//variableName convention
//Rule: Use camelCase
//Start with lowercase letter | Capitalize first letter of subsequent words | Use descriptive names
//Eg int age | String firstName

//methodName convention
//Rule: Use camelCase (same as variables)
//Use verbs to describe what the method does | Be descriptive about the action
//Eg public void calculateTotal() { } | public String getName() { }

//CONSTANT_NAMING_CONVENTION
//Rule: Use SCREAMING_SNAKE_CASE | All uppercase letters | Underscores between words
//Usually declared as static final
//public static final int MAX_SIZE = 100;
//public static final String DEFAULT_NAME = "Unknown";
//public static final double PI = 3.14159;

//package.name.convention
//Rule: Use all lowercase
//Reverse domain name convention | Use dots to separate levels
//package com.company.project; | package java.util;  | package org.example.utils;



//Element	    Convention	                Example	        Pattern
//Classes	    PascalCase	            BankAccount	        UpperCamelCase
//Interfaces	PascalCase	            Drawable	        UpperCamelCase
//Variables	    camelCase	            firstName	        lowerCamelCase
//Methods	    camelCase	            calculateTotal()	lowerCamelCase
//Constants	    SCREAMING_SNAKE_CASE	MAX_SIZE	        ALL_CAPS
//Packages	    lowercase	            com.example.utils	all.lowercase



//Special Naming Patterns

//Boolean Variables - Use question-like names:
//boolean isActive; | boolean hasPermission; | boolean canEdit;

//Getter and Setter Methods - Follow standard patterns:
//public String getName() { }        // get + PropertyName
//public void setName(String name) { } // set + PropertyName
//public boolean isActive() { }      // is + BooleanProperty

//Collection Variables - Use plural names: