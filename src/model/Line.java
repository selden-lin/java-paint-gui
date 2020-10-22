package model;

import java.awt.Graphics;

public class Line implements Shape{
	Point start, end;
	public Line (Point start, Point end) {
		this.start = start;
		this.end = end;
	}
	
	@Override
	public void draw(Graphics g) {
		int x1 = start.getX();
		int y1 = start.getY();
		int x2 = end.getX();
		int y2 = end.getY();
		
		g.drawLine(x1, y1, x2, y2);
	}
	
	public String toString() {
		return "Line: ("+this.start.toString()+", "+this.end.toString();
	}
}
