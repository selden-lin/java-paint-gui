package model.factories;

import model.Point;
import model.Circle;
import model.Shape;

public class CircleFactory implements ShapeFactory{
	private Point start, end;
	@Override
	public void setStart(Point p) {
		// TODO Auto-generated method stub
		this.start = p;
	}

	@Override
	public Shape setEnd(Point p) {
		// TODO Auto-generated method stub
		this.end = p;
		return new Circle(this.start,this.end);
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		this.start = null;
		this.end = null;
	}
}
