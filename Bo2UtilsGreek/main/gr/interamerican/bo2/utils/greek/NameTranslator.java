package gr.interamerican.bo2.utils.greek;

import static java.lang.Character.toUpperCase;

import java.util.HashMap;
import java.util.Map;

import gr.interamerican.bo2.utils.Utils;
import gr.interamerican.bo2.utils.beans.AssociationTable;
import gr.interamerican.bo2.utils.beans.Pair;

/**
 * Translates a name from/to Greek/Latin.
 */
public class NameTranslator {
	
	/**
	 * Characters asssociation table.
	 * 
	 * Greek character is left, Latin character is right.
	 */
	Map<Character, Character> associations = 
		new HashMap<Character, Character>();

	/**
	 * Creates a new VisuallySimilarLatin object. 
	 *
	 */
	public NameTranslator() {
		super();
		Map<Character, Character> lowercases = 
				new HashMap<Character, Character>();
		lowercases.put('�', 'a');
		lowercases.put('�', 'b');
		lowercases.put('�', 'g');
		lowercases.put('�', 'd');
		lowercases.put('�', 'e');
		lowercases.put('�', 'z');
		lowercases.put('�', 'i');
		lowercases.put('�', 't'); //TODO: th
		lowercases.put('�', 'i');
		lowercases.put('�', 'k');
		lowercases.put('�', 'l');
		lowercases.put('�', 'm');
		lowercases.put('�', 'n');
		lowercases.put('�', 'x');
		lowercases.put('�', 'o');
		lowercases.put('�', 'p');
		lowercases.put('�', 'r');
		lowercases.put('�', 's');
		lowercases.put('�', 's');
		lowercases.put('�', 't');
		lowercases.put('�', 'y');
		lowercases.put('�', 'f');
		lowercases.put('�', 'h'); //TODO: ch
		lowercases.put('�', 'p'); //TODO: ps
		lowercases.put('�', 'o');		
		//TODO: �� => ou, ���������, ���.
		
		for (Map.Entry<Character, Character> entry : lowercases.entrySet()) {
			Character l = entry.getKey();
			Character r = entry.getValue();	
			associations.put(l, r);
			associations.put(toUpperCase(l), toUpperCase(r));
		}
	}
	
	/**
	 * Gets the associated latin character.
	 * 
	 * @param greek
	 *        Greek character.
	 *        
	 * @return Returns the associated Latin character.
	 */
	Character getLatin(Character greek) {
		Character c = associations.get(greek);
		return Utils.notNull(c, greek);		
	}
	
	/**
	 * Writes the specified Greek name with Latin characters.
	 * 
	 * Only capital letters have a visually similar character. 
	 * 
	 * @param greek
	 * 
	 * @return Returns the Greek character that is visually similar
	 *         with the specified character. If the specified character 
	 *         is not a Latin capital letter, or if it has not a visually
	 *         similar Greek character, then returns null.
	 */
	public String toLatin(String greek) {
		char[] input = greek.toCharArray();
		char[] output = new char[input.length];
		for (int i = 0; i < input.length; i++) {			
			output[i] = getLatin(input[i]);			
		}
		return new String(output);		
	}
	
	
	
	

}
