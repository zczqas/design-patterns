package Creational;

// Singleton pattern is a creational design pattern 
// that lets you ensure that a class has only one instance and provides a global point of access to that instance.

// Singleton pattern is used for logging, driver objects, caching, thread pools, database connections.

public class Singleton {
    private static Singleton instance;
    // Singleton class have a private constructor

    private Singleton() {
    } // This is a private constructor

    // This is a static method that returns the instance of the Singleton class
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public static void main(String[] args) {
        // In singleton pattern, we cannot create an object of the class using the new
        // keyword since the constructor is private

        // Singleton obj = new Singleton(); // This will give an error
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance1 == instance2); // true
    }
}
