package com.uab.model;

import java.util.List;

public class Caret {
	private Composition document;
	private int rowIndex;
	private int columnIndex;
	private int glyphIndex;

	public Caret() {
		this.rowIndex = 0;
		this.columnIndex = 0;
		this.glyphIndex = 0;
	}

	public Caret(Composition document, int rowIndex, int columnIndex,
			int glyphIndex) {
		this.document = document;
		this.rowIndex = rowIndex;
		this.columnIndex = columnIndex;
		this.glyphIndex = glyphIndex;

	}

	public void setGlyphIndex(int glyphIndex) {
		this.glyphIndex = glyphIndex;
	}

	public Composition getDocument() {
		return document;
	}

	public void setDocument(Composition document) {
		this.document = document;
	}

	public int getRowIndex() {
		return rowIndex;
	}

	public void setRowIndex(int rowIndex) {
		this.rowIndex = rowIndex;
	}

	public int getColumnIndex() {
		return columnIndex;
	}

	public void setColumnIndex(int columnIndex) {
		this.columnIndex = columnIndex;
	}

	public void mapPointToRowAndColumn(Point p) {
		this.rowIndex = -1;
		this.columnIndex = -1;
		Column doc = this.document.getFormattedDocument();

		if (doc.intersects(p)) {
			for (int i = 0; i < doc.getRowsCount(); i++) {

				Row row = (Row) doc.getChild(i);

				if (row.intersects(p)) {
					for (int j = 0; j < row.getGlyphsCount(); j++) {
						Glyph g = row.getChild(j);
						if (g.intersects(p)) {
							this.rowIndex = i;
							this.columnIndex = j;
							System.out.println("Row is " + this.rowIndex
									+ "  and colIndex iis " + this.columnIndex);
							break;
						}

					}

				}

			}

		}
	}

	public void moveLeft() {

	}

	public void moveRight() {

	}

	public void mapToGlyphIndex() {
		this.glyphIndex = 0;
		Column doc = this.document.getFormattedDocument();
		if (rowIndex == -1 && columnIndex == -1) {
			this.glyphIndex = this.document.getComponents().size();

		} else {

			for (int i = 0; i <= this.rowIndex - 1; i++) {
				Row row = (Row) doc.getChild(i);
				glyphIndex += row.getGlyphsCount();
			}
			glyphIndex += this.columnIndex;

			System.out.println("Glyph id =" + glyphIndex);
		}
	}

	public void incrementGlyphIndex() {

		if (this.glyphIndex < this.document.getComponents().size()) {

			this.glyphIndex++;
		}

	}

	public int getGlyphIndex() {
		return glyphIndex;
	}

	public void decrementGlyphIndex() {
		if (this.glyphIndex > 0) {
			this.glyphIndex--;

		}

	}

	public void updateCursor() {
		deActivateCursor();
		if (this.glyphIndex == 0) {

			if (this.document.getComponents().size() > 0) {
				Glyph lastGlyph = this.document.getComponents().get(
						this.glyphIndex);

				lastGlyph.activateHasCursor(true);
			} else {
				// draw the initial cursor
			}

		}
		if (this.glyphIndex > 0) {
			Glyph lastGlyph = this.document.getComponents().get(
					this.glyphIndex - 1);
			if (lastGlyph != null) {
				lastGlyph.activateHasCursor(false);

			}
		}
	}

	public void deActivateCursor() {
		List<Glyph> components = this.document.getComponents();
		for (Glyph g : components) {
			g.deActivateHasCursor();
		}

	}

}
