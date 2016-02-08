import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

/**
   A star.
*/
public class Star
{
   private double x;
   private double y;
   private double width;
   private double height;

   /**
      Constructs a Star at x, y coordinates of size w * h
      @param x the x-coordinate of the topleft corner
      @param y the y-coordinate of the topleft corner
      @param w the width
      @param h the height
   */
   public Star(double anX, double aY, double w, double h)
   {
      x = anX;
      y = aY;
      width = w;
      height = h;
   }

   /**
      Draws the star.
      @param g2 the graphics context
   */
   public void draw(Graphics2D g2)
   {
      Line2D.Double diag1 =
         new Line2D.Double(x, y, x + width, y + height);
      Line2D.Double diag2 =
         new Line2D.Double(x, y + height, x + width, y);
      Line2D.Double horiz =
         new Line2D.Double(x, y + height / 2, x + width, y + height / 2);
      Line2D.Double vert =
         new Line2D.Double(x + width / 2, y, x + width / 2, y + height);

      g2.draw(diag1);
      g2.draw(diag2);
      g2.draw(horiz);
      g2.draw(vert);
   }
}

