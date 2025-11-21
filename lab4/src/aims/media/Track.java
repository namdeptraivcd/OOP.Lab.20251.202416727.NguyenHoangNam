package lab4.src.aims.media;

public class Track implements playable {
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

    public void play(){
        System.out.println("Playing Track: " + this.getTitle());
        System.out.println("Track length: " + this.getLength());
    }
}
