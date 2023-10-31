import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import java.sql.Connection;
import java.sql.DriverManager;    //biblioteci necesare pt database
import java.sql.ResultSet;        //folosim XAMPP pentru a crea legatura intre intellij si mysql
import java.sql.Statement;

public class FormService {
    public JPanel rootPanel;
    private JButton mecanicaButton;
    private JButton vopsitorieButton;
    private JButton tinichigerieButton;
    private JButton afisareAngajatiButton;
    private JButton inserareAngajatButton;
    private JButton stergereAngajatButton;
    private JButton mutaAngajatButton;
    private JPanel listPanel;
    private JButton selectareAngajatButton1;
    private int k = -1; // ID departament

    public FormService(){
        Service.getInstance().addDepartment(new Departament(0,"Vopsitorie",new ArrayList<Angajat>()));
        Service.getInstance().addDepartment(new Departament(1,"Tinichigerie",new ArrayList<Angajat>()));
        Service.getInstance().addDepartment(new Departament(2,"Mecanica",new ArrayList<Angajat>()));

        String[] listElems = new String[100];
        final JList list = new JList(listElems);
        final JScrollPane pane = new JScrollPane(list);

        vopsitorieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                k =Service.getInstance().getDepartamente().get(0).getIdDepartament();
            }
        });

        tinichigerieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                k =Service.getInstance().getDepartamente().get(1).getIdDepartament();
            }
        });

        mecanicaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                k =Service.getInstance().getDepartamente().get(2).getIdDepartament();
            }
        });

        afisareAngajatiButton.addActionListener(new ActionListener() {
            @Override//----------------------------Afisare lista de angajati
            public void actionPerformed(ActionEvent e) {
                if (k != -1) {

                    DefaultListModel<String> listModel = new DefaultListModel<>();
                    for (int i = 0; i < Service.getInstance().getDepartamente().get(k).getAngajatiDepartament().size(); i++) {
                        listModel.addElement(Service.getInstance().getDepartamente().get(k).getAngajatiDepartament().get(i).toString());
                    }
                    list.setModel(listModel);
                    listPanel.removeAll();
                    listPanel.setLayout(new BorderLayout());
                    listPanel.add(pane, BorderLayout.CENTER);
                    listPanel.revalidate();

                } else {
                    JOptionPane.showMessageDialog(null, "Please select a department first.");
                }
            }
        });

        inserareAngajatButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame formSpital = new JFrame("Inserare Angajat");
                formSpital.setContentPane(new FormAngajat(k).rootAngajat);
                formSpital.setSize(450,170);
                formSpital.setVisible(true);
                formSpital.setLocationRelativeTo(null);
                afisareAngajatiButton.doClick();
            }
        });

        selectareAngajatButton1.addActionListener(new ActionListener() {
            @Override//___________________________________________Window de afisare date ale angajatului si lista de clienti pe care ii are
            public void actionPerformed(ActionEvent e) {
                String selectedElem = "";
                int selectedIndices[] = list.getSelectedIndices();
                int elemID=0;
                for (int j = 0; j < selectedIndices.length; j++) {
                    String elem =
                            (String) list.getModel().getElementAt(selectedIndices[j]);
                    elemID = selectedIndices[j];
                    selectedElem += "\n" + elem ;
                }
                JFrame formSpital = new JFrame("Afisare Angajat");
                formSpital.setContentPane(new AfisareAngajat(k,elemID).afisareAngajat);
                formSpital.setSize(525,215);
                formSpital.setVisible(true);
                formSpital.setLocationRelativeTo(null);
            }
        });

        stergereAngajatButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedElem = "";
                int selectedIndices[] = list.getSelectedIndices();
                int elemID=0;
                for (int j = 0; j < selectedIndices.length; j++) {
                    String elem =
                            (String) list.getModel().getElementAt(selectedIndices[j]);
                    elemID = selectedIndices[j];
                    selectedElem += "\n" + elem ;

                }
                Service.getInstance().getDepartamente().get(k).removeAngajatByIndex(elemID);
                afisareAngajatiButton.doClick();
            }
        });
        mutaAngajatButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedElem = "";
                int selectedIndices[] = list.getSelectedIndices();
                int angajatId=-1;
                for (int j = 0; j < selectedIndices.length; j++) {
                    String elem =
                            (String) list.getModel().getElementAt(selectedIndices[j]);
                    angajatId = selectedIndices[j];
                    selectedElem += "\n" + elem ;
                }
                JFrame formSpital = new JFrame("Introducere ID");
                formSpital.setContentPane(new FormMove().panel1);
                formSpital.setSize(200,215);
                formSpital.setVisible(true);
                formSpital.setLocationRelativeTo(null);
                Angajat copy= new Angajat(Service.getInstance().getDepartamente().get(k).getAngajatiDepartament().get(angajatId));
                Service.getInstance().getDepartamente().get(ID.getInstance().getId()).getAngajatiDepartament().add(copy);
                stergereAngajatButton.doClick();

            }
        });
    }
}
