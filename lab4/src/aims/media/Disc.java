package lab4.src.aims.media;

public class Disc extends Media{
    private float length;
    private String director;


    public Disc(int id, String title, String category, float cost, float length, String director){
        super(id, title, category, cost);
        this.length = length;
        this.director = director;
    }
    
    public float getLength() {
        return length;
    }

    public String getDirector() {
        return director;
    }
    @Override
    public String toString(){
        return super.toString() + 
                " - " + "Director: " + this.director +
                " - " + "Length: " + this.length + "mins";

    }
}
