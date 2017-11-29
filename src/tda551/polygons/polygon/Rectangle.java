package tda551.polygons.polygon;

import java.awt.*;

class Rectangle extends Polygon {
  Rectangle(int x, int y) {
    super(x, y);
  }

  public void paint(Graphics g) {
    g.drawRect(centerPoint.x - 20, centerPoint.y - 10, 40, 20);
  }
}
