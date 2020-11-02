package gui.btnHandlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.PaintController;

public class ResetBtnHandler implements ActionListener{
	private PaintController ctrl = PaintController.getInstance();
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.ctrl.clearScreen();
	}

}
