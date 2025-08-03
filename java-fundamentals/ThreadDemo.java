public class ThreadDemo
    //Threads
    //A thread is lightweight subprocess
    //the smallest unit of execution that can run independently within a program
    // threads allow multiple lines of code to execute at the same time.
{
    public static void main(String[] args) throws InterruptedException
    {
        // Without threads - sequential execution
        System.out.println("=== Sequential Execution ===");

        long startTime = System.currentTimeMillis();

        int a = 4 ,b = 5;
        int add = b + a ;// task1: Executes first
        simulateWork(1000); // Simulate 1 second of work
        System.out.println("Task 1 (Add): " + add);
        int subs = b - a ;// task2: executes after task1 completes
        simulateWork(1000); // Simulate 1 second of work
        System.out.println("Task 2 (Sub): " + subs);
        int multi = b*a ;// task3: executes after task2 completes
        simulateWork(1000); // Simulate 1 second of work
        System.out.println("Task 3 (Multiply): " + multi);

        long sequentialTime = System.currentTimeMillis() - startTime;
        System.out.println("⏱️ Sequential execution time: " + sequentialTime + "ms");

        //With threads - concurrent execution
        System.out.println("\n=== Concurrent Execution with Lambda Threads ===");

        startTime = System.currentTimeMillis();

        Thread task1 = new Thread( () -> {
            System.out.println("🧠 Task 1 running on " + Thread.currentThread().getName());
            simulateWork(1000); // Simulate 1 second of work
            System.out.println("✅ Task 1 completed");
        });
        Thread task2 = new Thread( () -> {
            System.out.println("🧠 Task 2 running on " + Thread.currentThread().getName());
            simulateWork(1000); // Simulate 1 second of work
            System.out.println("✅ Task 2 completed");
        });
        Thread task3 = new Thread( () -> {
            System.out.println("🧠 Task 3 running on " + Thread.currentThread().getName());
            simulateWork(1000); // Simulate 1 second of work
            System.out.println("✅ Task 3 completed");
        });// All three tasks execute at same time

        //Start all threads
        task1.start();
        task2.start();
        task3.start();

        // Wait for completion before measuring time
        task1.join();
        task2.join();
        task3.join();

        long concurrentTime = System.currentTimeMillis() - startTime;
        System.out.println("⏱️ Concurrent execution time: " + concurrentTime + "ms");
        System.out.println("⚡ Performance improvement: " + (sequentialTime > 0 ? (sequentialTime - concurrentTime) : 0) + "ms faster");


        //Method1 : step3 - create and start threads
        System.out.println("\n=== Method 1: Extending Thread Class ===");

        MyThread threadA = new MyThread("Download Task");//Create thread objects
        MyThread threadB = new MyThread("Upload Task");
        MyThread threadC = new MyThread("Processing Task");

        threadA.start();//Start threads (calls run() method internally)
        threadB.start();
        threadC.start();

        System.out.println("All task from method1 started concurrently");

        //Method2 : step3 - create and start threads
        System.out.println("\n=== Method 2: Implementing Runnable Interface ===");

        MyTask emailTask = new MyTask("Send Emails",3 );// Create Runnable objects
        MyTask backupTask = new MyTask("Backup Database",4);
        MyTask reportTask = new MyTask("Generate Report",2);

        Thread emailThread = new Thread(emailTask);//Create Thread objects with Runnable
        Thread backupThread = new Thread(backupTask);
        Thread reportThread = new Thread(reportTask);

        emailThread.start();
        backupThread.start();
        reportThread.start();

        System.out.println("🎯 Main thread: All background tasks initiated!");

        //Demonstrating Thread Synchronization
        System.out.println("\n=== Thread Synchronization Demo ===");

        Counter counter = new Counter();
        Thread[] threadSafe = new Thread[5];// Create multiple threads that increment the counter
        for (int i = 0; i < 5; i++ )
        {
            threadSafe[i] = new Thread( () -> {
                for (int j = 0; j < 1000; j++) {
                    counter.safeIncrement();// Use synchronized method
                }
            });
            threadSafe[i].start();
        }

        //Wait for all threads to complete
        for (Thread thread : threadSafe){
            thread.join();
        }
        Thread.sleep(1000);//Give other threads time to finish printing
        System.out.println("Final count: " + counter.getCount()); // Should be 5000




    }

    //Helper method to simulate work
    private static void simulateWork(int milliseconds){
        try {
            Thread.sleep(milliseconds);
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }

    }

}

// Thread Lifecycle States
/*
    NEW → RUNNABLE → RUNNING → BLOCKED/WAITING → TERMINATED
     ↑       ↓         ↓           ↓              ↓
   Created  Ready   Executing   Suspended        Dead
*/

//State	        Description	                        When It Happens
//NEW	        Thread created but not started	    Thread t = new Thread()
//RUNNABLE	    Ready to run, waiting for CPU time	After calling t.start()
//RUNNING	    Currently executing	                Thread scheduler assigns CPU
//WAITING	    Temporarily inactive	            Waiting for resources or sleep
//TERMINATED	Thread finished execution	        run() method completes

//Creating Threads in Java - Two methods

//Method1 : Extending Thread class
class MyThread extends Thread //Step 1: Create a class that extends Thread
{
    private String taskName;

    public MyThread(String taskName)
    {
        this.taskName = taskName;
        setName(taskName + "-Thread");//Set meaningful thread name
    }

    //Step 2: Override the run() method
    @Override
    public void run()
    {
        for(int i = 1; i <= 5; i++)
        {
            System.out.println(taskName + " - Count: " + i +
                    " (Thread: " + Thread.currentThread().getName() + ")");

            try
            {
                Thread.sleep(1000);//Sleep for 1 second
            }
            catch (InterruptedException e)
            {
                System.out.println("Thread interrupted: " + e.getMessage());
            }
        }
        System.out.println(taskName + " completed!");
        // Step 3: Create and start threads(inside main method)
    }

}

//Method 2: Implementing Runnable Interface (Preferred)
class MyTask implements Runnable // // Step 1: Create a class that implements Runnable
{
    private String taskName;
    private int taskDuration;

    public MyTask(String taskName,int taskDuration)
    {
        this.taskName = taskName;
        this.taskDuration = taskDuration;
    }

    // Step 2: Implement the run() method
    @Override
    public void run()
    {
        System.out.println("Starting " + taskName + " on thread: " + Thread.currentThread().getName());

        for(int i = 1; i <= taskDuration; i++) {
            System.out.println(taskName + " - progress: " + i + "/" + taskDuration);
            try {
                Thread.sleep(800);//simulate work
            } catch (InterruptedException e) {
                System.out.println("❌ " + taskName + " was interrupted");
                return;
            }
        }
        System.out.println("✅ " + taskName + " completed successfully!");
        //Step 3: Create Thread objects and start them (inside main method )
    }
}

//Thread vs Runnable:
//Aspect	            Extending Thread	            Implementing Runnable
//Inheritance	        Cannot extend other classes	    Can extend other classes
//Code Reusability	    Tightly coupled to Thread	    More flexible and reusable
//Best Practice	        ❌ Less preferred	            ✅ Recommended approach
//Use Case	            Simple, standalone threads	    Complex applications, better design

//Important Thread Methods
//Method	        Purpose	                            Example Usage
//start()	        Begins thread execution	            thread.start()
//run()	            Contains the thread's code	        Override this method
//sleep(ms)	        Pauses thread for specified time	Thread.sleep(1000)
//join()	        Wait for thread to complete	        thread.join()
//isAlive()	        Check if thread is running	        if (thread.isAlive())
//getName()	        Get thread name	                    Thread.currentThread().getName()
//setPriority(int)	Set thread priority (1-10)	        thread.setPriority(Thread.MAX_PRIORITY)

//Thread Synchronization (Basic Concept)
//When multiple threads access shared resources,
//we need synchronization to prevent conflicts:
class Counter
{
    private int count = 0;

    //Without synchronization - can cause problems!
    public void increment()
    {
        count++; //not thread safe
    }

    //with synchronization - thread-safe
    public synchronized void safeIncrement()
    {
        count++; // Only one thread can execute this at a time
    }

    public int getCount() {
        return count;
    }
}