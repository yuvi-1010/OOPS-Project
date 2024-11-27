/*
6. Build a simple quiz application with multiple-choice questions.
Requirements:
 Display questions with four options and a Submit button.
 Track and display the score as the user progresses through the questions.
 Provide a Next button to move to the next question.
 Show a Finish button at the end of the quiz to display the final score.
 Use JLabel for questions and JRadioButton for answer choices.
*/

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class Quiz extends JFrame {
    private ArrayList<Question> questions;
    private int currentQuestionIndex;
    private int score;
    
    private JLabel questionLabel;
    private JLabel scoreLabel;
    private ButtonGroup optionsGroup;
    private JRadioButton[] options;
    private JButton submitButton;
    private JButton nextButton;
    private JPanel cardPanel;
    private CardLayout cardLayout;
    private JPanel quizPanel;
    private JPanel completionPanel;
    
    public Quiz() {
        initializeQuestions();
        setupUI();
        
        setTitle("Quiz Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
    }
    
    private void initializeQuestions() {
        questions = new ArrayList<>();
        
        // Add sample questions
        questions.add(new Question(
            "What is the jersey number of Virat Kolhi?",
            new String[]{"7", "18", "10", "45"},
            2
        ));
        
        questions.add(new Question(
            "Which galaxy do you live in?",
            new String[]{"Milky Way", "Mahi Way", "Thala", "Dead"},
            1
        ));
        
        questions.add(new Question(
            "Who painted the Mona Lisa?",
            new String[]{"Van Gogh", "Da Vinci", "Picasso", "Rembrandt"},
            1
        ));
        
        questions.add(new Question(
            "What is the largest mammal in the world?",
            new String[]{"African Elephant", "Blue Whale", "Giraffe", "Hippopotamus"},
            1
        ));
        
        currentQuestionIndex = 0;
        score = 0;
    }
    
    private void setupUI() {
        cardPanel = new JPanel();
        cardLayout = new CardLayout();
        cardPanel.setLayout(cardLayout);
        
        // Quiz Panel
        quizPanel = createQuizPanel();
        
        // Completion Panel
        completionPanel = createCompletionPanel();
        
        // Add panels to card layout
        cardPanel.add(quizPanel, "quiz");
        cardPanel.add(completionPanel, "completion");
        
        add(cardPanel);
        
        // Show first question
        showQuestion(currentQuestionIndex);
    }
    
    private JPanel createQuizPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        
        // Top Panel for Score
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        scoreLabel = new JLabel("Score: 0");
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 14));
        topPanel.add(scoreLabel);
        
        // Center Panel for Question and Options
        JPanel centerPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        questionLabel = new JLabel();
        questionLabel.setFont(new Font("Arial", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        centerPanel.add(questionLabel, gbc);
        
        optionsGroup = new ButtonGroup();
        options = new JRadioButton[4];
        
        for (int i = 0; i < 4; i++) {
            options[i] = new JRadioButton();
            optionsGroup.add(options[i]);
            gbc.gridx = 0;
            gbc.gridy = i + 1;
            gbc.gridwidth = 1;
            centerPanel.add(options[i], gbc);
        }
        
        // Bottom Panel for Buttons
        JPanel bottomPanel = new JPanel(new FlowLayout());
        
        submitButton = new JButton("Submit");
        submitButton.addActionListener(e -> checkAnswer());
        
        nextButton = new JButton("Next");
        nextButton.addActionListener(e -> showNextQuestion());
        nextButton.setEnabled(false);
        
        bottomPanel.add(submitButton);
        bottomPanel.add(nextButton);
        
        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(centerPanel, BorderLayout.CENTER);
        panel.add(bottomPanel, BorderLayout.SOUTH);
        
        return panel;
    }
    
    private JPanel createCompletionPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        
        // Create components with custom styling
        JLabel congratsLabel = new JLabel("Quiz Completed!");
        congratsLabel.setFont(new Font("Arial", Font.BOLD, 24));
        congratsLabel.setForeground(new Color(44, 62, 80));
        congratsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JLabel finalScoreLabel = new JLabel();
        finalScoreLabel.setFont(new Font("Arial", Font.BOLD, 20));
        finalScoreLabel.setForeground(new Color(52, 152, 219));
        finalScoreLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        // Performance message
        JLabel performanceLabel = new JLabel();
        performanceLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        performanceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        // Buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        
        JButton restartButton = new JButton("Restart Quiz");
        restartButton.setFont(new Font("Arial", Font.BOLD, 14));
        restartButton.addActionListener(e -> restartQuiz());
        
        JButton exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Arial", Font.BOLD, 14));
        exitButton.addActionListener(e -> System.exit(0));
        
        buttonPanel.add(restartButton);
        buttonPanel.add(exitButton);
        
        // Add components to panel
        panel.add(congratsLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(finalScoreLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(performanceLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 30)));
        panel.add(buttonPanel);
        
        // Store references for updating later
        panel.putClientProperty("finalScoreLabel", finalScoreLabel);
        panel.putClientProperty("performanceLabel", performanceLabel);
        
        return panel;
    }
    
    private void showQuestion(int index) {
        Question question = questions.get(index);
        questionLabel.setText((index + 1) + ". " + question.getQuestion());
        
        String[] choices = question.getChoices();
        for (int i = 0; i < 4; i++) {
            options[i].setText(choices[i]);
            options[i].setSelected(false);
        }
        
        submitButton.setEnabled(true);
        nextButton.setEnabled(false);
    }
    
    private void checkAnswer() {
        int selectedOption = -1;
        for (int i = 0; i < 4; i++) {
            if (options[i].isSelected()) {
                selectedOption = i;
                break;
            }
        }
        
        if (selectedOption == -1) {
            JOptionPane.showMessageDialog(this, 
                "Please select an answer!", 
                "Warning", 
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        Question current = questions.get(currentQuestionIndex);
        if (selectedOption == current.getCorrectAnswer()) {
            score++;
            scoreLabel.setText("Score: " + score);
            JOptionPane.showMessageDialog(this, "Correct!");
        } else {
            JOptionPane.showMessageDialog(this, 
                "Incorrect! The correct answer was: " + 
                current.getChoices()[current.getCorrectAnswer()]);
        }
        
        submitButton.setEnabled(false);
        
        if (currentQuestionIndex < questions.size() - 1) {
            nextButton.setEnabled(true);
        } else {
            showCompletionScreen();
        }
    }
    
    private void showNextQuestion() {
        currentQuestionIndex++;
        showQuestion(currentQuestionIndex);
    }
    
    private void showCompletionScreen() {
        // Calculate percentage
        double percentage = (double) score / questions.size() * 100;
        
        // Update labels
        JLabel finalScoreLabel = (JLabel) completionPanel.getClientProperty("finalScoreLabel");
        JLabel performanceLabel = (JLabel) completionPanel.getClientProperty("performanceLabel");
        
        finalScoreLabel.setText(String.format("Final Score: %d out of %d (%.1f%%)", 
            score, questions.size(), percentage));
        
        // Set performance message based on score
        String performanceMessage;
        if (percentage >= 90) {
            performanceMessage = "Excellent! Outstanding performance!";
        } else if (percentage >= 70) {
            performanceMessage = "Good job! Well done!";
        } else if (percentage >= 50) {
            performanceMessage = "Not bad! Keep practicing!";
        } else {
            performanceMessage = "You might want to study more!";
        }
        performanceLabel.setText(performanceMessage);
        
        // Show completion panel
        cardLayout.show(cardPanel, "completion");
    }
    
    private void restartQuiz() {
        currentQuestionIndex = 0;
        score = 0;
        scoreLabel.setText("Score: 0");
        showQuestion(currentQuestionIndex);
        cardLayout.show(cardPanel, "quiz");
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                // Set system look and feel
                UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }
            new Quiz().setVisible(true);
        });
    }
}

class Question {
    private String question;
    private String[] choices;
    private int correctAnswer;
    
    public Question(String question, String[] choices, int correctAnswer) {
        this.question = question;
        this.choices = choices;
        this.correctAnswer = correctAnswer;
    }
    
    public String getQuestion() {
        return question;
    }
    
    public String[] getChoices() {
        return choices;
    }
    
    public int getCorrectAnswer() {
        return correctAnswer;
    }
}