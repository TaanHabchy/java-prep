package structures;

import java.util.HashMap;

abstract class Pay{

    abstract int getAvailable();

    abstract boolean makePayment(int cost);

    boolean enoughMoney(int cost) {
        if (cost > getAvailable()) {
            System.out.println("Not enough money loser! Balance is $" + getAvailable());
            return false;
        }
        return true;
    }
}

class Card extends Pay {
    private int available;
    private boolean chip;

    public Card(int av){
        this.available = av;
        this.chip = true;
    }

    @Override
    int getAvailable() {
        return available;
    }

    @Override
    boolean makePayment(int cost){
        if (enoughMoney(cost) == false){
            return false;
        }

        if (!chip) {
            System.out.println("Chip is broken, please try another method");
            return false;
        }
//        if (cost >= this.available){
//            System.out.println("Not enough money loser! Balance is $"+this.available);
//        }
        else {
            this.available -= cost;
            System.out.println("Success! New balance is $"+this.available);
            return true;
        }
    }
}

//class Paypal implements Pay {
//    public boolean makePayment(){
//        return true;
//    }
//}
//
//class Apple implements Pay {
//
//    public boolean makePayment(){
//        return true;
//    }
//}

class Item {
    String name;
    int cost;

    Item(String name, int cost){
        this.name = name;
        this.cost = cost;
    }

    int getCost(){
        return this.cost;
    }

    String getName(){
        return this.name;
    }
}

public class PaymentProcessing {
    // needs to be able to see if the payment was processed true
    // and check how much money is in the bank,
    // as well as how many items it has, along with that item's cost
    static HashMap<String, Integer> stock = new HashMap<>();
    int cash;
    Pay method;

    public PaymentProcessing(Pay method){
        this.cash = 100;
        this.stock = stock;
        this.method = method;
    }

    void checkCash() {
        System.out.println("The store has $" + this.cash);
    }

    void showStock(PackableItem item) {
        int total = this.stock.get(item.getName());
        System.out.println("You have " + total + " " + item.getName() +"s");
    }

    int checkStock(PackableItem item) {
        int total = this.stock.get(item.getName());
        return total;
    }

    void tryPayment(PackableItem item){
        if (checkStock(item) < 0) {
            System.out.println("Out of stock sorry");
            return;
        }

        if (this.method.makePayment(item.cost) == true) {
            this.cash -= item.cost;
            this.stock.put(item.name, stock.get(item.name) - 1);
        }
    }

    static void main() {
        Card card = new Card(500);
        PaymentProcessing process = new PaymentProcessing(card);
        PackableItem mac = new PackableItem("Mac", 300);
        stock.put(mac.getName(), 2);

        process.showStock(mac);
        process.checkCash();

        process.tryPayment(mac);

        process.showStock(mac);

        process.tryPayment(mac);

        process.checkCash();
    }
}
