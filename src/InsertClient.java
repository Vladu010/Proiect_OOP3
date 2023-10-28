import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.IntBuffer;

public class InsertClient {
    private JTextField numeClient;
    private JTextField telefonClient;
    private JTextField tipText;
    private JTextField anText;
    private JTextField marcaText;
    private JTextField serieText;
    private JButton inserareButton;
    public JPanel inserareClient;

    public InsertClient(int depID, int elemID) {
        inserareButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Masina carClient = new Masina(serieText.getText(), marcaText.getText(), Integer.parseInt(anText.getText()), tipText.getText());
                Service.getInstance().getDepartamente().get(depID).getAngajatiDepartament().get(elemID).introducereClient(new Client(numeClient.getText(), telefonClient.getText(), carClient));
                numeClient.setText(null);
                telefonClient.setText(null);
                serieText.setText(null);
                marcaText.setText(null);
                anText.setText(null);
                tipText.setText(null);
            }
        });
    }
}
