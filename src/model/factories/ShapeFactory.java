package model.factories;

import model.*;

public interface ShapeFactory {
	public void setStart(Point p);
	public Shape setEnd(Point p);
	public void reset();
}
