import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private JFrame frame;
    private JTextField display;
    private String currentInput;
    private List<Integer> baseFourNumbers;
    private int baseTenResult;
    private int baseFourResult;
    private String operator;
    private boolean isDisplayingBaseTen;
    private BaseConverter baseConverter; // Added BaseConverter instance

    public Calculator() {
        frame = new JFrame("Quaternary Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);

        display = new JTextField(10);
        display.setFont(new Font("Arial", Font.PLAIN, 24));
        display.setEditable(false);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4));
        String[] buttonLabels = {
                "0", "1", "+", "2",
                "3", "-", "*", "/",
                "=", "<--", "CLR", "Toggle"
        };
        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.addActionListener(new ButtonClickListener());
            button.setFont(new Font("Arial", Font.PLAIN, 18));
            buttonPanel.add(button);
        }
        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(display, BorderLayout.NORTH);
        frame.getContentPane().add(buttonPanel, BorderLayout.CENTER);

        baseFourNumbers = new ArrayList<>();
        currentInput = "";
        baseTenResult = 0;
        baseFourResult = 0;
        operator = "";
        isDisplayingBaseTen = true;
        baseConverter = new BaseConverter(); // Initialize BaseConverter

        frame.setVisible(true);
    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if (command.matches("[0-3]")) {
                currentInput += command;
                display.setText(currentInput);
            } else if (command.equals("+") || command.equals("-") || command.equals("*") || command.equals("/")) {
                if (!currentInput.isEmpty()) {
                    baseFourNumbers.add(Integer.parseInt(currentInput));
                    currentInput = "";
                }
                operator = command;
            } else if (command.equals("=")) {
                if (!currentInput.isEmpty()) {
                    baseFourNumbers.add(Integer.parseInt(currentInput));
                    calculateResult();
                }
            } else if (command.equals("CLR")) {
                currentInput = "";
                baseFourNumbers.clear();
                baseTenResult = 0;
                baseFourResult = 0;
                operator = "";
                display.setText("");
                isDisplayingBaseTen = true;
            } else if (command.equals("<--")) {
                currentInput = "";
                baseFourNumbers.clear();
                baseTenResult = 0;
                baseFourResult = 0;
                operator = "";
                display.setText("");
                isDisplayingBaseTen = true;
            } else if (command.equals("Toggle")) {
                isDisplayingBaseTen = !isDisplayingBaseTen;
                updateDisplay();
            }
        }

        private void calculateResult() {
            if (!baseFourNumbers.isEmpty()) {
                baseFourResult = baseFourNumbers.get(0);
                for (int i = 1; i < baseFourNumbers.size(); i++) {
                    int baseFourOperand = baseFourNumbers.get(i);
                    switch (operator) {
                        case "+":
                            baseFourResult += baseFourOperand;
                            break;
                        case "-":
                            baseFourResult -= baseFourOperand;
                            break;
                        case "*":
                            baseFourResult *= baseFourOperand;
                            break;
                        case "/":
                            if (baseFourOperand != 0) {
                                baseFourResult /= baseFourOperand;
                            } else {
                                // Handle division by zero error
                                display.setText("Error: Division by zero");
                                return;
                            }
                            break;
                    }
                }

                if (isDisplayingBaseTen) {
                    baseTenResult = baseConverter.baseFourToBaseTen(baseFourResult);
                } else {
                    baseTenResult = baseFourResult; // Set baseTenResult directly to baseFourResult
                }

                updateDisplay();
                baseFourNumbers.clear();
                currentInput = Integer.toString(baseFourResult);
            }
        }



        private void updateDisplay() {
            if (isDisplayingBaseTen) {
                display.setText("Base 10: " + baseTenResult);
            } else {
                display.setText("Base 4: " + baseFourResult);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Calculator();
            }
        });
    }
}

