import java.util.Arrays;

public class Array
{
    public static void main(String[] args)
    {
        //Arrays
        //1.Declaring an Array
        int[] numbers; // preferred style
        String[] fruits; // String fruits[]; c-declaration,also valid

        //Declaration + Instantiation (Empty Array)
        int[] numbers1 = new int[5]; //creates an array of 5 integers
        String[] words = new String[3];//Creates an array of 3 Strings

        //2.Declaration + Literal Initialization
        int[] numbers2 = {0,1,2,3,4};
        String[] fruit = {"apple","banana","cherry"};

        //3. Multi-step Initialization
        int[] numbers3;
        numbers3 = new int[]{10,20,30};

        //operations on arrays
        // accessing
        System.out.println(numbers2[0]);//ArrayName[index]
        //change element
        fruit[1] = "blueberry"; // ArrayName[index] = new_data

        //Checking Array Length
        System.out.println(fruit.length);  // ArrayName.length

        //Multidimensional array
        int[][] matrix = { {0,1,2}, {3,4,5} };// Array 1i-rows,2i-columns,3i-3d
        System.out.println(matrix[1][2]);  // Outputs: 6

        //copying array
        int[] source = {1, 2, 3};
        int[] dest = new int[source.length];
        System.arraycopy(source, 0, dest, 0, source.length);
        int[] dext = Arrays.copyOf(source, source.length);

        //sorting arrays
        int[] numbers_a = {20, 10, 30, 5};
        Arrays.sort(numbers_a); // numbers is now {5, 10, 20, 30}

        //3D array declaration
        //dataType[][][] arrayName; declaration
        //dataType[][][] arrayName = new dataType[size1][size2][size3]; instantiation:
        int[][][] building = new int[3][4][5]; // 3 floors, 4 rows, 5 columns each

        int[][][] data = {
                { {1, 2, 3}, {4, 5, 6}, {7, 8, 9} },
                { {10, 11, 12}, {13, 14, 15}, {16, 17, 18} },
                { {19, 20, 21}, {22, 23, 24}, {25, 26, 27} }
        };

        int value = data[0][1][2];  // Returns 6 in the example above

        //Dynamic 3D Arrays (Jagged Arrays)
        int[][][] jaggedArray = new int[3][][]; // 3 layers, but rows/columns vary

        jaggedArray[0] = new int[2][];// Layer 0: 2 rows
        jaggedArray[0][0] = new int[]{1, 2, 3}; // Row 0: 3 elements

        jaggedArray[1] = new int[3][];// Layer 1: 3 rows
        jaggedArray[1][0] = new int[]{6, 7, 8, 9}; // Row 0: 4 elements
        jaggedArray[1][1] = new int[]{10};           // Row 1: 1 element
        jaggedArray[1][2] = new int[]{11, 12};       // Row 2: 2 elements

        //Array of objects
        //array of objects as a collection of references pointing to multiple instances of a class
        //Stores references to objects, not the objects themselves
        //All elements must be of the same class type or its subclasses

        class Student
        {
            String name;
            int age;
            double gpa;

            public Student(String name,int age,double gpa)
            {
                this.name = name;
                this.age = age;
                this.gpa = gpa;
            }
        }

        //declare an array of objects
        //ClassName[] arrayName;
        Student[] students;

        // Step 1: Declare and create array
        Student[] student_set2 = new Student[3];

        // Step 2: Create individual objects
        student_set2[0] = new Student("Alice", 20, 3.8);
        student_set2[1] = new Student("Bob", 19, 3.5);
        student_set2[2] = new Student("Carol", 21, 3.9);

        //
        Student[] student_set3 =// ClassName[] ArrayName
                {
                        new Student("Alice", 20, 3.8),//creating objects
                        new Student("Bob", 19, 3.5),
                        new Student("Carol", 21, 3.9)
                };
        // Correct approach:
        student_set3[0] = new Student("Sice", 10, 3.9);  // accessing and changing objects



    }
}
