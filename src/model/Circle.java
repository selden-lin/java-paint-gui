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
	@Override
	public void draw(Graphics g) {
		g.drawOval(this.center.getX()-this.radius, this.center.getY()-this.radius, this.radius*2, this.radius*2);
		
	}

}
