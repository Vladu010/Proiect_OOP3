import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormAngajat {
    private JTextField numeAngajatText;
    public JPanel rootAngajat;
    private JButton inserareButton;

    public FormAngajat(int depID){
        inserareButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    if (numeAngajatText.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(rootAngajat,
                                "Date incomplete");
                    } else {
                        Service.getInstance().getDepartamente().get(depID).addAngajat(numeAngajatText.getText());
                        numeAngajatText.setText(null);

                    }

            }

        });

    }
}
