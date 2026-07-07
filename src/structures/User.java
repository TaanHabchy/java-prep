package structures;

import java.io.FileWriter;
import java.io.IOException;

// SRP: A class should have only one reason to change, meaning it should have only one job or responsibility.
public class User {
    private String name;
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        System.out.println(name);
        return name;
    }

    public String getEmail() {
        System.out.println(email);
        return email;
    }

}

class FileManager {

    public void saveToFile(User user){
        // create a file with the email of the user, .txt
        // save
        // if success print success, else print error
        try (FileWriter fileWriter = new FileWriter("src/structures/"+user.getName() + ".txt")) {
            fileWriter.write("The user is " + user.getName());
            fileWriter.write("The email is " + user.getEmail());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

class Main {
    public static void main(String[] args) {
        User user = new User("John Doe", "john.doe@example.com");
        FileManager filem = new FileManager();
        filem.saveToFile(user);
    }
}
