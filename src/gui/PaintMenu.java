package gui;

import java.awt.event.ActionEvent;

import javax.swing.*;

import controller.PaintController;

import java.io.File; // Import the File class
import java.io.FileWriter;
import java.io.IOException; // Import the IOException class to handle errors
import java.util.ArrayList;
import java.util.Scanner;

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
						File myObj = new File(fileToSave.getParent()+"\\"+fileToSave.getName());
						ArrayList<String> shapes = ctrl.canvasToString();
						

						if (myObj.createNewFile()) {
							// file does not exist
							
							FileWriter myWriter = new FileWriter(myObj.getAbsolutePath());
							for (int x = 0; x < shapes.size(); x++) {
								myWriter.write(shapes.get(x));
								myWriter.write(System.getProperty( "line.separator" ));
							}
							myWriter.close();
						} else {
							JPanel panel = new JPanel();
							int res = JOptionPane.showConfirmDialog(null, "File already exists, overwrite it?",
									"WARNING",JOptionPane.YES_NO_OPTION);
							if(res == JOptionPane.NO_OPTION) 
								return;
							
							FileWriter myWriter = new FileWriter(myObj.getAbsolutePath());
							for (int x = 0; x < shapes.size(); x++) {
								myWriter.write(shapes.get(x));
								myWriter.write(System.getProperty( "line.separator" ));
							}
							myWriter.close();
						}
						
					} catch (IOException error) {
						System.out.println("An error occurred.");
						error.printStackTrace();
					}
				}

			}
		});
		this.openOption = new JMenuItem(new AbstractAction("Open") {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame parentFrame = new JFrame();

				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setDialogTitle("Specify a file to open");
				PaintController ctrl = PaintController.getInstance();

				int userSelection = fileChooser.showOpenDialog(parentFrame);
				if (userSelection == JFileChooser.APPROVE_OPTION) {
					File fileToOpen= fileChooser.getSelectedFile();
					
					try {
						File myObj = new File(fileToOpen.getAbsolutePath());
						Scanner myReader = new Scanner(myObj);
						ArrayList<String> shapes = new ArrayList<String>();
						
						while(myReader.hasNextLine()) {
							String l = myReader.nextLine();
							shapes.add(l);
						}
						myReader.close();
						ctrl.readShapes(shapes);
						
					} catch (Exception error) {
						error.printStackTrace();
						JOptionPane.showMessageDialog(null, "Error: this paint file is not formatted correctly");
					}
				}

			}
		});

		this.fileMenu.add(this.openOption);
		this.fileMenu.add(this.saveOption);

		this.add(fileMenu);
	}
}
