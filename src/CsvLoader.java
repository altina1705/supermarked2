package supermarked.data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class CsvLoader {

    public static Map<String, Vare> loadVarer(String filnavn) {
        Map<String, Vare> varer = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filnavn))) {
            br.readLine(); // Skip header
            String line;

            while ((line = br.readLine()) != null) {
                String[] arr = line.split(";");
                if (arr.length < 4) continue;

                String id = arr[0];
                String navn = arr[1];
                double pris = Double.parseDouble(arr[3]);

                varer.put(id, new Vare(id, navn, pris));
            }
        } catch (Exception e) {
            System.out.println("Fejl ved indlæsning af varer.");
        }

        return varer;
    }

    public static void loadTilbud(String filnavn, Map<String, Vare> varer) {
        try (BufferedReader br = new BufferedReader(new FileReader(filnavn))) {
            br.readLine(); // skip header
            String line;

            while ((line = br.readLine()) != null) {
                String[] arr = line.split(";");
                if (arr.length < 4) continue;

                String id = arr[0];
                double tilbudPris = Double.parseDouble(arr[3]);

                if (varer.containsKey(id)) {
                    varer.get(id).setTilbudsPris(tilbudPris);
                }
            }
        } catch (Exception e) {
            System.out.println("Fejl ved indlæsning af tilbud.");
        }
    }
}
