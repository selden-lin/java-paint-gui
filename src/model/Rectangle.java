package model;

import java.awt.Graphics;

import model.Shape;
public class Rectangle implements Shape{
	Point start,end;
	public Rectangle(Point start, Point end) {
		this.start = start;
		this.end = end;
	}

	
	public ShapeType getShapeType() {
		return ShapeType.rectangle;
	}
	
	@Override
	public void draw(Graphics g) {
		int x1 = start.getX();
		int y1 = start.getY();
		int x2 = end.getX();
		int y2 = end.getY();
		
		int width=Math.abs(x1-x2),height=Math.abs(y1-y2);
		if(x2 < x1) {
			int temp = x1;
			x1 = x2;
			x2 = temp;
		}
		if (y2 < y1) {
			int temp = y1;
			y1 = y2;
			y2 = temp;
		}
		g.drawRect(x1,  y1, width, height);
	}
	
	
	public Point getStartPoint() {
		return this.start;
	}
	public Point getEndPoint() {
		return this.end;
	}

	
	@Override
	public Shape getBaseShape() {
		// TODO Auto-generated method stub
		return this;
	}

}
