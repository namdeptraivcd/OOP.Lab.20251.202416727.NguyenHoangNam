package aims.store;

import aims.media.Media;
import java.util.ArrayList;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();
    
    public Store() {}
    
    public void addMedia(Media media) {
        if (!itemsInStore.contains(media)) {
            itemsInStore.add(media);
            System.out.println("Media has been added to the store: " + media.getTitle());
        } else {
            System.out.println("Media already exists in store!");
        }
    }
    
    public void removeMedia(Media media) {
        if (itemsInStore.contains(media)) {
            itemsInStore.remove(media);
            System.out.println("Media has been removed from the store: " + media.getTitle());
        } else {
            System.out.println("Media not found in store!");
        }
    }
    
    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }
    
    public Media searchByTitle(String title) {
        for (Media media : itemsInStore) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null;
    }
    
    public void printStore() {
        System.out.println("********************STORE********************");
        for (int i = 0; i < itemsInStore.size(); i++) {
            System.out.println((i + 1) + ". " + itemsInStore.get(i).toString());
        }
        System.out.println("*********************************************");
    }
}
