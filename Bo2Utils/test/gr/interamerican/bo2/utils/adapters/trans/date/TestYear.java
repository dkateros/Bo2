package gr.interamerican.bo2.utils.adapters.trans.date;

import gr.interamerican.bo2.utils.DateUtils;
import gr.interamerican.bo2.utils.adapters.trans.date.Year;

import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests for {@link Year}.
 */
public class TestYear {
	
	/**
	 * Test for execute().
	 */
	@Test
	public void testExecute() {
		Year calc = new Year();
		Integer year = 2014;
		Date input = DateUtils.getDate(year, Calendar.JULY, 13); 
		Integer actual = calc.execute(input);		
		Assert.assertEquals(year, actual);
	}

}
