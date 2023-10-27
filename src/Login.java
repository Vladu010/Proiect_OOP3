import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login {
    private JButton logInButton;
    private JTextField userText;
    public JPanel formLogin;
    private JPasswordField passwordField1;

    public Login() {
        logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputUsername = userText.getText();
                String[] validUsernames = {"Vlad", "Paul"};
                String inputPassword = new String(passwordField1.getPassword()); // Get password as a String
                String[] validPasswords = {"12345", "67891"};

                boolean valid = false;

                for (int i = 0; i < validUsernames.length; i++) {
                    if (inputUsername.equals(validUsernames[i]) && inputPassword.equals(validPasswords[i])) {
                        valid = true;
                        break;
                    }
                }

                if (valid) {
                    //--------------Closes Log in Window
                    JFrame loginFrame = (JFrame) SwingUtilities.getWindowAncestor(formLogin);
                    loginFrame.dispose();
                    //---------------Opens Service Frame
                    JFrame rootPanel = new JFrame("Service");
                    rootPanel.setContentPane(new FormService().rootPanel);
                    rootPanel.setSize(600, 300);
                    rootPanel.setVisible(true);
                    rootPanel.setLocationRelativeTo(null);
                    rootPanel.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                } else {
                    JOptionPane.showMessageDialog(null, "User/Password wrong");
                }
            }
        });
    }
}
