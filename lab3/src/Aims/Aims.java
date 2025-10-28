package lab3.src.Aims;
import java.util.Scanner;

public class Aims {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Store store = new Store();
        Cart cart = new Cart();

        // Khởi tạo sẵn các DVD và add vào store
        DVD dvd1 = new DVD("Suzume", "Animation", "Shinkai Makoto", 100, 100.0f);
        DVD dvd2 = new DVD("Your Name", "Animation", "Shinkai Makoto", 106, 95.0f);
        DVD dvd3 = new DVD("Weathering With You", "Animation", "Shinkai Makoto", 112, 90.0f);
        DVD dvd4 = new DVD("The Garden of Words", "Animation", "Shinkai Makoto", 46, 50.0f);
        DVD dvd5 = new DVD("5 Centimeters per Second", "Animation", "Shinkai Makoto", 63, 45.0f);
        store.add_DVD(dvd1);
        store.add_DVD(dvd2);
        store.add_DVD(dvd3);
        store.add_DVD(dvd4);
        store.add_DVD(dvd5);

        System.out.println("[Store] Welcome to Store DVD!");
        boolean running = true;
        while (running) {
            System.out.println("\n[Store] What do you want?");
            System.out.println("1. Add DVD to (Cart)");
            System.out.println("2. Remove DVD from (Cart)");
            System.out.println("3. Check num current DVD in (Cart)");
            System.out.println("4. Check (Cart)");
            System.out.println("5. Search DVD by ID (Cart)");
            System.out.println("6. Search DVD by Title(Cart)");
            System.out.println("7. Check Bill (Cart)");
            System.out.println("8. Exit");
            System.out.print("[Customer]: choose option");
            int choice = -1;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("[Store] ERROR option!");
                continue;
            }
            switch (choice) {
            
                case 1:
                    System.out.print("[Store] Title DVD you want to add: ");
                    String cartTitle = sc.nextLine();

                    DVD found = null;
                    for (int i = 0; i < 200; i++) {

                        try {
                            java.lang.reflect.Field f = store.getClass().getDeclaredField("itemsInStore");
                            f.setAccessible(true);
                            DVD[] arr = (DVD[]) f.get(store);
                            if (arr[i] != null && arr[i].getTitle().equalsIgnoreCase(cartTitle)) {
                                found = arr[i];
                                break;
                            }
                        } catch (Exception e) { break; }
                    }
                    if (found != null) {
                        cart.add_DVD(found);
                    } else {
                        System.out.println("[Store] DVD not found in store!");
                    }
                    break;
                case 2:
                    System.out.print("[Store] Title of DVD you want to remove: ");
                    String cartRemoveTitle = sc.nextLine();
                    cart.remove_DVD(new DVD(cartRemoveTitle));
                    break;
                case 3:
                    System.out.print("[Store] Num DVD in Cart: ");
                    cart.qtyOrdered();
                    break;
                case 4:
                    cart.printCart();
                    break;
                case 5:
                    System.out.print("[Store] ID DVD you want to search: ");
                    int searchId = 0;
                    try { searchId = Integer.parseInt(sc.nextLine()); } catch (Exception e) {}
                    cart.searchById(searchId);
                    break;
                case 6:
                    System.out.print("[Store] Title of DVD you want to search: ");
                    String searchTitle = sc.nextLine();
                    cart.searchByTitle(searchTitle);
                    break;
                case 7:
                    System.out.printf("[Store] Total cost: $%.2f\n", cart.totalCost());
                    break;
                case 8:
                    System.out.println("[Store] Thanks you!");
                    running = false;
                    break;
                default:
                    System.out.println("[Store] Error option!");
            }
        }
        sc.close();
    }
}