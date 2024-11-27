/*
Develop a basic student management system to add, delete, update, and view student records.
Requirements:
 Create a form with fields like Student ID, Name, Age, Gender, Department, etc.
 Provide buttons for Add, Update, Delete, and View.
 Use a JTable to display the list of students.
 Use JDBC to connect to a MySQL database and perform CRUD operations.
 Implement ActionListener for each button to handle respective actions.
*/
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class StudentManagementSystem extends JFrame {
    private ArrayList<Student> studentList; 
    private JTable table;
    private DefaultTableModel tableModel;

    private JTextField txtStudentID, txtName, txtAge, txtDepartment;
    private JComboBox<String> cmbGender;

    public StudentManagementSystem() {
        studentList = new ArrayList<>();

        setTitle("Student Management System");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel formPanel = createFormPanel();
        add(formPanel, BorderLayout.NORTH);

        JPanel tablePanel = createTablePanel();
        add(tablePanel, BorderLayout.CENTER);

        JPanel buttonPanel = createButtonPanel();
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private JPanel createFormPanel() {
        JPanel panel = new JPanel(new GridLayout(2, 5, 10, 10));

        JLabel lblStudentID = new JLabel("Student ID:");
        JLabel lblName = new JLabel("Name:");
        JLabel lblAge = new JLabel("Age:");
        JLabel lblGender = new JLabel("Gender:");
        JLabel lblDepartment = new JLabel("Department:");

        txtStudentID = new JTextField();
        txtName = new JTextField();
        txtAge = new JTextField();
        txtDepartment = new JTextField();

        cmbGender = new JComboBox<>(new String[]{"Male", "Female", "Other"});

        panel.add(lblStudentID);
        panel.add(txtStudentID);
        panel.add(lblName);
        panel.add(txtName);
        panel.add(lblAge);
        panel.add(txtAge);
        panel.add(lblGender);
        panel.add(cmbGender);
        panel.add(lblDepartment);
        panel.add(txtDepartment);

        return panel;
    }

    private JPanel createTablePanel() {
        JPanel panel = new JPanel(new BorderLayout());

        String[] columnNames = {"Student ID", "Name", "Age", "Gender", "Department"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        panel.add(scrollPane, BorderLayout.CENTER);
        return panel;
    }

    private JPanel createButtonPanel() {
        JPanel panel = new JPanel(new FlowLayout());

        JButton btnAdd = new JButton("Add");
        JButton btnUpdate = new JButton("Update");
        JButton btnDelete = new JButton("Delete");
        JButton btnView = new JButton("View");

        panel.add(btnAdd);
        panel.add(btnUpdate);
        panel.add(btnDelete);
        panel.add(btnView);

        btnAdd.addActionListener(e -> addStudent());
        btnUpdate.addActionListener(e -> updateStudent());
        btnDelete.addActionListener(e -> deleteStudent());
        btnView.addActionListener(e -> viewStudents());

        return panel;
    }

    private void addStudent() {
        String id = txtStudentID.getText();
        String name = txtName.getText();
        String ageText = txtAge.getText();
        String gender = (String) cmbGender.getSelectedItem();
        String department = txtDepartment.getText();

        if (id.isEmpty() || name.isEmpty() || ageText.isEmpty() || department.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            int age = Integer.parseInt(ageText);
            studentList.add(new Student(id, name, age, gender, department));
            JOptionPane.showMessageDialog(this, "Student added successfully!");
            clearForm();
            viewStudents();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Age must be a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateStudent() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a student to update.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String id = txtStudentID.getText();
        String name = txtName.getText();
        String ageText = txtAge.getText();
        String gender = (String) cmbGender.getSelectedItem();
        String department = txtDepartment.getText();

        if (id.isEmpty() || name.isEmpty() || ageText.isEmpty() || department.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            int age = Integer.parseInt(ageText);
            Student student = studentList.get(selectedRow);
            student.setId(id);
            student.setName(name);
            student.setAge(age);
            student.setGender(gender);
            student.setDepartment(department);
            JOptionPane.showMessageDialog(this, "Student updated successfully!");
            clearForm();
            viewStudents();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Age must be a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteStudent() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a student to delete.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        studentList.remove(selectedRow);
        JOptionPane.showMessageDialog(this, "Student deleted successfully!");
        viewStudents();
    }

    private void viewStudents() {
        tableModel.setRowCount(0); // Clear table
        for (Student student : studentList) {
            tableModel.addRow(new Object[]{
                    student.getId(),
                    student.getName(),
                    student.getAge(),
                    student.getGender(),
                    student.getDepartment()
            });
        }
    }

    private void clearForm() {
        txtStudentID.setText("");
        txtName.setText("");
        txtAge.setText("");
        txtDepartment.setText("");
        cmbGender.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            StudentManagementSystem app = new StudentManagementSystem();
            app.setVisible(true);
        });
    }
}

class Student {
    private String id;
    private String name;
    private int age;
    private String gender;
    private String department;

    public Student(String id, String name, int age, String gender, String department) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.department = department;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}