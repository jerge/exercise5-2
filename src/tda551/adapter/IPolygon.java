package tda551.adapter;

import java.awt.*;

public interface IPolygon {
  void paint(Graphics g);

  void updateCenter(int newX, int newY);

  Point getCenter();
}
