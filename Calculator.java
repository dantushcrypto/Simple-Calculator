import javax.swing.*;
import java.awt.*;

public class Calculator {
    // Declare and instantiate window components
    JButton button0=new JButton("0");
    JButton button1=new JButton("1");
    JButton button2=new JButton("2");
    JButton button3=new JButton("3");
    JButton button4=new JButton("4");
    JButton button5=new JButton("5");
    JButton button6=new JButton("6");
    JButton button7=new JButton("7");
    JButton button8=new JButton("8");
    JButton button9=new JButton("9");
    JButton buttonPoint=new JButton(".");
    JButton buttonEqual=new JButton("=");
    JButton buttonPlus=new JButton("+");
    JButton buttonMinus=new JButton("-");
    JButton buttonDivide=new JButton("/");
    JButton buttonMultiply=new JButton("*");
    JButton buttonDelete=new JButton("<");
    JPanel windowContent=new JPanel();
    JTextField displayField=new JTextField(30);
    //constructor
    Calculator(){
        //Set the layout manager for this panel
        BorderLayout b1=new BorderLayout();
        windowContent.setLayout(b1);
        //Add the display field to the top of the window
        windowContent.add("North",displayField);
        /*Create the panel with the GridLayout that will contain the
        buttons created
         */
        JPanel p1=new JPanel();
        GridLayout g1=new GridLayout(4,3);
        p1.setLayout(g1);
        p1.add(button1);
        p1.add(button2);
        p1.add(button3);
        p1.add(button4);
        p1.add(button5);
        p1.add(button6);
        p1.add(button7);
        p1.add(button8);
        p1.add(button9);
        p1.add(button0);
        p1.add(buttonPoint);
        p1.add(buttonEqual);
        //Add the panel p1 to the centre  area of the window
        windowContent.add("Center",p1);
        /* create the panel withe the GridLayout that will contain 4
        action buttons plus,minus,divide and multiply
         */
        JPanel p2=new JPanel();
        GridLayout g12=new GridLayout(5,1);
        p2.add(buttonDelete);
        p2.setLayout(g12);
        p2.add(buttonPlus);
        p2.add(buttonMinus);
        p2.add(buttonMultiply);
        p2.add(buttonDivide);
        //Add the panel p2 to the east area of the window
        windowContent.add("East",p2);
        //Create the frame and add the content pane to it
        JFrame frame;
        frame=new JFrame();
        frame.setContentPane(windowContent);
        //Set the size of the window to be big enough to accommodate
        //all window controls
        frame.pack();
        //Display the window
        frame.setVisible(true);
        //Instantiate the event listener and register each button with
        //it
        CalculatorEngine calcEngine=new CalculatorEngine(this);
        button0.addActionListener(calcEngine);
        button1.addActionListener(calcEngine);
        button2.addActionListener(calcEngine);
        button3.addActionListener(calcEngine);
        button4.addActionListener(calcEngine);
        button5.addActionListener(calcEngine);
        button6.addActionListener(calcEngine);
        button7.addActionListener(calcEngine);
        button8.addActionListener(calcEngine);
        button9.addActionListener(calcEngine);
        buttonPoint.addActionListener(calcEngine);
        buttonEqual.addActionListener(calcEngine);
        buttonPlus.addActionListener(calcEngine);
        buttonMinus.addActionListener(calcEngine);
        buttonMultiply.addActionListener(calcEngine);
        buttonDivide.addActionListener(calcEngine);
        buttonDelete.addActionListener(calcEngine);
    }

    public static void main(String[] args) {
        //Instantiate the class calculator
        Calculator calculator=new Calculator();
    }
}
