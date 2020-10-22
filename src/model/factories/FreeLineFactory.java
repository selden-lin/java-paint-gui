package model.factories;

import model.FreeLine;
import model.Point;
import model.Shape;

public class FreeLineFactory implements ShapeFactory{
	private Point start;
	private FreeLine line;
	@Override
	public void setStart(Point p) {
		// TODO Auto-generated method stub 
		this.start = p;
	}

	@Override
	public Shape setEnd(Point p) {
		// TODO Auto-generated method stub
		if (line == null) 
			this.line = new FreeLine(start, p);
		else
			this.line.addPoint(p);

		return this.line;
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		this.start = null;
		this.line = null;
	}

}
