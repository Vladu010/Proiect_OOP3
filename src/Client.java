public class Client {

    private String numeClient;
    public String getNumeClient() { return numeClient; }
    public void setNumeClient(String numeClient){ this.numeClient=numeClient; }

    private String telefonClient;
    public String getTelefonClient() { return telefonClient; }
    public void setTelefonClient(String telefonClient) { this.telefonClient = telefonClient; }

    private Masina masinaClient;
    public Masina getMasinaClient() { return masinaClient; }
    public void setMasinaClient(Masina masinaClient) { this.masinaClient = masinaClient; }


    public Client(String numeClient, String telefonClient, Masina masinaClient){
        this.masinaClient=masinaClient;
        this.telefonClient=telefonClient;
        this.numeClient=numeClient;
    }
}