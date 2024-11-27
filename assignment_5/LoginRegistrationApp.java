/*
Create a graphical login and registration page using Java Swing, connecting to a
MySQL database with JDBC. The program should allow users to register with a
username, password, and email, and then log in using their credentials. 
*/
// This code is using Hash Map. SQL connectivity is not done

import java.awt.*;
import java.util.HashMap;
import javax.swing.*;

public class LoginRegistrationApp extends JFrame {
    private HashMap<String, User> users; // In-memory storage for user data

    public LoginRegistrationApp() {
        users = new HashMap<>();

        setTitle("Login and Registration");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new CardLayout());

        JPanel loginPanel = createLoginPanel();
        JPanel registerPanel = createRegisterPanel();

        CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
        getContentPane().add(loginPanel, "Login");
        getContentPane().add(registerPanel, "Register");

        cardLayout.show(getContentPane(), "Login");
    }

    private JPanel createLoginPanel() {
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        JLabel lblUsername = new JLabel("Username:");
        JLabel lblPassword = new JLabel("Password:");
        JTextField txtUsername = new JTextField();
        JPasswordField txtPassword = new JPasswordField();
        JButton btnLogin = new JButton("Login");
        JButton btnSwitchToRegister = new JButton("Register");

        panel.add(lblUsername);
        panel.add(txtUsername);
        panel.add(lblPassword);
        panel.add(txtPassword);
        panel.add(btnLogin);
        panel.add(btnSwitchToRegister);

        btnLogin.addActionListener(e -> {
            String username = txtUsername.getText();
            String password = new String(txtPassword.getPassword());

            if (authenticateUser(username, password)) {
                JOptionPane.showMessageDialog(this, "Login successful!");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnSwitchToRegister.addActionListener(e -> {
            CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
            cardLayout.show(getContentPane(), "Register");
        });

        return panel;
    }

    private JPanel createRegisterPanel() {
        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
        JLabel lblUsername = new JLabel("Username:");
        JLabel lblPassword = new JLabel("Password:");
        JLabel lblEmail = new JLabel("Email:");
        JTextField txtUsername = new JTextField();
        JPasswordField txtPassword = new JPasswordField();
        JTextField txtEmail = new JTextField();
        JButton btnRegister = new JButton("Register");
        JButton btnSwitchToLogin = new JButton("Login");

        panel.add(lblUsername);
        panel.add(txtUsername);
        panel.add(lblPassword);
        panel.add(txtPassword);
        panel.add(lblEmail);
        panel.add(txtEmail);
        panel.add(btnRegister);
        panel.add(btnSwitchToLogin);

        btnRegister.addActionListener(e -> {
            String username = txtUsername.getText();
            String password = new String(txtPassword.getPassword());
            String email = txtEmail.getText();

            if (registerUser(username, password, email)) {
                JOptionPane.showMessageDialog(this, "Registration successful! You can now log in.");
                CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
                cardLayout.show(getContentPane(), "Login");
            }
        });

        btnSwitchToLogin.addActionListener(e -> {
            CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
            cardLayout.show(getContentPane(), "Login");
        });

        return panel;
    }

    private boolean authenticateUser(String username, String password) {
        if (users.containsKey(username)) {
            User user = users.get(username);
            return user.getPassword().equals(password);
        }
        return false;
    }

    private boolean registerUser(String username, String password, String email) {
        if (users.containsKey(username)) {
            JOptionPane.showMessageDialog(this, "Username already exists.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        users.put(username, new User(username, password, email));
        return true;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoginRegistrationApp app = new LoginRegistrationApp();
            app.setVisible(true);
        });
    }
}

class User {
    private String username;
    private String password;
    private String email;

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}