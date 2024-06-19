import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements ActionListener {
    JFrame frame;
    JButton[] numButtons = new JButton[10];
    JButton[] funcButtons = new JButton[10];
    JButton addButton, subButton, multButton, divButton;
    JButton eqButton , negButton, delButton, clrButton, decButton, sqrtButton;
    JTextField textfield;
    JPanel panel;

    Font myFont = new Font("Aerial",Font.BOLD,25);

    double num1 = 0, num2 = 0, result = 0;
    char operator;

    Main(){
        frame = new JFrame("Calculator !");
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setSize(400,600);
        frame.setLayout(null);

        textfield = new JTextField();
        textfield.setBounds(50, 25, 300, 50);
        textfield.setFont(myFont);
        textfield.setEditable(false);

        for(int i=0; i<10; i++){
            numButtons[i] = new JButton(String.valueOf(i));
            numButtons[i].setFont(myFont);
            numButtons[i].addActionListener(this);
            numButtons[i].setFocusable(false);
        }

        addButton = new JButton("+");
        subButton = new JButton("-");
        multButton = new JButton("*");
        divButton = new JButton("/");
        delButton = new JButton("Del");
        clrButton = new JButton("Clr");
        eqButton = new JButton("=");
        negButton = new JButton("(-)");
        decButton = new JButton(".");
        sqrtButton = new JButton("SQRT");

        funcButtons[0] = addButton;
        funcButtons[1] = subButton;
        funcButtons[2] = multButton;
        funcButtons[3] = divButton;
        funcButtons[4] = decButton;
        funcButtons[5] = eqButton;
        funcButtons[6] = delButton;
        funcButtons[7] = clrButton;
        funcButtons[8] = negButton;
        funcButtons[9] = sqrtButton;

        for(int i =0;i<10;i++) {
            funcButtons[i].addActionListener(this);
            funcButtons[i].setFont(myFont);
            funcButtons[i].setFocusable(false);
        }

        sqrtButton.setBounds(50,430,75,50);
        delButton.setBounds(125,430,75,50);
        clrButton.setBounds(200,430,75,50);
        negButton.setBounds(275,430,75,50);

        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4,4,10,10));

        panel.add(numButtons[1]);
        panel.add(numButtons[2]);
        panel.add(numButtons[3]);
        panel.add(addButton);
        panel.add(numButtons[4]);
        panel.add(numButtons[5]);
        panel.add(numButtons[6]);
        panel.add(subButton);
        panel.add(numButtons[7]);
        panel.add(numButtons[8]);
        panel.add(numButtons[9]);
        panel.add(multButton);
        panel.add(decButton);
        panel.add(numButtons[0]);
        panel.add(eqButton);
        panel.add(divButton);

        frame.setResizable(false);
        frame.add(panel);
        frame.add(sqrtButton);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textfield);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        Main M = new Main();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0; i<10; i++){
            if(e.getSource() == numButtons[i]){
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource() == decButton){
            textfield.setText(textfield.getText().concat("."));
        }

        if(e.getSource() == addButton){
            num1 = Double.parseDouble(textfield.getText());
            operator = '+';
            textfield.setText("");
        }

        if(e.getSource() == subButton){
            num1 = Double.parseDouble(textfield.getText());
            operator = '-';
            textfield.setText("");
        }

        if(e.getSource() == multButton){
            num1 = Double.parseDouble(textfield.getText());
            operator = '*';
            textfield.setText("");
        }

        if(e.getSource() == divButton){
            num1 = Double.parseDouble(textfield.getText());
            operator = '/';
            textfield.setText("");
        }

        if(e.getSource() == eqButton) {
            num2=Double.parseDouble(textfield.getText());

            switch(operator) {
                case'+':
                    result=num1+num2;
                    break;
                case'-':
                    result=num1-num2;
                    break;
                case'*':
                    result=num1*num2;
                    break;
                case'/':
                    result=num1/num2;
                    break;
            }
            textfield.setText(String.valueOf(result));
            num1=result;
        }

        if(e.getSource() == sqrtButton){
            double temp = Double.parseDouble(textfield.getText());
            textfield.setText("");
            result = Math.sqrt(temp);
            textfield.setText(String.valueOf(result));
        }

        if(e.getSource() == negButton){
            Double temp = Double.parseDouble(textfield.getText());
            temp *= -1;
            textfield.setText(String.valueOf(temp));
        }

        if(e.getSource() == delButton){
            String string = textfield.getText();
            textfield.setText("");
            for(int i=0; i<string.length()-1; i++){
                textfield.setText(textfield.getText() + string.charAt(i));
            }
        }

        if(e.getSource() == clrButton){
            textfield.setText("");
        }
    }
}
