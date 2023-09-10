import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// produces null in calculator
public class Calculator {
    private JFrame frame;
    private JTextField display;
    private String currentInput;

    private char operatorClicked;

    private boolean isOperatorClicked;



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
                "=", "<--", "CLR", " "
        };
        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.addActionListener(new buttonClickListener());
            button.setFont(new Font("Arial", Font.PLAIN, 18));
            buttonPanel.add(button);
        }
        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(display, BorderLayout.NORTH);
        frame.getContentPane().add(buttonPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    private class buttonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if (command.matches("[0-3]")) {
                if (isOperatorClicked) {
                    currentInput = "";
                    isOperatorClicked = false;
                }
                currentInput += command;
                display.setText(currentInput);

            }

        }

    }

    public int example(int numOne, int numTwo) {
        return numOne + numTwo;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Calculator();
            }
        });
    }

        public void getResult () {
            double result = 0;
            double[] temporary = {0, 0};
            temporary[1] = Double.parseDouble(display.getText());
            try {
                if (operatorClicked == '+') {
                    result = temporary[0] + temporary[1];
                } else if (operatorClicked == '-') {
                    result = temporary[0] - temporary[1];
                } else if (operatorClicked == '*') {
                    result = temporary[0] * temporary[1];
                } else if (operatorClicked == '/') {
                    result = temporary[0] / temporary[1];
                }
                display.setText(Double.toString(result));
                for(int i = 0; i < 4; i++);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

}

