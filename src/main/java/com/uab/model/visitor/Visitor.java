package com.uab.model.visitor;

import com.uab.model.ArrowModel;
import com.uab.model.CharacterModel;
import com.uab.model.Column;
import com.uab.model.ImageModel;
import com.uab.model.Row;

public interface Visitor {
	public void visit(CharacterModel charModel);

	public void visit(ImageModel imgModel);

	public void visit(Row rowModel);

	public void visit(Column colModel);

	public void visit(ArrowModel arrowModel);
}
