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
        users.add(new User("Henni32", "password", "Henry", "Hoover", 4, true));
        users.add(new User("les10", "password1", "Lesley", "Hanover", 5, false));
        users.add(new User("kyl0", "r3n", "Kilo", "Ren", 6, false));
        users.add(new User("oil43", "drowssap", "oliver", "Tree", 7, true));
        return users;
    }

    public static void getAlbums(){
        Albums[] albums = new Albums[10];
        albums[0] = new Albums(1, "Gold-Diggers Sound", "Leon Bridges", 9.99, 20);
        albums[1] = new Albums(2, "30", "Adele", 12.99, 45);
        albums[2] = new Albums(3, "I Had The Blues But I Shook Them Loose", "Bombay Bicycle Club",
                11.99, 11);
        albums[3] = new Albums(4, "DJ-Kicks [DJ Mix]", "Peggy Gou", 8.99, 2);
        albums[4] = new Albums(5, "Nectar", "Joji", 15.00, 5);
        albums[5] = new Albums(6, "This is All Yours", "Alt-j", 5.99, 14);
        albums[6] = new Albums(7, "Dark Eyes", "Half Moon Run", 8.50, 12);
        albums[7] = new Albums(8, "Portals", "Sub Focus", 9.50, 45);
        albums[8] = new Albums(9, "Zipper Down", "Eagles Of Death Metal", 4.99, 6);
        albums[9] = new Albums(10, "Hunky Dory", "David Bowie", 11.05, 5);
    }

    public void checkDetails() {
        System.out.println("Please enter your Username");
        String username = new Scanner(System.in).nextLine();
        System.out.println("Please enter your password");
        String password = new Scanner(System.in).nextLine();
        for (User u : users) {
            if (username.equalsIgnoreCase(u.username)&&password.equals(u.password)) {
                    MainMenu mm = new MainMenu();
                    Initialise init = new Initialise();
                    Initialise.writeData(mm.albums);
                    mm.getData();
                    break;

            }
            else {
                System.out.println("Incorrect details entered, please try again.");
            }
        }
    }

}