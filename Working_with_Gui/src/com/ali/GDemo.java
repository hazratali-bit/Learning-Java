package com.ali;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.*;


public class GDemo extends JFrame {
    public static void main(String [] args){
        new GDemo();
    }
    public GDemo(){
        this.setSize(400,400);
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dim = tk.getScreenSize();
        int posx= (dim.width/2)-this.getWidth()/2;
        int posy= (dim.height/2)- this.getHeight()/2;
        this.setResizable(true);
        this.setLocation(posx,posy);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
