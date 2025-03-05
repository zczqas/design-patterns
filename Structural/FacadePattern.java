// Facade pattern hides the complexities of the system and provides an interface to the client using which the client can access the system.
// Abstraction is provided by the Facade class.

// Here, the ComputerFacade class is the facade that provides a simple interface to the client to start the computer.
// The ComputerFacade class uses the CPU, Memory, and HardDrive classes to start the computer.

package Structural;

class CPU {
    void start() {
        System.out.println("CPU is starting");
    }
}

class Memory {
    void load() {
        System.out.println("Memory is loading");
    }
}

class HardDrive {
    void read() {
        System.out.println("HardDrive is reading");
    }
}

class ComputerFacade {
    private CPU processor;
    private Memory ram;
    private HardDrive hd;

    public ComputerFacade() {
        this.processor = new CPU();
        this.ram = new Memory();
        this.hd = new HardDrive();
    }

    public void start() {
        processor.start();
        ram.load();
        hd.read();
        System.out.println("Computer is ready to use");
    }
}

public class FacadePattern {
    public static void main(String[] args) {
        ComputerFacade computer = new ComputerFacade();
        computer.start();
    }

}
