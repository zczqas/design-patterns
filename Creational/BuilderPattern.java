// Builder pattern is a creational design pattern that lets you construct complex objects step by step.
// The pattern allows you to produce different types and representations of an object using the same construction code.
package Creational;

class Computer {
    private String CPU;
    private int RAM;
    private int storage;
    private String GPU;
    private boolean isBluetoothEnabled;

    // Constructor is private to prevent direct instantiation
    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
        this.GPU = builder.GPU;
        this.isBluetoothEnabled = builder.isBluetoothEnabled;
    }

    // Static builder class
    public static class Builder {
        private String CPU;
        private int RAM;
        private int storage;
        private String GPU;
        private boolean isBluetoothEnabled;

        // Builder methods
        public Builder setCPU(String CPU) {
            this.CPU = CPU;
            return this;
        }

        public Builder setRAM(int RAM) {
            this.RAM = RAM;
            return this;
        }

        public Builder setStorage(int storage) {
            this.storage = storage;
            return this;
        }

        public Builder setGPU(String GPU) {
            this.GPU = GPU;
            return this;
        }

        public Builder setIsBluetoothEnabled(boolean isBluetoothEnabled) {
            this.isBluetoothEnabled = isBluetoothEnabled;
            return this;
        }

        // Build method
        public Computer build() {
            return new Computer(this);
        }
    }

    // toString method
    @Override
    public String toString() {
        return "Computer [CPU=" + CPU + ", RAM=" + RAM + "GB, Storage=" + storage + "GB, GPU=" + GPU
                + ", BluetoothEnabled=" + isBluetoothEnabled + "]";
    }
}

public class BuilderPattern {
    public static void main(String[] args) {
        // Builder pattern is used when we have a complex object that needs to be
        // created step by step.
        Computer myComputer = new Computer.Builder()
                .setCPU("Intel i9")
                .setRAM(32)
                .setStorage(1024)
                .setGPU("RTX 1080 Ti")
                .setIsBluetoothEnabled(false)
                .build();

        // This prints the computer configuration since we have overridden the toString
        // method in the Computer class
        System.out.println(myComputer);
    }
}