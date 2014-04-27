//This is a sample java script for running the pipeline

//http://stackoverflow.com/questions/13991007/execute-external-program-in-java

//Writing a simple java applet: http://www.cs.colorado.edu/~main/applets/Simple.html

// Simple adding applet: http://www.roseindia.net/answers/viewqa/Java-Beginners/18504-Applet-for-add-two-numbers.html


import java.applet.Applet; // Provides the Applet class.
import java.awt.*;         // Provides Button class, etc.
import java.awt.event.*;   // Provides ActionEvent, ActionListener 
import JTable;


//applet temporarily an adding app

public class pipe extends Applet{
	int sum;
	int x;
	int y;
	public void init() {
		String num1;
		String num2;
		// read first number from the keyboard
		num1 = JOptionPane.showInputDialog("Enter a First number");
		// read seond number from the ketboard
		num2 = JOptionPane.showInputDialog("Enter a Second number");
		x= Integer.parseInt(num1); // comvert the string to an integer
		y= Integer.parseInt(num2); // convert the string to an integer
		sum = x + y;
}

public void paint(Graphics g) {
	//writes the output in the applet starting at position 30, 30
	g.drawString("The sum of x ("+x+") +y ("+y+")="+sum, 30,30);\
}

}