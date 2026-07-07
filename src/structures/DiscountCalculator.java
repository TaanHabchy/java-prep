package structures;

// OCP - Open/Closed Principle: Software entities should be open for extension but closed for modification
abstract class Discount { // abstract because no method body instantiation
    abstract double calculate(double amount);
}

class RegularDiscount extends Discount {
    double calculate(double amount){
        return amount * 0.1;
    }
}

class PremiumDiscount extends Discount {
    double calculate(double amount){
        return amount * 0.2;
    }
}
public class DiscountCalculator {
    public double calculateDiscount(Discount discount, double amount) {
        return discount.calculate(amount);
    }

    static void main() {
        DiscountCalculator calc = new DiscountCalculator();
        PremiumDiscount prem = new PremiumDiscount();
        RegularDiscount reg = new RegularDiscount();
        System.out.println(calc.calculateDiscount(reg, 100));
        System.out.println(calc.calculateDiscount(prem, 100));
    }
}
