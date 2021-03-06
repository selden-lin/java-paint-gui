package model;

import java.awt.Graphics;

public class Circle implements Shape{
	Point center;
	int radius;
	public Circle(Point start, Point end) {
		int x1 = start.getX();
		int y1 = start.getY();
		int x2 = end.getX();
		int y2 = end.getY();
		this.center = start;
		this.radius = (int)Math.sqrt(Math.pow(x1-x2, 2)+Math.pow(y1-y2, 2));
	}
	
	public Circle(Point center, int radius) {
		this.center = center;
		this.radius = radius;
	}
	
	public ShapeType getShapeType() {
		return ShapeType.circle;
	}
	
	public String toString() {
		return "(circle,"+this.center.toString()+","+Integer.toString(this.radius)+")";
	}

	@Override
	public void draw(Graphics g) {
		g.drawOval(this.center.getX()-this.radius, this.center.getY()-this.radius, this.radius*2, this.radius*2);
	}
	
	public int getRadius() {
		return this.radius;
	}
	
	public Point getCenter() {
		return this.center;
	}

	@Override
	public Shape getBaseShape() {
		// TODO Auto-generated method stub
		return this;
	}

}
