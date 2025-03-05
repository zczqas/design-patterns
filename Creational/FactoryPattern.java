// Factory pattern is a creational pattern that provides an interface for creating objects in a superclass, 
// but allows subclasses to alter the type of objects that will be created.

// Here, Product is an interface that defines the behavior of the objects the factory method creates.
// ConcreteProductA and ConcreteProductB are classes that implement the Product interface.

package Creational;

interface Product {
    void use();
}

class ConcreteProductA implements Product {
    public void use() {
        System.out.println("Using ConcreteProductA");
    }
}

class ConcreteProductB implements Product {
    public void use() {
        System.out.println("Using ConcreteProductB");
    }
}

class Factory {
    // Factory class has a static method createProduct that returns an instance of a
    // Product based on the type passed to it.
    public static Product createProduct(String type) {
        switch (type) {
            case "A":
                return new ConcreteProductA();
            case "B":
                return new ConcreteProductB();
            default:
                throw new IllegalArgumentException("Invalid type: " + type);
        }
    }
}

class FactoryPattern {
    public static void main(String[] args) {
        // Factory pattern is used when we have a superclass with multiple sub-classes
        // and based on input,
        // we need to return one of the sub-class.
        Product productA = Factory.createProduct("A"); // Here, we are creating an object of ConcreteProductA
        productA.use();
        Product productB = Factory.createProduct("B"); // Here, we are creating an object of ConcreteProductB
        productB.use();

        System.out.println(productA == productB); // false
    }
}