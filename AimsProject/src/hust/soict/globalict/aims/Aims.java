package hust.soict.globalict.aims;
import java.util.Scanner;
import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.store.Store;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Playable;

public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        store.addMedia(new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f));
        store.addMedia(new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f));
        store.addMedia(new DigitalVideoDisc("Aladin", "Animation", 18.99f));

        int choice;
        do {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    viewStore();
                    break;
                case 2:
                    updateStore();
                    break;
                case 3:
                    seeCurrentCart();
                    break;
                case 0:
                    System.out.println("Exit AIMS.");
                    break;
                default:
                    System.out.println("Invalid input.");
            }
        } 
        while (choice != 0);
    }

    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    public static void viewStore() {
        int choice;
        do {
            storeMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter media title: ");
                    String title = scanner.nextLine();
                    Media media = store.searchByTitle(title);
                    if (media != null) {
                        System.out.println(media.toString());
                        mediaDetailsMenu(media);
                    } 
                    else {
                        System.out.println("Media not found in store!");
                    }
                    break;
                case 2:
                    System.out.print("Enter media title to add: ");
                    String titleAdd = scanner.nextLine();
                    Media mediaAdd = store.searchByTitle(titleAdd);
                    if (mediaAdd != null) {
                        cart.addMedia(mediaAdd);
                    } 
                    else {
                        System.out.println("Media not found in store!");
                    }
                    break;
                case 3:
                    System.out.print("Enter media title to play: ");
                    String titlePlay = scanner.nextLine();
                    Media mediaPlay = store.searchByTitle(titlePlay);
                    if (mediaPlay != null) {
                        if (mediaPlay instanceof Playable) {
                            ((Playable) mediaPlay).play();
                        } else {
                            System.out.println("This media type cannot be played.");
                        }
                    } 
                    else {
                        System.out.println("Media not found in store!");
                    }
                    break;
                case 4:
                    seeCurrentCart();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid input.");
            }
        } 
        while (choice != 0);
    }

    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    public static void mediaDetailsMenu(Media media) {
        int choice;
        do {
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. Add to cart");
            System.out.println("2. Play");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    cart.addMedia(media);
                    break;
                case 2:
                    if (media instanceof Playable) {
                        ((Playable) media).play();
                    } 
                    else {
                        System.out.println("This media type cannot be played.");
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid input.");
            }
        } 
        while (choice != 0);
    }

    public static void updateStore() {
        System.out.println("1. Add a new DVD to store");
        System.out.println("2. Remove a media from store");
        System.out.println("0. Back");

        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
            System.out.print("Enter DVD Title: ");
            String title = scanner.nextLine();
            System.out.print("Enter DVD Category: ");
            String category = scanner.nextLine();
            System.out.print("Enter DVD Cost: ");
            float cost = scanner.nextFloat();
            store.addMedia(new DigitalVideoDisc(title, category, cost));
            System.out.println("DVD added successfully!");
        } 
        else if (choice == 2) {
            System.out.print("Enter the title of the media to remove: ");
            String title = scanner.nextLine();
            Media m = store.searchByTitle(title);
            if (m != null) {
                store.removeMedia(m);
            } 
            else {
                System.out.println("Media not found in store.");
            }
        }
    }

    public static void seeCurrentCart() {
        cart.print();
        int choice;
        do {
            cartMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    filterCart();
                    break;
                case 2:
                    sortCart();
                    break;
                case 3:
                    System.out.print("Enter media title to remove: ");
                    String titleRemove = scanner.nextLine();
                    Media mediaRemove = cart.searchByTitle(titleRemove);
                    if (mediaRemove != null) {
                        cart.removeMedia(mediaRemove);
                    } 
                    else {
                        System.out.println("Media not found in cart.");
                    }
                    break;
                case 4:
                    System.out.print("Enter media title to play: ");
                    String titlePlay = scanner.nextLine();
                    Media mediaPlay = cart.searchByTitle(titlePlay);
                    if (mediaPlay != null) {
                        if (mediaPlay instanceof Playable) {
                            ((Playable) mediaPlay).play();
                        } 
                        else {
                            System.out.println("This media type cannot be played.");
                        }
                    } 
                    else {
                        System.out.println("Media not found in cart.");
                    }
                    break;
                case 5:
                    System.out.println("An order is created."); 
                    cart = new Cart();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid input.");
            }
        } 
        while (choice != 0);
    }

    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter media in cart");
        System.out.println("2. Sort media in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }

    public static void filterCart() {
        System.out.println("1. Filter by ID");
        System.out.println("2. Filter by Title");
        System.out.println("0. Back");

        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
            System.out.print("Enter ID to filter: ");
            int id = scanner.nextInt();
            cart.searchById(id);
        } 
        else if (choice == 2) {
            System.out.print("Enter Title to filter: ");
            String title = scanner.nextLine();
            cart.searchByTitle(title);
        }
    }

    public static void sortCart() {
        System.out.println("1. Sort by Title");
        System.out.println("2. Sort by Cost");
        System.out.println("0. Back");

        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
            cart.sortByTitleCost();
        } 
        else if (choice == 2) {
            cart.sortByCostTitle();
        }
        cart.print();
    }
}