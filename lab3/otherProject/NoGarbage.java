package lab3.otherProject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NoGarbage {
    public static void main(String[] args) {
        String filename = "lab3/otherProject/test.txt";
        byte[] inputBytes = null;
        StringBuilder outputString = new StringBuilder();
        long startTime, endTime;

        try {
            inputBytes = Files.readAllBytes(Paths.get(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }

        startTime = System.currentTimeMillis();
        for (byte b : inputBytes) {
            outputString.append((char) b);
        }

        endTime = System.currentTimeMillis();
        System.out.println("Length of data: " + outputString.length());
        System.out.println("Execution time (NoGarbage): " + (endTime - startTime) + " ms");
    }
}
