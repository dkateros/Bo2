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
package gr.interamerican.bo2.impl.open.operations;


import gr.interamerican.bo2.arch.exceptions.DataAccessException;
import gr.interamerican.bo2.arch.exceptions.DataException;
import gr.interamerican.bo2.arch.exceptions.InitializationException;
import gr.interamerican.bo2.arch.exceptions.LogicException;
import gr.interamerican.bo2.arch.exceptions.UnexpectedException;
import gr.interamerican.bo2.impl.open.annotations.ManagerName;
import gr.interamerican.bo2.impl.open.runtime.AbstractBo2RuntimeCmd;
import gr.interamerican.bo2.impl.open.workers.ArrayIteratorQuery;
import gr.interamerican.bo2.utils.adapters.mod.GetTheSame;

import org.junit.Test;

/**
 * Unit test for {@link QueryExporterOperation}.
 */
public class TestQueryPrinterOperation {
	/**
	 * Query rows.
	 */
	@SuppressWarnings("nls")
	String[] strings = {"one", "two", "three", "four"};
	
	
	
	
	
	/**
	 * test.
	 *
	 * @throws UnexpectedException the unexpected exception
	 * @throws DataException the data exception
	 * @throws LogicException the logic exception
	 */
	@Test
	public void testLifecycle() throws UnexpectedException, DataException, LogicException {
		new AbstractBo2RuntimeCmd() {			
			@Override
			public void work() throws LogicException, DataException,
			InitializationException, UnexpectedException {
				SampleOperation op = new SampleOperation();
				op.init(getProvider());
				op.open();
				op.execute();
				op.close();
			}
		}.execute();		
	}
	
	/**
	 * Sample operation.
	 */
	@ManagerName("LOCALFS")
	class SampleOperation extends QueryPrinterOperation<String, ArrayIteratorQuery<String>> {

		/**
		 * Creates a new SampleOperation object. 
		 *		
		 */
		@SuppressWarnings("nls")
		public SampleOperation() {
			super(new ArrayIteratorQuery<String>(strings), //query
				  new GetTheSame<String>(),  			   //transformation	
				  "TestQueryPrinterOperation.out");		   //output name	 
		}
		
		@Override
		protected String getCurrentRow() throws DataAccessException {			
			return query.getEntity();
		}
		
	}

}
