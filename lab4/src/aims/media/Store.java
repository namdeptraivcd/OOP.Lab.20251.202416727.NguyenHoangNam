package lab4.src.aims.media;
import java.util.ArrayList;
public class Store {


    private ArrayList<Media> itemsInStore = new ArrayList<Media>();


    public Store(){}

    public void addMedia(Media media) {
        if (media != null) {
            itemsInStore.add(media);
            System.out.println("Added media: " + media.getTitle() + " to the store.");
        } else {
            System.out.println("Cannot add null item to the store");
        }
    }

    public void removeMedia(Media media) {

        if (media == null) {
            System.out.println("Cannot remove null item from store");
            return;
            }
        
        if (itemsInStore.remove(media)) {
            System.out.println("Remove media: " + media.getTitle() + " successfully from the Store");
            }

        else {
            System.out.println("Media " + media.getTitle() + " not found in store.");
        }
    }

    public void printStore(){
        System.out.println("\n**********************STORE ITEMS**********************");
        if (itemsInStore.isEmpty()) {
            System.out.println("Store is currently empty.");
        } else {
            for (int i = 0; i < itemsInStore.size(); i++) {
                Media item = itemsInStore.get(i);
                System.out.println((i + 1) + ". " + item.toString());
            }
        }
        System.out.println("*******************************************************");
    }

}


