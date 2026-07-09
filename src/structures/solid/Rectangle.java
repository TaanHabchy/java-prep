package structures.solid;

// Liskov Substitution Principle (LSP) - Subtypes must by substitutable for their
// base types without altering the correctness of the program

interface Shape {
    void getArea();
}

public class Rectangle implements Shape{
    int width;
    int height;

    void setWidth(int w){
        this.width = w;
    }

    void setHeight(int h) {
        this.height = h;
    }

    public void getArea(){
        System.out.println(this.width * this.height);
    }
}

class Square implements Shape {
    int side;

    void setWidth(int w) { //overriding the setWidth, breaks LSP
        this.side = w;
    }

    public void getArea(){
        System.out.println(this.side * this.side);
    }

    static void main() {
        Square square = new Square();
        square.setWidth(5);
        square.getArea();

        Rectangle rec = new Rectangle();
        rec.setWidth(54);
        rec.setHeight(2);
        rec.getArea();
    }

}