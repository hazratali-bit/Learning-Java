package com.ali;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdditionGui {
    public static void main(String[] args) {
        Addition addition = new Addition();
    }
}

class Addition extends JFrame implements ActionListener {
    JTextField textField;
    JTextField textField1;
    JLabel label;
    JLabel label2;
    JButton button;
    JLabel label3;
    Addition(){
        textField=new JTextField(20);
        textField1=new JTextField(20);
        label = new JLabel("First Number:");
        label2 = new JLabel("Second Number:");
        button = new JButton("Sum");
        label3= new JLabel("Result");

        add(label);
        add(textField);
        add(label2);
        add(textField1);
        add(button);
        add(label3);




        button.addActionListener(this);

        setLayout(new FlowLayout());
        setVisible(true);
        setSize(400,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public int add(int x,int y){
        return x+y;
    }
    public void actionPerformed(ActionEvent e){
        String firstNum= textField.getText();
        String secondNum =textField1.getText();

        int num1= Integer.parseInt(firstNum);
        int num2= Integer.parseInt(secondNum);
        int result=add(num1,num2);

        label3.setText(result+"");
    }
}