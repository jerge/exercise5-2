package tda551.polygons.polygon;

import java.awt.*;

class Square extends Polygon {
  Square(int x, int y) {
    super(x, y);
  }

  @Override
  public void paint(Graphics g) {
    g.drawRect(centerPoint.x - 10, centerPoint.y - 10, 20, 20);
  }
}
