package lab4.src.aims.media;

import java.util.Comparator;

public abstract class Media {
    private static int nbMedia = 0; 
    private int id;
    private String title;
    private String category;
    private float cost;
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

    public Media(String title, String category, float cost){
        this.id = ++nbMedia;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }
    
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public float getCost() {
        return cost;
    }



    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Media media = (Media) obj;

        return this.title.equals(media.title);  
    }

    public String toString(){
        return "ID: " + this.id +
                " - " + "Title: " + this.title +
                " - " + "Category: " + this.category +
                " - " + "Cost: " + this.cost;
    }


}

