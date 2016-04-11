// Assignment #: 7
//  Description: The whole panel creates components for the whole panel
//  of this applet. It also contains CanvasPanel, ButtonListener, ColorListener,
//  and PointListner classes.

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class WholePanel extends JPanel
{
   private Color currentColor;
   private CanvasPanel canvas;
   private JPanel primary, buttonPanel, topPanel;
   private JButton erase, undo;
   private String[] colorList = {"black", "red", "blue", "green", "orange"};
   private JRadioButton[] colorRadio;
   private ButtonGroup group;
   private ArrayList lineList, tempList;
   private Color[] colors;
   private int x1, y1, x2, y2, x3, y3;
   private boolean mouseDragged = false;

   public WholePanel()
   {
      //default color to draw is black
      currentColor = Color.black;
      lineList = new ArrayList();
      tempList = new ArrayList();

      //create buttons
      erase = new JButton("Erase");
      undo = new JButton ("Undo");
      erase.addActionListener (new ButtonListener());
      undo.addActionListener (new ButtonListener());

      buttonPanel = new JPanel();
      buttonPanel.setLayout(new GridLayout(colorList.length+2,1));

      group = new ButtonGroup();
      colorRadio = new JRadioButton[colorList.length];

      //create 5 radio buttons for each color and add it to the RadioGroup,
      //a panel, and also add its action listener
      for (int i=0; i<colorList.length; i++)
       {
        colorRadio[i] = new JRadioButton(colorList[i]);
        group.add(colorRadio[i]);
        buttonPanel.add(colorRadio[i]);
        colorRadio[i].addActionListener(new ColorListener());
       }

      buttonPanel.add(undo);
      buttonPanel.add(erase);

      //store 5 colors in an array
      colors = new Color[5];
      colors[0] = Color.black;
      colors[1] = Color.red;
      colors[2] = Color.blue;
      colors[3] = Color.green;
      colors[4] = Color.orange;

      topPanel = new JPanel();
      topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
      topPanel.add(buttonPanel);

      //canvas panel is where lines will be drawn, thus
      //it will be listening to a mouse.
      canvas = new CanvasPanel();
      canvas.setBackground(Color.white);
      canvas.addMouseListener(new PointListener());
      canvas.addMouseMotionListener(new PointListener());

      JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, topPanel, canvas);

      setLayout(new BorderLayout());
      add(sp);
    }

   //ButtonListener defined actions to take in case
   //"Undo", or "Erase" is chosen.
   private class ButtonListener implements ActionListener
    {
      public void actionPerformed (ActionEvent event)
      {
       Object source = event.getSource();

       if (source == undo)  //in case "undo" button is pushed
        {
            if(lineList.size() > 0)
              {
                lineList.remove(lineList.size()-1);
              }
            //the following is for "undo" after "erase"
            //It copies the content of lineList to a backup arraylist.
            else if (lineList.isEmpty())
              {
                for (int i=0; i<tempList.size(); i++)
                 {
                   lineList.add(tempList.get(i));
                 }
                tempList.clear();

              }
            canvas.repaint();
        }
       else if (source == erase) //in case "erase" button is pushed
        {
          if (!lineList.isEmpty())
           {
               tempList.clear();
               for (int i=0; i<lineList.size(); i++)
                 {
                     tempList.add(lineList.get(i));
                 }
               lineList.clear();
               canvas.repaint();
           }
        }

      }
   } // end of ButtonListener

   // listener class to set the color chosen by a user using
   // the color radio buttons
   private class ColorListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
         {
            Object source = event.getSource();

            for (int i=0; i<colorList.length; i++)
             {
                 if (source == colorRadio[i])
                  {
                      currentColor = colors[i];
                      break;
                  }
             }
         }
    }


 //CanvasPanel is the panel where lines will be drawn
 private class CanvasPanel extends JPanel
  {
     //this method draws all lines specified by a user
     public void paintComponent(Graphics page)
      {
       super.paintComponent(page);

          //draw all lines
          for (int i=0; i < lineList.size(); i++)
            {
              ((Line) lineList.get(i)).draw(page);
            }

          //draw a temporary line that is currently being drawn.
          if (mouseDragged == true)
           {
            page.setColor(currentColor);
            page.drawLine(x1, y1, x3, y3);
           }

      }
    } //end of CanvasPanel class

   // listener class that listens to the mouse
   public class PointListener implements MouseListener, MouseMotionListener
    {
     //in case that a user presses using a mouse,
     //record the point where it was pressed.
     public void mousePressed (MouseEvent event)
      {
           x1 = event.getPoint().x;
           y1 = event.getPoint().y;
           mouseDragged = true;
      }

     //mouseReleased method takes the point where a mouse is released,
     //using the point and the pressed point to create a line,
     //add it to the ArrayList "lineList", and call paintComponent method.
     public void mouseReleased (MouseEvent event)
      {
          x2 = event.getPoint().x;
          y2 = event.getPoint().y;

          Line line1 = new Line(x1, y1, x2, y2, currentColor);
          lineList.add(line1);
          mouseDragged = false;
          canvas.repaint();

          tempList.clear(); //Once another line is drawn,
                            //erased lines cannot be re-drawn by undo button
      }

     //mouseDragged method takes the point where a mouse is dragged
     //and call paintComponent method
     public void mouseDragged(MouseEvent event)
      {
                x3 = event.getPoint().x;
                y3 = event.getPoint().y;

                canvas.repaint();
      }

     public void mouseClicked (MouseEvent event) {}
     public void mouseEntered (MouseEvent event) {}
     public void mouseExited (MouseEvent event) {}
     public void mouseMoved(MouseEvent event) {}

    } // end of PointListener

} // end of Whole Panel Class