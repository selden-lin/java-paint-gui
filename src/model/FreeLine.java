package model;

import java.awt.Graphics;
import java.util.ArrayList;

public class FreeLine implements Shape{
	ArrayList<Point> points = new ArrayList<Point>();
	public FreeLine (Point start, Point end) {
		this.points.add(start);
		this.points.add(end);
	}
	
	public ShapeType getShapeType() {
		return ShapeType.freeLine;
	}
	
	public void addPoint(Point p) {
		this.points.add(p);
	}
	
	@Override
	public void draw(Graphics g) {
		for(int x=1;x<this.points.size();x++) {
			int x1 = points.get(x-1).getX();
			int y1 = points.get(x-1).getY();
			int x2 = points.get(x).getX();
			int y2 = points.get(x).getY();
			g.drawLine(x1, y1, x2, y2);
		}
	}

	@Override
	public Shape getBaseShape() {
		// TODO Auto-generated method stub
		return this;
	}
}
