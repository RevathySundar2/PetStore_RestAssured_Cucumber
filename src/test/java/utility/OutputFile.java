package utility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class OutputFile {

    public static String filePath = "src/test/resources/outputCSVfile/output.csv";

    public static void saveToCSV(Map<Integer, String> userdetails)
    {

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

    public Map<Integer, String> readFromCSV()
    {
        String line;
        Map<Integer, String> result = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while ((line = br.readLine()) != null) {
                String[] values = line.split(" "); // split by comma

                result.put(Integer.valueOf(values[0]), values[3]);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
