package gui;

import javax.swing.*;


public class PaintMenu extends JMenuBar {
	private JMenu fileMenu;
	private JMenuItem openOption, saveOption, quitOption;
	public PaintMenu() {
		this.fileMenu = new JMenu("File");
		this.saveOption = new JMenuItem("Save");
		this.quitOption = new JMenuItem("Quit");
		this.openOption = new JMenuItem("Open");
		
		this.fileMenu.add(this.openOption);
		this.fileMenu.add(this.saveOption);
		this.fileMenu.add(this.quitOption);
		
		this.add(fileMenu);
	}
}
