/*
Name: Agastya-Brahmbhatt
Date: 4/27/2024
CS2 Final Project: Graphs
 */

import javax.swing.*;
import java.awt.event.*;

// Cited Source: https://www.javatpoint.com/java-jcheckbox
public class GraphSelection extends JFrame implements ActionListener {
    JLabel l;
    JRadioButton rb1,rb2,rb3,rb4;
    JCheckBox cb1;
    JButton b;
    ButtonGroup bg;
    FrontEnd window;
    public GraphSelection(){
        l=new JLabel("Select a graph to display: ");
        l.setBounds(50,50,300,20);
        rb1=new JRadioButton("f(x) = x");
        rb1.setBounds(100,100,150,20);
        rb2=new JRadioButton("f(x) = x^2");
        rb2.setBounds(100,150,150,20);
        rb3=new JRadioButton("f(x) = sinx");
        rb3.setBounds(100,200,150,20);
        rb4=new JRadioButton("f(x) = cosx");
        rb4.setBounds(100,250,150,20);
        bg = new ButtonGroup();
        bg.add(rb1); bg.add(rb2);bg.add(rb3);bg.add(rb4);
        cb1=new JCheckBox("Display Area Under Graph Too");
        cb1.setBounds(200,100,150,20);
        b=new JButton("Display Graph");
        b.setBounds(100,300,80,30);
        b.addActionListener(this);
        add(l);add(cb1);add(b);
        add(rb1);add(rb2);add(rb3);add(rb4);
        setSize(400,400);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.window = new FrontEnd();
    }

    public FrontEnd getWindow() {
        return window;
    }

    public void actionPerformed(ActionEvent e){
        MathFunction f = new MathFunction();
        if(rb1.isSelected()){
            f.setStringF("x");
            window.setF(f);
        }
        if(rb2.isSelected()){
            f.setStringF("x^2");
            window.setF(f);
        }
        if(rb3.isSelected()){
            f.setStringF("sinx");
            window.setF(f);
        }
        if(rb4.isSelected()){
            f.setStringF("cosx");
            window.setF(f);
        }
        if(cb1.isSelected())
        {
            f.setDisplayArea(true);
        }
        else {
            f.setDisplayArea(false);
        }
        JOptionPane.showMessageDialog(this,"Displaying Graph: " + f.getStringF());
        window.repaint();
    }
}
