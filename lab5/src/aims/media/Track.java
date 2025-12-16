package aims.media;
import aims.exception.PlayerException;
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
    @Override
    public void play() throws PlayerException {
    if (this.getLength() <= 0) {
        throw new PlayerException("ERROR: Track length is non-positive!");
    }
    System.out.println("Playing track: " + title + " (" + length + " mins)");
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
