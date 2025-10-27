package lab3.src.Test;

import lab3.src.Aims.Aims.DVD;

public class DVD_test {
    
    public static void main(String[] args) {
        DVD dvd1 = new DVD("kimi");
        DVD dvd2 = new DVD("nawa");

        System.out.println(dvd1.getId());
        System.out.println(dvd2.getId());
        
        System.out.println(dvd1.getNumberDVD());
        System.out.println(dvd2.getNumberDVD());
    }
}
