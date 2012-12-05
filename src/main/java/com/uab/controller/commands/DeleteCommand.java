package com.uab.controller.commands;

import com.uab.model.Glyph;

public class DeleteCommand implements Command {
	private Glyph document;
	private Glyph glyph;
	private int glyphIndex;
	private int deleteIndex;

	public DeleteCommand(Glyph document, int index) {

		this.document = document;

		this.glyphIndex = index;
	}

	public void execute() {
		this.deleteIndex = this.glyphIndex - 1;

		if (deleteIndex >= 0) {
			this.glyph = this.document.getChild(deleteIndex);
			this.document.remove(deleteIndex);
		}

	}

	public void undo() {
		if (deleteIndex >= 0) {
			this.document.add(glyph, deleteIndex);
		}

	}

	public boolean isReversible() {
		return true;
	}

}
