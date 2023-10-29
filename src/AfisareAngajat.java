import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AfisareAngajat {
    private JButton inserareClientButton;
    private JButton mutaClientButton;
    private JButton stergereClientButton;
    private JButton statusClientButton;
    private JTextPane dateAngajat;
    public JPanel afisareAngajat;
    private JPanel listPanel;


    public AfisareAngajat(int depID,int elemID){
        String[] listElems = new String[100];
        final JList list = new JList(listElems);
        final JScrollPane pane = new JScrollPane(list);

        dateAngajat.setText(Service.getInstance().getDepartamente().get(depID).getAngajatiDepartament().get(elemID).toString());

        inserareClientButton.addActionListener(new ActionListener() {
            @Override//-----------------------------Window pt inserare client, apeleaza form Inseare CLient
            public void actionPerformed(ActionEvent e) {
                JFrame formSpital = new JFrame("Introducere Client");
                formSpital.setContentPane(new InsertClient(depID,elemID).inserareClient);
                formSpital.setSize(525,215);
                formSpital.setVisible(true);
                formSpital.setLocationRelativeTo(null);
                statusClientButton.doClick();

            }
        });

        statusClientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    DefaultListModel<String> listModel = new DefaultListModel<>();
                    for (int i = 0; i < Service.getInstance().getDepartamente().get(depID).getAngajatiDepartament().get(elemID).getClientiAngajat().size(); i++) {
                        listModel.addElement(Service.getInstance().getDepartamente().get(depID).getAngajatiDepartament().get(elemID).getClientiAngajat().get(i).toString());
                    }
                    list.setModel(listModel);
                    listPanel.removeAll();
                    listPanel.setLayout(new BorderLayout());
                    listPanel.add(pane, BorderLayout.CENTER);
                    listPanel.revalidate();
                dateAngajat.setText(Service.getInstance().getDepartamente().get(depID).getAngajatiDepartament().get(elemID).toString());

            }

        });

        stergereClientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedElem = "";
                int selectedIndices[] = list.getSelectedIndices();
                int stergereId=-1;
                for (int j = 0; j < selectedIndices.length; j++) {
                    String elem =
                            (String) list.getModel().getElementAt(selectedIndices[j]);
                    stergereId = selectedIndices[j];
                    selectedElem += "\n" + elem ;
                }
                Service.getInstance().getDepartamente().get(depID).getAngajatiDepartament().get(elemID).getClientiAngajat().remove(stergereId);
                statusClientButton.doClick();


            }
        });

        mutaClientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedElem = "";
                int selectedIndices[] = list.getSelectedIndices();
                int clientId=-1;
                for (int j = 0; j < selectedIndices.length; j++) {
                    String elem =
                            (String) list.getModel().getElementAt(selectedIndices[j]);
                    clientId = selectedIndices[j];
                    selectedElem += "\n" + elem ;
                }
                JFrame formSpital = new JFrame("Introducere ID");
                formSpital.setContentPane(new FormMove().panel1);
                formSpital.setSize(200,215);
                formSpital.setVisible(true);
                formSpital.setLocationRelativeTo(null);
                Client copy= new Client(Service.getInstance().getDepartamente().get(depID).getAngajatiDepartament().get(elemID).getClientiAngajat().get(clientId));
                Service.getInstance().getDepartamente().get(depID).getAngajatiDepartament().get(ID.getInstance().getId()).getClientiAngajat().add(copy);
                stergereClientButton.doClick();
            }
        });
    }
}
