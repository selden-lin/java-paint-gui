package gui.btnHandlers;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;

import controller.PaintController;

public class ColorBtnHandler implements ActionListener{
	PaintController ctrl = PaintController.getInstance();
	@Override
	public void actionPerformed(ActionEvent e) {
		Color color=JColorChooser.showDialog((JButton)e.getSource(),"Select a color", ctrl.getColor());   
		this.ctrl.setColor(color);
	}

}
