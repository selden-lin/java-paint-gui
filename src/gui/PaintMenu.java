package gui;

import java.awt.event.ActionEvent;

import javax.swing.*;

import controller.PaintController;

import java.io.File; // Import the File class
import java.io.FileWriter;
import java.io.IOException; // Import the IOException class to handle errors
import java.util.ArrayList;

public class PaintMenu extends JMenuBar {
	private JMenu fileMenu;
	private JMenuItem openOption, saveOption, quitOption;

	public PaintMenu() {
		this.fileMenu = new JMenu("File");
		this.saveOption = new JMenuItem(new AbstractAction("Save") {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame parentFrame = new JFrame();

				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setDialogTitle("Specify a file to save");
				PaintController ctrl = PaintController.getInstance();

				int userSelection = fileChooser.showSaveDialog(parentFrame);
				if (userSelection == JFileChooser.APPROVE_OPTION) {
					File fileToSave = fileChooser.getSelectedFile();
					
					try {
						File myObj = new File(fileToSave.getParent()+"\\"+fileToSave.getName()+".txt");
						ArrayList<String> shapes = ctrl.canvasToString();
						
						// file does not exist
						if (myObj.createNewFile()) {
							FileWriter myWriter = new FileWriter(myObj.getAbsolutePath());
							for (int x = 0; x < shapes.size(); x++) {
								System.out.println(shapes.get(x));
								myWriter.write(shapes.get(x));
							}
							myWriter.close();
						} else {
							System.out.println("File already exists.");
						}
						System.out.println("Save as file: " + myObj.getAbsolutePath());
					} catch (IOException error) {
						System.out.println("An error occurred.");
						error.printStackTrace();
					}

					
				}

			}
		});
		this.openOption = new JMenuItem("Open");

		this.fileMenu.add(this.openOption);
		this.fileMenu.add(this.saveOption);

		this.add(fileMenu);
	}
}
