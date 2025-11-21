package lab4.src.aims.media;

import java.util.ArrayList;
import java.util.List;


public class Book extends Media {
    private List<String> authors = new ArrayList<String>();
    private static int nbBook = 0;

    public Book(String title){
        super(++ nbBook, title, "N/A", 0);

    }

    public List<String> getAuthors() {
        return authors; 
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public void addAuthor (String authorName){
        if (!authors.contains(authorName)) {
            System.out.println("Add author: " + authorName);
        }
        else{
            System.out.println("author " + authorName + " does exist");
        }
    }

    public void removeAuthor (String authorName){
        if (authors.contains(authorName)) {
            System.out.println("remove author: " + authorName);
        }
        else{
            System.out.println("author " + authorName + " doesn't exist");
        }
    }

    
}

