import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyCalculator extends JFrame implements ActionListener {
    //button for arithmetic operation
    JButton additionBt, minusBt, multiplyBt, divisionBt, equalBt, clearBt;
    //get 0 to 9 button using array
    JButton buttons[] = new JButton[10];
    //
    int i, response, no1, no2;
    JTextField resultTf;
    char op;

    public MyCalculator() {
        super("Mit Calulator");
        setLayout(new BorderLayout());
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(4, 4));
        for (int i = 0; i <= 9; i++) {
            buttons[i] = new JButton(i + "");
            p.add(buttons[i]);
            buttons[i].addActionListener(this);
        }
        additionBt = new JButton("+");
        p.add(additionBt);
        additionBt.addActionListener(this);

        minusBt = new JButton("-");
        p.add(minusBt);
        minusBt.addActionListener(this);

        multiplyBt = new JButton("*");
        p.add(multiplyBt);
        multiplyBt.addActionListener(this);

        divisionBt = new JButton("/");
        p.add(divisionBt);
        divisionBt.addActionListener(this);

        equalBt = new JButton("=");
        p.add(equalBt);
        equalBt.addActionListener(this);

        clearBt = new JButton("C");
        p.add(clearBt);
        clearBt.addActionListener(this);

        resultTf = new JTextField(10);
        resultTf.setSize(400, 60);
        add(p, BorderLayout.CENTER);
        add(resultTf, BorderLayout.NORTH);
        setVisible(true);
        setSize(400, 300);
    }

    public void actionPerformed(ActionEvent ae) {
        JButton pb = (JButton) ae.getSource();
        if (pb == clearBt) {
            response = no1 = no2 = 0;
            resultTf.setText("");
        } else if (pb == equalBt) {
            no2 = Integer.parseInt(resultTf.getText());
            eval();
            resultTf.setText("" + response);
        } else {
            boolean opf = false;
            if (pb == additionBt) {
                op = '+';
                opf = true;
            }
            if (pb == minusBt) {
                op = '-';
                opf = true;
            }
            if (pb == multiplyBt) {
                op = '*';
                opf = true;
            }
            if (pb == divisionBt) {
                op = '/';
                opf = true;
            }

            if (opf == false) {
                for (i = 0; i < 10; i++) {
                    if (pb == buttons[i]) {
                        String t = resultTf.getText();
                        t += i;
                        resultTf.setText(t);
                    }
                }
            } else {
                no1 = Integer.parseInt(resultTf.getText());
                resultTf.setText("");
            }
        }
    }

    int eval() {
        switch (op) {
            case '+':
                response = no1 + no2;
                break;
            case '-':
                response = no1 - no2;
                break;
            case '*':
                response = no1 * no2;
                break;
            case '/':
                response = no1 / no2;
                break;

        }
        return 0;
    }

    public static void main(String arg[]) {
        new MyCalculator();
    }
}