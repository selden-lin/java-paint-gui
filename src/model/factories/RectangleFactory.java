package model.factories;

import model.Rectangle;
import model.Point;
import model.Shape;

public class RectangleFactory implements ShapeFactory{
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
		return new Rectangle(this.start,this.end);
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		this.start = null;
		this.end = null;
	}

}
