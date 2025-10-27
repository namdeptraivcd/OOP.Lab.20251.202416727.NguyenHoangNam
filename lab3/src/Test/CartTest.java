package lab3.src.Test;

import lab3.src.Aims.Cart;

import lab3.src.Aims.DVD;

public class CartTest {
    public static void main(String[] args) {

        DVD dvd1 = new DVD("hello world", "nam", 750);
        DVD dvd2 = new DVD("test", "huy", 800);
        DVD dvd3 = new DVD ("validation", "bao", 900);

        DVD[] listDVD = new DVD[3];
        listDVD[0] = dvd1;
        listDVD[1] = dvd2;
        listDVD[2] = dvd3;

        Cart cart = new Cart();
        cart.add_DVD(listDVD);
        
        // Test Search function

        cart.searchById(dvd2.getId());
        cart.searchByTitle(dvd3.getTitle());
        }
}
