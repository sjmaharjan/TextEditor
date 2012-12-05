package com.uab.controller;

import javax.swing.JFrame;

import com.uab.controller.commands.CommandsInvoker;
import com.uab.controller.commands.DeleteCommand;
import com.uab.controller.commands.InsertCommand;
import com.uab.controller.commands.OpenCommand;
import com.uab.controller.commands.QuitCommand;
import com.uab.controller.commands.SaveCommand;
import com.uab.model.Glyph;
import com.uab.model.Point;
import com.uab.model.decorator.BorderDecorator;
import com.uab.model.decorator.ScrollDecorator;
import com.uab.model.strategies.Compositor;
import com.uab.model.visitor.SpellCheckingVisitor;
import com.uab.model.visitor.spellcheckers.JazzySpellChecker;
import com.uab.view.TextPanel;

public class TextController implements ControllerInterface {
	private TextPanel view;
	private Glyph document;
	private CommandsInvoker cmdInvoker;
	SpellCheckingVisitor visitor = new SpellCheckingVisitor(
			new JazzySpellChecker());

	public TextController(Glyph g) {
		this.document = g;
		view = new TextPanel(g, this);
		view.createView();
		cmdInvoker = new CommandsInvoker();

	}

	public void setLineBreakingAlgorithm(Compositor compositor) {

	}

	public void scrollUp() {

		this.document.scrollUp(view);

	}

	public void scrollDown() {
		this.document.scrollDown(view);

	}

	public void newFile() {
		// TODO Auto-generated method stub

	}

	public void openFile(JFrame parent) {
		OpenCommand openCmd = new OpenCommand(this.document, parent);
		cmdInvoker.execute(openCmd);

	}

	public void saveFile(JFrame parent) {
		SaveCommand saveCmd = new SaveCommand(this.document, parent);
		cmdInvoker.execute(saveCmd);

	}

	public void closeFile(JFrame parent) {

		QuitCommand quitCmd = new QuitCommand(this.document, parent);
		cmdInvoker.execute(quitCmd);

	}

	public void undo() {
		cmdInvoker.undo();
	}

	public void redo() {
		cmdInvoker.redo();

	}

	public void cut() {
		// TODO Auto-generated method stub

	}

	public void copy() {
		// TODO Auto-generated method stub

	}

	public void paste() {
		// TODO Auto-generated method stub

	}

	public void insert(Glyph glyph, int insertIndex) {
		System.out.println("Controller" + insertIndex);
		InsertCommand insertCmd = new InsertCommand(this.document, glyph,
				insertIndex);
		cmdInvoker.execute(insertCmd);

	}

	public void locateGlyph(Point point) {

		this.document.getCursor().mapPointToRowAndColumn(point);
		this.document.getCursor().mapToGlyphIndex();

		this.document.getCursor().updateCursor();
		this.view.update();
	}

	public void delete(int glyphIndex) {
		System.out.println("Controller degete" + glyphIndex);
		DeleteCommand deleteCmd = new DeleteCommand(this.document, glyphIndex);
		cmdInvoker.execute(deleteCmd);
	}

	public void decorateWithBorder() {
		this.document = new BorderDecorator(document, 1);
		view.setGlyph(document);
		view.update();

	}

	public void decorateWithScrollBar() {
		this.document = new ScrollDecorator(document, 1);
		view.setGlyph(document);
		view.update();
	}

	public void removeBorder() {
		this.document = document.getDecoratedGlyph();
		view.setGlyph(document);
		view.update();
	}

	public void removeScrollBar() {

		this.document = document.getDecoratedGlyph();
		view.setGlyph(document);
		view.update();
	}

	public void disableSpellCheck() {
		this.document.setSpellCheckVisitor(null);
		view.setGlyph(document);
		view.update();

	}

	public void enableSpellCheck() {
		System.out.println("Called here");
		this.document.setSpellCheckVisitor(visitor);
		view.setGlyph(document);
		view.update();
	}

}
