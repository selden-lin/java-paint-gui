package gui.btnHandlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import controller.PaintController;
import model.ShapeType;

public class CircleBtnHandler implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
		PaintController ctrl = PaintController.getInstance();
		
		ctrl.disableShapeBtn(ShapeType.circle, ((JButton) e.getSource()).getModel());
		
		JButton btn = (JButton)e.getSource();
		btn.setEnabled(false);
		
		ctrl.setShape(ShapeType.circle);
	}
}
