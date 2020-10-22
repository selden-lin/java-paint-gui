package model;

import java.awt.Color;
import java.util.*;

import javax.swing.ButtonModel;

import model.ShapeType;
import model.decorators.ColorDecorator;
import model.factories.*;
import model.factories.*;
public class PaintModel {
	private ShapeType shape = ShapeType.line;
	private ArrayList<Shape> shapeQueue = new ArrayList<Shape>();
	private ShapeFactory shapeMaker = new LineFactory();
	private HashMap<ShapeType, ButtonModel> btnModels = new HashMap<ShapeType, ButtonModel>();
	
	// shape properties
	private Color color = Color.black;
	private boolean isFilled = false;
	private int thickness = 1;
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
		Shape s = this.shapeMaker.setEnd(end);
		s = new ColorDecorator(s, this.color);
		
		return s;
	}
	
	public void setEndPoint(Point end) {
		Shape s = this.shapeMaker.setEnd(end);
		s = new ColorDecorator(s, this.color);
		
		this.shapeQueue.add(s);
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
	
	public void setColor(Color color) {
		this.color = color;
	}
	public Color getColor() {
		return this.color;
	}
}
