import java.util.ArrayList;

public class Angajat extends Client {

  private int id;
  public int getId() {return id;}
  public void setId(int id) {this.id = id;}

  private String numeAngajat;
  public String getNumeAngajat() {return numeAngajat;}
  public void setNumeAngajat(String numeAngajat) {this.numeAngajat = numeAngajat;}

  private ArrayList<Client> clientiAngajat;
  public ArrayList<Client> getClientiAngajat() {return clientiAngajat;}
  public void setClientiAngajat(ArrayList<Client> clientiAngajat) {this.clientiAngajat = clientiAngajat;}

  public Angajat(int id, String numeAngajat, ArrayList<Client> clientiAngajat) {
    super(null,null,null);
    this.id = id;
    this.numeAngajat = numeAngajat;
    this.clientiAngajat = clientiAngajat;
  }

  public Angajat(String numeClient, String telefonClient, Masina masinaClient) {
    super(numeClient, telefonClient, masinaClient);
  }

  public void introducereClient(Client client){
    clientiAngajat.add(client);
  }
  public void stergereClient(int idClient){
    clientiAngajat.remove(idClient);
  }

}
