// Assignment #: 7
//         Name: Zeeshan Mallick
//    StudentID: 1208822598
//      Lecture: Tuesday/Thursday 4;30 - 5:45
//  Arizona State University CSE205
//  Description: Line class that will be called when in the paintComponent class.
import java.awt.Color;
import java.applet.*;
import java.awt.*;
public class Line 
{
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	private Color color;
	
	
	public Line(int x1, int y1, int x2, int y2, Color Color)
	{
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
		this.color = color;
	}
	
	public void draw(Graphics page)
	{
		page.setColor(color);
		page.drawLine(x1, y1, x2, y2);
		
		
	}
	

}