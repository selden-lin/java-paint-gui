package controller;

import java.awt.Canvas;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ButtonModel;

import gui.PaintCanvas;
import model.*;

public class PaintController {
	private static PaintController instance;
	private PaintModel paintModel;
	private Point startPoint, endPoint;
	private Shape currShape;
	
	private PaintController() {
		this.paintModel = new PaintModel();
	}
	
	public static PaintController getInstance() {
		if (instance == null) {
			instance = new PaintController();
		}
		return instance;
	}
	
	public void setStartPoint (int x, int y) {
		this.startPoint = new Point(x,y);
		this.paintModel.setStartPoint(this.startPoint);
	}
	
	public void setDragPoint (int x, int y) {
		this.currShape = this.paintModel.setDragPoint(new Point(x,y));
	}
	
	
	public void clearScreen() {
		this.paintModel.setCanvasBackground(Color.white);
	}
	
	public void setCanvas(PaintCanvas canvas) {
		this.paintModel.setCanvas(canvas);
	}
	
	public void setEndPoint (int x, int y) {
		this.endPoint = new Point(x,y);
		this.paintModel.setEndPoint(this.endPoint);
		this.currShape = null;
	}
	
	public void setShape(ShapeType shape) {
		this.paintModel.setShape(shape);
	}
	
	public void toggleFill() {
		this.paintModel.toggleFill();
	}
	
	public Shape getCurrShape() {
		return this.currShape;
	}
	
	public ArrayList<Shape> getAllShapes() {
		ArrayList<Shape> allShapes = (ArrayList<Shape>) this.paintModel.getShapes().clone();
		allShapes.add(this.currShape);
		return allShapes;
	}
	
	public void disableShapeBtn(ShapeType shape, ButtonModel model) {
		this.paintModel.disableShapeBtn(shape, model);
	}
	
	public HashMap<ShapeType, ButtonModel> getBtnModels() {
		return this.paintModel.getBtnModels();
	}
	
	public void setColor(Color c) {
		this.paintModel.setColor(c);
	}
	public Color getColor() {
		return this.paintModel.getColor();
	}
}
