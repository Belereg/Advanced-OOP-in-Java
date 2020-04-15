package packages;

import java.sql.Timestamp;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Audit {
    private static Audit single_instance = null;
    public String s;

    private Audit() {
        //System.out.println("Audit()");
    }

    // static method to create instance of Singleton class
    public static Audit getInstance() {
        if (single_instance == null)
            single_instance = new Audit();

        return single_instance;
    }

    public void writePersonsToFile(String t) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("audit.csv", true))) {
            bufferedWriter.write(t + ", " + timestamp);
            bufferedWriter.newLine();

        } catch (IOException e) {
            System.out.println("Could not write data to file");
            return;
        }
        System.out.println("Successfully wrote " + timestamp + "\n\n");
    }
}
