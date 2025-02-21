//Imports
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {
    //Buttons
    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] FunctionButtons = new JButton[9];
    JButton addButton, subtractButton, multiplyButton, divideButton;
    JButton decButton, equButton, delButton, clrButton, negButton;
    Font myFont = new Font("Ink Free", Font.BOLD,30);
    double num1 = 0, num2 = 0, result = 0;
    char operator;

    //Interfaces
    Calculator(){
        frame = new JFrame("calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,550);
        frame.setLayout(null);
        textField = new JTextField();
        textField.setBounds(50,25,300,50);
        textField.setFont(myFont);
        textField.setEditable(false);

        addButton = new JButton("+");
        subtractButton = new JButton("-");
        multiplyButton = new JButton("*");
        divideButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Delete");
        clrButton = new JButton("Clear");
        negButton = new JButton("(-)");

        FunctionButtons[0] = addButton;
        FunctionButtons[1] = subtractButton;
        FunctionButtons[2] = multiplyButton;
        FunctionButtons[3] = divideButton;
        FunctionButtons[4] = decButton;
        FunctionButtons[5] = equButton;
        FunctionButtons[6] = delButton;
        FunctionButtons[7] = clrButton;
        FunctionButtons[8] = negButton;
    
        for(int i = 0; i < 9; i++){
            FunctionButtons[i].addActionListener(this);
            FunctionButtons[i].setFont(myFont);
            FunctionButtons[i].setFocusable(false);
        }

        for(int i = 0; i < 10; i++){
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }
        negButton.setBounds(20,430,100,50);
        delButton.setBounds(110,430,145,50);
        clrButton.setBounds(250,430,145,50);
        
        JPanel panel;
        panel = new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));
        panel.setBackground(Color.red);

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subtractButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(multiplyButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divideButton);

        frame.add(panel);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textField);
        frame.setVisible(true);
    }

        public static void main(String[] args){
            Calculator calc = new Calculator();
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            for(int i = 0 ; i < 10 ; i++){
                if(e.getSource() == numberButtons[i]){
                    textField.setText(textField.getText().concat(String.valueOf(i)));
                }
            }
            if(e.getSource() == decButton){
                textField.setText(textField.getText().concat("."));
            }
            if(e.getSource() == addButton){
                num1 = Double.parseDouble(textField.getText());
                operator = '+';
                textField.setText("");
            }
            if(e.getSource() == subtractButton){
                num1 = Double.parseDouble(textField.getText());
                operator = '-';
                textField.setText("");
            }
            if(e.getSource() == multiplyButton){
                num1 = Double.parseDouble(textField.getText());
                operator = '*';
                textField.setText("");
            }
            if(e.getSource() == divideButton){
                num1 = Double.parseDouble(textField.getText());
                operator = '/';
                textField.setText("");
            }
            if(e.getSource() == equButton){
                num2 = Double.parseDouble(textField.getText());

                switch(operator){
                    case '+':
                        result = num1 + num2;
                        break;
                    case '-':
                        result = num1 - num2;
                        break;
                    case '*':
                        result = num1 * num2;
                        break;
                    case '/':
                        result = num1 / num2;
                        break;
                }
                textField.setText(String.valueOf(result));
                num1 = result;
            }
            if(e.getSource() == clrButton){
                textField.setText("");
            }
            if(e.getSource() == delButton){
                String string = textField.getText();
                textField.setText("");
                for(int i = 0; i < string.length()-1; i++){
                    textField.setText(textField.getText()+string.charAt(i));
                }
            }
            if(e.getSource() == negButton){
                double temp = Double.parseDouble(textField.getText());
                temp*=-1;
                textField.setText(String.valueOf(temp));
            }
    }
}