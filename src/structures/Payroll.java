package structures;

// different types of employees, where each employee calculates rate deserved differently
interface Employee {
     // get payed, check their bank accounts, see how much PTO they have, check their benefits
    void calculatePay();
    void totalEarned();
}

interface BenefitsEligible {
    // check to see all of their benefits
    void checkPTO();
}

class Hourly implements Employee, BenefitsEligible{
    int hours;
    int totalEarned;
    int pto;

    public void submitHours(int h){
        System.out.println("Submitting "+h+" hours");
        hours+=h;
    }

    public void calculatePay(){
        if (hours > 0) {
            System.out.println("You have been payed " + (hours * 18));
            totalEarned += (hours * 18);
            this.hours = 0;
        } else {
            System.out.println("You don't have any new wages.");
        }
    }

    public void totalEarned(){
        System.out.println("Total earned is $"+totalEarned);
    }

    public void checkPTO() {
        System.out.println("You have "+pto+" days of PTO.");
    }
}

class Salary implements Employee, BenefitsEligible {
    int totalEarned;
    int pto;
    int days;

    Salary(){
        this.pto = 80;
        this.totalEarned = 15000;
        this.days = 3;
    }

    public void calculatePay(){
        System.out.println("You have earned $"+(this.days * 800));
        totalEarned += (this.days * 800);
    }

    public void totalEarned(){
        System.out.println("Total earned is $"+this.totalEarned);
    }

    public void checkPTO() {
        System.out.println("You have "+this.pto+" days of PTO.");
    }
}

public class Payroll {
    static void main() {
        Salary mark = new Salary();
        Hourly sharbel = new Hourly();
        sharbel.submitHours(40);
        sharbel.calculatePay();
        sharbel.submitHours(40);
        sharbel.totalEarned();

        mark.checkPTO();
        mark.calculatePay();
    }

}
