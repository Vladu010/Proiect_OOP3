import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FormService {
    public JPanel rootPanel;
    private JButton mecanicaButton;
    private JButton vopsitorieButton;
    private JButton tinichigerieButton;
    private JButton afisareAngajatiButton;
    private JButton selectareAngajatButton;
    private JButton stergereAngajatButton;
    private JButton mutaAngajatButton;
    private JPanel listPanel;
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
            @Override
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
    }
}
