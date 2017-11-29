package tda551.polygons.polygon;

import javax.swing.*;
import java.awt.*;

abstract class Polygon extends JComponent implements IPolygon {
  public Point centerPoint;

  Polygon(Point center) {
    this.centerPoint = center;
  }

  Polygon(int x, int y) {
    this(new Point(x, y));
  }

  public void updateCenter(int x, int y) {
    this.centerPoint = new Point(x, y);
  }

  public Point getCenter() {
    return centerPoint;
  }

  @Override
  public abstract void paint(Graphics g)//paint
  ;
}
