package com.ali;

import org.w3c.dom.Text;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;
import java.util.EventListener;

public class Guiptest extends JFrame {
    JButton button;
    JTextField textField;
    JTextArea textArea;
    int buttonclicked;

    public static void main(String[] args) {
        new Guiptest();
    }
    public Guiptest(){
        this.setSize(400,400);
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dim = tk.getScreenSize();
        int xPos = (dim.width / 2) - (this.getWidth() / 2);
        int yPos = (dim.height / 2) - (this.getHeight() / 2);
        this.setLocation(xPos, yPos);

        button=new JButton("ClickHere");
        textField = new JTextField("Type Here",15);
        textArea = new JTextArea(15,20);


        JPanel jPanel = new JPanel();
        jPanel.add(button);
        jPanel.add(textField);
        jPanel.add(textArea);
       textArea.setText("Tracking windows\n");
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jPanel.add(scrollPane);

        ListenerForButton lForButton = new ListenerForButton();
        button.addActionListener(lForButton);

        ListenerForTextField listenerForTextField= new ListenerForTextField();
        textField.addKeyListener(listenerForTextField);



        this.add(jPanel);

        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private class ListenerForButton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource()==button){
                buttonclicked++;
                textArea.append("button clicked "+ buttonclicked+"\n");

            }
        }
    }
    private class ListenerForTextField implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {
            textArea.append(e.getKeyChar()+"\n");
            textArea.append("Code:"+e.getKeyCode()+"\n");
        }

        @Override
        public void keyPressed(KeyEvent e) {
            textArea.append(e.getKeyChar()+" Pressed.\n");
        }

        @Override
        public void keyReleased(KeyEvent e) {
            textArea.append(e.getKeyChar()+" Released. \n\n");
        }
    }
}
