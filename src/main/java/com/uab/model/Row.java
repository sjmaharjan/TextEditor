package com.uab.model;

import java.awt.Graphics;
import java.util.ArrayList;

import com.uab.model.visitor.Visitor;

public class Row extends Glyph {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Glyph> glyphs = new ArrayList<Glyph>();
	private Rect bounds;

	public Row() {
		bounds = Rect.ZERO;
	}

	public int getGlyphsCount() {
		return glyphs.size();
	}

	@Override
	public void add(Glyph glyph) {
		glyphs.add(glyph);

	}

	@Override
	public void remove(int index) {

		glyphs.remove(index);
	}

	@Override
	public void remove(Glyph glyph) {
		glyphs.remove(glyph);

	}

	@Override
	public Glyph getChild(int i) {
		return glyphs.get(i);
	}

	@Override
	public Glyph parent() {
		// TODO Auto-generated method stub
		return super.parent();
	}

	@Override
	public void draw(Graphics g, Point position, int width, int height) {
		bounds.setLeft(position.getX());
		bounds.setBottom(position.getY() - getHeigth());

		for (Glyph glyph : glyphs) {
			glyph.draw(g, position, width, height);

		}
		position.setX(20);

		bounds.setExtent(new Point(getWidth(), getHeigth()));
		System.out.println("Row bounds" + getBounds());
		// g.drawRect(bounds.getLeft(), bounds.getBottom(), bounds.getWidth(),
		// bounds.getHeight());
	}

	@Override
	public int getWidth() {
		int totalWidth = 0;
		for (Glyph glyph : glyphs) {
			totalWidth += glyph.getWidth();
		}
		return totalWidth;
	}

	public int getCummulativeHeight() {
		int totalHeight = 0;
		for (Glyph glyph : glyphs) {
			totalHeight += glyph.getHeigth();
		}
		return totalHeight;
	}

	@Override
	public int getHeigth() {
		int maxHeight = 0;
		for (Glyph glyph : glyphs) {

			if (maxHeight <= glyph.getHeigth()) {
				maxHeight = glyph.getHeigth();
			}
		}
		return maxHeight;
	}

	@Override
	public Rect getBounds() {
		return this.bounds;
	}

	@Override
	public void setBounds(Rect rectangle) {
		this.bounds = rectangle;
	}

	@Override
	public void accept(Visitor visitor) {
		for (int i = 0; i < glyphs.size(); i++)
			glyphs.get(i).accept(visitor);

		visitor.visit(this);
	}

}
