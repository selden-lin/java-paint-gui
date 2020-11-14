package gui;

import javax.swing.*;
import java.awt.*;

public class ShapeButton extends JButton { 
	
	public ShapeButton(String label) {
		this.setText(label);
		
		Dimension size = new Dimension(100, 50);
		this.setMinimumSize(size);
		this.setPreferredSize(size);
		this.setMaximumSize(size);
	}
}
