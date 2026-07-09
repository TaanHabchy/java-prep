package structures;
import java.util.*;

abstract class Borrowable extends LibraryItem{
    int checkoutDates;

    String getTitle(){
        return title;
    };

    Borrowable(int n, String t, int checkoutDates) {
        super(n, t);
        this.checkoutDates = checkoutDates;
    }
}

interface LoaningService {
    void checkout(LibraryUser user, Borrowable item);
    void returnItem(Borrowable item);
}

abstract class LibraryItem {
    int itemNumber;
    String title;

    LibraryItem(int n, String t){
        this.itemNumber = n;
        this.title = t;
    }
}

class Book extends Borrowable{
    Book(int n, String t) {
        super(n, t, 14);
    }
}

class DVD extends Borrowable{
    DVD(int n, String t) {
        super(n, t, 7);
    }
}

class Magazine extends LibraryItem {
    Magazine(int n, String t) {
        super(n, t);
    }
}

class Loan {
    private LibraryUser user;
    private Borrowable item;
    private int dueDate;

    Loan(LibraryUser user, Borrowable item){
        this.user = user;
        this.item = item;
        this.dueDate = item.checkoutDates;
    }

    LibraryUser getUser(){
        return user;
    };

    Borrowable getItem(){
        return item;
    }
}

class LoanService implements LoaningService{
    HashMap<LibraryUser, List<Loan>> userLoans = new HashMap<>();
    HashMap<Borrowable, Loan> itemLoans = new HashMap<>();

    LoanService(){
        this.userLoans = new HashMap<>();
        this.itemLoans = new HashMap<>();
    }

    public void checkout(LibraryUser user, Borrowable item){
        if (itemLoans.containsKey(item)) {
            throw new IllegalStateException("Item already checked out");
        }

        Loan loan = new Loan(user, item);

        itemLoans.put(item, loan);
        userLoans.computeIfAbsent(user, k -> new ArrayList<>()).add(loan);

        System.out.println("LibraryUser "+user.cardNumber+" checkout out "+item.title);
    }

    public void returnItem(Borrowable item){
        Loan loan = itemLoans.remove(item);
        LibraryUser user = loan.getUser();
        userLoans.get(user).remove(loan);

        System.out.println("LibraryUser "+user.cardNumber+" returned "+item.title);
    };

    public void checkUserItems(LibraryUser user){
        List<Loan> list = userLoans.get(user);
        System.out.println("The user has checked out: ");
        for (Loan loan : list){
            System.out.println("- "+loan.getItem().title);
        }

    }
}

class LibraryUser {
    final int cardNumber;

    LibraryUser(int n){
        this.cardNumber = n;
    }
}

class LibraryService {
    ArrayList<LibraryItem> catalog;

    LibraryService(Library lib){
        this.catalog = lib.catalog;
    }

    void showCatalog(){
        System.out.println("We have: ");
        for (LibraryItem item : catalog){
            System.out.println(item.title);
        }
    }
}

public class Library {
    ArrayList<Loan> loans;
    ArrayList<LibraryItem> catalog;

    Library(){
        this.loans = new ArrayList<>();
        this.catalog = new ArrayList<>();
    }

    static void main() {
        Library lib = new Library();
        LibraryService libserv = new LibraryService(lib);
        LoanService loanservice = new LoanService();
        LibraryUser user1 = new LibraryUser(1);
        LibraryUser user2 = new LibraryUser(2);

        Borrowable bible = new Book(1, "bible");
        Borrowable myantonia = new Book(2, "my antonia");
        Borrowable flies = new DVD(3, "lord of the flies");
        Magazine sportsIllustrated = new Magazine(4, "Sports Illustrated");

        lib.catalog.add(bible);
        lib.catalog.add(myantonia);
        lib.catalog.add(flies);
        lib.catalog.add(sportsIllustrated);

        libserv.showCatalog();

        // only checkout if the item is available
        loanservice.checkout(user1, bible);
        loanservice.checkout(user1, myantonia);
        loanservice.checkout(user2, flies);

        loanservice.checkUserItems(user1);

    }
}
