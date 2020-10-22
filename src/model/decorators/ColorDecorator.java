package model.decorators;

import java.awt.Color;
import java.awt.Graphics;

import model.Shape;

public class ColorDecorator implements Shape{
	Shape prev_shape;
	Color c;
	public ColorDecorator(Shape s, Color c) {
		this.prev_shape = s;
		this.c = c;
	}
	@Override
	public void draw(Graphics g) {
		g.setColor(c);
		prev_shape.draw(g);
	}

}
