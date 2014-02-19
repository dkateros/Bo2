package gr.interamerican.bo2.utils;

import static gr.interamerican.bo2.utils.GreekUtils.*;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * 
 */
public class TestGreekUtils {
	
	/**
	 * test toGreekPlateNo
	 */
	@SuppressWarnings("nls")
	@Test
	public void testRemoveSignsAndReplaceLatinWithSimilarGreekChars() {
		String[] inputs = 
			{"yzx 5248",  "ikn-4789", "abe_5486", "opt3547", "hmg3547", "kkk*2525*"};
		String[] expecteds = 
			{"���5248",   "���4789",  "���5486",  "���3547", "��g3547", "���2525"};
		
		for (int i = 0; i < inputs.length; i++) {
			String actual = removeSymbolsAndReplaceLatinWithSimilarGreekChars(inputs[i]);
			assertEquals(expecteds[i].toUpperCase(),actual);
		}
	}

}
