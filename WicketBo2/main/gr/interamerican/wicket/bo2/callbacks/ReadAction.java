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
package gr.interamerican.wicket.bo2.callbacks;

import gr.interamerican.bo2.arch.PersistenceWorker;
import gr.interamerican.bo2.arch.PersistentObject;
import gr.interamerican.bo2.arch.exceptions.DataException;
import gr.interamerican.bo2.utils.functions.SerializableUnaryOperator;
import gr.interamerican.wicket.bo2.protocol.http.Bo2WicketRequestCycle;

/**
 * Action that will just read a {@link PersistentObject} with the use of it's
 * {@link PersistenceWorker}.
 * 
 * @param <P>
 *            Type of {@link PersistentObject}
 */
public class ReadAction<P extends PersistentObject<?>>
implements SerializableUnaryOperator<P> {

	/**
	 * serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * PO class.
	 */
	Class<P> poClass;

	/**
	 * Public Constructor
	 * 
	 * @param poClass
	 *            PersistentObject class.
	 */
	public ReadAction(Class<P> poClass) {
		this.poClass = poClass;
	}

	@Override
	public P apply(P b) {
		PersistenceWorker<P> pw = Bo2WicketRequestCycle.openPw(poClass);
		try {
			return pw.read(b);
		} catch (DataException e) {
			throw new RuntimeException(e);
		}
	}
}