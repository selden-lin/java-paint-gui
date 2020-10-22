package gui;

import controller.PaintController;
import javax.swing.*;
import java.awt.*;

public class PaintCanvas extends JPanel{
	private PaintController controller;
	int width = 780, height = 800;
	public PaintCanvas() {
		this.controller = PaintController.getInstance();
		this.setSize(this.width,this.height);
		this.setPreferredSize(new Dimension(this.width, this.height));
		this.setBackground(Color.white);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.white);
		g.fillRect(0, 0, this.width, this.height);
		g.setColor(Color.black);
		for(model.Shape shape : this.controller.getAllShapes()) {
			if (shape != null) {
				shape.draw(g);
			}
		}
    } 
}
