import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AfisareAngajat {
    private JButton inserareClientButton;
    private JButton mutaClientButton;
    private JButton stergereClientButton;
    private JButton statusClientButton;
    private JTextPane dateAngajat;
    public JPanel afisareAngajat;

    public AfisareAngajat(int depID,int elemID){
        dateAngajat.setText(Service.getInstance().getDepartamente().get(depID).getAngajatiDepartament().get(elemID).toString());

        inserareClientButton.addActionListener(new ActionListener() {
            @Override//-----------------------------Window pt inserare client, apeleaza form Inseare CLient
            public void actionPerformed(ActionEvent e) {
                JFrame formSpital = new JFrame("Introducere Client");
                formSpital.setContentPane(new InsertClient(depID,elemID).inserareClient);
                formSpital.setSize(525,215);
                formSpital.setVisible(true);
                formSpital.setLocationRelativeTo(null);
            }
        });
    }
}
