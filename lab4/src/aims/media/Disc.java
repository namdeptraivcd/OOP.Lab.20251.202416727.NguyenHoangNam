package lab4.src.aims.media;

public class Disc extends Media{
    private float length;
    private String director;
    private static int nbDiscs = 0;

    public Disc(String title){
        super(++nbDiscs, title, "N/A", 0);
        this.length = 0;
        this.director = "Unkown";
    }
}
