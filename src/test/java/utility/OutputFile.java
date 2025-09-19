package utility;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class OutputFile {

    public static void saveToCSV(Map<Integer, String> userdetails)
    {

        String filePath = "src/test/resources/outputCSVfile/output.csv";

        try (FileWriter writer = new FileWriter(filePath)) {

            for (Map.Entry<Integer, String> entry : userdetails.entrySet()) {
                writer.append(entry.getKey().toString());
                writer.append("   ");
                writer.append(entry.getValue());
                writer.append("\n");
            }

          System.out.println("Data saved to " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
