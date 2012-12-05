package com.uab.controller.commands;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

import com.uab.model.Glyph;
import com.uab.model.ImageModel;

public class OpenCommand implements Command {
	private Glyph document;
	private String fileName;
	private JFrame parent;

	public OpenCommand(Glyph doucment, JFrame parent) {
		this.document = doucment;
		this.parent = parent;

	}

	public void execute() {
		createOpenDialogBox(parent);
		try {
			FileInputStream fileIn = new FileInputStream(this.fileName);
			ObjectInputStream in = new ObjectInputStream(fileIn);

			List<Glyph> glyphList = (List<Glyph>) in.readObject();
			int counter = 0;
			for (Glyph g : glyphList) {
				if (g instanceof ImageModel) {
					ImageModel m = ((ImageModel) g);

					m.setImage(ImageIO.read(new File(this.fileName + counter
							+ "jpeg")));
					counter++;

				}
			}

			document.setComponents(glyphList);
			document.notifyObservers();
			in.close();
			fileIn.close();
		} catch (IOException i) {
			i.printStackTrace();
			return;
		} catch (ClassNotFoundException c) {

			c.printStackTrace();
			return;
		}

	}

	public void undo() {

	}

	public boolean isReversible() {
		return false;
	}

	public void createOpenDialogBox(JFrame parent) {
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showOpenDialog(parent);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			this.fileName = fc.getSelectedFile().getAbsolutePath();
			System.out.println(fileName);
		}
	}

}
