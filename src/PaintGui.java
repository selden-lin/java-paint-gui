import javax.swing.*;
import java.awt.*;

import gui.*;
import controller.PaintController;

public class PaintGui {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        
        PaintController ctrl = PaintController.getInstance();
        PaintMenu menu = new PaintMenu();
        PaintOptionPanel optionPanel = new PaintOptionPanel();
        PaintCanvas canvas = new PaintCanvas();
        ctrl.setCanvas(canvas);
        canvas.setDoubleBuffered(true);
        CanvasMouseListener canvasMouse = new CanvasMouseListener(canvas);
        
        frame.getContentPane().add(BorderLayout.WEST, optionPanel);
        frame.getContentPane().add(BorderLayout.NORTH, menu);
        frame.getContentPane().add(BorderLayout.EAST, canvas);
        
        frame.setSize(1000, 800);
        frame.setVisible(true);
	}
}
