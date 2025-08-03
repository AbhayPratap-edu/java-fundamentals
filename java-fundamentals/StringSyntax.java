public class StringSyntax

{
    public static void main(String[] args)
    {
        //strings are objects that belong to the java.lang.String class

        //String Declaration and Creation
        //1. String Literal (Recommended)
        String greeting = "Hello World";
        String name = "Alice";

        //2. Using new Keyword
        String str1 = new String("Hello");

        //3. From Character Arrays
        char[] charArray = {'J', 'a', 'v', 'a'};
        String str2 = new String(charArray);

        //strings are immutable
        String original = "Hello";
        String modified = original.concat("World");//Creates new string
        System.out.println(original);//still "Hello"
        System.out.println(modified);// "Hello World"

        //String Operations
        //1. Getting String Length
        String text = "java programming";
        int length = text.length();
        System.out.println("length :" +length);//output :16

        //2. Accessing Characters
        String word = "Hello";
        char firstChar = word.charAt(0); // 'H'
        char lastChar = word.charAt(word.length()-1);

        //3. Finding Substrings
        String sentence = "Learn Java Programming";
        int position = sentence.indexOf("Java"); //returns 6
        boolean contains = sentence.contains("Program");//returns true

        //String Concatenation
        String firstName = "john";
        String lastName = "doe";
        String fullName = firstName + " " + lastName;// "john doe using + operator

        String strA = "hello";
        String strB = " world";
        String result = strA.concat(strB);// "hello world"

        //Method	        Purpose                         Example
        // length()	        Get string length	            "Hello".length() → 5
        //substring(int)	Extract substring	            "Hello".substring(2) → "llo"
        //toLowerCase()	    Convert to lowercase	        "WORLD".toLowerCase() → "world"
        // toUpperCase()	Convert to uppercase	        "hello".toUpperCase() → "HELLO"
        // trim()	        Remove whitespace	            " text ".trim() → "text"
        //split()	        Split into array	            "a,b,c".split(",") → ["a", "b", "c"]
        // replace()	    Replace characters	            "Hello".replace('l', 'x') → "Hexxo"
        // charAt(int)	    Get character at index	        "Java".charAt(1) → 'a'
        //split("char")     splitString into array          text.split(" "); / text.split("[, :]");
        //compareTo()       compare 2 strings lexicographically || A.compareTo(B);
        //compareTo()       return >0 if( A > B ) | <0 if( A < B ) | 0 if both strings are equal


        String str3 = "hello"; // Stored in string pool
        String str4 = "hello";// References same object in pool
        String str5 = new String("hello");// Creates new object

        System.out.println(str3.equals(str4));//TRUE
        System.out.println(str3.equalsIgnoreCase("HELLO"));//TRUE

        //split() method breaks a string into an array of substrings
        //String[] split(String regex); regex: A regular expression pattern used as the delimiter
        //String[] split(String , int limit); limit: Optional parameter that controls the number of splits
        //Returns: An array of strings (String[]) containing the split substrings

        String data = "apple,banana,cherry";
        String[] fruits = data.split(",");//Simple Delimiter Splitting

        System.out.println("Fruits list:");
        for (String fruit : fruits)
        {
            System.out.println(fruit);
        }// Output: ["apple", "banana", "cherry", "grape"]

        String textA = "apple,banana;cherry:grape";
        String[] fruitsA = text.split("[,;:]");  // Split on comma, semicolon, or colon

        //StringBuilder and performance
        String str = "Hello";
        str = str + " World";  // Creates new String object, old "Hello" becomes garbage

        //Efficient string building
        StringBuilder sb = new StringBuilder(); //empty s
        StringBuilder sbA = new StringBuilder("hello"); //with initial text
        StringBuilder sbB = new StringBuilder(16);//initial capacity:16characters
        sbB.append("hello world");//length: 12,capacity:16
        sbB.append("how are you");//length: 25, capacity:34 auto expanded
        //New capacity = (old capacity * 2) + 2

        for (int i = 0;i<10;i++)
        {
            sbB.append("text").append(i);//modifies internal buffer,no new objects
        }

        String resultS = sbB.toString();//convert to string only when done

        // Single-threaded: Use StringBuilder
        StringBuilder sbN = new StringBuilder();

        // Multi-threaded: Use StringBuffer
        StringBuffer buffer = new StringBuffer();

        //StringBuilder chaining
        String nameG = "Ganesh";
        int age = 14;

        String chainMethod = new StringBuilder().append("name: ").append(nameG).append("Age: ").append(age).toString();
        //new StringBuilder() - Creates an empty StringBuilder
        //.append("Name: ") - Adds "Name: " to the StringBuilder
        //.append(name) - Adds the value of name variable
        //.append(", Age: ") - Adds ", Age: "
        //.append(age) - Adds the value of age variable
        //.toString() - Converts the StringBuilder to a regular String

        //STRING BUILDER METHODS
        //Method	            Purpose	               Example
        //append(String)	    Add text to end	      sb.append("Hello")
        //insert(int, String)	Insert at position	  sb.insert(5, "World")
        //delete(int, int)	    Remove characters	  sb.delete(0, 5)
        //reverse()         	Reverse content 	  sb.reverse()
        //toString()	        Convert to String	  String str = sb.toString()
        //length()          	Get current length	  int len = sb.length()
        //setLength(int)       	Set buffer length	  sb.setLength(10)


    }
}
