import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame rootPanel = new JFrame("Service");
        rootPanel.setContentPane(new Login().formLogin);
        rootPanel.setSize(300,200);
        rootPanel.setVisible(true);
        rootPanel.setLocationRelativeTo(null);
        rootPanel.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
}


//pachet de service
//angajat fara masina
// muta client - eroarea