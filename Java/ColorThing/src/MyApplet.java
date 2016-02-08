import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class MyApplet extends Applet  { 
    TextField inputLine = new TextField(15);  
    int x;
    
    int[][] RGB = {
    		{0, 0, 0}, {0, 0, 0}, {0, 0, 0},
    		{0, 0, 0}, {0, 0, 0}, {0, 0, 0},
    		{0, 0, 0}, {0, 0, 0}, {0, 0, 0},
    		{0, 0, 0}, {0, 0, 0}, {0, 0, 0},
    		{0, 0, 0}, {0, 0, 0}, {0, 0, 0},
    		{0, 0, 0}, {0, 0, 0}, {0, 0, 0},
    		{0, 0, 0}, {0, 0, 0}, {0, 0, 0},
    		{0, 0, 0}, {0, 0, 0}, {0, 0, 0},
    		{0, 0, 0}, {0, 0, 0}, {0, 0, 0},
    		{0, 0, 0}, {0, 0, 0}, {0, 0, 0},
    		{0, 0, 0}, {0, 0, 0}};
    public MyApplet() {
        add(inputLine);
        inputLine.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    String s = inputLine.getText();
                    x = Integer.parseInt(s);
                    
                }
            }
         );
    }
    
    public void paint(Graphics g) {
    	Color color = new Color(x, x, x);
        g.setColor(color);
        g.fillRect(50,50, 100,50);
     }
}
