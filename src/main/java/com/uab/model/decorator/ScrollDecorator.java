package com.uab.model.decorator;

import java.awt.Color;
import java.awt.Graphics;

import com.uab.model.Glyph;
import com.uab.model.Point;
import com.uab.view.TextPanel;

public class ScrollDecorator extends Decorator {
	private int scrollPosition;
	private int frameWidth;
	private int frameHeight;
	private int scrollYLocation = 20;

	public ScrollDecorator(Glyph glyph, int scrollPosition) {
		this.component = glyph;
		this.scrollPosition = scrollPosition;

	}

	private void scrollTo(Graphics g) {
		g.fillRect(frameWidth + 12, scrollYLocation, 6, 20);
	}

	@Override
	public void scrollUp(TextPanel view) {
		if (scrollYLocation > 20) {
			scrollYLocation -= 20;

			view.getStartPoistion().incrementYBy(20);
		}

		view.update();
	}

	@Override
	public void scrollDown(TextPanel view) {
		if (scrollYLocation < frameHeight) {

			scrollYLocation += 20;

			view.getStartPoistion().incrementYBy(-20);
		}
		view.update();
	}

	public void setFrameWidth(int width) {
		this.frameWidth = width;
	}

	public void setFrameHeight(int height) {
		this.frameHeight = height;
	}

	@Override
	public void draw(Graphics g, Point position, int width, int height) {
		int frameWidth = width - 30;
		this.setFrameHeight(height);
		this.setFrameWidth(frameWidth);
		g.setColor(Color.BLACK);
		this.component.draw(g, position, frameWidth, height);
		scrollTo(g);

	}

}
