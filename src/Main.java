import javax.swing.*;

import java.io.File;
import java.io.IOException;


public class Main {
    public static void main(String[] args) {
        JFrame rootPanel = new JFrame("Service");
        rootPanel.setContentPane(new Login().formLogin);
        rootPanel.setSize(300,200);
        rootPanel.setVisible(true);
        rootPanel.setLocationRelativeTo(null);
        rootPanel.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        try{
            File myObj = new File("clienti.txt");
            if(myObj.createNewFile()){
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException eFile) {
            System.out.println("ERROR FILE");
        }
    }
}
