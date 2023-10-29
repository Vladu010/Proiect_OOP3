public class Masina implements Automobile{

    private int seria;
    public int getSeria() { return seria; }

    private String marca;
    public String getMarca() { return marca; }

    private int an;
    public int getAn() { return an; }

    private String tip;
    public String getTip() { return tip; }

    public Masina(int seria, String marca, int an, String tip)
    {
        this.marca=marca;
        this.seria=seria;
        this.an=an;
        this.tip=tip;
    }

    public String toString() { return seria + " " + marca + " " + an + " " + tip; }

}