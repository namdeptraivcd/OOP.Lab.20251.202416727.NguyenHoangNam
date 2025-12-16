package aims.media;
import aims.exception.PlayerException;
public class DVD extends Disc implements playable {
    public DVD (String title){
        this(title, "N/A", "Unknown", 0.0f, 0.0f);
    }
    public DVD(String title, String category, String director, float length, float cost){
        super(title, category, cost, length, director);
    }
    @Override
    public void play() throws PlayerException{
        if (this.getLength() <= 0){
            throw new PlayerException("The DVD has the length less than or equal 0");
        }
        System.out.println("Playing DVD: " + getTitle() + " (" + getLength() + " mins)");
    }
    @Override
    public String toString(){
        return "DVD - " + super.toString();
    }
}
