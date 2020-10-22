package gui;

import javax.swing.*;
import java.awt.*;

public class ShapeButton extends JButton { 
	private String shape;
	public ShapeButton(String shape) {
		this.shape = shape;
		this.setText(shape);
		
		Dimension size = new Dimension(100, 50);
		this.setMinimumSize(size);
		this.setPreferredSize(size);
		this.setMaximumSize(size);
	}
	public String getShape() {
		return this.shape;
	}
}
