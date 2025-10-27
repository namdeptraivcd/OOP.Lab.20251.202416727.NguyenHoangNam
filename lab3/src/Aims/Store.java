package lab3.src.Aims;

import lab3.src.Aims.DVD;

public class Store {
    public static final int MAX_ITEMS = 200;
    private DVD[] itemsInStore = new DVD[MAX_ITEMS];
    private int numItems = 0;


    public Store(){}

    public void add_DVD(DVD new_DVD) {
        if (numItems < MAX_ITEMS) {
            itemsInStore[numItems] = new_DVD;
            numItems++;
            System.out.println("Added DVD: " + new_DVD.getTitle() + " to the store.");
        } else {
            System.out.println("Store is full! Cannot add more DVDs.");
        }
    }

    public void remove_DVD(DVD dvd) {
        int foundIndex = -1;
        for (int i = 0; i < numItems; i++) {
            if (itemsInStore[i].getTitle().equalsIgnoreCase(dvd.getTitle())) {
                foundIndex = i;
                break;
            }
        }
        if (foundIndex != -1) {
            for (int i = foundIndex; i < numItems - 1; i++) {
                itemsInStore[i] = itemsInStore[i + 1];
            }
            itemsInStore[numItems - 1] = null;
            numItems--;
            System.out.println("Removed DVD: " + dvd.getTitle());
        } else {
            System.out.println("DVD not found in store.");
        }
    }

}
