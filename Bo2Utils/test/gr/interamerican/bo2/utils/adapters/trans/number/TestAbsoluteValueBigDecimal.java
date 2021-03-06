package gr.interamerican.bo2.utils.adapters.trans.number;

import gr.interamerican.bo2.utils.adapters.trans.number.AbsoluteValueBigDecimal;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests for {@link AbsoluteValueBigDecimal}.
 */
public class TestAbsoluteValueBigDecimal {
	
	/**
	 * Test for execute().
	 */
	@Test
	public void testExecute() {
		AbsoluteValueBigDecimal calc = new AbsoluteValueBigDecimal();
		BigDecimal input = new BigDecimal(-6).setScale(3); 
		Object actual = calc.execute(input);
		Assert.assertEquals(input.abs(), actual);
	}

}
