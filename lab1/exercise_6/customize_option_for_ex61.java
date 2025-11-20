package lab1.exercise_6;
import javax.swing.JOptionPane;



public class customize_option_for_ex61 extends exercise_6_1 {
    @Override
    public int showDialog() {
        Object[] options = {"I do", "I don't"};
        return JOptionPane.showOptionDialog(
                null,
                "Do you want to change to the first class ticket?",
                "Ticket Confirmation",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);
    }

    public static void main(String[] args) {
        new customize_option_for_ex61().run();
    }
}

