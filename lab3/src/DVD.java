package lab3.src;
public class DVD {

    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;

    // Constructor 1: create by title
    public DVD (String title){
        this.title = title;
        this.category = "NA";
        this.director = "Unknown";
        this.length = 0;
        this.cost = 0.0f;
    }

    // Constructor 2: Create by category, title, and cost
    public DVD(String title, String category, float cost ){
        this.title = title;
        this.category = category;
        this.director = "Unknown";
        this.length = 0;
        this.cost = cost;
    }

    //Constructor 3: Create by director, category, title, and cost
    public DVD (String director, String category, String title, float cost){
       this.title = title;
        this.category = category;
        this.director = director;
        this.length = 0;
        this.cost = cost;
    }

    // Constructor 4: Create by all attributes
    public DVD(String title, String category, String director, int length, float cost){
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
    }

    public void show_all_info(){
        System.out.println(this.title);
        System.out.println(this.category);
        System.out.println(this.director);
        System.out.println(this.length);
        System.out.println(this.cost);
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
        return length;
    }

    public float getCost(){
        return cost;
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
