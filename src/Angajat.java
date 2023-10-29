import java.util.ArrayList;

public class Angajat extends Client {
  private static int nextID=0;
  private int id;

    public int getId() {return id;}
  public void setId(int id) {this.id = id;}

  private String numeAngajat;
  public String getNumeAngajat() {return numeAngajat;}
  public void setNumeAngajat(String numeAngajat) {this.numeAngajat = numeAngajat;}

  private ArrayList<Client> clientiAngajat;
  public ArrayList<Client> getClientiAngajat() {return clientiAngajat;}
  public void setClientiAngajat(ArrayList<Client> clientiAngajat) {this.clientiAngajat = clientiAngajat;}

  public Angajat( String numeAngajat) {
    super(null,null,null);
    this.id = nextID;
    this.numeAngajat = numeAngajat;
    this.clientiAngajat = new ArrayList<Client>();
    nextID++;
  }
  public Angajat( Angajat copy) {
    super(null,null,null);
    this.id =copy.id;
    this.numeAngajat =copy.numeAngajat;
    this.clientiAngajat =copy.getClientiAngajat();
  }

  public Angajat(String numeClient, String telefonClient, Masina masinaClient) {
    super(numeClient, telefonClient, masinaClient);
  }
  public int getNumarClienti(){return clientiAngajat.size();}
  public String toString(){return "ID : " + id + " Nume angajat : " + numeAngajat + " ,numar clienti : " + getNumarClienti();}
  public void introducereClient(Client client){
    clientiAngajat.add(client);
  }
  public void stergereClient(int idClient){
    clientiAngajat.remove(idClient);
  }

}
