package lab4.src.aims;

import java.util.ArrayList;
import java.util.Arrays;

import lab4.src.aims.media.*;
import java.util.Scanner;

public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initSetup();
        
        boolean running = true;
        while (running) {
            showMenu();
            int choice = getChoice(0, 3);
            
            switch (choice) {
                case 1:
                    viewStore();
                    break;
                case 2:
                    updateStore();
                    break;
                case 3:
                    seeCart();
                    break;
                case 0:
                    System.out.println("Thank for using AIMS.");
                    running = false;
                    break;
            }
        }
        scanner.close();
    }
    
    public static void showMenu() {
        System.out.println("\nAIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    public static void storeMenu() {
        System.out.println("\nOptions: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    public static void mediaDetailsMenu() {
        System.out.println("\nOptions: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void cartMenu() {
        System.out.println("\nOptions: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }

    public static void viewStore() {
        while (true) {
            store.printStore();
            storeMenu();
            int choice = getChoice(0, 4);
            
            if (choice == 0) return;
            switch (choice) {
                case 1: seeMediaDetails(); break;
                case 2: addMediaToCart(); break;
                case 3: playMedia(); break;
                case 4: cart.printCart(); break;
            }
        }
    }

    public static void updateStore() {
        System.out.println("\nUpdate Store:");
        System.out.println("1. Add media \n 2. Remove media \n 0. Back");
        int choice = getChoice(0, 2);
        
        if (choice == 1) addMediaToStore();
        else if (choice == 2) removeMediaFromStore();
    }



    public static void seeMediaDetails() {
        System.out.print("Enter media title: ");
        Media media = store.searchByTitle(scanner.nextLine());
        
        if (media == null) {
            System.out.println("Media not found!");
            return;
        }
        
        System.out.println("\n" + media);
        while (true) {
            mediaDetailsMenu();
            int choice = getChoice(0, 2);
            
            if (choice == 0) return;
            if (choice == 1) {
                cart.addMedia(media);
                System.out.println("Added! Cart size: " + cart.getSize());
                return; 
            } else if (media instanceof playable) {
                ((playable) media).play();
            } else {
                System.out.println("Cannot play this media!");
            }
        }
    }

    public static void addMediaToCart() {
        System.out.print("Enter media title: ");
        Media media = store.searchByTitle(scanner.nextLine());
        
        if (media != null) {
            cart.addMedia(media);
            System.out.println("Added! Cart size: " + cart.getSize());
        } else {
            System.out.println("Media not found!");
        }
    }

    public static void playMedia() {
        System.out.print("Enter media title: ");
        Media media = store.searchByTitle(scanner.nextLine());
        
        if (media == null) {
            System.out.println("Media not found!");
        } else if (media instanceof playable) {
            ((playable) media).play();
        } else {
            System.out.println("Cannot play this media!");
        }
    }

    private static void addMediaToStore() {
        System.out.println("Select: 1.DVD  2.CD  3.Book");
        int type = getChoice(1, 3);
        
        System.out.print("Title: ");
        String title = scanner.nextLine();
        System.out.print("Category: ");
        String category = scanner.nextLine();
        System.out.print("Cost: ");
        float cost = getFloatInput();
        
        Media media = null;
        if (type == 1) {
            System.out.print("Director: ");
            String director = scanner.nextLine();
            System.out.print("Length: ");
            media = new DVD(title, category, director, getFloatInput(), cost);
        } else if (type == 2) {
            System.out.print("Artist: ");
            media = new CompactDisc(title, category, cost, scanner.nextLine());
        } else {
            media = new Book(title, category, cost);
        }
        
        store.addMedia(media);
    }

    private static void removeMediaFromStore() {
        store.printStore();
        System.out.print("Enter title to remove: ");
        Media media = store.searchByTitle(scanner.nextLine());
        
        if (media != null) {
            store.removeMedia(media);
        } else {
            System.out.println("Media not found!");
        }
    }

    public static void seeCart() {
        while (true) {
            cart.printCart();
            cartMenu();
            int choice = getChoice(0, 5);
            
            if (choice == 0) return;
            switch (choice) {
                case 1: filterCart(); break;
                case 2: sortCart(); break;
                case 3: removeFromCart(); break;
                case 4: playFromCart(); break;
                case 5: placeOrder(); return;
            }
        }
    }

    public static void filterCart() {
        System.out.println("Filter by: 1.ID  2.Title");
        int choice = getChoice(1, 2);
        
        Media media = null;
        if (choice == 1) {
            System.out.print("Enter ID: ");
            media = cart.searchById(getIntInput());
        } else {
            System.out.print("Enter title: ");
            media = cart.searchByTitle(scanner.nextLine());
        }
        if (media != null) System.out.println(media);
    }

    public static void sortCart() {
        System.out.println("Sort: 1.Title>Cost  2.Cost>Title");
        int choice = getChoice(1, 2);
        
        if (choice == 1) cart.sortByTitleCost();
        else cart.sortByCostTitle();
        cart.printCart();
    }

    private static void removeFromCart() {
        System.out.print("Enter title: ");
        Media media = cart.searchByTitle(scanner.nextLine());
        if (media != null) cart.removeMedia(media);
        else System.out.println("Not found!");
    }

    private static void playFromCart() {
        System.out.print("Enter title: ");
        Media media = cart.searchByTitle(scanner.nextLine());
        
        if (media == null) {
            System.out.println("Not found!");
        } else if (media instanceof playable) {
            ((playable) media).play();
        } else {
            System.out.println("Cannot play!");
        }
    }

    private static void placeOrder() {
        if (cart.getSize() == 0) {
            System.out.println("Cart is empty!");
            return;
        }
        
        System.out.printf("Order placed! Total: $%.2f\n", cart.totalCost());
        cart.clear();
    }

    public static int getChoice(int min, int max) {
        while (true) {
            try {
                System.out.print("Choice: ");
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice >= min && choice <= max) return choice;
                System.out.println("Choose " + min + "-" + max);
            } catch (NumberFormatException e) {
                System.out.println("Invalid!");
            }
        }
    }

    public static void initSetup() {
        store.addMedia(new DVD("Suzume", "Animation", "Shinkai Makoto", 122, 19.99f));
        store.addMedia(new DVD("Your Name", "Animation", "Shinkai Makoto", 106, 18.99f));
        store.addMedia(new DVD("Spirited Away", "Animation", "Hayao Miyazaki", 125, 19.99f));

        Track track01 = new Track("Loser", 3.4f);
        Track track02 = new Track("Đã có em là Nhà", 3.2f);
        Track track03 = new Track("Chẳng phải tình đầu sao đau đến thế", 4.2f);
        ArrayList<Track> tracklist = new ArrayList<>(Arrays.asList(track01, track02, track03));

        CompactDisc CD01 = new CompactDisc("Dear Min", "Music", 40f, "MIN");
        CD01.addTracks(tracklist);
        store.addMedia(CD01);
        store.addMedia(new CompactDisc("Your Name OST", "Music", 15.99f, "Radwimps"));
        store.addMedia(new Book("Crossing Time", "Manga", 45.00f));
        System.out.println("Store initialized.");
    }

    private static int getIntInput() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid!");
            }
        }
    }

    private static float getFloatInput() {
        while (true) {
            try {
                return Float.parseFloat(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid!");
            }
        }
    }
}
