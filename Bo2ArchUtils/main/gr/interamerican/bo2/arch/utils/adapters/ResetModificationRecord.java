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
package gr.interamerican.bo2.arch.utils.adapters;

import gr.interamerican.bo2.arch.ModificationRecord;
import gr.interamerican.bo2.arch.PersistentObject;
import gr.interamerican.bo2.arch.utils.beans.ModificationRecordImpl;

/**
 * Sets the modification record.
 *
 * @param <P> the generic type
 */
public class ResetModificationRecord<P extends PersistentObject<?> & ModificationRecord>
extends SetModificationRecord<P> {
	
	/**
	 * Empty modification record.
	 */
	private static final ModificationRecordImpl EMPTY;
	
	static {
		EMPTY = new ModificationRecordImpl();
		EMPTY.setLastModified(null);
		EMPTY.setLastModifiedBy(null);
	}
	

	
	/**
	 * Creates a new ResetModificationRecord object. 
	 *
	 */
	public ResetModificationRecord() {
		super(EMPTY);
	}
	

}
