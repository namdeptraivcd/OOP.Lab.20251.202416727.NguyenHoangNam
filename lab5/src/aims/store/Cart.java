package aims.store;

import aims.media.Media;
import aims.exception.LimitExceededException;
import java.util.ArrayList;
import java.util.Collections;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
    
    public Cart() {}
    
    public void addMedia(Media media) throws LimitExceededException {
        if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
            throw new LimitExceededException("ERROR: The number of media has reached its limit (" + MAX_NUMBERS_ORDERED + " items)");
        }
        
        if (!itemsOrdered.contains(media)) {
            itemsOrdered.add(media);
            System.out.println("The media " + media.getTitle() + " has been added!");
        } else {
            System.out.println("The media " + media.getTitle() + " is already in the cart!");
        }
    }
    
    public void removeMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            System.out.println("The media " + media.getTitle() + " has been removed!");
        } else {
            System.out.println("The media " + media.getTitle() + " is not in the cart!");
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
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < itemsOrdered.size(); i++) {
            System.out.println((i + 1) + ". " + itemsOrdered.get(i).toString());
        }
        System.out.println("Total cost: " + totalCost() + " $");
        System.out.println("***************************************************");
    }
    
    public Media searchByID(int id) {
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                return media;
            }
        }
        return null;
    }
    
    public Media searchByTitle(String title) {
        for (Media media : itemsOrdered) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null;
    }
    
    public void sortByTitleCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
        System.out.println("Cart sorted by Title then Cost!");
    }
    
    public void sortByCostTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
        System.out.println("Cart sorted by Cost then Title!");
    }
    
    public ArrayList<Media> getItemsOrdered() {
        return itemsOrdered;
    }
    
    public void clear() {
        itemsOrdered.clear();
        System.out.println("Cart has been cleared!");
    }
}
