package gui;

import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.util.Properties;

public class LoginGUI extends JFrame {
    public LoginGUI() {
        // 1. Apply Nimbus look & feel
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ignored) {}

        // 2. Frame settings
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // 3. Main panel with padding and GridBagLayout
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setBackground(new Color(245, 245, 245)); // very light gray
        add(panel);

        // 4. Shared constraints
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

        // 5. Title label
        JLabel title = new JLabel("Please Log In");
        title.setFont(new Font("Serif", Font.BOLD, 18));
        title.setForeground(new Color(60, 63, 65));
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        panel.add(title, gbc);

        // 6. Username label + field
        gbc.gridwidth = 1;
        JLabel userLabel = new JLabel("Username:");
        userLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(userLabel, gbc);

        JTextField userText = new JTextField(15);
        userText.setFont(new Font("SansSerif", Font.PLAIN, 14));
        gbc.gridx = 1; gbc.gridy = 1;
        panel.add(userText, gbc);

        // 7. Password label + field
        JLabel passLabel = new JLabel("Password:");
        passLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(passLabel, gbc);

        JPasswordField passText = new JPasswordField(15);
        passText.setFont(new Font("SansSerif", Font.PLAIN, 14));
        gbc.gridx = 1; gbc.gridy = 2;
        panel.add(passText, gbc);

        // 8. Login button
        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("SansSerif", Font.BOLD, 14));
        loginButton.setBackground(new Color(70, 130, 180));   // Steel Blue
        loginButton.setForeground(Color.WHITE);
        loginButton.setFocusPainted(false);
        gbc.gridx = 1; gbc.gridy = 3; gbc.anchor = GridBagConstraints.EAST;
        panel.add(loginButton, gbc);

        // 9. Button action remains the same
        loginButton.addActionListener(e -> {
            String username = userText.getText();
            String password = new String(passText.getPassword());
            try {
                Properties props = new Properties();
                props.load(new FileInputStream("config/credentials.properties"));
                if (props.containsKey(username) && props.getProperty(username).equals(password)) {
                    dispose();
                    new MainMenuGUI(username);
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid credentials",
                            "Login Failed", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        // 10. Finalize frame
        pack();
        setLocationRelativeTo(null);  // center on screen
        setVisible(true);
    }
}
