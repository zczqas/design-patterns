// Observer pattern is used when there is one-to-many relationship between objects such as if one object is modified, 
// its depenedent objects are to be notified automatically.

// Observer pattern falls under behavioural pattern category.

package Behavioural;

import java.util.ArrayList;
import java.util.List;

// Observer interface
interface Observer {
    void update(String message);
}

// Concrete observer
class ConcreteObserver implements Observer {
    public String name;

    public ConcreteObserver(String name) {
        this.name = name;
    }

    // Update method to be called when subject notifies observer
    @Override
    public void update(String message) {
        System.out.println(name + " received update: " + message);
    }
}

// Subject class to be observed
class Subject {
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.addLast(observer);
    }

    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}

public class ObserverPattern {
    public static void main(String[] args) {
        Subject subject = new Subject();
        Observer ob1 = new ConcreteObserver("observer 1");
        Observer ob2 = new ConcreteObserver("observer 2");
        subject.addObserver(ob1);
        subject.addObserver(ob2);
        // Notify all observers
        subject.notifyObservers("Event occured.");
    }
}
