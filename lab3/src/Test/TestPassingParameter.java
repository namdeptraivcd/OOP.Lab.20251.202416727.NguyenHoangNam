package lab3.src;

public class TestPassingParameter {

    public static void swap (Object o1, Object o2){
        Object tmp = o1;
        o1 = o2;
        o2 = tmp;
    }

    public static void changeTitle(DVD dvd, String title){
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);
        dvd = new DVD (oldTitle);
    }
    public static void main(String[] args) {
        DVD jungleDVD = new DVD("jungle");
        DVD cinderellaDVD = new DVD ("cinderella");

        swap(jungleDVD, cinderellaDVD);

        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("cinderella dvd title: "+ cinderellaDVD.getTitle());

        changeTitle(jungleDVD, cinderellaDVD.getTitle());
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
    }


}
