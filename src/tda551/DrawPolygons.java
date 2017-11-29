package tda551;

/* This is now all we (can) use from the sub-package */

import tda551.polygons.polygon.*;

/* By commenting out the imports above, and instead importing the adapter package,
 * we effectively switch to using the tda551.shapes package.
 */
//import tda551.adapter.*;

import javax.swing.*;
import java.awt.Graphics;
import java.util.*;

public class DrawPolygons extends JComponent {
  public ArrayList<IPolygon> polygons;
  public boolean direction = true;
  public int ticker = 0;
  public JFrame frame;

  public DrawPolygons() {
    polygons = new ArrayList<>(10);

    polygons.add(PolygonFactory.createSquare(50, 50));
    polygons.add(PolygonFactory.createTriangle(100, 100));
    polygons.add(PolygonFactory.createRectangle(50, 150));

  }//constructor

  public void update() {
    ticker++;
    int value = direction ? 10 : -10;
    for (IPolygon p : polygons) {
      p.updateCenter(p.getCenter().x + value, p.getCenter().y + value);
    }
    if (ticker > 10) {
      direction = !direction;
      ticker = 0;
    }
    repaint();
  }

  @Override
  public void paint(Graphics g) {
    for (IPolygon currentPolygon : polygons) {
      currentPolygon.paint(g);
    }
  }//paint

  public static void main(String[] args) {
    JFrame frame = new JFrame();
    DrawPolygons polygons = new DrawPolygons();
    polygons.frame = frame;

    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setBounds(30, 30, 300, 300);
    frame.getContentPane().add(polygons);
    frame.setVisible(true);

    try {
      while (true) {
        Thread.sleep(500);
        polygons.update();
      }
    } catch (InterruptedException e) {
    }
  }
}