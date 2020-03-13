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
package gr.interamerican.bo2.utils.meta.ext.formatters.nr;

import gr.interamerican.bo2.arch.Money;
import gr.interamerican.bo2.utils.meta.ext.formatters.MoneyFormatter;
import gr.interamerican.bo2.utils.meta.formatters.nr.NullReturningFormatter;

/**
 * NullFilteringFormatter for Numbers.
 */
public class NrMoneyFormatter extends NullReturningFormatter<Money> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Creates a new NfObjectFormatter object. 
	 */
	public NrMoneyFormatter() {
		super(MoneyFormatter.INSTANCE);
	}

	
}
