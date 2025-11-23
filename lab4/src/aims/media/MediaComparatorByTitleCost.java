package lab4.src.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
    @Override
    public int compare(Media media1, Media media2) {
        return Comparator
                .comparing(Media::getTitle)
                .thenComparing(Media::getCost, Comparator.reverseOrder())
                .compare(media1, media2);
    }
}