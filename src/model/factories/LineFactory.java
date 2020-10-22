package model.factories;

import model.*;

public class LineFactory implements ShapeFactory{
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
		return new Line(this.start,this.end);
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		this.start = null;
		this.end = null;
	}

}
