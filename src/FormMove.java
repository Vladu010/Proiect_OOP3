import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormMove  {
    private JTextField textField1;
    public JPanel panel1;
    private JButton button1;

    public FormMove(){

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //else {JOptionPane.showMessageDialog(null, "ID introdus gresit");}
                ID.getInstance().setId(Integer.parseInt(textField1.getText()));
                System.out.println(textField1.getText());
            }
        });

        }

    }

