package gui;

import javax.swing.*;

import controller.PaintController;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import gui.ShapeButton;
import gui.btnHandlers.*;
import model.ShapeType;

public class PaintOptionPanel extends JPanel {
	private ShapeButton rectangleBtn, circleBtn, lineBtn, freeLineBtn, colorBtn, resetBtn;
	private PaintController ctrl = PaintController.getInstance();

	public PaintOptionPanel() {
		this.rectangleBtn = new ShapeButton("rectangle");
		this.rectangleBtn.addActionListener(new RectangleBtnHandler());
		this.rectangleBtn.setEnabled(false);
		ctrl.disableShapeBtn(ShapeType.rectangle, this.rectangleBtn.getModel());

		this.circleBtn = new ShapeButton("circle");
		this.circleBtn.addActionListener(new CircleBtnHandler());

		this.lineBtn = new ShapeButton("line");
		this.lineBtn.addActionListener(new LineBtnHandler());

		this.freeLineBtn = new ShapeButton("freeLine");
		this.freeLineBtn.addActionListener(new FreeLineHandler());

		this.colorBtn = new ShapeButton("set color");
		this.colorBtn.addActionListener(new ColorBtnHandler());

		JCheckBox fillBox = new JCheckBox("Fill shape");
		fillBox.setBounds(100,100, 50,50);  
		fillBox.addItemListener(new ItemListener() {    
             public void itemStateChanged(ItemEvent e) {                 
                PaintController p = PaintController.getInstance();
                p.toggleFill();
             }    
          });    
		
		this.resetBtn = new ShapeButton("reset");
		this.resetBtn.addActionListener(new ResetBtnHandler());

		this.setBorder(BorderFactory.createLineBorder(Color.black));
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		this.add(this.rectangleBtn);
		this.add(this.circleBtn);
		this.add(this.lineBtn);
		this.add(this.freeLineBtn);
		this.add(this.colorBtn);
		this.add(this.resetBtn);
		this.add(fillBox);
	}
}
