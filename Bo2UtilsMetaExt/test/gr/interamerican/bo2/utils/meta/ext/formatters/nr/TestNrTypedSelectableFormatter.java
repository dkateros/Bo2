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

import static org.junit.Assert.assertNotNull;
import gr.interamerican.bo2.utils.ReflectionUtils;
import gr.interamerican.bo2.utils.meta.ext.formatters.TypedSelectableFormatter;

import org.junit.Test;

/**
 * The Class TestNrTypedSelectableFormatter.
 */
public class TestNrTypedSelectableFormatter {


	
	/**
	 * test Constructor.
	 */
	@Test
	public void testConstructor(){
		NrTypedSelectableFormatter formatter = new NrTypedSelectableFormatter();
		assertNotNull(formatter);
		ReflectionUtils.isInstanceOf(formatter, TypedSelectableFormatter.class);
	}
	
}
