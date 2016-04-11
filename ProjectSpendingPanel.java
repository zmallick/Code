import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

public class ProjectSpendingPanel extends JPanel
 {
     private Vector projectList;
     private JList list1;
     private JButton button2;
     private JLabel label1,label2;
     private JTextField field1;
     private JTextArea area1;
   //Constructor initialize each component and arrange them using
   //certain layouts

     public ProjectSpendingPanel(Vector projectList)
     {
         this.projectList = projectList;


  		 JPanel p1 = new JPanel();
  		 p1.setLayout(new BorderLayout());
  		 JPanel p2 = new JPanel();
  		 p2.setLayout(new GridLayout(2,1));
  		 JPanel p3 = new JPanel();
  		 p3.setLayout(new BorderLayout());
         list1 = new JList(projectList);

         label2 = new JLabel("Choose a project to specify some spending:");
         p1.add(label2,BorderLayout.NORTH);
         p1.add(list1,BorderLayout.CENTER);

		label1 = new JLabel("Specify your amount to spend:");
         p2.add(label1);
         field1 = new JTextField(50);
         p2.add(field1);
         button2 = new JButton("Add Spending");



         ButtonListener button = new ButtonListener();
         button2.addActionListener(button);

         p3.add(p2,BorderLayout.SOUTH);

         p3.add(button2,BorderLayout.EAST);

         p1.add(p3,BorderLayout.SOUTH);

		setLayout(new BorderLayout());
		 add(p1, BorderLayout.CENTER);
		 
		 



         //organize components for spending panel
     }

 //This method  refreshes the JList with
 //updated vector information
 public void updateProjectList()
  {
     list1.updateUI();
	 //call updateUI() for the JList object
  }

 //ButtonListener class listens to see the button "Add Spending" is pushed.
 //A user can choose which project to add spending, and that will update the
 //spending and current balance of such project.
 private class ButtonListener implements ActionListener
  {
       public void actionPerformed(ActionEvent event)
        {


    	   String text5 = field1.getText();
    	   double amount2 = Double.parseDouble(text5);
    	   int int2 = list1.getSelectedIndex();
    	   Project object1 = (Project)(projectList.get(int2));
    	   object1.addExpenditure(amount2);
    	   updateProjectList();


    	   //get some additional spending from the textfield,
          //update the spending and current balance
          //for the chosen project in the JList.
        }
  } //end of ButtonListener class

} //end of ProjectSpending class