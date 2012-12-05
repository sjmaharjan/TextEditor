package com.uab.controller.commands;

import java.util.Stack;

public class CommandsInvoker {
	private Stack<Command> undoStack;
	private Stack<Command> redoStack;

	public CommandsInvoker() {
		undoStack = new Stack<Command>();
		redoStack = new Stack<Command>();
	}

	public void execute(Command cmd) {

		cmd.execute();
		if (cmd.isReversible())
			undoStack.push(cmd);

	}

	public void undo() {

		if (!undoStack.isEmpty()) {
			Command cmd = undoStack.pop();
			redoStack.push(cmd);
			cmd.undo();
		}

	}

	public void redo() {

		if (!redoStack.isEmpty()) {
			Command cmd = redoStack.pop();
			undoStack.push(cmd);
			cmd.execute();
		}

	}

}
