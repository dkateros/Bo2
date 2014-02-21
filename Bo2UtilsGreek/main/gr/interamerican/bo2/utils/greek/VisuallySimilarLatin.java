package gr.interamerican.bo2.utils.greek;

import gr.interamerican.bo2.utils.beans.AssociationTable;

/**
 * Associates a Greek character to its Latin visually similar.
 */
public class VisuallySimilarLatin {
	
	/**
	 * Characters asssociation table.
	 * 
	 * Greek character is left, Latin character is right.
	 */
	AssociationTable<Character, Character> associations = 
		new AssociationTable<Character, Character>();

	/**
	 * Creates a new VisuallySimilarLatin object. 
	 *
	 */
	public VisuallySimilarLatin() {
		super();
		associations.associate('�', 'A');
		associations.associate('�', 'B');
		associations.associate('�', 'E');
		associations.associate('�', 'Z');
		associations.associate('�', 'H');
		associations.associate('�', 'I');
		associations.associate('�', 'K');
		associations.associate('�', 'M');
		associations.associate('�', 'N');
		associations.associate('�', 'O');
		associations.associate('�', 'P');
		associations.associate('�', 'T');
		associations.associate('�', 'Y');
		associations.associate('�', 'X');
	}
	
	/**
	 * Gets the greek character that is visually similar
	 * with the specified latin character.
	 * 
	 * Only capital letters have a visually similar character. 
	 * 
	 * @param latin
	 * 
	 * @return Returns the Greek character that is visually similar
	 *         with the specified character. If the specified character 
	 *         is not a Latin capital letter, or if it has not a visually
	 *         similar Greek character, then returns null.
	 */
	public Character getGreek(char latin) {
		return associations.getLeft(latin);
	}
	
	/**
	 * Gets the latin character that is visually similar
	 * with the specified greek character.
	 * 
	 * Only capital letters have a visually similar character. 
	 * 
	 * @param greek
	 * 
	 * @return Returns the Latin character that is visually similar
	 *         with the specified character. If the specified character 
	 *         is not a Greek capital letter, or if it has not a visually
	 *         similar Latin character, then returns null.
	 */
	public Character getLatin(char greek) {
		return associations.getRight(greek);
	}
	
	

}
