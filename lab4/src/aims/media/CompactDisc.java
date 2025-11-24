package lab4.src.aims.media;
import java.util.ArrayList;
import java.util.List;
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

    public void addTrack(Track track){
        if (!tracks.contains(track)){
            tracks.add(track);
            System.out.println("Add: " + track.getTitle() + " successfully");
        }
        else{
            System.out.println("Track: " + track.getTitle() + " does exist");
        }
    }


    public void addTracks(List<Track> trackList) {
    if (trackList == null || trackList.isEmpty()) {
        System.out.println("List track is null");
        return;
    }
    
    int addedCount = 0;

    
    for (Track track : trackList) {
        if (!tracks.contains(track)) {
            tracks.add(track);
            System.out.println("Add: " + track.getTitle() + " successfully");
            addedCount++;
        } else {
            System.out.println("Track '" + track.getTitle() + "' have already exist");
        }
    }


    System.out.println("Added " + addedCount + " new Tracks ");
}


    public void removeTrack(Track track){
        if (tracks.contains(track)){
            tracks.remove(track);
            System.out.println("Remove: " + track.getTitle() + " successfully");
        }
        else{
            System.out.println("Track: " + track.getTitle() + " doesn't exist");
        }
    }

    public float getLength(){
        float total = 0.0f;
        for (int i = 0; i < tracks.size(); i++){
            total += tracks.get(i).getLength();
        }
        return total;

    }
@Override
public void play(){
    if (tracks.isEmpty()) {
        System.out.println("No tracks available to play for CD: " + getTitle());
        return;
    }
    System.out.println("Playing CD: " + getTitle() + " by " + artist);
    for ( Track track: tracks){
        track.play();
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

