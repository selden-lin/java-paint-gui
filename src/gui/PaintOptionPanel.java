package gui;

import javax.swing.*;
import java.awt.*;

import gui.ShapeButton;
import gui.btnHandlers.*;
public class PaintOptionPanel extends JPanel {
	ShapeButton rectangleBtn, circleBtn, lineBtn, freeLineBtn, colorBtn;
	public PaintOptionPanel() {
		this.rectangleBtn = new ShapeButton("rectangle");
		this.rectangleBtn.addActionListener(new RectangleBtnHandler());
		
		this.circleBtn= new ShapeButton("circle");
		this.circleBtn.addActionListener(new CircleBtnHandler());
		
		this.lineBtn = new ShapeButton("line");
		this.lineBtn.addActionListener(new LineBtnHandler());
		
		this.freeLineBtn = new ShapeButton("freeLine");
		this.freeLineBtn.addActionListener(new FreeLineHandler());
		
		this.colorBtn = new ShapeButton("color");
		this.colorBtn.addActionListener(new ColorBtnHandler());
		
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		this.add(this.rectangleBtn);
		this.add(this.circleBtn);
		this.add(this.lineBtn);
		this.add(this.freeLineBtn);
		this.add(this.colorBtn);
	}
}
