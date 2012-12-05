package com.uab.controller.commands;

import java.awt.image.RenderedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

import com.uab.model.Glyph;
import com.uab.model.ImageModel;

public class SaveCommand implements Command {
	private Glyph document;
	private String fileName;
	private JFrame parent;

	public SaveCommand(Glyph document, JFrame parent) {
		this.document = document;
		this.parent = parent;
	}

	public void execute() {
		if (fileName == null) {
			createSaveDialogBox(parent);
		}
		try {

			FileOutputStream fileOut = new FileOutputStream(this.fileName);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			List<Glyph> components = document.getComponents();

			out.writeObject(components);
			// copying image to location
			int counter = 0;
			for (Glyph g : components) {
				if (g instanceof ImageModel) {
					ImageModel m = ((ImageModel) g);
					ImageIO.write((RenderedImage) m.getImage(), "jpeg",
							new File(this.fileName + counter + "jpeg"));
					counter++;

				}
			}

			System.out.println("File Saved");
			out.close();
			fileOut.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("File error occured");
			e.printStackTrace();
		}

	}

	public void undo() {

	}

	public void createSaveDialogBox(JFrame parent) {
		JFileChooser fc = new JFileChooser();
		fc.showSaveDialog(parent);
		String fileName = fc.getSelectedFile().getAbsolutePath();
		if (!fileName.isEmpty()) {
			this.fileName = fileName;
		}
	}

	public boolean isReversible() {
		return false;
	}

}
