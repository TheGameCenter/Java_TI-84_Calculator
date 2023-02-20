package pkg;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainActivity extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;

    private JTextField display;

    private double currentValue = 0.0;
    private double memoryValue = 0.0;
    private String currentOperation = "";

    public MainActivity() {
        // Set up the frame
        setTitle("TI-84 Calculator by Jayden");
        setSize(420, 300);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create the display field
        display = new JTextField("0.0");
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        add(display, BorderLayout.NORTH);

        // Create the buttons
        JPanel buttonPanel = new JPanel(new GridLayout(6, 4, 5, 5));

        String[] buttonLabels = {"sin", "M+", "M-", "9", "+", "cos", "8", "7", "6", "-", "log", "5", "4", "3", "*", "tan", "2", "1", "0", "/", "x²", "√x", "(", ")", "="};

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.addActionListener(this);
            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String buttonLabel = e.getActionCommand();

        if (buttonLabel.equals("C")) {
            currentValue = 0.0;
            currentOperation = "";
            display.setText("0.0");
        } else if (buttonLabel.equals("+")) {
            currentValue = Double.parseDouble(display.getText());
            currentOperation = "+";
            display.setText("0.0");
        } else if (buttonLabel.equals("-")) {
            currentValue = Double.parseDouble(display.getText());
            currentOperation = "-";
            display.setText("0.0");
        } else if (buttonLabel.equals("*")) {
            currentValue = Double.parseDouble(display.getText());
            currentOperation = "*";
            display.setText("0.0");
        } else if (buttonLabel.equals("/")) {
            currentValue = Double.parseDouble(display.getText());
            currentOperation = "/";
            display.setText("0.0");
        } else if (buttonLabel.equals("=")) {
            double secondValue = Double.parseDouble(display.getText());
            if (currentOperation.equals("+")) {
                currentValue += secondValue;
            } else if (currentOperation.equals("-")) {
                currentValue -= secondValue;
            } else if (currentOperation.equals("*")) {
                currentValue *= secondValue;
            } else if (currentOperation.equals("/")) {
                currentValue /= secondValue;
            }
            display.setText("" + currentValue);
        } else if (buttonLabel.equals("M+")) {
            memoryValue += Double.parseDouble(display.getText());
            display.setText("0.0");
        } else if (buttonLabel.equals("M-")) {
            memoryValue -= Double.parseDouble(display.getText());
            display.setText("0.0");
        } else if (buttonLabel.equals("MR")) {
            display.setText("" + memoryValue);
        } else if (buttonLabel.equals("MC")) {
            memoryValue = 0.0;
        } else if (buttonLabel.equals("sin")) {
            currentValue = Math.sin(Double.parseDouble(display.getText()));
            display.setText("" + currentValue);
        } else if (buttonLabel.equals("cos")) {
            currentValue = Math.cos(Double.parseDouble(display.getText()));
            display.setText("" + currentValue);
        } else if (buttonLabel.equals("tan")) {
            currentValue = Math.tan(Double.parseDouble(display.getText()));
            display.setText("" + currentValue);
        } else if (buttonLabel.equals("log")) {
            currentValue = Math.log10(Double.parseDouble(display.getText()));
            display.setText("" + currentValue);
        } else if (buttonLabel.equals("x²")) {
            currentValue = Double.parseDouble(display.getText()) * Double.parseDouble(display.getText());
            display.setText("" + currentValue);
        } else if (buttonLabel.equals("√x")) {
            currentValue = Math.sqrt(Double.parseDouble(display.getText()));
            display.setText("" + currentValue);
        } else if (buttonLabel.equals("π")) {
            display.setText("" + Math.PI);
        } else if (buttonLabel.equals("e")) {
            display.setText("" + Math.E);
        } else if (buttonLabel.equals("(")) {
            display.setText("(" + display.getText());
        } else if (buttonLabel.equals(")")) {
            display.setText(display.getText() + ")");
        } else if (buttonLabel.equals("1/x")) {
            currentValue = 1 / Double.parseDouble(display.getText());
            display.setText("" + currentValue);
        } else if (buttonLabel.equals("xⁿ")) {
            currentValue = Math.pow(Double.parseDouble(display.getText()), 2);
            display.setText("" + currentValue);
        } else if (buttonLabel.equals("±")) {
            double value = Double.parseDouble(display.getText());
            value *= -1;
            display.setText("" + value);
        } else if (buttonLabel.equals(".")) {
            if (!display.getText().contains(".")) {
                display.setText(display.getText() + ".");
            }
        } else {
            // Add the number to the display
            String currentText = display.getText();
            if (currentText.equals("0.0")) {
                currentText = "";
            }
            currentText += buttonLabel;
            display.setText(currentText);
        }
    }

    public static void main(String[] args) {
        new MainActivity();
    }
}

/**
* code by Jayden
* https://thegamecenter.github.io
* https://github.com/TheGameCenter
*/