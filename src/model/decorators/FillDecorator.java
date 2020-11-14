package model.decorators;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import model.*;

public class FillDecorator implements Shape{
	Shape prevShape;
	public FillDecorator(Shape s) {
		this.prevShape = s;
	}
	
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		switch(this.prevShape.getShapeType()) {
		case circle:
			Circle c = (Circle) this.getBaseShape();
			int r = c.getRadius();
			model.Point p = c.getCenter();
			g.fillOval(p.getX()-r, p.getY()-r, r*2, r*2);
			break;
		case rectangle:
			Rectangle rect = (Rectangle) this.getBaseShape();
			model.Point rectStart = rect.getStartPoint();
			model.Point rectEnd = rect.getEndPoint();
			int x1 = rectStart.getX();
			int y1 = rectStart.getY();
			int x2 = rectEnd.getX();
			int y2 = rectEnd.getY();
			
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
			g.fillRect(x1,  y1, width, height);
			break;
		default:
			this.prevShape.draw(g);
		}
	}

	@Override
	public ShapeType getShapeType() {
		// TODO Auto-generated method stub
		return this.prevShape.getShapeType();
	}
	
	public String toString() {
		String s = "(fill,"+this.prevShape.toString()+")";
		return s;
	}

	@Override
	public Shape getBaseShape() {
		// TODO Auto-generated method stub
		return this.prevShape.getBaseShape();
	}

}
