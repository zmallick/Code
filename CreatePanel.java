import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class CreatePanel extends JPanel
 {
   private Vector projectList;
   private JButton button1;
   private ProjectSpendingPanel spendingPanel;
   private JLabel projectnameApp1;
   private JLabel projectnameApp2;
   private JLabel projectnameApp3;
   private JLabel projectnameApp4;
   private JTextField textField1;
   private JTextField textField2;
   private JTextField textField3;
   private JTextField textField4;
   private JTextArea area1;
   private JLabel message;
   private JScrollPane pane;
  

 //Constructor initializes components and organize them using certain layouts
 public CreatePanel(Vector projectList, ProjectSpendingPanel spendingPanel)
  {
    this.projectList = projectList;
    this.spendingPanel = spendingPanel;

    //organize components here

    button1 = new JButton("Create a project");
    add(button1);
    
    JPanel panel1 = new JPanel(new GridLayout (1,2));
    JPanel panel2 = new JPanel(new GridLayout(3,1));
    JPanel panel3 = new JPanel(new GridLayout(4,2));
  
    
    message = new JLabel("");
    message.setForeground(Color.red);
    message.setVisible(false);
    
    projectnameApp1 = new JLabel("Project Name");
    //add(projectnameApp1);
    
    textField1 = new JTextField(20);
    //add(textField1);
    
    projectnameApp2 = new JLabel("Project Number");
   // add(projectnameApp2);
    
    textField2 = new JTextField(20);
    //add(textField2);

    projectnameApp3 = new JLabel("Project Location");
    //add(projectnameApp3);
    
    textField3 = new JTextField(20);
    //add(textField3);
    
    projectnameApp4 = new JLabel("Initial Funding");
    //add(projectnameApp4);
    
    textField4 = new JTextField(20);
    //add(textField4);
    
    area1 = new JTextArea("No Project", 20, 40);
    
    pane = new JScrollPane(area1);
    //add(pane);
    
    panel3.add(projectnameApp1);
    panel3.add(textField1);
    
    panel3.add(projectnameApp2);
    panel3.add(textField2);
    
    panel3.add(projectnameApp3);
    panel3.add(textField3);
    
    panel3.add(projectnameApp4);
    panel3.add(textField4);
   
    
    panel2.add(message);
    panel2.add(panel3);
    panel2.add(button1);
    
    panel1.add(panel2);
    panel1.add(pane); //add this
    //panel1.add(area1);
    add(panel1);
    
    
    
 //--------------------------------------------------------------------------  
   
    
    
    
    
     //needs to start with no project
    //add(area1);
    
    ButtonListener ron = new ButtonListener();
    button1.addActionListener(ron);
    
    String text ="";
    String text2="";
    String text3="";
    String text4 = "";
    
    
  }


  //ButtonListener is a listener class that listens to
  //see if the button "Create a project" is pushed.
  //When the event occurs, it adds a project information from
  //the text fields to the text area. It also creates a Project object
  //using the information and add it to the projectList.
  //It also does error checking.
  private class ButtonListener implements ActionListener
   {
	  
    public void actionPerformed(ActionEvent event)
     {
       // if there is no error, add a project to project list
       // otherwise, show an error message
    	

        String text ="";
        String text2="";
        String text3="";
        String text4 = "";
    	
    	
    	text = textField1.getText();
    	text2 = textField2.getText();
        text3 = textField3.getText();
      	text4 = textField4.getText();
      	
    	if (text.equals("") || text2.equals("")|| text3.equals("") || text4.equals(""))
    	{
    		message.setText("Please fill all fields");
    		message.setVisible(true);
    	}
    	
    	
    	else try 
    	{	
    	if (area1.getText().equals("No Project"))
    			{
    				area1.setText("");
    			}
    	
    	
    	double amount = Double.parseDouble(text4);
    	Project object = new Project(amount);
    	projectList.add(object);
    	
    
    	
    	object.setName(text); //using methods in the project class
    	
   
    	
    	int int1 = Integer.parseInt(textField2.getText());
    	object.setNumber(int1);
    	
    	
    	object.setLocation(text3);
    
    	area1.append(object.toString());   
    	//add(area1);
    	spendingPanel.updateProjectList();
    	
    	message.setText("Project Added");
    	message.setVisible(true);
    	
     
    }
    catch (NumberFormatException ex)
    {
    	message.setText("Please enter numerical values for the field labeled Project Number and Initial Funding");
    	message.setVisible(true);
    }
    	
    	
   
    	
    	
    	
    	
    	
     } //end of actionPerformed method
  } //end of ButtonListener class

} //end of CreatePanel class