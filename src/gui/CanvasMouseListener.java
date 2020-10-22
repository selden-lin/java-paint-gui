package gui;

import java.awt.*;  
import java.awt.event.*;  
import controller.PaintController;

public class CanvasMouseListener implements MouseListener, MouseMotionListener {
	private PaintCanvas canvas;
	private PaintController controller;
	
	public CanvasMouseListener(PaintCanvas canvas) {
		this.canvas = canvas;
		this.controller = PaintController.getInstance();
		this.canvas.addMouseListener(this);
		this.canvas.addMouseMotionListener(this);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		
		this.controller.setStartPoint(e.getX(), e.getY());
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		this.controller.setEndPoint(e.getX(), e.getY());
		this.canvas.repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		this.controller.setDragPoint(e.getX(), e.getY());
		this.canvas.repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
