package structures;

import java.util.*;

// an amazon warehouse contains boxes, boxes can contain other boxes and/or items
interface Packable {
    String getType();
}

class PackableItem implements Packable {
    String name;

    PackableItem(String name){
        this.name = name;
    }

    public String getType(){
        return "item";
    }
}

public class Box implements Packable{
    ArrayList<Packable> contents;
    // also need to store the contents of the box

    Box(){
        this.contents = new ArrayList<>();
    }

    public void put(Packable pack) {
        this.contents.add(pack);
    }

    public void remove(Packable pack){
        if (this.contents.contains(pack)) {
            this.contents.remove(pack);
            System.out.println("Removed item");
        } else {
            System.out.println("Item not found in box");
        }
    }

    public int countContents() {
        System.out.println("There are "+contents.size()+" items in this box");
        return this.contents.size();
    }

    public String getType(){
        return "box";
    }

    static void main() {
        Box box1 = new Box();
        Box box2 = new Box();
        Box box3 = new Box();
        PackableItem packableItem1 = new PackableItem("Shoes");
        PackableItem packableItem2 = new PackableItem("TV");

        box1.countContents();

        box2.put(packableItem1);
        box3.put(packableItem2);
        box1.put(box3);
        box1.put(packableItem2);

        box1.countContents();
        box1.remove(box3);
        box1.remove(box3);
    }

}
