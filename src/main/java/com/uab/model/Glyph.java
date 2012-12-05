package com.uab.model;

import java.awt.Graphics;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.uab.listeners.Observer;
import com.uab.model.visitor.SpellCheckingVisitor;
import com.uab.model.visitor.Visitor;
import com.uab.view.TextPanel;

public abstract class Glyph implements Serializable {

	private static final long serialVersionUID = 1L;

	private ArrayList<Observer> observers = new ArrayList<Observer>();

	public void add(Glyph glyph, int index) {
		throw new UnsupportedOperationException();
	}

	public void add(Glyph glyph) {
		throw new UnsupportedOperationException();
	}

	public void remove(Glyph glyph) {
		throw new UnsupportedOperationException();
	}

	public void remove(int index) {
		throw new UnsupportedOperationException();
	}

	public Glyph getChild(int i) {
		throw new UnsupportedOperationException();
	}

	public Glyph parent() {
		throw new UnsupportedOperationException();

	}

	public void draw(Graphics g, Point position, int width, int height) {

	}

	public void registerObservers(Observer o) {
		observers.add(o);
	}

	public void removeObserver(Observer o) {
		int i = observers.indexOf(o);
		if (i >= 0) {
			observers.remove(i);
		}
	}

	public void format(int width, int height) {

	}

	public void notifyObservers() {
		for (Observer observer : observers) {
			observer.update();
		}
	}

	public Rect getBounds() {
		throw new UnsupportedOperationException();
	}

	public void setBounds(Rect rectangle) {

	}

	public int getCummulativeHeight() {
		throw new UnsupportedOperationException();
	}

	public int getWidth() {
		throw new UnsupportedOperationException();
	}

	public int getHeigth() {
		throw new UnsupportedOperationException();
	}

	public void scrollUp(TextPanel view) {

	}

	public void scrollDown(TextPanel view) {

	}

	public Caret getCursor() {
		throw new UnsupportedOperationException();
	}

	public boolean intersects(Point p) {
		Rect bound = getBounds();
		if ((bound.getLeft() <= p.getX() && p.getX() <= bound.getWidth()
				+ bound.getLeft())
				&& (bound.getBottom() <= p.getY() && p.getY() <= bound
						.getBottom() + bound.getHeight()))
			return true;
		else
			return false;
	}

	public void accept(Visitor visitor) {

	}

	public List<Glyph> getComponents() {

		return null;
	}

	public void setComponents(List<Glyph> components) {

	}

	public void activateHasCursor(boolean before) {

	}

	public void deActivateHasCursor() {

	}

	public void setSpellCheckVisitor(SpellCheckingVisitor visitor) {

	}

	public Glyph getDecoratedGlyph() {
		throw new UnsupportedOperationException();
	}

}
