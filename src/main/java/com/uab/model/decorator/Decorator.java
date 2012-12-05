package com.uab.model.decorator;

import java.awt.Graphics;
import java.util.List;

import com.uab.model.Caret;
import com.uab.model.Glyph;
import com.uab.model.Point;
import com.uab.model.visitor.SpellCheckingVisitor;
import com.uab.view.TextPanel;

public class Decorator extends Glyph {

	protected Glyph component;

	@Override
	public Glyph getDecoratedGlyph() {
		return this.component;
	}

	public void setSpellCheckVisitor(SpellCheckingVisitor visitor) {
		this.component.setSpellCheckVisitor(visitor);
	}

	@Override
	public void draw(Graphics g, Point position, int width, int height) {
		component.draw(g, position, width, height);
	}

	@Override
	public void add(Glyph glyph, int index) {
		this.component.add(glyph, index);
		notifyObservers();
	}

	@Override
	public void remove(int index) {
		this.component.remove(index);
		notifyObservers();

	}

	@Override
	public Glyph getChild(int i) {
		return this.component.getChild(i);
	}

	@Override
	public Caret getCursor() {
		return component.getCursor();
	}

	@Override
	public List<Glyph> getComponents() {

		return component.getComponents();
	}

	@Override
	public void setComponents(List<Glyph> components) {

		this.component.setComponents(components);
	}

	@Override
	public void scrollUp(TextPanel view) {
		this.component.scrollUp(view);
	}

	@Override
	public void scrollDown(TextPanel view) {
		this.component.scrollDown(view);
	}
}
