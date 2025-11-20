package supermarked;

import supermarked.data.*;
import supermarked.kasse.Kasseapparat;
import supermarked.robot.Robot;

import java.util.Collection;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Map<String, Vare> varer = CsvLoader.loadVarer("data/varer.csv");
        CsvLoader.loadTilbud("data/tilbud.csv", varer);

        Robot robot = new Robot();
        Collection<Vare> kurv = robot.fyldIKurv(varer.values());

        Kasseapparat kasse = new Kasseapparat();
        kasse.printBon(kurv);
    }
}
