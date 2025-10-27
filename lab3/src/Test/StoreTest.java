package lab3.src.Test;

import lab3.src.Aims.Store;

import lab3.src.Aims.DVD;

public class StoreTest {
    public static void main(String[] args) {
        Store store = new Store();


        DVD dvd3 = new DVD("Weathering With You", "Animation", "Shinkai Makoto", 112, 90.0f);
        
        store.add_DVD(dvd3);
        store.remove_DVD(dvd3);


    }
}
