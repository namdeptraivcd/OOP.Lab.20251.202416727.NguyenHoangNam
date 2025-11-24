package lab4.src.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    private List<String> authors = new ArrayList<String>();


    public Book(String title, String category, float cost) {
        super(title, category, cost);
    }

    // Constructor with only title
    public Book(String title) {
        super(title, "N/A", 0);
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

    @Override
    public String toString(){
        String bookInfo = this.authors.isEmpty() ? "None Authors" : this.authors.size() + "authors";
        return "Book - " + super.toString() + " - " + bookInfo;
    }

    
}

