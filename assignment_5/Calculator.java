/*
3. Develop a basic calculator that can perform simple arithmetic operations using
ActionListener, Focus Listener, and Key Board Listener.
*/
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Calculator extends JFrame implements ActionListener, KeyListener, FocusListener {
    private JTextField display;
    private JButton[] numberButtons;
    private JButton[] operationButtons;
    private JButton equalsButton, clearButton, decimalButton;
    private JPanel buttonPanel;
    private double firstNumber = 0;
    private String operation = "";
    private boolean isNewCalculation = true;
    private Connection connection;

    public Calculator() {
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);
        setLayout(new BorderLayout());

        initializeDatabase();

        display = new JTextField("0");
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        display.addKeyListener(this);
        display.addFocusListener(this);
        add(display, BorderLayout.NORTH);

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4, 5, 5));

        numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].addKeyListener(this);
        }

        operationButtons = new JButton[4];
        operationButtons[0] = new JButton("+");
        operationButtons[1] = new JButton("-");
        operationButtons[2] = new JButton("*");
        operationButtons[3] = new JButton("/");

        for (JButton button : operationButtons) {
            button.addActionListener(this);
            button.addKeyListener(this);
        }

        equalsButton = new JButton("=");
        clearButton = new JButton("C");
        decimalButton = new JButton(".");

        equalsButton.addActionListener(this);
        clearButton.addActionListener(this);
        decimalButton.addActionListener(this);

        buttonPanel.add(numberButtons[7]);
        buttonPanel.add(numberButtons[8]);
        buttonPanel.add(numberButtons[9]);
        buttonPanel.add(operationButtons[0]);

        buttonPanel.add(numberButtons[4]);
        buttonPanel.add(numberButtons[5]);
        buttonPanel.add(numberButtons[6]);
        buttonPanel.add(operationButtons[1]);

        buttonPanel.add(numberButtons[1]);
        buttonPanel.add(numberButtons[2]);
        buttonPanel.add(numberButtons[3]);
        buttonPanel.add(operationButtons[2]);

        buttonPanel.add(clearButton);
        buttonPanel.add(numberButtons[0]);
        buttonPanel.add(decimalButton);
        buttonPanel.add(operationButtons[3]);

        add(buttonPanel, BorderLayout.CENTER);
        add(equalsButton, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void initializeDatabase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/calculator_db",
                "root",
                "password"
            );
            createHistoryTable();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createHistoryTable() {
        try {
            Statement stmt = connection.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS calculation_history " +
                        "(id INTEGER PRIMARY KEY AUTO_INCREMENT, " +
                        " calculation VARCHAR(255), " +
                        " result DOUBLE, " +
                        " timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP)";
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void saveCalculation(String calculation, double result) {
        try {
            String sql = "INSERT INTO calculation_history (calculation, result) VALUES (?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, calculation);
            pstmt.setDouble(2, result);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        
        if (command.matches("[0-9]")) {
            if (isNewCalculation) {
                display.setText(command);
                isNewCalculation = false;
            } else {
                display.setText(display.getText() + command);
            }
        } else if (command.equals(".")) {
            if (!display.getText().contains(".")) {
                display.setText(display.getText() + ".");
            }
        } else if (command.matches("[+\\-*/]")) {
            firstNumber = Double.parseDouble(display.getText());
            operation = command;
            isNewCalculation = true;
        } else if (command.equals("=")) {
            double secondNumber = Double.parseDouble(display.getText());
            double result = 0;
            String calculation = firstNumber + " " + operation + " " + secondNumber;

            switch (operation) {
                case "+":
                    result = firstNumber + secondNumber;
                    break;
                case "-":
                    result = firstNumber - secondNumber;
                    break;
                case "*":
                    result = firstNumber * secondNumber;
                    break;
                case "/":
                    if (secondNumber != 0) {
                        result = firstNumber / secondNumber;
                    } else {
                        display.setText("Error");
                        return;
                    }
                    break;
            }

            display.setText(String.valueOf(result));
            saveCalculation(calculation, result);
            isNewCalculation = true;
        } else if (command.equals("C")) {
            display.setText("0");
            firstNumber = 0;
            operation = "";
            isNewCalculation = true;
        }
    }

    // KeyListener implementation
    @Override
    public void keyTyped(KeyEvent e) {
        char key = e.getKeyChar();
        if (Character.isDigit(key)) {
            actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, String.valueOf(key)));
        } else if (key == '+' || key == '-' || key == '*' || key == '/') {
            actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, String.valueOf(key)));
        } else if (key == '\n') {
            actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "="));
        } else if (key == '.') {
            actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "."));
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "C"));
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Not used but required by KeyListener interface
    }

    // FocusListener implementation
    @Override
    public void focusGained(FocusEvent e) {
        // Highlight the display when it gains focus
        display.setBackground(new Color(230, 230, 250));
    }

    @Override
    public void focusLost(FocusEvent e) {
        // Reset display background when focus is lost
        display.setBackground(Color.WHITE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Calculator());
    }
}