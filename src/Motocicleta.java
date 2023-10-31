public class Motocicleta {

    private int seriaM;
    public int getSeriaM() { return seriaM; }

    private String marcaM;
    public String getMarcaM() { return marcaM; }

    private int anM;
    public int getAnM() { return anM; }

    private String tipM;
    public String getTipM() { return tipM; }

    public Motocicleta(int seriaM, String marcaM, int anM, String tipM)
    {
        this.seriaM = seriaM;
        this.marcaM=marcaM;
        this.anM=anM;
        this.tipM=tipM;
    }

    public String toStringM() { return seriaM + " " + marcaM + " " + anM + " " + tipM; }

}
