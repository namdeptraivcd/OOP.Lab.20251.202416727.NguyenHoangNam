package lab4.src.aims.media;

public class Track {
    private String title;
    private float length;
    public Track(String title, float length) {
        this.title = title;
        this.length = length;
    }
    
    public String getTitle() {
        return title;
    }

    public float getLength() {
        return length;
    }
}
