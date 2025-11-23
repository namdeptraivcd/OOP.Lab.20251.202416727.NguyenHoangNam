package lab4.src.aims.media;
public class DVD extends Disc implements playable {
    private static int nbDigitalVideoDiscs = 0; //class attribute


    public DVD (String title){
        this(title, "N/A", "Unknown", 0.0f, 0.0f);
    }
    public DVD(String title, String category, String director, float length, float cost){
        super(++nbDigitalVideoDiscs, title, category, cost, length, director);

    }

    public void show_all_info(){
    System.out.println("title: " + getTitle());
    System.out.println("category: " + getCategory());
    System.out.println("director: " + getDirector());
    System.out.println("length: " + getLength());
    System.out.println("cost: " + getCost());
    System.out.println("id: " + getId());
    }    
    public int getNumberDVD(){
        return nbDigitalVideoDiscs;
    }
    @Override
    public void play(){
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }

    @Override
    public String toString(){
        return "DVD: " + super.toString();
    }

}
