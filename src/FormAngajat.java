import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormAngajat  {
    private JTextField numeAngajatText;
    public JPanel rootAngajat;
    private JButton inserareButton;
    private JTextField tipAngajat;
    private JTextField marcaAngajat;
    private JTextField serieAngajat;
    private JTextField anAngajat;

    public FormAngajat(int depID){
        inserareButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    if (numeAngajatText.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(rootAngajat,
                                "Date incomplete");
                    } else {

                      //  try {

                            int serieAUX = Integer.parseInt(serieAngajat.getText());   !!!!
                            int anAUX = Integer.parseInt(anAngajat.getText());

                            if (anAUX == 0 && serieAUX == 0 && marcaAngajat.getText().isEmpty() && tipAngajat.getText().isEmpty()) {
                                Service.getInstance().getDepartamente().get(depID).addAngajat(numeAngajatText.getText(), null);
                                numeAngajatText.setText(null);
                                anAngajat.setText(null);
                                serieAngajat.setText(null);
                                tipAngajat.setText(null);
                                marcaAngajat.setText(null);


                            } else {
                                Service.getInstance().getDepartamente().get(depID).addAngajat(numeAngajatText.getText(), new Masina(Integer.parseInt(serieAngajat.getText()), marcaAngajat.getText(), Integer.parseInt(anAngajat.getText()), tipAngajat.getText()));
                                numeAngajatText.setText(null);
                                anAngajat.setText(null);
                                serieAngajat.setText(null);
                                tipAngajat.setText(null);
                                marcaAngajat.setText(null);
                            }

                           // }catch(Exception eINT){
                           //     System.out.println("EROARE TIP INTRARE");
                          //      JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),
                          //              "Nu ati introdus datele corect !",
                            //            "Eroare Date",
                            //            JOptionPane.ERROR_MESSAGE);


                        }


            }

        });

    }
}
