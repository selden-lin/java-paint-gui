package model;

import java.awt.Canvas;
import java.awt.Color;
import java.util.*;

import javax.swing.ButtonModel;

import gui.PaintCanvas;
import model.ShapeType;
import model.decorators.ColorDecorator;
import model.decorators.FillDecorator;
import model.factories.*;
import model.factories.*;
public class PaintModel {
	private ShapeType shape = ShapeType.rectangle;
	private ArrayList<Shape> shapeQueue = new ArrayList<Shape>();
	private ArrayList<Shape> undoQueue = new ArrayList<Shape>();
	private ShapeFactory shapeMaker = new RectangleFactory();
	private HashMap<ShapeType, ButtonModel> btnModels = new HashMap<ShapeType, ButtonModel>();
	private PaintCanvas canvas;
	private boolean isFill = false;
	
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
		if (this.isFill) {
			s = new FillDecorator(s);
		}
		s = new ColorDecorator(s, this.color);
		
		return s;
	}
	
	public void setEndPoint(Point end) {
		Shape s = this.shapeMaker.setEnd(end);
		if (this.isFill) {
			s = new FillDecorator(s);
		}
		s = new ColorDecorator(s, this.color);
		
		this.shapeQueue.add(s);
		this.shapeMaker.reset();
		this.undoQueue.clear();
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
	
	public void toggleFill() {
		this.isFill = !this.isFill;
	}
	
	public void setCanvas(PaintCanvas canvas2) {
		this.canvas = canvas2;
	}
	
	public void setCanvasBackground(Color color) {
		Shape r = new Rectangle(new Point(0,0), new Point(this.canvas.getWidth(), this.canvas.getHeight()));
		r = new FillDecorator(r);
		r = new ColorDecorator(r, color);
		this.shapeQueue.add(r);
		this.canvas.repaint();
	}
	
	public void undo() {
		if (this.shapeQueue.size() > 0) {			
			Shape old = this.shapeQueue.remove(this.shapeQueue.size()-1);
			this.undoQueue.add(old);
			this.canvas.repaint();
		}
	}
	
	public void redo() {
		if(this.undoQueue.size() > 0) {			
			Shape redo = this.undoQueue.remove(this.undoQueue.size()-1);
			this.shapeQueue.add(redo);
			this.canvas.repaint();
		}
	}
}
