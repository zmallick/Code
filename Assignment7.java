// Assignment #: 7
//         Name: Zeeshan Mallick
//    StudentID: 1208822598
//      Lecture: Tuesday/Thursday 4;30 - 5:45
//  Arizona State University CSE205
//  Description: This is the class that will make the applet that contains the applet.

import javax.swing.*;

public class Assignment7 extends JApplet
{

 public void init()
  {
    // create a WholePanel object and add it to the applet
    WholePanel wholePanel = new WholePanel();
    getContentPane().add(wholePanel);

    //set applet size to 400 X 400
    setSize (400, 400);
  }

}

