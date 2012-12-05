package com.uab.model.decorator;

import java.awt.Color;
import java.awt.Graphics;

import com.uab.model.Glyph;
import com.uab.model.Point;

public class BorderDecorator extends Decorator {
	private int width = 1;
	private int frameWidth;
	private int frameHeight;
	private int borderYLocation = 10;

	public BorderDecorator(Glyph glyph, int width) {
		this.component = glyph;
		this.width = width;

	}

	public int getFrameWidth() {
		return frameWidth;
	}

	public void setFrameWidth(int frameWidth) {
		this.frameWidth = frameWidth;
	}

	public int getFrameHeight() {
		return frameHeight;
	}

	public void setFrameHeight(int frameHeight) {
		this.frameHeight = frameHeight;
	}

	private void drawBorder(Graphics g, int width) {
		g.setColor(Color.BLACK);
		g.drawRect(8, borderYLocation, frameWidth + 1, frameHeight + 5);

	}

	public void draw(Graphics g, Point position, int width, int height) {
		int frameWidth = width - 10;
		this.setFrameHeight(height);
		this.setFrameWidth(frameWidth);
		borderYLocation = position.getY() - 42;
		drawBorder(g, width);
		this.component.draw(g, position, frameWidth, height);

	}

}
