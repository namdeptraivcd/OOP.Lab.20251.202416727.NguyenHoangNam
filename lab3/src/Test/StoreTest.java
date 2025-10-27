package lab3.src;

public class StoreTest {
    public static void main(String[] args) {
        Store store = new Store();


        DVD dvd3 = new DVD("Weathering With You", "Animation", "Shinkai Makoto", 112, 90.0f);
        
        store.add_DVD(dvd3);
        store.remove_DVD(dvd3);


    }
}
