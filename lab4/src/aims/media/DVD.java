package lab4.src.aims.media;
public class DVD extends Media  {
    // Getter & Setter cho các thuộc tính kế thừa từ Media
    public int getId() {
        return super.getId();
    }

    public void setId(int id) {
        super.setId(id);
    }

    public String getTitle() {
        return super.getTitle();
    }

    public void setTitle(String title) {
        super.setTitle(title);
    }

    public String getCategory() {
        return super.getCategory();
    }

    public void setCategory(String category) {
        super.setCategory(category);
    }

    public float getCost() {
        return super.getCost();
    }

    public void setCost(float cost) {
        super.setCost(cost);
    }

    // Getter & Setter cho các thuộc tính riêng của DVD
    public String getDirector() {
        return this.director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public float getLength() {
        return this.length;
    }

    public void setLength(float length) {
        this.length = length;
    }
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
    // Removed duplicate getter/setter methods for director and length
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

}
