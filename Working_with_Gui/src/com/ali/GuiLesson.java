package com.ali;

import javax.swing.*;
import java.awt.*;

public class GuiLesson {
    public static void main(String[] args) {
        Gui gui = new Gui();
    }
}

class Gui extends JFrame{
    Gui(){

        setSize(400,400);
        setLocationRelativeTo(null);
        setTitle("Navin Raddy");
        JLabel label= new JLabel("i am watching a video tutorial on youtube");
        JButton button = new JButton("send me");
        JPanel panel = new JPanel();
        panel.add(button);
        panel.add(label);
        add(panel);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);




    }
}
