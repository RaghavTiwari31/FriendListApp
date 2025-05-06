package gui;

import model.Friend;
import service.FriendService;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class MainMenuGUI extends JFrame {
    private final FriendService service;
    private final String username;

    public MainMenuGUI(String username) {
        this.username = username;
        this.service = new FriendService(username);

        // 1. Apply Nimbus L&F for consistency
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ignored) {}

        // 2. Frame settings
        setTitle("Main Menu - " + username);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);  // must be true to maximize

        // 3. Main panel with GridBagLayout and dark background
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(10, 25, 70));  // dark navy
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(panel);

        // 4. Common font and constraints
        Font btnFont = new Font("Segoe UI", Font.BOLD, 14);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15);
        gbc.fill   = GridBagConstraints.HORIZONTAL;
        gbc.gridx  = 0;
        gbc.weightx = 1;

        // 5. Buttons
        JButton addBtn     = makeButton("Add Friend",     btnFont);
        JButton updateBtn  = makeButton("Update Friend",  btnFont);
        JButton deleteBtn  = makeButton("Delete Friend",  btnFont);
        JButton displayBtn = makeButton("Display Friends",btnFont);
        JButton exitBtn    = makeButton("Exit",            btnFont);

        gbc.gridy = 0; panel.add(addBtn,     gbc);
        gbc.gridy = 1; panel.add(updateBtn,  gbc);
        gbc.gridy = 2; panel.add(deleteBtn,  gbc);
        gbc.gridy = 3; panel.add(displayBtn, gbc);
        gbc.gridy = 4; panel.add(exitBtn,    gbc);

        // 6. Actions
        addBtn.addActionListener(e -> handleAdd());
        updateBtn.addActionListener(e -> handleUpdate());
        deleteBtn.addActionListener(e -> handleDelete());
        displayBtn.addActionListener(e -> handleDisplay());
        exitBtn.addActionListener(e -> System.exit(0));

        // 7. Finalize and maximize
        pack();
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);  // <-- makes it fill the screen
        setVisible(true);
    }

    private JButton makeButton(String text, Font font) {
        JButton btn = new JButton(text);
        btn.setFont(font);
        btn.setBackground(new Color(100, 149, 237)); // light cornflower blue
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        return btn;
    }

    private void handleAdd() {
        String name    = JOptionPane.showInputDialog(this, "Enter Name:");
        String contact = JOptionPane.showInputDialog(this, "Enter Contact:");
        String address = JOptionPane.showInputDialog(this, "Enter Address:");
        String dob     = JOptionPane.showInputDialog(this, "Enter DOB (DD-MM-YYYY):");
        try {
            service.addFriend(new Friend(name, contact, address, dob));
            JOptionPane.showMessageDialog(this, "Friend added.");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void handleUpdate() {
        String name    = JOptionPane.showInputDialog(this, "Enter name to update:");
        String contact = JOptionPane.showInputDialog(this, "Enter new Contact:");
        String address = JOptionPane.showInputDialog(this, "Enter new Address:");
        String dob     = JOptionPane.showInputDialog(this, "Enter new DOB:");
        try {
            boolean ok = service.updateFriend(name, new Friend(name, contact, address, dob));
            JOptionPane.showMessageDialog(this, ok ? "Friend updated." : "Friend not found.");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void handleDelete() {
        String name = JOptionPane.showInputDialog(this, "Enter name to delete:");
        try {
            boolean ok = service.deleteFriend(name);
            JOptionPane.showMessageDialog(this, ok ? "Friend deleted." : "Friend not found.");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void handleDisplay() {
        try {
            List<String> list = service.getAllFriends();
            JTextArea ta = new JTextArea();
            ta.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            list.forEach(line -> ta.append(line + "\n"));
            ta.setEditable(false);
            JScrollPane sp = new JScrollPane(ta);
            sp.setPreferredSize(new Dimension(400, 300));
            JOptionPane.showMessageDialog(this, sp, "Friends", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
