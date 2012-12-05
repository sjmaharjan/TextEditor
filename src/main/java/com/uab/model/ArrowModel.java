package com.uab.model;

import java.awt.Graphics;

import com.uab.model.visitor.Visitor;

public class ArrowModel extends Glyph {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7995523187884933397L;
	private Rect bounds;
	private boolean hasCursor;
	private boolean before;

	public ArrowModel() {
		super();
			}
	
	@Override
	public void draw(Graphics g, Point position, int width, int height) {
		g.drawString(">>==>", position.getX(),
				position.getY());

		bounds = new Rect(position.getX(), position.getY() - getHeigth(), getWidth(),
				getHeigth());
		position.incrementXBy(getWidth());
		
		if (this.hasCursor) {
			if (before)
				g.fillRect(bounds.getLeft() - 3, bounds.getBottom(), 2,
						bounds.getHeight());
			else
				g.fillRect(bounds.getLeft() + bounds.getWidth() - 3,
						bounds.getBottom(), 2, bounds.getHeight());
		}
		
//		 g.drawRect(bounds.getLeft(), bounds.getBottom(), bounds.getWidth(),
//		 bounds.getHeight());
	}

	@Override
	public String toString() {
		return "[>>==>]";
	}

	@Override
	public int getWidth() {
		return 50;
	}

	@Override
	public int getHeigth() {
		return 20;
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
		visitor.visit(this);
	}

	
	public void activateHasCursor(boolean before) {
		this.hasCursor = true;
		this.before = before;
	}

	public void deActivateHasCursor() {
		this.hasCursor = false;
	}
	
	
}
