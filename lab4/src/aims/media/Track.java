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
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Track track = (Track) obj;
        return this.title.equals(track.title) && 
               (this.length == track.length);
    }
}
