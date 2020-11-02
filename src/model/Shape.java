package model;

import java.awt.*;

public interface Shape {
	public void draw(Graphics g);
	public ShapeType getShapeType();
	public Shape getBaseShape();
}
