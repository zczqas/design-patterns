// Strategy Pattern: Define a family of algorithms, encapsulate each one, and make them interchangeable. 
// Strategy lets the algorithm vary independently from clients that use it.

// Here the Strategy interface is the strategy interface that has a method execute() that is implemented by the concrete strategies.
// The Addition and Multiplication classes are the concrete strategies that implement the Strategy interface.

// The Context class is the class that uses the strategy interface. 
// It has a method executeStrategy() that calls the execute() method of the strategy interface.

// Here the runtime behaviour of the Context class can be changed by changing the strategy object.

// Strategy Pattern is programming at the interface level just use a interface and do the logic below the interface.
package Behavioural;

interface Strategy {
    int execute(int a, int b);
}

class Addition implements Strategy {
    @Override
    public int execute(int a, int b) {
        return a + b;
    }
}

class Multiplication implements Strategy {
    @Override
    public int execute(int a, int b) {
        return a * b;
    }
}

// The Context class can be changed without changing the strategy interface.
class Context {
    private Strategy strategy;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public int executeStrategy(int a, int b) {
        return strategy.execute(a, b);
    }
}

public class StrategyPattern {
    public static void main(String[] args) {
        Context context = new Context();
        Addition addition = new Addition();
        Multiplication multiplication = new Multiplication();

        // The runtime behaviour of the Context class can be changed by changing the
        // strategy object.
        // Here the strategy object is changed to Addition.
        context.setStrategy(addition);
        System.out.println("Addition: " + context.executeStrategy(3, 4));

        // Here the strategy object is changed to Multiplication.
        context.setStrategy(multiplication);
        System.out.println("Multiplication: " + context.executeStrategy(3, 4));
    }
}
