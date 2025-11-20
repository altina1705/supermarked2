package supermarked.data;

public class Vare {
    private String id;
    private String navn;
    private double pris;
    private double tilbudsPris = -1;

    public Vare(String id, String navn, double pris) {
        this.id = id;
        this.navn = navn;
        this.pris = pris;
    }

    public String getId() {
        return id;
    }

    public String getNavn() {
        return navn;
    }

    public double getPris() {
        return tilbudsPris > 0 ? tilbudsPris : pris;
    }

    public double getNormalPris() {
        return pris;
    }

    public void setTilbudsPris(double tilbudsPris) {
        this.tilbudsPris = tilbudsPris;
    }

    public boolean erTilbud() {
        return tilbudsPris > 0;
    }
}
