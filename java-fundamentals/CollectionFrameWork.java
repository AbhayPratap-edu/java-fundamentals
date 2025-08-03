//Collection FrameWork
// It provides a unified architecture for storing,manipulating and retrieving groups of objects efficiently
// It provides Interfaces,Implementations, and algorithms for representing and manipulating collections of objects

// Collection Framework Hierarchy
/*
                    Iterable<E>
                        |
                   Collection<E>
                    /    |    \
                List<E> Set<E> Queue<E>
                 |       |       |
            ArrayList  HashSet  PriorityQueue
            LinkedList TreeSet  LinkedList
            Vector     LinkedHashSet

         Map<K,V> (separate hierarchy)
             |
        HashMap, TreeMap, LinkedHashMap
*/

//Collection<E> - Root Interfaces for all collections except maps
//List<E> - Ordered collections that allow duplicates
//Set<E> - Collection that don't allow duplicates
//Map<K,V> - Key-Value pair mappings (separate from hierarchy)
//Iterable<E> - Allows collections to be used in for-each loops


import java.util.*;

public class CollectionFrameWork
{
    public static void main(String[] args)
    {
        //List Interface (ArrayList vs LinkedList)
        //Characteristics of List - Allow Duplicates , Indexed access
        //                         Maintains insertion order , Resizable

        //ArrayList Implementation
        System.out.println("ArrayList Implementation");
        //ArrayList is a resizable array implementation of the List interface
        // Creating ArrayList with different approaches

        List<String> fruitListA = new ArrayList<>();// Preferred - interface reference
        ArrayList<Integer> numbersListA = new ArrayList<>(20);//Initial capacity

        //Adding Elements
        fruitListA.add("Apple");    // Index 0
        fruitListA.add("Banana");   // Index 1
        fruitListA.add("Cherry");   // Index 2
        fruitListA.add("Apple");    // Index 3 - duplicates allowed

        System.out.println("ArrayList of fruits:" + fruitListA);

        // Accessing elements by index
        System.out.println("First fruit: " + fruitListA.get(0));
        System.out.println("Last fruit: " + fruitListA.get(fruitListA.size() - 1));

        //Modifying elements
        fruitListA.set(1,"BlueBerry"); // Replace element at index 1
        System.out.println("After Modification ArrayList: " + fruitListA );

        // Inserting Elements at specific position
        fruitListA.add(2,"orange"); // Insert at Index 2
        System.out.println("After insertion ArrayList: " + fruitListA);

        // Removing Elements
        fruitListA.remove("Apple"); // Removes first occurrence
        fruitListA.remove(0);      // Removes element at index 0
        System.out.println("After removal ArrayList: " + fruitListA);

        //LinkedList Implementation
        System.out.println("LinkedList Implementation");
        //LinkedList is a double-linked list implementations where
        //elements are stored in nodes with references to next and previous elements.

        LinkedList<String> taskLinkedList = new LinkedList<>();

        // LinkedList has additional methods beyond list interface
        taskLinkedList.addFirst("Wake up"); // Add to beginning
        taskLinkedList.addLast("go to sleep"); // Add to end
        taskLinkedList.add("Eat breakfast"); // Add to end ( same as addLast)
        taskLinkedList.add(1,"exercise"); // Add at index 1

        System.out.println("Task LinkedList: " + taskLinkedList);

        // LinkedList specific methods
        System.out.println("First task" + taskLinkedList.getFirst());
        System.out.println("Last task: " + taskLinkedList.getLast());

        // Using as a stack ( LIFO )
        taskLinkedList.push("Check emails"); // Add to front
        String currentTask = taskLinkedList.pop();// Remove from front
        System.out.println("Current task: " + currentTask);

        // Using as a queue (FIFO)
        taskLinkedList.offer("Meeting"); // Add to end
        String nextTask = taskLinkedList.poll(); // Remove from front
        System.out.println("Next task: " + nextTask);

        System.out.println("Remaining tasks: " + taskLinkedList);

        //ArrayList vs LinkedList Comparison
        //Aspect	                ArrayList	                LinkedList
        //Internal Structure	    Resizable array	            Doubly-linked nodes
        //Random Access	            O(1) - very fast	        O(n) - slower
        //Insertion at End	        O(1) amortized	            O(1)
        //Insertion at Beginning	O(n) - slow	                O(1) - fast
        //Insertion in Middle	    O(n)	                    O(1) if position known
        //Memory Usage	            Lower overhead	            Higher (extra node objects)
        //Cache Performance	        Better (contiguous memory)	Worse (scattered nodes)
        //Best Use Case	            Random access, iteration	Frequent insertions/deletion

        //Set Interface (HashSet vs TreeSet)
        //Characteristics of Set: No duplicates , No indexed access , Based on equals() and hashCode()

        //HashSet Implementation
        System.out.println("HashSet Implementation");
        //HashSet uses a hash table for storage, providing constant-time performance for basic operations

        Set<String> countriesSet = new HashSet<>();

        // Adding elements
        countriesSet.add("USA");
        countriesSet.add("Canada");
        countriesSet.add("Mexico");
        countriesSet.add("USA"); // Duplicate - will be ignored
        countriesSet.add("Brazil");

        System.out.println("HashSet of countries: " + countriesSet);
        System.out.println("Size of HashSet: " + countriesSet.size()); //only unique elements

        // Checking Membership
        if(countriesSet.contains("Canada")){
            System.out.println("Canada is in the set");
        }

        // Set operations
        Set<String> northAmerica = new HashSet<>();
        northAmerica.add("USA");
        northAmerica.add("Canada");
        northAmerica.add("Mexico");

        Set<String> developed = new HashSet<>();
        developed.add("USA");
        developed.add("Canada");
        developed.add("Germany");
        developed.add("Japan");

        // Union (all elements from both sets)
        Set<String> unionSet = new HashSet<>(northAmerica);
        unionSet.addAll(developed);
        System.out.println("UnionSet: " + unionSet);

        // Intersection (common elements)
        Set<String> intersectionSet = new HashSet<>(northAmerica);
        intersectionSet.retainAll(developed);
        System.out.println("IntersectionSet: " + intersectionSet);

        // Difference (elements in first but not second)
        Set<String> differenceSet = new HashSet<>(northAmerica);
        differenceSet.removeAll(developed);
        System.out.println("Difference: " + differenceSet);

        // TreeSet Implementation
        System.out.println("TreeSet Implementation");

        Set<Integer> scoresSet = new TreeSet<>();

        //  Adding elements (will be automatically sorted)
        scoresSet.add(96);
        scoresSet.add(93);
        scoresSet.add(78);
        scoresSet.add(96);// Duplicate - ignored
        scoresSet.add(85);
        scoresSet.add(88);

        System.out.println("TreeSet (sorted): " + scoresSet);

        // TreeSet specific operations
        TreeSet<Integer> sortedScores = new TreeSet<>(scoresSet);

        System.out.println("First (lowest): " + sortedScores.first());
        System.out.println("Last (highest): " + sortedScores.last());

        // Range operations
        System.out.println("Scores >= 85: " + sortedScores.tailSet(85));
        System.out.println("Scores < 90: " + sortedScores.headSet(90));
        System.out.println("Scores 80-90: " + sortedScores.subSet(80,90));

        // Navigation methods
        System.out.println("Higher than 85: " + sortedScores.higher(85));
        System.out.println("Lower than 90: " + sortedScores.lower(90));
        System.out.println("Ceiling of 87: " + sortedScores.ceiling(87));
        System.out.println("Floor of 87: " + sortedScores.floor(87));

        // HashSet vs TreeSet Comparison
        //Aspect	        HashSet	                        TreeSet
        //Ordering	        No ordering (random)	        Natural ordering (sorted)
        //Performance	    O(1) average for basic ops	    O(log n) for basic ops
        //Null Elements	    Allows one null	                Does not allow null
        //Memory Usage	    Lower	                        Higher (tree structure)
        //Interface	        Set	              |             Set + SortedSet + NavigableSet
        //Best Use Case	    Fast lookups, membership tests	Sorted data, range queries

        // Map Interface (HashMap vs TreeMap)
        // It represents key-value pair mappings
        // And is not part of Collection hierarchy
        // Characteristics of Map - Key-value pairs , Unique keys
        //                          No inheritance from Collection , Three collection views

        // HashMap Implementation
        System.out.println("HashMap Implementation");
        //HashMap uses a hash table for storage and provides constant-time performance for basic operations

        // Creating a HashMap
        Map<String, Integer> studentGrades = new HashMap<>();

        // Adding key-value pairs
        studentGrades.put("Alice",95);
        studentGrades.put("Bob",87);
        studentGrades.put("Charlie", 92);
        studentGrades.put("Diana", 88);
        studentGrades.put("Alice", 98);  // Updates Alice's grade

        System.out.println("Student grades: " + studentGrades);

        // Accessing values
        String student = "Bob";
        if(studentGrades.containsKey(student)){
            System.out.println(student + " 's grade: " + studentGrades.get(student));
        }

        // Using getOrDefault for safe access
        System.out.println("Eve's grade: " + studentGrades.getOrDefault("Eve",0));

        // Iterating through key-value pairs
        System.out.println("\nAll student grades:");
        for(Map.Entry<String, Integer> entry : studentGrades.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        //working with keys and values separately
        System.out.println("Students: " + studentGrades.keySet());
        System.out.println("Grades: " + studentGrades.values());

        // Conditional operations (Java 8+)
        studentGrades.putIfAbsent("Eve",85); // Add only if key does not exist
        studentGrades.replace("Bob",90); // Replace existing value

        System.out.println("After conditional operations: " + studentGrades);

        // Practical Example : word frequency counter
        String textDemo = "java is great java is powerful java is fun";

        Map<String, Integer> wordCount = new HashMap<>();

        for (String word : textDemo.split(" ")){
            wordCount.put(word, wordCount.getOrDefault(word,0) + 1);
        }

        System.out.println("\nWord frequencies: " + wordCount);

        // TreeMap Implementation
        System.out.println("TreeMap Implementation");
        //TreeMap uses a red-black tree and maintains keys in sorted order
        // TreeMap automatically sorts by keys

        Map<String, String> capitals = new TreeMap<>();

        capitals.put("France", "Paris");
        capitals.put("Germany", "Berlin");
        capitals.put("Italy", "Rome");
        capitals.put("Spain", "Madrid");
        capitals.put("Australia", "Canberra");

        System.out.println("Capitals (sorted by country): " + capitals);

        // TreeMap specific operations
        TreeMap<Integer, String> timeline = new TreeMap<>();

        timeline.put(2010, "Project started");
        timeline.put(2015, "First major release");
        timeline.put(2012, "Beta version");
        timeline.put(2018, "Market expansion");
        timeline.put(2020, "Global presence");

        System.out.println("Timeline (sorted by year): " + timeline);

        // Navigation methods
        System.out.println("First entry: " + timeline.firstEntry());
        System.out.println("Last entry: " + timeline.lastEntry());
        System.out.println("Entry before 2015: " + timeline.lowerEntry(2015));
        System.out.println("Entry after 2015: " + timeline.higherEntry(2015));

        // Range Operations
        System.out.println("Events 2012-2018: " + timeline.subMap(2012, 2019));
        System.out.println("Events up to 2015: " + timeline.headMap(2016));
        System.out.println("Events from 2015: " + timeline.tailMap(2015));

        //HashMap vs TreeMap Comparison
        //Aspect	        HashMap	                TreeMap
        //Ordering	        No ordering	            Natural key ordering
        //Performance	    O(1) average	        O(log n)
        //Null Keys	        One null key allowed	No null keys
        //Null Values	    Multiple null values	Multiple null values
        //Interface	        Map.	                Map + SortedMap + NavigableMap
        //Memory Usage	    Lower	                Higher (tree structure)
        //Best Use Case	    Fast lookups	        Sorted keys, range operations

        // For-Each Loop
        //for-each loop (enhanced for loop) provides a clean and simple way to iterate through arrays and collections
        //For-Each Syntax:
        /*for (dataType element : collection)
         {
            // Use element
         }*/

        System.out.println("For-Each loop demonstration");

        // For-each with List
        System.out.println("\nFor-Each with list");
        List<String> fruitsListB = Arrays.asList("Apple","Banana","Cherry");

        for (String fruit : fruitsListB){
            System.out.println("- " + fruit);
        }

        // For-each with Set
        System.out.println("\nFor-Each with Set");
        Set<Integer> numbersSetB = new HashSet<>(Arrays.asList(1,2,3,4,5));

        for (Integer number : numbersSetB){
            System.out.print(number + " " );
        }
        System.out.println();

        // For-each with Map (iterate over entries)
        System.out.println("\nFor-Each with Map(iterate over entries)");
        Map<String, Integer> ages = new HashMap<>();
        ages.put("Alice", 25);
        ages.put("Bob", 30);
        ages.put("Charlie", 35);

        for (Map.Entry<String, Integer> entry : ages.entrySet()){
            System.out.println(entry.getKey() + " is " + entry.getValue() + " years old");
        }

        // For-each with Map keys only
        System.out.println("For-each with Map keys only");
        for (String name : ages.keySet()){
            System.out.println("Name: " + name);
        }

        // For-each with Map values only
        System.out.println("For-each with Map values only");
        for (Integer age : ages.values()){
            System.out.println("Age: " + age);
        }

        // For-each with Arrays
        System.out.println(" For-each with Arrays");
        int[] scores = {66,21,45,16,745,211};
        for (int score : scores){
            System.out.println("Score: " + score);
        }

        //For-Each Limitations:
        //❌Cannot modify collection during for-each
        //❌ Cannot get index in for-each
        //✅ For-each is read-only and doesn't provide index

        //ITERATOR INTERFACE
        //it  provides a universal way to traverse collections
        // provides a universal way to traverse collections

        //Iterator Methods:
        //Method	    Purpose	                            Returns
        //hasNext()	    Checks if more elements exist       boolean
        //next()	    Returns next element	            E
        //remove()	    Removes current element (optional)	void

        System.out.println("ITERATOR INTERFACE demonstration");

        // Basic Iterator usage
        List<String> colors = new ArrayList<>();
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");
        colors.add("Yellow");

        System.out.println("Colors using Iterators: ");

        Iterator<String> iterator = colors.iterator();
        while (iterator.hasNext()){
            String color = iterator.next();
            System.out.println("Color: " + color);
        }

        // Safe removal using Iterator
        System.out.println("Removing colors starting with using Iterators" );

        iterator = colors.iterator();// Get fresh iterators
        while (iterator.hasNext()){
            String color = iterator.next();
            if (color.startsWith("G")){
                iterator.remove(); // safe removal
                System.out.println("Removed: " + color);
            }
        }
        System.out.println("Remaining colors: " + colors);

        // Iterator with Set
        System.out.println("Iterator with Set");

        Set<Integer> numbersC = new HashSet<>(Arrays.asList(1,2,3,4,5,6,7,8,9));

        System.out.println("\nRemoving even numbers from set using Iterator:");

        Iterator<Integer> numIterator = numbersC.iterator();
        while (numIterator.hasNext()){
            Integer number = numIterator.next();
            if (number % 2 == 0){
                numIterator.remove();
            }
        }
        System.out.println("Odd numbers only: " + numbersC);

        //Iterator with Map
        System.out.println("Iterator with Map");

        Map<String, Integer> scoresC = new HashMap<>();
        scoresC.put("Alice", 95);
        scoresC.put("Bob", 45);  // Failing score
        scoresC.put("Charlie", 87);
        scoresC.put("Diana", 62);
        scoresC.put("Eve", 33);   // Failing score

        System.out.println("\nRemoving failing scores (< 60) using Iterator:");

        Iterator<Map.Entry<String,Integer>> mapIterator = scoresC.entrySet().iterator();
        while (mapIterator.hasNext()){
            Map.Entry<String, Integer> entry = mapIterator.next();
            if (entry.getValue() < 60){
                System.out.println("Removing " + entry.getKey() +  " (score: " + entry.getValue() + ")");
                mapIterator.remove();
            }
        }
        System.out.println("Passing scores: " + scoresC);

        //ListIterator for Bidirectional Traversal:


        // GENERICS
        //It provides compile-time type safety
        //eliminate the need for type casting when working with collections

        // ✅ With Generics (modern way - always use this)
        List<String> stringList = new ArrayList<String>();  // Java 7-
        List<String> modernList = new ArrayList<>();        // Java 7+ Diamond operator

        modernList.add("Hello");
        modernList.add("World");

        //     No casting needed, type-safe access
        //     Generic collections with different types
        //     Custom generic methods
        //     Set with custom generic objects
        //     List with different generic types
        //     Map with generic types
        //     Nested generics
        //     Generic methods\


        //List Interface: Ordered collections with indexed access (ArrayList, LinkedList)
        //Set Interface: Unique element collections (HashSet, TreeSet)
        //Map Interface: Key-value pair mappings (HashMap, TreeMap)
        //For-each Loop: Clean iteration syntax for all collections
        //Iterator: Universal traversal with safe removal capabilities
        //Generics: Compile-time type safety and cleaner code



    }

}

