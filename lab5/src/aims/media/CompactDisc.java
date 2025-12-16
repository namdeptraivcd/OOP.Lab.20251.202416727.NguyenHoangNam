package aims.media;
import java.util.ArrayList;
import java.util.List;
import aims.exception.PlayerException;
import java.util.Iterator;
public class CompactDisc extends Disc implements playable {
    private String artist;
    private List<Track> tracks =  new ArrayList<Track>();
    public CompactDisc(String title, String category, float cost, String director, float length, String artist, List<Track> tracks) {
        super(title, category, cost, length, director);
        this.artist = artist;
        this.tracks = tracks;
    }
    public CompactDisc(String title, String category, float cost, String artist) {
        super(title, category, cost, 0, "Unknown");
        this.artist = artist;
    }
    public CompactDisc(String title) {
        super(title, "N/A", 0, 0, "Unknown");
        this.artist = "Unknown";
    }
    public String getArtist(){
        return this.artist;
    }
    public List<Track> getTracks() {
        return this.tracks;
    }
    public void addTrack(Track track){
        if (!tracks.contains(track)){
            tracks.add(track);
        }
    }
    public void addTracks(List<Track> trackList) {
        if (trackList == null || trackList.isEmpty()) {
            return;
        }
        for (Track track : trackList) {
            if (!tracks.contains(track)) {
                tracks.add(track);
            }
        }
    }
    public void removeTrack(Track track){
        tracks.remove(track);
    }
    public float getLength(){
        float total = 0.0f;
        for (int i = 0; i < tracks.size(); i++){
            total += tracks.get(i).getLength();
        }
        return total;
    }
@Override
public void play() throws PlayerException{
    if (this.getLength() <= 0 ) {
        throw new PlayerException("ERROR: CD length is non-positive");
    }
    
    System.out.println("Playing CD: " + this.getTitle());
    System.out.println("Artist: " + this.artist);
    System.out.println("Total tracks: " + tracks.size());
    System.out.println("========================================");
    
    int successCount = 0;
    int failCount = 0;
    StringBuilder errors = new StringBuilder();

    for (int i = 0; i < tracks.size(); i++) {
        Track track = tracks.get(i);
        System.out.print("Track " + (i + 1) + ": " + track.getTitle() + " - ");
        
        try {
            track.play();
            successCount++;
        } catch (PlayerException e) {
            failCount++;
            System.out.println("ERROR: " + e.getMessage());
            errors.append("\n  Track ").append(i + 1)
                  .append(": \"").append(track.getTitle()).append("\"")
                  .append("\n    ↳ ERROR: ").append(e.getMessage())
                  .append("\n    ↳ Length: ").append(track.getLength()).append(" mín");
        }
    }
    
    System.out.println("========================================");
    System.out.println("Playback summary: " + successCount + " succeeded, " + failCount + " failed");
    
    if (failCount > 0) {
        throw new PlayerException("Có " + failCount + " track(s) không play được:" + errors.toString());
    }
}
@Override
public String toString(){
    String track_info = this.tracks.isEmpty() ? "None tracks" : this.tracks.size() + " tracks";
    float totalLength = getLength(); 
    return "CD: ID: " + getId() + " - Title: " + getTitle() + 
           " - Category: " + getCategory() + " - Cost: " + getCost() +
           " - Director: " + getDirector() + 
           " - Length: " + totalLength + " mins" +
           " - Artist: " + this.artist + " - " + track_info;
}
}
