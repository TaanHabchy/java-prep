package structures.solid;

// Dependency Inversion Principle (DIP) - High Level Modules do not depend on low level modules.
//                                        Both should depend on abstractions. Abstractions shouldn't
//                                          depend on details, details depend on abstractions.

interface Switchable {
    void turnOn();
    void turnOff();
    boolean check();
}

public class LightBulb implements Switchable{
    boolean isOn;

    public void turnOn() {
        this.isOn = true;
        System.out.println("Turned on");
    }

    public void turnOff() {
        this.isOn = false;
        System.out.println("turned off");
    }

    public boolean check() {
        return this.isOn;
    }

    static void main() {
        LightBulb lb = new LightBulb();
        Switch ls = new Switch(lb);

        ls.operate();

    }
}

class Switch {
    private Switchable dev; // now I know that any device that implements a switchable device will have the functionality of switchable

    public Switch(Switchable dev) {
        this.dev = dev;
    }

    public void operate() {
        dev.turnOn();
    }
}

