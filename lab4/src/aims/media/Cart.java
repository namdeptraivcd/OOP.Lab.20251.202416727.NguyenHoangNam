package lab4.src.aims.media;

import java.util.ArrayList;
import java.util.Collections;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();


    public ArrayList<Media> getItemsOrdered() {
        return itemsOrdered;
    }


    public void addMedia(Media newMedia) {
        if (newMedia == null) {
            System.out.println("Cannot add null media.");
            return;
        }
        
        if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
            System.out.println("Cart is full. Cannot add more items.");
            return;
        }
        
        itemsOrdered.add(newMedia);
        System.out.println("Added media: " + newMedia.getTitle() + " successfully.");
    }


    public void removeMedia(Media media) {
        if (media == null) {
            System.out.println("Cannot remove null item.");
            return;
        }
        
        if (itemsOrdered.remove(media)) {
            System.out.println("Media removed successfully: " + media.getTitle());
        } else {
            System.out.println("Media not found in cart: " + media.getTitle());
        }
    }


    public float totalCost() {
        float total = 0;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }


    public void printCart() {
        System.out.println("\n**********************CART**********************");
        if (itemsOrdered.isEmpty()) {
            System.out.println("Cart is empty.");
            System.out.println("************************************************");
            return;
        }

        System.out.println("Ordered Items:");
        for (int i = 0; i < itemsOrdered.size(); i++) {
            Media item = itemsOrdered.get(i);
            System.out.println((i + 1) + ". " + item.toString());
        }
        
        System.out.printf("Total Cost: $%.2f%n", totalCost());
        System.out.println("************************************************");
    }


    public Media searchById(int id) {
        for (Media item : itemsOrdered) {
            if (item.getId() == id) {
                System.out.println("Media found by ID: " + item.getTitle());
                return item;
            }
        }
        System.out.println("Media not found with ID: " + id);
        return null;
    }


    public Media searchByTitle(String title) {
        for (Media item : itemsOrdered) {
            if (item.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Media found: " + item.getTitle());
                return item;
            }
        }
        System.out.println("Media not found with title: " + title);
        return null;
    }


    public void sortMediaByTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
        System.out.println("Cart sorted by title then cost.");
    }


    public void sortMediaByCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
        System.out.println("Cart sorted by cost then title.");
    }


    public int getSize() {
        return itemsOrdered.size();
    }


    public void clear() {
        itemsOrdered.clear();
        System.out.println("Cart has been cleared.");
    }


    public void sortByTitleCost() {
        sortMediaByTitle();
    }


    public void sortByCostTitle() {
        sortMediaByCost();
    }
}