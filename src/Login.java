import com.sun.tools.javac.Main;
import java.util.ArrayList;
import java.util.Scanner;

public class Login {

    ArrayList<User> users;

    public static void main(String[] args) {
        Login login = new Login();
        login.users = login.getUsers();
        while(true)
            login.checkDetails();
    }

    public ArrayList<User> getUsers(){
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("Char1803", "pass123", "Charlotte", "Ripley", 1, true));
        users.add(new User("Lukey110", "123pass", "Luke", "Young", 2, true));
        users.add(new User("Morga2903", "pa123ss", "Morgan", "Elanor", 3, false));
        return users;
    }

    public void checkDetails(){
        System.out.println("Please enter your Username");
        String username = new Scanner(System.in).nextLine();
        System.out.println("Please enter your password");
        String password = new Scanner(System.in).nextLine();
        for(User u : users) {
            if (username.equals(u.username)) {
                if (password.equals(u.password)) {
                    MainMenu mm = new MainMenu();
                    mm.getData();
                    break;
                }
            }
            System.out.println("Incorrect details, please try again.");
        }
    }
}