package lab3.src.Aims;
public class DVD {

    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;
    private int id; // instance attribute

    private static int nbDigitalVideoDiscs = 0; //class attribute

    // Constructor 1: create by title
    public DVD (String title){
        this.title = title;
        this.category = "NA";
        this.director = "Unknown";
        this.length = 0;
        this.cost = 0.0f;

        nbDigitalVideoDiscs += 1;
        this.id = nbDigitalVideoDiscs;

    }

    // Constructor 2: Create by category, title, and cost
    public DVD(String title, String category, float cost ){
        this.title = title;
        this.category = category;
        this.director = "Unknown";
        this.length = 0;
        this.cost = cost;

        nbDigitalVideoDiscs += 1;
        this.id = nbDigitalVideoDiscs;
    }

    //Constructor 3: Create by director, category, title, and cost
    public DVD (String director, String category, String title, float cost){
       this.title = title;
        this.category = category;
        this.director = director;
        this.length = 0;
        this.cost = cost;

        nbDigitalVideoDiscs += 1;
        this.id = nbDigitalVideoDiscs;
    }

    // Constructor 4: Create by all attributes
    public DVD(String title, String category, String director, int length, float cost){
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;

        nbDigitalVideoDiscs += 1;
        this.id = nbDigitalVideoDiscs;
    }

    public void show_all_info(){
        System.out.println("title: " + this.title);
        System.out.println("category: " + this.category);
        System.out.println("director: " + this.director);
        System.out.println("length: " + this.length);
        System.out.println("cost: " + this.cost);
        System.out.println("id: " + this.id);
    }

    public String getTitle(){
        return this.title;
    }

    public String getCategory(){
        return this.category;
    }

    public String getDirector(){
        return this.director;
    }
    public int getLength(){
        return this.length;
    }

    public float getCost(){
        return this.cost;
    }

    public int getId(){
        return this.id;
    }

    public int getNumberDVD(){
        return nbDigitalVideoDiscs;
    }
    public void setTitle(String title) {
    this.title = title;
}

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }


}
