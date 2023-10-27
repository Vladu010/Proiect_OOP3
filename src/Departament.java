import java.util.ArrayList;

public class Departament {
    private int idDepartament;
    public int getIdDepartament() {return idDepartament;}

    private String numeDepartament;
    public String getNumeDepartament() {return numeDepartament;}
    public void setNumeDepartament(String numeDepartament) {this.numeDepartament = numeDepartament;}

    private ArrayList<Angajat> angajatiDepartament;
    public ArrayList<Angajat> getAngajatiDepartament() {return angajatiDepartament;}
    public void setAngajatiDepartament(ArrayList<Angajat> angajatiDepartament) {this.angajatiDepartament = angajatiDepartament;}

    public Departament(int idDepartament, String numeDepartament, ArrayList<Angajat> angajatiDepartament) {
        this.idDepartament = idDepartament;
        this.numeDepartament = numeDepartament;
        this.angajatiDepartament = angajatiDepartament;
    }
}
