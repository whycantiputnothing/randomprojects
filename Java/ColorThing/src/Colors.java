import java.awt.*;
import java.applet.*;

public class Colors extends Applet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1889057656836429376L;
	TextField text1;
	int x;
	int[][] RGB = { { 0, 0, 0 }, { 12, 50, 75 }, { 123, 156, 125 }, { 100, 220, 255 }, { 0, 0, 0 }, { 0, 0, 0 },
			{ 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 },
			{ 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 },
			{ 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 },
			{ 0, 0, 0 }, { 0, 0, 0 } };

	public void init() {
		text1 = new TextField(8);
		add(text1);
		text1.setText("a");
	}

	public void paint(Graphics g) {
		String s1;
		g.drawString("Input a letter in the box  ", 40, 50);
		try {
			s1 = text1.getText();
			x = Character.getNumericValue(s1.charAt(0));

		} catch (Exception e) {

		}
		paint2(g);
	}

	public void paint2(Graphics g) {
		Color color = new Color(RGB[x - 10][0], RGB[x - 10][1], RGB[x - 10][2]);
		g.setColor(color);
		g.fillRect(80, 100, 40, 40);
	}

	public boolean action(Event event, Object obj) {
		repaint();
		return true;
	}
}