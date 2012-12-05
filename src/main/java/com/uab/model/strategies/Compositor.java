package com.uab.model.strategies;

import com.uab.model.Composition;

public interface Compositor {

	public void setComposition(Composition composition);

	public void compose(int lineWidth, int height);
}
