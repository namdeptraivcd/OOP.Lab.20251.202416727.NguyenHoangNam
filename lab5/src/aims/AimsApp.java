package aims;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import aims.exception.PlayerException;
import aims.media.*;
import aims.screen.StoreScreenController;
import aims.store.Cart;
import aims.store.Store;

public class AimsApp extends Application {
    private static Store store;
    private static Cart cart;
    
    @Override
    public void start(Stage primaryStage) {
        try {
            store = createStore();
            cart = new Cart();
            
            testPlayMethod();
            
            java.net.URL fxmlLocation = getClass().getResource("/aims/screen/StoreScreen.fxml");
            if (fxmlLocation == null) {
                fxmlLocation = new java.io.File("src/aims/screen/StoreScreen.fxml").toURI().toURL();
            }
            
            FXMLLoader loader = new FXMLLoader(fxmlLocation);
            Parent root = loader.load();
            
            StoreScreenController controller = loader.getController();
            controller.setStoreAndCart(store, cart);
            
            Scene scene = new Scene(root, 1024, 768);
            primaryStage.setTitle("AIMS Store - FXML + Controller Pattern");
            primaryStage.setScene(scene);
            primaryStage.show();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void testPlayMethod() {
        System.out.println("\n=== TESTING PLAY METHOD WITH TRY-CATCH ===\n");
        
        for (Media media : store.getItemsInStore()) {
            if (media instanceof playable) {
                System.out.println("Testing: " + media.getTitle());
                try {
                    ((playable) media).play();
                    System.out.println("SUCCESS: " + media.getTitle() + " played successfully!\n");
                    
                } catch (PlayerException e) {
                    System.err.println("EXCEPTION CAUGHT!");
                    System.err.println("getMessage(): " + e.getMessage());
                    System.err.println("toString(): " + e.toString());
                    System.err.print("printStackTrace(): ");
                    e.printStackTrace();
                    System.err.println();
                }
            }
        }
        
        System.out.println("=== Testing CD with invalid tracks ===");
        CompactDisc testCD = new CompactDisc("Test CD", "Music", 10.0f, "Test Artist");
        testCD.addTrack(new Track("Valid Track", 3.5f));
        testCD.addTrack(new Track("Invalid Track 1", -1.0f));
        testCD.addTrack(new Track("Invalid Track 2", 0.0f));
        
        try {
            testCD.play();
        } catch (PlayerException e) {
            System.err.println("\nEXCEPTION DETAILS:");
            System.err.println("getMessage(): " + e.getMessage());
            System.err.println("toString(): " + e.toString());
            System.err.print("printStackTrace(): ");
            e.printStackTrace();
        }
        
        System.out.println("\n=== END OF TESTING ===\n");
    }
    public static Store createStore() {
        Store store = new Store();
        store.addMedia(new DVD("Suzume", "Animation", "Shinkai Makoto", 122, 19.99f));
        store.addMedia(new DVD("Your Name", "Animation", "Shinkai Makoto", 106, 18.99f));
        store.addMedia(new DVD("Spirited Away", "Animation", "Hayao Miyazaki", 125, 19.99f));
        CompactDisc cd1 = new CompactDisc("Dear Min", "Music", 40f, "MIN");
        cd1.addTrack(new Track("Loser", 3.4f));
        cd1.addTrack(new Track("Đã có em là Nhà", 3.2f));
        store.addMedia(cd1);
        store.addMedia(new CompactDisc("Your Name OST", "Music", 15.99f, "Radwimps"));
        store.addMedia(new Book("Crossing Time", "Manga", 45.00f));
        store.addMedia(new Book("Effective Java", "Programming", 50.00f));
        return store;
    }
    public static void main(String[] args) {
        launch(args);
    }
}
