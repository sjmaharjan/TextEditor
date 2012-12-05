package com.uab.model.visitor.spellcheckers;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.swabunga.spell.engine.SpellDictionaryHashMap;
import com.swabunga.spell.engine.Word;
import com.swabunga.spell.event.SpellChecker;

public class JazzySpellChecker implements SpellCheck {

	private static final String DICTIONARY_FILE = "src/main/resources/fulldictionary00.txt";
	protected static SpellDictionaryHashMap dictionary = null;
	protected static SpellChecker spellChecker = null;
	static {

		try {

			dictionary = new SpellDictionaryHashMap(new File(DICTIONARY_FILE));
		} catch (IOException e) {

			e.printStackTrace();
		}
		spellChecker = new SpellChecker(dictionary);
	}

	public static List<Word> getSuggestions(String word, int threshold) {

		return spellChecker.getSuggestions(word, threshold);
	}

	public boolean checkSpelling(String word) {

		List<Word> newWord = spellChecker.getSuggestions(word, 1);

		System.out.println("The new word is " + newWord + "send word is "
				+ word);
		for (Word suggesstion : newWord) {
			if (suggesstion.getWord().equalsIgnoreCase(word)) {
				return true;

			}
		}

		return false;
	}

}
