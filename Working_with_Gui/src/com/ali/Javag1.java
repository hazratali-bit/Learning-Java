package com.ali;
import javax.swing.*;

public class Javag1 extends JFrame {
    public static void main(String[] args) {
        new Javag1();
    }
    Javag1(){
        JButton jButton1=new JButton("Button1");
        JPanel panel= new JPanel();
        panel.add(jButton1);
        this.setVisible(true);
        this.add(panel);
    }
}
