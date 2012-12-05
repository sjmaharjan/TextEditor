package com.uab.model.visitor;

import java.util.ArrayList;
import java.util.List;

import com.uab.model.ArrowModel;
import com.uab.model.CharacterModel;
import com.uab.model.Column;
import com.uab.model.ImageModel;
import com.uab.model.Row;
import com.uab.model.visitor.spellcheckers.SpellCheck;

public class SpellCheckingVisitor implements Visitor {

	private SpellCheck spellChecker;
	private String currentWord;
	private List<CharacterModel> charModelList;
	private List<String> missSpellings;
	private List<CharacterModel> missSpelledList;

	public SpellCheckingVisitor(SpellCheck sp) {
		missSpellings = new ArrayList<String>();
		charModelList = new ArrayList<CharacterModel>();
		missSpelledList = new ArrayList<CharacterModel>();
		spellChecker = sp;
		currentWord = new String();

	}

	public void clearList() {
		this.missSpelledList.clear();
		this.missSpellings.clear();
		this.charModelList.clear();
		this.currentWord = new String();
	}

	public void setSpellCheck(SpellCheck sp) {
		this.spellChecker = sp;
	}

	public void visit(CharacterModel charModel) {
		char character = charModel.getCharacter();
		charModel.removeUnderline();
		if (isAlpha(character)) {
			currentWord += character;
			charModelList.add(charModel);
		} else {
			if (isMissSpelled(currentWord)) {
				System.out.println("Miss spelling " + currentWord);
				missSpellings.add(currentWord);

				for (CharacterModel c : charModelList)
					missSpelledList.add(c);
			}
			// reset current string
			charModelList.clear();
			currentWord = new String();
		}

	}

	public List<String> getMissSpellings() {
		return missSpellings;
	}

	private boolean isAlpha(char character) {
		int code = (int) character;
		if ((code >= 65 && code <= 90) || (code >= 97 && code <= 122))
			return true;
		else
			return false;
	}

	public void visit(ImageModel imgModel) {
		if (isMissSpelled(currentWord)) {
			System.out.println("Miss spelling" + currentWord);
			missSpellings.add(currentWord);

			for (CharacterModel c : charModelList)
				missSpelledList.add(c);
		}
		// reset current string
		charModelList.clear();
		currentWord = new String();

	}

	public void visit(Row rowModel) {
		// TODO Auto-generated method stub

	}

	public void visit(Column colModel) {
		// TODO Auto-generated method stub

	}

	public boolean isMissSpelled(String word) {
		if (word.isEmpty() || word == null) {
			return false;
		}
		return !this.spellChecker.checkSpelling(word);
	}

	public List<CharacterModel> getMissSpelledList() {
		return missSpelledList;
	}

	public void markMissSpelledWords() {
		for (CharacterModel c : getMissSpelledList()) {
			c.underlineWithRed();
		}
		for (String c : getMissSpellings()) {
			System.out.println("Miss spelled " + c);
			;
		}
	}


	public void visit(ArrowModel arrowModel) {
		// TODO Auto-generated method stub
		
	}

}
