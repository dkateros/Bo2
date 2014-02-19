package gr.interamerican.bo2.utils;

import static gr.interamerican.bo2.utils.GreekUtils.*;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * 
 */
public class TestGreekUtils {
	
	/**
	 * test removeSymbolsAndReplaceLatinWithSimilarGreekChars
	 */
	@SuppressWarnings("nls")
	@Test
	public void testRemoveSignsAndReplaceLatinWithSimilarGreekChars() {
		String[] inputs = 
			{"yzx 5248", "ikn-4789", "abe_5486", "opt3547", "hmg3547", "kkk*2525*"};
		String[] expecteds = 
			{"���5248",  "���4789",  "���5486",  "���3547", "��g3547", "���2525"};
		
		for (int i = 0; i < inputs.length; i++) {
			String actual = removeSymbolsAndReplaceLatinWithSimilarGreekChars(inputs[i]);
			assertEquals(expecteds[i].toUpperCase(),actual);
		}
	}
	
	/**
	 * test containsNonGreekLetters
	 */
	@SuppressWarnings("nls")
	@Test
	public void testContainsNonGreekLetters() {
		String[] inputs = 
			{"���-5248!", "ibm4789", "���5486", "* ***", "/ //f", "\u0428-2525"};
		boolean[] expecteds = 
			{false,        true,      false,    false,   true,   true };
		
		for (int i = 0; i < inputs.length; i++) {
			System.out.println(inputs[i]);
			boolean actual = containsNonGreekLetters(inputs[i]);
			assertEquals("Input string="+inputs[i], expecteds[i],actual);
		}
	}
	
	/**
	 * test removeNonGreekLetters
	 */
	@SuppressWarnings("nls")
	@Test
	public void testRemoveEverythingButGreekLetters() {
		String[] inputs = 
			{"���-5248!", "ibm4789", "���5486", "* ***", "/ //f", "\u0428-2525"};
		String[] expecteds = 
			{"���", "", "���", "", "", ""};
		
		for (int i = 0; i < inputs.length; i++) {
			System.out.println(inputs[i]);
			String actual = removeEverythingButGreekLetters(inputs[i]);
			assertEquals(expecteds[i], actual);
		}
	}
	
	/**
	 * test removeNonGreekLetters
	 */
	@SuppressWarnings("nls")
	@Test
	public void testRemoveGreekLetters() {
		String[] inputs = 
			{"���-5248!", "ibm4789", "���5486", "* ***", "/ //f", "\u0428-2525"};
		String[] expecteds = 
			{"-5248!", "ibm4789", "5486", "* ***", "/ //f", "\u0428-2525"};
		
		for (int i = 0; i < inputs.length; i++) {
			System.out.println(inputs[i]);
			String actual = removeGreekLetters(inputs[i]);
			assertEquals(expecteds[i], actual);
		}
	}

}
