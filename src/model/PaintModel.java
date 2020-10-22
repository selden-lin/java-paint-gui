package model;

import java.util.*;

import javax.swing.ButtonModel;

import model.ShapeType;
import model.factories.*;
import model.factories.*;
public class PaintModel {
	private ShapeType shape = ShapeType.line;
	private ArrayList<Shape> shapeQueue = new ArrayList<Shape>();
	private ShapeFactory shapeMaker = new LineFactory();
	private HashMap<ShapeType, ButtonModel> btnModels = new HashMap<ShapeType, ButtonModel>();
	
	public void setShape(ShapeType shape) {
		switch(shape) {
		case line:
			this.shapeMaker = new LineFactory();
			break;
		case rectangle:
			this.shapeMaker = new RectangleFactory();
			break;
		case circle:
			this.shapeMaker = new CircleFactory();
			break;
		case freeLine:
			this.shapeMaker = new FreeLineFactory();
			break;
		}
	}
	
	public void setStartPoint(Point start) {
		this.shapeMaker.setStart(start);
	}
	
	public Shape setDragPoint(Point end) {
		return this.shapeMaker.setEnd(end);
	}
	
	public void setEndPoint(Point end) {
		this.shapeQueue.add(this.shapeMaker.setEnd(end));
		this.shapeMaker.reset();
	}
	
	public ArrayList<Shape> getShapes() {
		return this.shapeQueue;
	}
	
	public void disableShapeBtn(ShapeType shape, ButtonModel model) {
		if (!this.btnModels.containsKey(shape)) {
			this.btnModels.put(shape, model);
		}
		for(ShapeType s: this.btnModels.keySet()) {
			if (s != shape) {
				this.btnModels.get(s).setEnabled(true);
			}
		}
	}
	
	public HashMap<ShapeType, ButtonModel> getBtnModels() {
		return this.btnModels;
	}
}
