package com.ali;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

public class GuiRadio extends JFrame {
    JButton button;
    JLabel label1, label2, label3;
    JTextField textField1, textField2;
    JCheckBox dollarSign,commaSeparator;
    JRadioButton addNums, subtNums, multNums, divideNums;
    JSlider howManyTimes;

    double number1, number2, totalCalc;

    public static void main(String[] args) {

        new GuiRadio();
    }
    public GuiRadio(){
        this.setSize(400,400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("My Program");

        JPanel thePanel =  new JPanel();

        button= new JButton("Calculate");
        ListenForButton lForButton= new ListenForButton();
        button.addActionListener(lForButton);

        thePanel.add(button);

        label1= new JLabel("Number1");
        thePanel.add(label1);

        textField1= new JTextField("",5);
        thePanel.add(textField1);

        label2= new JLabel("Number2");
        thePanel.add(label2);

        textField2= new JTextField("",5);
        thePanel.add(textField2);

        dollarSign= new JCheckBox("Dollars");
        commaSeparator=new JCheckBox("commas");

        thePanel.add(dollarSign);
        thePanel.add(commaSeparator,true);

        addNums = new JRadioButton("Add");
        subtNums = new JRadioButton("Subtract");
        multNums = new JRadioButton("Multiply");
        divideNums = new JRadioButton("Divide");

        ButtonGroup buttonGroup= new ButtonGroup();
        buttonGroup.add(addNums);
        buttonGroup.add(subtNums);
        buttonGroup.add(multNums);
        buttonGroup.add(divideNums);

        JPanel operPanel = new JPanel();

        Border operBorder = BorderFactory.createTitledBorder("Operation");
        operPanel.setBorder(operBorder);
        operPanel.add(addNums);
        operPanel.add(subtNums);
        operPanel.add(multNums);
        operPanel.add(divideNums);

        addNums.setSelected(true);
        thePanel.add(operPanel);

        label3= new JLabel("Perform How Many Times");
        thePanel.add(label3);

        howManyTimes = new JSlider(0,99,1);
        howManyTimes.setMinorTickSpacing(1);
        howManyTimes.setMajorTickSpacing(10);
        howManyTimes.setPaintTicks(true);
        howManyTimes.setPaintLabels(true);
        ListenForSlider lForSlider = new ListenForSlider();
        howManyTimes.addChangeListener(lForSlider);
        thePanel.add(howManyTimes);
        this.add(thePanel);
        this.setVisible(true);
        textField1.requestFocus();

    }

    private class ListenForButton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==button){
                try{
                    number1=Double.parseDouble(textField1.getText());
                    number2=Double.parseDouble(textField2.getText());
                }
                catch (NumberFormatException execep){
                    JOptionPane.showMessageDialog(GuiRadio.this,"Please Enter the Right Info", "Error",JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
                }
                if (addNums.isSelected()){
                    totalCalc = addNumbers(number1,number2,howManyTimes.getValue());
                }
                else if(subtNums.isSelected()){
                    totalCalc = subtNumbers(number1,number2,howManyTimes.getValue());
                }
                else if (multNums.isSelected()){
                    totalCalc = multNumbers(number1,number2,howManyTimes.getValue());
                }
                else{
                    totalCalc = divideNumbers(number1,number2,howManyTimes.getValue());
                }

                if (dollarSign.isSelected()){
                    NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
                    JOptionPane.showMessageDialog(GuiRadio.this, numberFormat.format(totalCalc),"Solution",JOptionPane.INFORMATION_MESSAGE);

                }
                else if (commaSeparator.isSelected()){
                    NumberFormat numberFormat = NumberFormat.getNumberInstance();
                    JOptionPane.showMessageDialog(GuiRadio.this, numberFormat.format(totalCalc),"Solution",JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    JOptionPane.showMessageDialog(GuiRadio.this, totalCalc,"Solution",JOptionPane.INFORMATION_MESSAGE);

                }
            }
        }
    }
    private class ListenForSlider implements ChangeListener{

        @Override
        public void stateChanged(ChangeEvent e) {
            if (e.getSource()== howManyTimes){
                label3.setText(("Perform How Many Times?"+howManyTimes.getValue()));
            }
        }
    }
    public static double addNumbers(double number1, double number2, int howManyTimes){
        double total =0;
        int i =1;
          while (i<=howManyTimes){
              total=total+(number1+number2);
              i++;
          }
          return total;
    }
    public static double subtNumbers(double number1, double number2, int howManyTimes){
        double total =0.0;
        int i =1;
        while (i<=howManyTimes){
            total=total-(number1-number2);
            i++;
        }
        return total;
    }
    public static double multNumbers(double number1, double number2, int howManyTimes){
        double total =0;
        int i =1;
        while (i<=howManyTimes){
            total=total*(number1*number2);
            i++;
        }
        return total;
    }
    public static double divideNumbers(double number1, double number2, int howManyTimes){
        double total =0;
        int i =1;
        while (i<=howManyTimes){
            total=total/(number1/number2);
            i++;
        }
        return total;
    }
}
