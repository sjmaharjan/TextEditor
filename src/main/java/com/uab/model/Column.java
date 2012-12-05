package com.uab.model;

import java.awt.Graphics;
import java.util.ArrayList;

import com.uab.model.visitor.Visitor;

public class Column extends Glyph {
	private ArrayList<Glyph> rows = new ArrayList<Glyph>();
	private Rect bounds;
	private int lineSpacing;

	public Column() {
		bounds = Rect.ZERO;
		lineSpacing = 10;
	}

	public int getRowsCount() {
		return rows.size();
	}

	@Override
	public void add(Glyph glyph) {
		rows.add(glyph);
		// notifyObservers();

	}

	@Override
	public void remove(int index) {

		rows.remove(index);
	}

	@Override
	public void remove(Glyph glyph) {
		rows.remove(glyph);
		// notifyObservers();
	}

	@Override
	public Glyph getChild(int i) {
		return rows.get(i);
	}

	@Override
	public Glyph parent() {
		// TODO Auto-generated method stub
		return super.parent();
	}

	@Override
	public void draw(Graphics g, Point position, int width, int height) {
		bounds.setLeft(position.getX());

		for (Glyph row : rows) {
			row.draw(g, position, width, height);
			position.incrementYBy(row.getHeigth() + lineSpacing);

		}

		bounds.setBottom(position.getY() - getHeigth() - 2 * lineSpacing);
		bounds.setExtent(new Point(getWidth(), getHeigth()));

		// g.drawRect(bounds.getLeft(), bounds.getBottom(), bounds.getWidth(),
		// bounds.getHeight());
	}

	@Override
	public int getWidth() {
		int maxWidth = 0;
		for (Glyph row : rows) {

			if (maxWidth <= row.getWidth()) {
				maxWidth = row.getWidth();
			}

		}
		return maxWidth;
	}

	@Override
	public int getHeigth() {
		int totalHeight = 0;
		for (Glyph row : rows) {

			totalHeight += row.getHeigth() + lineSpacing;

		}
		return totalHeight;
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
		for (int i = 0; i < rows.size(); i++)
			rows.get(i).accept(visitor);

		visitor.visit(this);
	}

}
