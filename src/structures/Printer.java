package structures;

public interface Printer {
    void print();
}
interface Scanner {
    void scan();
}
interface Faxxer {
    void fax();
}

class BasicPrinter implements Printer{
    public void print() {
        System.out.println("printing");
    }

    public void scan() {
        System.out.println("scanning");
    }

    public void fax() {
        System.out.println("faxxing");
    }
    static void main() {
        BasicPrinter bp = new BasicPrinter();
        CoolPrinter cp = new CoolPrinter();
        bp.fax();
    }
}

class CoolPrinter implements Printer, Scanner, Faxxer{
    public void print() {
        System.out.println("printing");
    }

    public void scan() {
        System.out.println("scanning");
    }

    public void fax() {
        System.out.println("faxxing");
    }

}
