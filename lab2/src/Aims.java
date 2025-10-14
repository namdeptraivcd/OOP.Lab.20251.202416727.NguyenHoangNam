package lab2.src;
import java.util.Scanner;

public class Aims {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create object Cart
        Cart cart = new Cart();


        // Create and add 20 DVDs with full information
        DVD dvd1 = new DVD("Suzume", "Animation", "Shinkai Makoto", 100, 100.0f);
        DVD dvd2 = new DVD("Your Name", "Animation", "Shinkai Makoto", 106, 95.0f);
        DVD dvd3 = new DVD("Weathering With You", "Animation", "Shinkai Makoto", 112, 90.0f);
        DVD dvd4 = new DVD("The Garden of Words", "Animation", "Shinkai Makoto", 46, 50.0f);
        DVD dvd5 = new DVD("5 Centimeters per Second", "Animation", "Shinkai Makoto", 63, 45.0f);
        DVD dvd6 = new DVD("Spirited Away", "Animation", "Hayao Miyazaki", 125, 85.0f);
        DVD dvd7 = new DVD("My Neighbor Totoro", "Animation", "Hayao Miyazaki", 86, 80.0f);
        DVD dvd8 = new DVD("Princess Mononoke", "Animation", "Hayao Miyazaki", 134, 90.0f);
        DVD dvd9 = new DVD("Howl's Moving Castle", "Animation", "Hayao Miyazaki", 119, 85.0f);
        DVD dvd10 = new DVD("Ponyo", "Animation", "Hayao Miyazaki", 101, 75.0f);
        DVD dvd11 = new DVD("The Wind Rises", "Animation", "Hayao Miyazaki", 126, 85.0f);
        DVD dvd12 = new DVD("Grave of the Fireflies", "Animation", "Isao Takahata", 89, 70.0f);
        DVD dvd13 = new DVD("The Tale of Princess Kaguya", "Animation", "Isao Takahata", 137, 80.0f);
        DVD dvd14 = new DVD("Only Yesterday", "Animation", "Isao Takahata", 118, 65.0f);
        DVD dvd15 = new DVD("Pom Poko", "Animation", "Isao Takahata", 119, 60.0f);
        DVD dvd16 = new DVD("Whisper of the Heart", "Animation", "Yoshifumi Kondo", 111, 70.0f);
        DVD dvd17 = new DVD("The Cat Returns", "Animation", "Hiroyuki Morita", 75, 65.0f);
        DVD dvd18 = new DVD("Arrietty", "Animation", "Hiromasa Yonebayashi", 94, 70.0f);
        DVD dvd19 = new DVD("When Marnie Was There", "Animation", "Hiromasa Yonebayashi", 103, 75.0f);
        DVD dvd20 = new DVD("The Boy and the Beast", "Animation", "Mamoru Hosoda", 119, 85.0f);
        DVD dvd21 = new DVD("The 21 DVD");

        // TEST FUNCTION

        System.out.println("\n############# TEST function of DVD ############\n");
        System.out.println("Title of dvd2: " + dvd2.getTitle());
        System.out.println("Category of dvd2: " + dvd2.getCategory());
        System.out.println("Director of dvd2: " + dvd2.getDirector());
        System.out.println("Length of dvd2: " + dvd2.getLength());
        System.out.println("Cost of dvd2: " + dvd2.getCost());
        

        
        
        
        
        System.out.println("########### THE CART SYSTEM ###########");

        
        // Add all 21 DVDs to the cart
        System.out.println("\n############# ADD function of Cart ############\n");


        cart.add_DVD(dvd1);
        cart.add_DVD(dvd2);
        cart.add_DVD(dvd3);
        cart.add_DVD(dvd4);
        cart.add_DVD(dvd5);
        cart.add_DVD(dvd6);
        cart.add_DVD(dvd7);
        cart.add_DVD(dvd8);
        cart.add_DVD(dvd9);
        cart.add_DVD(dvd10);
        cart.add_DVD(dvd11);
        cart.add_DVD(dvd12);
        cart.add_DVD(dvd13);
        cart.add_DVD(dvd14);
        cart.add_DVD(dvd15);
        cart.add_DVD(dvd16);
        cart.add_DVD(dvd17);
        cart.add_DVD(dvd18);
        cart.add_DVD(dvd19);
        cart.add_DVD(dvd20);
        cart.add_DVD(dvd21);


        
        // Display all DVDs
        System.out.println("\n############# SHOW_DVD function of Cart ############\n");
        cart.showAll();
        

        // Display total cost
        System.out.println("\n############# TOTAL COST function of Cart ############\n");
        System.out.printf("\nTotal cost: $%.2f\n", cart.totalCost());
        



        // Remove DVD
        System.out.println("\n############# REMOVE DVD function of Cart ############\n");
        cart.remove_DVD(dvd1);

        System.out.println("\nCart after removing Suzume:");
        cart.showAll();
        
        System.out.println("\n Try to remove a DVD that isn't in the cart");
        DVD nonExistingDVD = new DVD("Non-existing DVD");
        cart.remove_DVD(nonExistingDVD);
        
        System.out.println("\nFinal total cost: $" + cart.totalCost());
        
    }
}
        