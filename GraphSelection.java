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
    JRadioButton rb1,rb2,rb3,rb4, rb5;
    JCheckBox cb1;
    JButton b;
    ButtonGroup bg;
    JTextField tf;
    FrontEnd window;
    JTextField inputX;
    JLabel l1;

    public GraphSelection(){
        l=new JLabel("Select a graph to display a function and its derivative: ");
        l.setBounds(50,50,300,20);
        rb1=new JRadioButton("f(x) = x");
        rb1.setBounds(100,100,150,20);
        rb2=new JRadioButton("f(x) = x^2");
        rb2.setBounds(100,150,150,20);
        rb3=new JRadioButton("f(x) = sinx");
        rb3.setBounds(100,200,150,20);
        rb4=new JRadioButton("f(x) = cosx");
        rb4.setBounds(100,250,150,20);
        rb5=new JRadioButton("Custom Polynomial");
        rb5.setBounds(100,300,150,20);
        bg = new ButtonGroup();
        bg.add(rb1); bg.add(rb2);bg.add(rb3);bg.add(rb4);bg.add(rb5);
        cb1=new JCheckBox("Display Area Under Graph Too");
        cb1.setBounds(200,100,150,20);
        tf = new JTextField("6x^3+5x^2+2x^1+21");
        tf.setBounds(250,300,200, 20);
        inputX = new JTextField("10");
        inputX.setBounds(300,200,50, 20);
        l1 = new JLabel("Input x value of interest");
        l1.setBounds(240,180,300,15);
        b=new JButton("Display Graph");
        b.setBounds(100,350,200,30);
        b.addActionListener(this);
        add(l);add(cb1);add(b);add(tf);add(l1);add(inputX);
        add(rb1);add(rb2);add(rb3);add(rb4);add(rb5);
        setSize(500,500);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public FrontEnd getWindow() {
        return window;
    }

    public void actionPerformed(ActionEvent e){
        if(this.window == null) {
            this.window = new FrontEnd();
            this.window.setGsWindow(this);
        }
        this.window.setVisible(true);
        setVisible(false);
        MathFunction f = null;
        if(rb1.isSelected()){
            f = new MathFunction(window);
            f.setStringF("x");
            window.setF(f);
        }
        if(rb2.isSelected()){
            f = new MathFunction(window);
            f.setStringF("x^2");
            window.setF(f);
        }
        if(rb3.isSelected()){
            f = new MathFunction(window);
            f.setStringF("sinx");
            window.setF(f);
        }
        if(rb4.isSelected()){
            f = new MathFunction(window);
            f.setStringF("cosx");
            window.setF(f);
        }
        if(rb5.isSelected())
        {
            String tStr = "polynomial "+tf.getText();
            //JOptionPane.showMessageDialog(this,"Polynomial Selected:" + tStr);
            f = new PolynomialFunc(tStr, window);
            f.setStringF(tStr);
            window.setF(f);
        }
        if(cb1.isSelected())
        {
            f.setDisplayArea(true);
        }
        else {
            f.setDisplayArea(false);
        }
        if(f != null)
        {
            String tstr1 = inputX.getText();
            if(tstr1 != null && tstr1.length() > 0 && Character.isDigit(tstr1.charAt(0)))
            {
                f.setInputX(Integer.parseInt(tstr1));
            }
        }
        //JOptionPane.showMessageDialog(this,"Displaying Graph: " + f.getStringF());
        window.repaint();
    }
    public static void main(String[] args) {
        GraphSelection gsDemo = new GraphSelection();
    }
}
