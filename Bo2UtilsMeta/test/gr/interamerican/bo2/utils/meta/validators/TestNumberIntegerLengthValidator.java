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
package gr.interamerican.bo2.utils.meta.validators;

import gr.interamerican.bo2.utils.meta.exceptions.ValidationException;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit tests for {@link NumberIntegerLengthValidator}.
 */
public class TestNumberIntegerLengthValidator {
	
	/**
	 * Test subject.
	 */
	private NumberIntegerLengthValidator<Number> validator = new NumberIntegerLengthValidator<Number>(1);

	/**
	 * Test method for validate(java.lang.Number)}.
	 *
	 * @throws ValidationException the validation exception
	 */
	@Test
	public void testValidate() throws ValidationException {
		validator.validate(1);
		validator.validate(1.1f);
		validator.validate(1.1d);
		validator.validate(new Integer(1));
		validator.validate(new Float(1.1f));
		validator.validate(new Double(1.1f));
		validator.validate(new BigDecimal(1.1f));
		
		boolean caught = false;
		try {
			validator.validate(11);
		} catch(ValidationException ve) {
			caught = true;
		}
		Assert.assertTrue(caught);
		
		caught = false;
		try {
			validator.validate(11.1f);
		} catch(ValidationException ve) {
			caught = true;
		}
		Assert.assertTrue(caught);
		
		caught = false;
		try {
			validator.validate(11.1d);
		} catch(ValidationException ve) {
			caught = true;
		}
		Assert.assertTrue(caught);
		
		caught = false;
		try {
			validator.validate(new Float(11.1f));
		} catch(ValidationException ve) {
			caught = true;
		}
		Assert.assertTrue(caught);
		
		caught = false;
		try {
			validator.validate(new Double(11.1d));
		} catch(ValidationException ve) {
			caught = true;
		}
		Assert.assertTrue(caught);
		
		caught = false;
		try {
			validator.validate(new BigDecimal(11.1d));
		} catch(ValidationException ve) {
			caught = true;
		}
		Assert.assertTrue(caught);
		
		caught = false;
		try {
			validator.validate(new Integer(11));
		} catch(ValidationException ve) {
			caught = true;
		}
		Assert.assertTrue(caught);
		
		caught = false;
		try {
			validator.validate(new Long(11));
		} catch(ValidationException ve) {
			caught = true;
		}
		Assert.assertTrue(caught);
	}

}
