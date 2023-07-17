package gui_swing_events;
import javax.swing.*;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class SwingEventWindow extends JFrame implements ActionListener, ItemListener{
    //create two lables for titles
    private JLabel h1 = new JLabel();
    private JLabel h2 = new JLabel();

    //create one input text field
    private JTextField inputT = new JTextField(40);

    //create one button for calcuation
    private JButton cal = new JButton("Calculate");

    //create a textfield to display result
    private JTextField resultT = new JTextField(40);
    
    //create a main panel
    private JPanel mainP = new JPanel();
    
    //create six seperate panels
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
    
    //create a initial viriable for result
    double result=0.0;
    
    //create a flag varible for radio button selection
    int rdoChecked = 1;

      public SwingEventWindow(){
            
            super("Excel Formula Window");
            setSize(500,400);
            setVisible(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            resultT.setText("Result: " + result);
            // set text for those two lables
            h1.setText("Excel Functions");
            h2.setText("Enter Your Numbers Seperated By Spaces");
            
            rSum.addActionListener(this);
            rAverage.addActionListener(this);
            rMax.addActionListener(this);
            rMin.addActionListener(this);
            // For some reason, we encountered issue while runing this part. after some rearch online, 
            //we found we can fix this error by manually calling it
            cal.addActionListener(e -> {
                itemStateChanged(null);
            });

            mainP.setLayout(new GridLayout(6, 1)); // 6 rows, 1 column

        //add each components to different panels

            pn1.add(h1);
            pn2.add(h2);
            pn3.add(inputT);
            pn4.add(rSum);
            pn4.add(rAverage);
            pn4.add(rMax);
            pn4.add(rMin);
            pn5.add(cal);
            pn6.add(resultT);
            
            //add four radio buttons into button group
            myGroup.add(rSum);
            myGroup.add(rAverage);
            myGroup.add(rMax);
            myGroup.add(rMin);

            //add all panels into the main panel
            mainP.add(pn1);
            mainP.add(pn2);
            mainP.add(pn3);
            mainP.add(pn4);
            mainP.add(pn5);
            mainP.add(pn6);

            //add the main panel
            add(mainP);  
      
      }

    @Override
    public void actionPerformed(ActionEvent e) {

        //get radio selection value by using e.getSource(), if AutoSum is selected, rdoChecked is set to 1
        //same logic for all four buttons

        if (e.getSource() == rSum) {
            rdoChecked = 1;
        }else if(e.getSource() == rAverage){
            rdoChecked = 2;
        }else if(e.getSource() == rMax){
            rdoChecked = 3;
        }else if(e.getSource() == rMin){
            rdoChecked = 4;
        }
    }
    @Override
    public void itemStateChanged(ItemEvent e) {
       
        //Initialize the excel object and get the user's input string from the first textfield
        Excel excel = new Excel(inputT.getText());
        
        //create if conditions for each radio button
        if (rdoChecked==1){// if rdoChecked is equal to 1, call findTotal()
            result = excel.findTotal();
            resultT.setText("Result: "+ String.valueOf(result));
        }else if (rdoChecked ==2){// if rdoChecked is equal to 2, call findAverage()
            result = excel.findAverage();
            resultT.setText("Result: "+ String.valueOf(result));
        }else if (rdoChecked ==3){// if rdoChecked is equal to 3, call findMax()
            result = excel.findMax();
            resultT.setText("Result: "+ String.valueOf(result));
        }else if (rdoChecked ==4){// if rdoChecked is equal to 4, call findMin()
            result = excel.findMin();
            resultT.setText("Result: "+ String.valueOf(result));
        }

    }
       
    
}
