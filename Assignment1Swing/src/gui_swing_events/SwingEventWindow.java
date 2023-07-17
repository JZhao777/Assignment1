package gui_swing_events;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class SwingEventWindow extends JFrame implements ActionListener, ItemListener{
    private JLabel h1 = new JLabel();
    private JLabel h2 = new JLabel();
    private JTextField inputT = new JTextField(40);
    private JButton cal = new JButton("Calculate");
    private JTextField resultT = new JTextField(40);
    private JPanel mainP = new JPanel();
    private JPanel pn1 = new JPanel();
    private JPanel pn2 = new JPanel();
    private JPanel pn3 = new JPanel();
    private JPanel pn4 = new JPanel();
    private JPanel pn5 = new JPanel();
    private JPanel pn6 = new JPanel();

    //radio buttons
    JRadioButton rSum = new JRadioButton("AutoSum");
    JRadioButton rAverage = new JRadioButton("Average");
    JRadioButton rMax= new JRadioButton("Maximum");
    JRadioButton rMin = new JRadioButton("Minimun");
    //create a group for those four radio buttons

    ButtonGroup myGroup = new ButtonGroup();
    double result=0.0;
    int rdoChecked = 1;

      public SwingEventWindow(){
            
            super("Excel Formula Window");
            setSize(500,400);
            setVisible(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            resultT.setText("Result: " + result);
            h1.setText("Excel Functions");
            h2.setText("Enter Your Numbers Seperated By Spaces");

            rSum.addActionListener(this);
            rAverage.addActionListener(this);
            rMax.addActionListener(this);
            rMin.addActionListener(this);
            cal.addActionListener(e -> {
                itemStateChanged(null);
            });

            pn1.add(h1);
            pn2.add(h2);
            pn3.add(inputT);
            pn4.add(rSum);
            pn4.add(rAverage);
            pn4.add(rMax);
            pn4.add(rMin);
            pn5.add(cal);
            pn6.add(resultT);
            
            myGroup.add(rSum);
            myGroup.add(rAverage);
            myGroup.add(rMax);
            myGroup.add(rMin);

            mainP.add(pn1);
            mainP.add(pn2);
            mainP.add(pn3);
            mainP.add(pn4);
            mainP.add(pn5);
            mainP.add(pn6);

            add(mainP);

        
      
      
        }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("actionPerformed called");
        if (e.getSource() == rSum) {
            rdoChecked = 1;
        } else if(e.getSource() == rAverage){
            rdoChecked = 2;
        }else if(e.getSource() == rMax){
            rdoChecked = 3;
        }else if(e.getSource() == rMin){
            rdoChecked = 4;
        }
    }
    @Override
    public void itemStateChanged(ItemEvent e) {
        System.out.println("itemStateChanged called");
        Excel excel = new Excel(inputT.getText());
        if (rdoChecked==1){
            result = excel.findTotal();
            resultT.setText(String.valueOf(result));
        }else if (rdoChecked ==2){
            result = excel.findAverage();
            resultT.setText(String.valueOf(result));
        }else if (rdoChecked ==3){
            result = excel.findMax();
            resultT.setText(String.valueOf(result));
        }else if (rdoChecked ==4){
            result = excel.findMin();
            resultT.setText(String.valueOf(result));
        }

    }
       
    
}
