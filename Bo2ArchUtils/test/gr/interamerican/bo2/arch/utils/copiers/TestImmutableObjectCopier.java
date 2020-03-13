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
package gr.interamerican.bo2.arch.utils.copiers;

import static org.junit.Assert.assertEquals;
import gr.interamerican.bo2.arch.Money;
import gr.interamerican.bo2.arch.utils.beans.MoneyImpl;

import java.math.BigDecimal;

import org.junit.Test;

/**
 * Test for ImmutableObjectCopier.
 */
public class TestImmutableObjectCopier {


	/** ImmutableObjectCopier. */
	ImmutableObjectCopier<Money> copier = new ImmutableObjectCopier<Money>();
	
	/**
	 * test copy.
	 */
	@Test
	public void testCopy(){
	
		Money money = new MoneyImpl();
		money.setAmount(new BigDecimal(1000));
		Money newMoney = copier.copy(money);
		assertEquals(money.getAmount(),newMoney.getAmount());
	}
	
}
