package lab1.exercise_6;

import javax.swing.JOptionPane;

public class exercise_6_1 {
    public int showDialog() {
        return JOptionPane.showConfirmDialog(
                null,
                "Do you want to change to the first class ticket?",
                "Ticket Confirmation",
                JOptionPane.YES_NO_CANCEL_OPTION
        );
    }

    public void run() {
        int option = showDialog();
        JOptionPane.showMessageDialog(null,
                "You've chosen: " + (option == JOptionPane.YES_OPTION ? "Yes" : "No"));
    }



    public static void main (String[] args){
        
        new exercise_6_1().run();
    }
}
