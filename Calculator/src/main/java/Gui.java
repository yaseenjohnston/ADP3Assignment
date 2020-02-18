import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class Gui extends JFrame implements ActionListener {
    Random rnd = new Random();
    ArrayList g = new ArrayList();
    ArrayList s = new ArrayList();

    private JPanel panelTop = new JPanel();

    private JPanel panelCenter = new JPanel();
    private JPanel panelBottom = new JPanel();

    private JLabel num1Lbl = new JLabel("Number 1: ");
    private JTextField num1Txt = new JTextField(10);

    private JLabel num2Lbl = new JLabel("Number 2: ");
    private JTextField num2Txt = new JTextField(10);

    private JLabel resultLbl = new JLabel("Result: ");
    private JTextField resultTxt = new JTextField(10);

    private JButton addBtn = new JButton("ADD");
    private JButton subtractBtn = new JButton("SUBTRACT");
    private JButton multiplyBtn = new JButton("MULTIPLY");
    private JButton divideBtn = new JButton("DIVIDE");
    private JButton resetBtn = new JButton("RESET");

    public Gui() {
        super("Menu Demo");

        setLayout(new BorderLayout());

        TitledBorder tBorder1 = new TitledBorder("");
        tBorder1.setTitleJustification(TitledBorder.LEFT);
        tBorder1.setTitlePosition(TitledBorder.TOP);
        panelTop.setBorder(tBorder1);

        TitledBorder tBorder2 = new TitledBorder("");
        tBorder1.setTitleJustification(TitledBorder.LEFT);
        tBorder1.setTitlePosition(TitledBorder.TOP);
        panelCenter.setBorder(tBorder2);

        TitledBorder tBorder3 = new TitledBorder("OPERATIONS");
        tBorder1.setTitleJustification(TitledBorder.LEFT);
        tBorder1.setTitlePosition(TitledBorder.TOP);
        panelBottom.setBorder(tBorder3);

        panelTop.setLayout(new FlowLayout());
        panelCenter.setLayout(new FlowLayout());
        panelBottom.setLayout(new GridLayout(1, 3));

        panelTop.add(num1Lbl);
        panelTop.add(num1Txt);
        num1Txt.addActionListener(this);
        panelTop.add(num2Lbl);
        panelTop.add(num2Txt);
        num2Txt.addActionListener(this);

        panelCenter.add(resultLbl);
        panelCenter.add(resultTxt);
        resultTxt.addActionListener(this);
        resultTxt.setEditable(false);
        resultTxt.setBackground(Color.white);

        panelBottom.add(addBtn);
        addBtn.addActionListener(this);
        panelBottom.add(subtractBtn);
        subtractBtn.addActionListener(this);
        panelBottom.add(multiplyBtn);
        multiplyBtn.addActionListener(this);
        panelBottom.add(divideBtn);
        divideBtn.addActionListener(this);
        panelBottom.add(resetBtn);
        resetBtn.addActionListener(this);

        add(panelTop, BorderLayout.NORTH);
        add(panelCenter, BorderLayout.CENTER);
        add(panelBottom, BorderLayout.SOUTH);

    }

    public void actionPerformed(ActionEvent a) {

        if (a.getSource() == addBtn) {
            boolean continueLoop = true;
            do {
                try {
                    String resultStr = num1Txt.getText();
                    int num1 = Integer.parseInt(resultStr);

                    String resultStr1 = num2Txt.getText();
                    int num2 = Integer.parseInt(resultStr1);

                    resultTxt.setText("" + (num1 + num2));

                    num1Txt.setText("");
                    num2Txt.setText("");
                    continueLoop = false;

                } catch (Exception e) {

                    JOptionPane.showMessageDialog(null, "A non-numeric value was entered", "", JOptionPane.ERROR_MESSAGE);
                    num1Txt.setText("");
                    num2Txt.setText("");
                }

            } while (continueLoop == true);

        } else if (a.getSource() == subtractBtn) {
            boolean continueLoop = true;
            do {
                try {
                    String resultStr = num1Txt.getText();
                    int num1 = Integer.parseInt(resultStr);

                    String resultStr1 = num2Txt.getText();
                    int num2 = Integer.parseInt(resultStr1);

                    resultTxt.setText("" + (num1 - num2));

                    num1Txt.setText("");
                    num2Txt.setText("");
                    continueLoop = false;
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "A non-numeric value was entered, please try again", "", JOptionPane.ERROR_MESSAGE);
                    num1Txt.setText("");
                    num2Txt.setText("");
                }
            } while (continueLoop == true);

        } else if (a.getSource() == multiplyBtn) {

            boolean continueLoop = true;
            do {
                try {
                    String resultStr = num1Txt.getText();
                    int num1 = Integer.parseInt(resultStr);

                    String resultStr1 = num2Txt.getText();
                    int num2 = Integer.parseInt(resultStr1);

                    resultTxt.setText("" + (num1 * num2));

                    num1Txt.setText("");
                    num2Txt.setText("");
                    continueLoop = false;
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "A non-numeric value was entered, please try again", "", JOptionPane.ERROR_MESSAGE);
                    num1Txt.setText("");
                    num2Txt.setText("");
                }
            } while (continueLoop == true);

        } else if (a.getSource() == divideBtn) {

            boolean continueLoop = true;
            do {
                try {
                    String resultStr = num1Txt.getText();
                    int num1 = Integer.parseInt(resultStr);

                    String resultStr1 = num2Txt.getText();
                    int num2 = Integer.parseInt(resultStr1);

                    resultTxt.setText("" + (num1 / num2));

                    num1Txt.setText("");
                    num2Txt.setText("");
                    continueLoop = false;
                } catch (ArithmeticException e) {
                    JOptionPane.showMessageDialog(null, "Zero is an invalid denominator, please try again", "", JOptionPane.ERROR_MESSAGE);
                    num1Txt.setText("");
                    num2Txt.setText("");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "A non-numeric value was entered, please try again", "", JOptionPane.ERROR_MESSAGE);
                    num1Txt.setText("");
                    num2Txt.setText("");

                }
            } while (continueLoop == true);
        } else if (a.getSource() == resetBtn) {

            num1Txt.setText("");
            num2Txt.setText("");
            resultTxt.setText("");
        }
    }
}
