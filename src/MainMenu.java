import java.util.ArrayList;
import java.util.Scanner;

public class MainMenu {

    ArrayList<Albums> albums = new ArrayList<>();
    private boolean exit = false;

    public void getData() {
        Initialise init = new Initialise();
        albums = init.getAlbum(init.readFile(Initialise.albumFile));
        while(!exit)
            menu();
    }


    public void menu() {
        System.out.println("Please select an option from the list below:");
        System.out.println("1 - View our Products");
        System.out.println("2 - Add a new album");
        System.out.println("3 - Edit an album in the store");
        System.out.println("4 - Remove an album");
        System.out.println("5 - Exit");
        int choice = Integer.parseInt(new Scanner(System.in).nextLine());
        handleChoice(choice);
    }

    private void handleChoice(int choice) {
        switch (choice) {

            case 1:
                displayProducts();
                break;

            case 2:
                addAlbum();
                break;

            case 3:
                editAlbum();
                break;

            case 4:
                removeAlbum();
                break;

            case 5:
                exitApplication();
                break;

            default:
                System.out.println("Invalid input provided, please try again");
                break;
        }
    }

    private void removeAlbum() {
        System.out.println("Please select the item you want to remove:");
        int count = 1;
        for (Albums a : albums) {
            System.out.println(count + " - " + a.albumTitle);
            count++;
        }
        int choice = Integer.parseInt(new Scanner(System.in).nextLine());
        albums.remove(choice - 1);
    }

    private void editAlbum() {
        System.out.println("Please enter the ID of the product you want to edit");
        int id = Integer.parseInt(new Scanner(System.in).nextLine());
        Albums editAlbum = null;
        for (Albums a : albums) {
            if (a.albumID == id) {
                editAlbum = a;
                break;
            }
        }
        System.out.println("Which field do you want to change?");
        System.out.println("1 - ID");
        System.out.println("2 - Manufacturer");
        System.out.println("3 - Name");
        System.out.println("4 - Price");
        System.out.println("5 - Stock");
        int choice = Integer.parseInt(new Scanner(System.in).nextLine());
        System.out.println("Please enter the new value:");
        if (editAlbum != null) {
            if (choice == 1) {
                editAlbum.albumID = Integer.parseInt(new Scanner(System.in).nextLine());
            }
            else if (choice == 2) {
                editAlbum.albumTitle = new Scanner(System.in).nextLine();
            }
            else if (choice == 3) {
                editAlbum.albumArtist = new Scanner(System.in).nextLine();
            }
            else if (choice == 4) {
                editAlbum.albumPrice = Double.parseDouble(new Scanner(System.in).nextLine());
            }
            else if (choice == 5) {
                editAlbum.albumStock = Integer.parseInt(new Scanner(System.in).nextLine());
            }
            else {
                System.out.println("Invalid input provided, please try again.");
                editAlbum();
            }
        }
    }

    private void addAlbum() {
        System.out.println("Please enter the product details.");
        System.out.println("Product ID: ");
        int albumID = Integer.parseInt(new Scanner(System.in).nextLine());
        System.out.println("Album Title: ");
        String albumTitle = new Scanner(System.in).nextLine();
        System.out.println("Album Artist: ");
        String albumArtist = new Scanner(System.in).nextLine();
        System.out.println("Album Price: ");
        double albumPrice = Double.parseDouble(new Scanner(System.in).nextLine());
        System.out.println("Quantity in Stock: ");
        int albumStock = Integer.parseInt(new Scanner(System.in).nextLine());
        albums.add(new Albums(albumID, albumTitle, albumArtist, albumPrice, albumStock));
    }

    private void exitApplication() {
        Initialise.writeData(albums);
        albums.clear();
        exit = true;
    }

    private void displayProducts() {
        for (Albums a : albums) {
            System.out.println("ID: " + a.albumID + " - title: " + a.albumTitle + " - artist: " + a.albumArtist
                    + " - price: " + a.albumPrice + " - Current Stock: " + a.albumStock);
        }
    }
}
