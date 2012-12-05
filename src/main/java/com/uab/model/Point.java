package com.uab.model;

import java.io.Serializable;

public class Point implements Serializable {
	private int x;
	private int y;

	public static final Point ZERO = new Point(0, 0);

	public Point() {
		this.x = 0;
		this.y = 0;
	}

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void add(Point point) {
		this.x += point.getX();
		this.y += point.getY();
	}

	public void sub(Point point) {
		this.x -= point.getX();
		this.y -= point.getY();
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}

	public void incrementXBy(int i) {
		this.x += i;

	}

	public void incrementYBy(int i) {
		this.y += i;

	}

}
