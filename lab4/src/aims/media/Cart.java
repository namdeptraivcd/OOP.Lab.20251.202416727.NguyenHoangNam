package lab4.src.aims.media;
import java.util.ArrayList;
public class Cart {
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();





    public void addMedia( Media newMedia){
        if (newMedia != null){
            itemsOrdered.add(newMedia);
            System.out.println("Add media: " + newMedia.getTitle() + "successfully ");
        }
        else{
            System.out.println("Cannot add");
        }
    }

    public void addMedia(Media newMedia1, Media newMedia2) {

    if (newMedia1 != null && newMedia2 != null) {
        
        itemsOrdered.add(newMedia1);
        itemsOrdered.add(newMedia2);

        System.out.println("Added media: " + newMedia1.getTitle() + " and " + newMedia2.getTitle() + " successfully.");
    } else {
        System.out.println("Cannot add: One or both media objects are null.");
    }
}

    public void addMedia(Media[] mediaList) { // METHOD OVERLOADING

        if (mediaList == null){
            System.out.println("cannot add");
            return;
        }
        int count = 0;
        for (Media media: mediaList){
            if (media != null){
                itemsOrdered.add(media);
                System.out.println("Add media: " + media.getTitle());
                count ++;
        }

    }
    System.out.println("Add: " + count + " to cart");
    }


    public Media searchById (int id_media){
        for (Media item : itemsOrdered) {
            if (item.getId() == (id_media)) { 
                System.out.println("Media found by ID " + item.getTitle());
                return item;
        }
    }
        System.out.println("Media not found");
        return null;
    }


    public Media searchByTitle (String mediaTitle){
        for (Media item : itemsOrdered) {
        if (item.getTitle().equalsIgnoreCase(mediaTitle)) { 
            System.out.println("Media found " + item.getTitle());
            return item;
        }
    }

        System.out.println("DVD not found");
        return null;

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

    public float totalCost(){
        float total = 0;
        for (Media media: itemsOrdered){
            total += media.getCost();
        }
        return total;
    }
    

    public void printCart() {
        System.out.println("**********************CART**********************");
        if (itemsOrdered.isEmpty() ) {
            System.out.println("Cart is empty.");
            System.out.println("******************************************************");
            return;
        }

        System.out.println("Ordered Items:");
        for (int i = 0; i < itemsOrdered.size(); i++) {
            Media item = itemsOrdered.get(i);
            System.out.println((i + 1) + ". " + item.toString()); 
        }
        
        System.out.printf("Total Cost: $%.2f%n", totalCost());
        System.out.println("******************************************************");
    }
}