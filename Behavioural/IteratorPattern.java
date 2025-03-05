// Iterator pattern is very commonly used design pattern in Java and .Net programming environment. 
// This pattern is used to get a way to access the elements of a collection object in 
// sequential manner without any need to know its underlying representation.

// Here the NameRepository class is the collection class that holds the names in an array.
// The NameIterator class is the iterator class that implements the Iterator interface.
// The NameRepository class has a method getIterator() that returns the iterator object.
// The NameIterator class has two methods hasNext() and next() that are used to iterate over the collection.

// The underlying representation of the collection can be changed in future without changing the iterator interface.
// Meaning that the iterator interface is decoupled from the collection class.
// The Iterator Interface is separated from the NameRepository class.
// The NameRepository class can be changed without changing the iterator interface.

package Behavioural;

interface Iterator {
    boolean hasNext();

    Object next();
}

class NameRepository {
    private String[] names = { "Robert", "John", "Julie", "Lora" };

    public Iterator getIterator() {
        return new NameIterator();
    }

    private class NameIterator implements Iterator {
        int index;

        @Override
        public boolean hasNext() {
            return index < names.length;
        }

        @Override
        public Object next() {
            if (this.hasNext()) {
                return names[index++];
            }
            return null;
        }
    }
}

public class IteratorPattern {
    public static void main(String[] args) {
        NameRepository namesRepository = new NameRepository();

        for (Iterator iter = namesRepository.getIterator(); iter.hasNext();) {
            String name = (String) iter.next();
            System.out.println("Name : " + name);
        }
    }
}
