import javax.swing.*;
import java.util.*;

public class Assignment6 extends JApplet
 {
   private int APPLET_WIDTH = 900, APPLET_HEIGHT = 350;

   private JTabbedPane tPane;
   private CreatePanel createPanel;
   private ProjectSpendingPanel spendingPanel;
   private Vector projectList;
   private JLabel projectnameApp1;
   private JLabel projectnameApp2;
   private JLabel projectnameApp3;
   private JLabel projectnameApp4;//new

   //The method init initializes the Applet with a Pane with two tabs
   public void init()
    {
     //list of projects to be used in every panel
     projectList = new Vector();

     //review panel uses the list of projects
     spendingPanel = new ProjectSpendingPanel(projectList);	

     createPanel = new CreatePanel(projectList, spendingPanel);

     //create a tabbed pane with two tabs
     tPane = new JTabbedPane();
     tPane.addTab("Project creation", createPanel);
     tPane.addTab("Project spending", spendingPanel);
     
     
     
     // projectnameApp1 = new JLabel("Project Name");
     
 
     getContentPane().add(tPane);
     setSize (APPLET_WIDTH, APPLET_HEIGHT); //set Applet size
    }
}
