package gr.interamerican.bo2.utils.adapters.mod;

import gr.interamerican.bo2.samples.bean.BeanWithStringAndDate;
import gr.interamerican.bo2.utils.adapters.mod.CopyFromMap;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit tests for {@link CopyFromMap}.
 */
public class TestCopyFromMap {
	
	/**
	 * Tests the constructor.
	 */
	@Test
	public void testConstructor() {		
		Map<String, Object> map = new HashMap<String, Object>();
		CopyFromMap<BeanWithStringAndDate> copy = 
			new CopyFromMap<BeanWithStringAndDate>(map);
		Assert.assertEquals(map, copy.map);
	}
	
	/**
	 * Tests the constructor.
	 */
	@Test
	public void testExecute() {
		String string = "s"; //$NON-NLS-1$
		Date date = new Date();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("string", string); //$NON-NLS-1$
		map.put("date", date); //$NON-NLS-1$
		CopyFromMap<BeanWithStringAndDate> copy = 
			new CopyFromMap<BeanWithStringAndDate>(map);
		
		BeanWithStringAndDate bean = new BeanWithStringAndDate();
		copy.execute(bean);
		Assert.assertEquals(string, bean.getString());
		Assert.assertEquals(date, bean.getDate());
		
	}

}
