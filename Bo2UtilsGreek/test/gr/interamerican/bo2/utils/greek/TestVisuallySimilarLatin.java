package gr.interamerican.bo2.utils.greek;

import gr.interamerican.bo2.utils.greek.VisuallySimilarLatin;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests for {@link VisuallySimilarLatin}.
 */
public class TestVisuallySimilarLatin {
	
	/**
	 * tests getGreek(c).
	 */
	@Test
	public void testGetGreek() {
		VisuallySimilarLatin obj = VisuallySimilarLatin.getInstance();	
		Character latin = Character.toUpperCase('a');
		Character greek = Character.toUpperCase('�');
		Character actual = obj.getGreek(latin);
		Assert.assertEquals(greek, actual);
		Assert.assertNull(obj.getGreek('f')); 		
	}
	
	/**
	 * tests getlatin(c).
	 */
	@Test
	public void testGetLatin() {
		VisuallySimilarLatin obj = VisuallySimilarLatin.getInstance();		
		Character latin = Character.toUpperCase('a');
		Character greek = Character.toUpperCase('�');
		Character actual = obj.getLatin(greek);
		Assert.assertEquals(latin, actual);
		Assert.assertNull(obj.getLatin('�')); 		
	}
	
	
	
	/**
	 * tests removeSymbolsAndReplaceLatinWithSimilarGreekChars(String str).
	 */
	@Test
	@SuppressWarnings("nls")
	public void testRemoveSymbolsAndReplaceLatinWithSimilarGreekChars () {
		
		VisuallySimilarLatin obj = VisuallySimilarLatin.getInstance();	
		String latin = "#abp";
		String greekExpected = "���";
		
		String actual = obj.removeSymbolsAndReplaceLatinWithSimilarGreekChars(latin);
		Assert.assertEquals(greekExpected, actual);
		
		latin = "#ff";		
		actual = obj.removeSymbolsAndReplaceLatinWithSimilarGreekChars(latin);
		
		
		String actualExpected = "FF";
		Assert.assertEquals(actualExpected, actual);
		
	}
	
	


	/**
	 * tests removeSymbolsAndReplaceLatinWithSimilarGreekChars(String str).
	 */
	@Test
	@SuppressWarnings("nls")
	public void testRemoveSymbolsAndReplaceGreekWithSimilarLatinChars () {
		
		VisuallySimilarLatin obj = VisuallySimilarLatin.getInstance();	
		String greek = "#���";
		String latinExpected = "ABP";
		
		String actual = obj.removeSymbolsAndReplaceGreekWithSimilarLatinChars(greek);
		Assert.assertEquals(latinExpected, actual);
		
		greek = "#��";		
		actual = obj.removeSymbolsAndReplaceGreekWithSimilarLatinChars(greek);
		
		String actualExpected = "��";
		Assert.assertEquals(actualExpected, actual);
		
	}

	
	
	


	/**
	 * tests removeAndReplaceLatinWithGreekCharsAndViceVersa(String str, boolean latinToGreek).
	 */
	@Test
	@SuppressWarnings("nls")
	public void testRemoveAndReplaceLatinWithGreekCharsAndViceVersa() {


		VisuallySimilarLatin obj = VisuallySimilarLatin.getInstance();	
		String latin = "#abp";
		String greekExpected = "���";
		
		String actual = obj.removeAndReplaceLatinWithGreekCharsAndViceVersa(latin, true);
		Assert.assertEquals(greekExpected, actual);
		
		latin = "#ff";		
		actual = obj.removeAndReplaceLatinWithGreekCharsAndViceVersa(latin, true);
		
		
		String actualExpected = "FF";
		Assert.assertEquals(actualExpected, actual);
		
		String greek = "#���";
		String latinExpected = "ABP";
		
		actual = obj.removeAndReplaceLatinWithGreekCharsAndViceVersa(greek, false);
		Assert.assertEquals(latinExpected, actual);
		
		greek = "#��";		
		actual = obj.removeAndReplaceLatinWithGreekCharsAndViceVersa(greek, false);
		
		actualExpected = "��";
		Assert.assertEquals(actualExpected, actual);
		
	}
	
}
