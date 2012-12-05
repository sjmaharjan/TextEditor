package com.uab.model.visitor.spellcheckers;

import java.util.ArrayList;
import java.util.List;

public class SimpleSpellChecker implements SpellCheck {

	private static List<String> dictionary = new ArrayList<String>();
	static {
		dictionary.add("the");
		dictionary.add("and");
		dictionary.add("but");
		dictionary.add("am");
		dictionary.add("i");
		dictionary.add("to");
		dictionary.add("know");
		dictionary.add("him");
		dictionary.add("her");
		dictionary.add("also");
	}

	public boolean checkSpelling(String word) {
		System.out.println("checjerer spelling" + word);
		if (dictionary.contains(word)) {
			System.out.println("diccitonary contains");

			return true;
		}

		else
			return false;
	}
}
