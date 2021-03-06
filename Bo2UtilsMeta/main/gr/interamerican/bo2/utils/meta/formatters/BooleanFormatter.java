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
package gr.interamerican.bo2.utils.meta.formatters;

import gr.interamerican.bo2.utils.StringConstants;

/**
 * Formatter for {@link Boolean} objects.
 */
public class BooleanFormatter implements Formatter<Boolean> {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	/**
	 * Literal for true.
	 */
	String trueLiteral;
	/**
	 * Literal for false.
	 */
	String falseLiteral;
	
	/**
	 * Creates a new BooleanFormatter object. 
	 *
	 * @param trueLiteral the true literal
	 * @param falseLiteral the false literal
	 */
	public BooleanFormatter(String trueLiteral, String falseLiteral) {
		super();
		this.trueLiteral = trueLiteral;
		this.falseLiteral = falseLiteral;
	}
	
	/**
	 * Creates a new BooleanFormatter object.
	 */
	@SuppressWarnings("nls")
	public BooleanFormatter() {
		this("true", "false");
	}

	@Override
	public String format(Boolean t) {
		if(t==null) {
			return StringConstants.NULL;
		}
		if (t) {
			return trueLiteral;
		}
		return falseLiteral;
	}

}
