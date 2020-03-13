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
package gr.interamerican.bo2.utils.sql.types;

import static org.junit.Assert.assertEquals;
import gr.interamerican.bo2.samples.sql.MockResultSet;

import java.sql.SQLException;

import org.junit.Test;

/**
 * The Class TestIntegerType.
 */
public class TestIntegerType {

	
	/** IntegerType. */
	IntegerType integerType = IntegerType.INSTANCE;
	
	/** MockResultSet. */
	MockResultSet rs = new MockResultSet();
	
	
	/**
	 * Tests get when column index is string.
	 *
	 * @throws SQLException the SQL exception
	 */
	@Test
	public void testGet_string() throws SQLException{
		Integer expected = rs.getInt("columnIndex"); //$NON-NLS-1$
		Integer actual = integerType.get(rs,"columnIndex"); //$NON-NLS-1$
		assertEquals(expected,actual);
		
	}
	
	/**
	 * Tests get when column index is integer.
	 *
	 * @throws SQLException the SQL exception
	 */
	@Test
	public void testGet_integer() throws SQLException{
		Integer expected = rs.getInt(0); 
		Integer actual = integerType.get(rs,0); 
		assertEquals(expected,actual);
		
	}
}
