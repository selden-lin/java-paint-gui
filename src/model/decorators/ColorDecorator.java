package model.decorators;

import java.awt.Color;
import java.awt.Graphics;

import model.Shape;
import model.ShapeType;

public class ColorDecorator implements Shape{
	private Shape prevShape;
	private Color color;
	public ColorDecorator(Shape s, Color c) {
		this.prevShape = s;
		this.color = c;
	}
	
	public Shape getBaseShape() {
		return this.prevShape.getBaseShape();
	}
	
	public String toString() {
		String s = "(color,"+String.valueOf(this.color.getRGB())+","+this.prevShape.toString()+")";
		return s;
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(color);
		prevShape.draw(g);
	}

	@Override
	public ShapeType getShapeType() {
		return this.prevShape.getShapeType();
	}
	
}
