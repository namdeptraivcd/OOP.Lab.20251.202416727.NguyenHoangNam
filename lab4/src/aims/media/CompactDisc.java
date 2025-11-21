package lab4.src.aims.media;
import java.util.ArrayList;
import java.util.List;
public class CompactDisc extends Disc implements playable {
    private static int nbCompactDiscs = 0;
    private String artist;
    private List<Track> tracks =  new ArrayList<>();


    public CompactDisc(String title, String category, float cost, String director, float length, String artist, List<Track> tracks) {
        // Gọi constructor Disc: id, title, category, cost, length, director
        super(++nbCompactDiscs, title, category, cost, length, director);
        this.artist = artist;
        this.tracks = tracks;
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
    for ( Track track: tracks){
        track.play();
    }
}

}

