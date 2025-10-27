package lab3.src;

public class Cart {
    public static final int MAX_DVD_ORDERS = 20;
    private DVD list_DVD[] = new DVD [MAX_DVD_ORDERS];
    private int num_curr_DVD = 0;


    public void qtyOrdered(){
        System.out.println(this.num_curr_DVD);
    }

    public void add_DVD( DVD new_dvd){
        if (num_curr_DVD < MAX_DVD_ORDERS){
            list_DVD[num_curr_DVD] = new_dvd;
            num_curr_DVD++;
            System.out.println("Num DVD in the current cart " + this.num_curr_DVD+ ". Add new DVD: " + new_dvd.getTitle());
        }
        else{
            System.out.println("List of DVD is full");
        }
    }
    public void add_DVD(DVD[] newDVDList) { // METHOD OVERLOADING
    if (num_curr_DVD + newDVDList.length <= MAX_DVD_ORDERS) {
        for (int i = 0; i < newDVDList.length; i++) {
            list_DVD[num_curr_DVD] = newDVDList[i];
            num_curr_DVD++;
            System.out.println("Added DVD: " + newDVDList[i].getTitle());
        }
        System.out.println("Now cart has " + num_curr_DVD + " DVDs.");
    } else {
            System.out.println("List of DVD is full");
    }
}
    public int searchById (int id_DVD){
        int found = -1;
        for (int i = 0; i < num_curr_DVD; i++) {
        if (list_DVD[i].getId() == (id_DVD)) { // dùng equalsIgnoreCase cho tiện
            System.out.println("DVD found ");
            list_DVD[i].show_all_info(); // in ra thông tin DVD
            found = i;
            break;
        }
    }

    if (found == -1) {
        System.out.println("DVD not found");
    }

    return found;
}
    

    public int searchByTitle (String DVD_Title){
        int found = -1;
        for (int i = 0; i < num_curr_DVD; i++) {
        if (list_DVD[i].getTitle().equalsIgnoreCase(DVD_Title)) { // dùng equalsIgnoreCase cho tiện
            System.out.println("DVD found ");
            list_DVD[i].show_all_info(); // in ra thông tin DVD
            found = i;
            break;
        }
    }

    if (found == -1) {
        System.out.println("DVD not found");
    }

    return found;

    }
    public void remove_DVD(DVD dvd ){
        int index_searching_dvd = searchByTitle(dvd.getTitle());
        if (index_searching_dvd != -1){ 
            for (int i = index_searching_dvd; i < num_curr_DVD - 1; i++){
                list_DVD[i] = list_DVD[i+1];
            }
            list_DVD[num_curr_DVD - 1] = null;
            num_curr_DVD--;
            System.out.println("DVD " + dvd.getTitle() + " has been removed");
        }
        else System.out.println("DVD not found ");
    }

    public float totalCost(){
        float total = 0;
        for (int i =0; i < num_curr_DVD; i++){
            total += list_DVD[i].getCost();
        }
        return total;
    }
    
    public void printCart() {
    System.out.println("**********************CART**********************");
    if (num_curr_DVD == 0) {
        System.out.println("Cart is empty.");
        return;
    }
    for (int i = 0; i < num_curr_DVD; i++) {
        System.out.println((i+1) + ". " + list_DVD[i].getTitle() 
            + " - " + list_DVD[i].getCategory() 
            + " - " + list_DVD[i].getDirector() 
            + " - " + list_DVD[i].getLength() + " mins - $" 
            + list_DVD[i].getCost());
    }
    System.out.println(totalCost());

    System.out.println("******************************************************");
}
        
}
