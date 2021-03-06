/*******************************************************************************
 * Copyright (c) 2013 INTERAMERICAN PROPERTY AND CASUALTY INSURANCE COMPANY S.A. 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v3
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/copyleft/lesser.html
 * 
 * This library is distributed in the hope that it will be useful, 
 * but WITHOUT ANY WARRANTY; without even the implied warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. 
 * See the GNU Lesser General Public License for more details.
 ******************************************************************************/
package gr.interamerican.bo2.utils.adapters.trans;

import org.junit.Assert;
import org.junit.Test;

import gr.interamerican.bo2.samples.bean.BeanWith2Fields;
import gr.interamerican.bo2.samples.bean.BeanWithNestedBean;
import gr.interamerican.bo2.utils.FunctionalUtils;
import gr.interamerican.bo2.utils.beans.Range;

/**
 * Unit tests for {@link GetRange}.
 */
public class TestGetRange {

	/**
	 * Tests execute.
	 */
	@Test
	public void testExecute() {
		BeanWithNestedBean bean = new BeanWithNestedBean(null, 5);
		bean.setProperty1(0);
		GetRange<BeanWithNestedBean, Integer> getRange = new GetRange<>(BeanWithNestedBean::getProperty1,
				FunctionalUtils.nullSafeSynthesize(BeanWithNestedBean::getNested, BeanWith2Fields::getField2));
		Range<Integer> actual = getRange.execute(bean);
		Range<Integer> expected = new Range<Integer>(0, 5);
		Assert.assertEquals(expected, actual);
	}
}