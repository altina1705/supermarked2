package supermarked.kasse;

import supermarked.data.Vare;

import java.util.*;

public class Kasseapparat {

    public void printBon(Collection<Vare> kurv) {
        Map<String, Integer> antal = new HashMap<>();

        for (Vare v : kurv) {
            antal.put(v.getId(), antal.getOrDefault(v.getId(), 0) + 1);
        }

        List<Vare> unikkeVarer = new ArrayList<>();
        for (Vare v : kurv) {
            if (!unikkeVarer.contains(v)) unikkeVarer.add(v);
        }

        double total = 0;

        System.out.println("===== KASSEBON =====");

        for (Vare v : unikkeVarer) {
            int stk = antal.get(v.getId());
            double prisBrugt = v.getPris();
            double subtotal = prisBrugt * stk;

            System.out.println(v.getNavn());
            System.out.println("  " + stk + " x " + prisBrugt + " kr");

            if (v.erTilbud()) {
                double rabat = (v.getNormalPris() - v.getPris()) * stk;
                System.out.println("  Rabat: -" + rabat + " kr");
            }

            System.out.println("  I alt: " + subtotal + " kr\n");

            total += subtotal;
        }

        double moms = total * 0.25;

        System.out.println("====================");
        System.out.println("TOTAL: " + total + " kr");
        System.out.println("MOMS (25%): " + moms + " kr");
    }
}
