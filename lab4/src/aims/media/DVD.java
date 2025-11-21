package lab4.src.aims.media;
public class DVD extends Media implements playable {
    private static int nbDigitalVideoDiscs = 0; //class attribute
    private String director;
    private float length;


    // Constructor 1: create by title
    public DVD (String title){
        super(++nbDigitalVideoDiscs, title, "NA", 0.0f);
        this.director = "Unknown";
        this.length = 0;
    }

    // Constructor 2: Create by category, title, and cost
    public DVD(String title, String category, float cost ){
        super(++nbDigitalVideoDiscs, title, category, cost);
        this.director = "Unknown";
        this.length = 0;
    }

    //Constructor 3: Create by director, category, title, and cost
    public DVD (String director, String category, String title, float cost){
        super(++nbDigitalVideoDiscs, title, category, cost);
        this.director = director;
        this.length = 0;
    }

    // Constructor 4: Create by all attributes
    public DVD(String title, String category, String director, float length, float cost){
        super(++nbDigitalVideoDiscs, title, category, cost);
        this.director = director;
        this.length = length;
    }

    public void show_all_info(){
    System.out.println("title: " + getTitle());
    System.out.println("category: " + getCategory());
    System.out.println("director: " + this.director);
    System.out.println("length: " + this.length);
    System.out.println("cost: " + getCost());
    System.out.println("id: " + getId());
    }

    
    public String getDirector(){
        return this.director;
    }
    public float getLength(){
        return this.length;
    }
    
    public int getNumberDVD(){
        return nbDigitalVideoDiscs;
    }
    
    public void setDirector(String director) {
        this.director = director;
    }

    public void setLength(int length) {
        this.length = length;
    }
    @Override
    public void play(){
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }

}
