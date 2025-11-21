package lab4.src.aims.media;

public class Disc extends Media{
    private float length;
    private String director;
    private static int nbDiscs = 0;

    public Disc(int id, String title, String category, float cost, float length, String director){
        super(id, title, category, cost);
        this.length = length;
        this.director = director;
    }
    public Disc(String title) {
        super(++nbDiscs, title, "N/A", 0.0f);
        this.length = 0.0f;
        this.director = "Unknown";
    }
    public float getLength() {
        return length;
    }

    public String getDirector() {
        return director;
    }


    public void setLength(float length) {
        this.length = length;
    }

    public void setDirector(String director) {
        this.director = director;
    }
}
