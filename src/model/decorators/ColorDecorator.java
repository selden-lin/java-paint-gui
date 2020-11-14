package model.decorators;

import java.awt.Color;
import java.awt.Graphics;

import model.Shape;
import model.ShapeType;

public class ColorDecorator implements Shape{
	private Shape prev_shape, baseShape;
	private Color c;
	private ShapeType type;
	public ColorDecorator(Shape s, Color c) {
		this.prev_shape = s;
		this.c = c;
		if (s != null) {
			this.type = s.getShapeType();
			this.baseShape = s.getBaseShape();
		}
	}
	
	public Shape getBaseShape() {
		return this.baseShape;
	}
	
	public String toString() {
		String s = "(color,"+String.valueOf(this.c.getRGB())+","+this.prev_shape.toString()+")";
		return s;
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(c);
		prev_shape.draw(g);
	}

	@Override
	public ShapeType getShapeType() {
		return this.type;
	}
	
}
