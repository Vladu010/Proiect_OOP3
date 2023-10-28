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

                    /*      test baza de date

                    try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection connection = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/bdmasini", "root", ""
                    );

                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery("select * from masina");


                        DefaultListModel<String> listModel = new DefaultListModel<>();

                    while (resultSet.next()) {

                       // System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " " + resultSet.getInt(3) + " " + resultSet.getString(4));

                        listModel.addElement(resultSet.getString(2));
                        list.setModel(listModel);
                        listPanel.removeAll();
                        listPanel.setLayout(new BorderLayout());
                        listPanel.add(pane, BorderLayout.CENTER);
                        listPanel.revalidate();
                    }

                    connection.close();
                } catch (Exception e2){
                    System.out.println(e2);
                }

                    */

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
                formSpital.setSize(400,300);
                formSpital.setVisible(true);
                formSpital.setLocationRelativeTo(null);
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
            }
        });
    }
}
