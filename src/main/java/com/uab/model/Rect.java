package com.uab.model;

import java.io.Serializable;

public class Rect implements Serializable {
	private Point origin;
	private Point extent;

	public static final Rect ZERO = new Rect();

	public Rect() {
		this.origin = new Point(0, 0);
		this.extent = new Point(0, 0);
	}

	public Rect(Point origin, Point extent) {
		this.origin = origin;
		this.extent = extent;
	}

	public Rect(int x, int y, int width, int height) {
		this.origin = new Point(x, y);
		this.extent = new Point(width, height);
	}

	public Point getOrigin() {
		return origin;
	}

	public void setOrigin(Point origin) {
		this.origin = origin;
	}

	public Point getExtent() {
		return extent;
	}

	public void setExtent(Point extent) {
		this.extent = extent;
	}

	public int getWidth() {
		return this.extent.getX();
	}

	public int getHeight() {
		return this.extent.getY();
	}

	public int getLeft() {
		return this.origin.getX();
	}

	public int getBottom() {
		return this.origin.getY();
	}

	public void setWidth(int width) {
		this.extent.setX(width);
	}

	public void setHeight(int height) {
		this.extent.setY(height);
	}

	public void setLeft(int left) {
		this.origin.setX(left);
	}

	public void setBottom(int bottom) {
		this.origin.setY(bottom);
	}

	void MoveTo(Point point) {
		this.origin.setX(point.getX());
		this.origin.setY(point.getY());
	}

	void MoveBy(Point point) {

	}

	boolean IsEmpty() {
		return false;
	}

	boolean contains(Point point) {
		return false;
	}

	@Override
	public String toString() {
		return "Rect [origin=" + origin + ", extent=" + extent + "]";
	}

}
