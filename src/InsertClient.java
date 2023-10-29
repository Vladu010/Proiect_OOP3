import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.Connection;
import java.sql.DriverManager;    //biblioteci necesare pt database
import java.sql.ResultSet;        //folosim XAMPP pentru a crea legatura intre intellij si mysql
import java.sql.Statement;


public class InsertClient {
    private JTextField numeClient;
    private JTextField telefonClient;
    private JTextField tipText;
    private JTextField anText;
    private JTextField marcaText;
    private JTextField serieText;
    private JButton inserareButton;
    public JPanel inserareClient;
    private JButton inserareAutobutton;


    //inserare manuala

    public InsertClient(int depID, int elemID) {
        inserareButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Masina carClient = new Masina(Integer.parseInt(serieText.getText()), marcaText.getText(), Integer.parseInt(anText.getText()), tipText.getText());
                Service.getInstance().getDepartamente().get(depID).getAngajatiDepartament().get(elemID).introducereClient(new Client(numeClient.getText(), telefonClient.getText(), carClient));
                numeClient.setText(null);
                telefonClient.setText(null);
                serieText.setText(null);
                marcaText.setText(null);
                anText.setText(null);
                tipText.setText(null);
            }
        });


        //auto inserare date masini din bd
        inserareAutobutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbmasini", "root", "");

                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery("select * from masina");

                    while (resultSet.next()) {

                        Masina carClient = new Masina(resultSet.getInt(3), resultSet.getString(4), resultSet.getInt(5), resultSet.getString(6));
                        Service.getInstance().getDepartamente().get(depID).getAngajatiDepartament().get(elemID).introducereClient(new Client(resultSet.getString(1), resultSet.getString(2), carClient));
                        numeClient.setText(null);
                        telefonClient.setText(null);
                        serieText.setText(null);
                        marcaText.setText(null);
                        anText.setText(null);
                        tipText.setText(null);
                    }

                    connection.close();
                } catch (Exception exBD) {
                    System.out.println("EROARE BD");
                }




            }
        });


    }
}