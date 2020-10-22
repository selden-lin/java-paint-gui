package gui.btnHandlers;

import javax.swing.*;
import javax.swing.event.ChangeListener;

import controller.PaintController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import model.*;

public class LineBtnHandler implements ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent e) {
		PaintController ctrl = PaintController.getInstance();
		
		ctrl.disableShapeBtn(ShapeType.line, ((JButton) e.getSource()).getModel());
		
		JButton lineBtn = (JButton)e.getSource();
		lineBtn.setEnabled(false);
		
		ctrl.setShape(ShapeType.line);
	}
	
	
	
}
