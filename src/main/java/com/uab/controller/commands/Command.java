package com.uab.controller.commands;

public interface Command {

	public void execute();

	public void undo();

	public boolean isReversible();
}
