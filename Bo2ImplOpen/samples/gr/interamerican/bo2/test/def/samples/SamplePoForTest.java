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
package gr.interamerican.bo2.test.def.samples;

import gr.interamerican.bo2.arch.ModificationRecord;
import gr.interamerican.bo2.arch.PersistentObject;
import gr.interamerican.bo2.arch.ext.TypedSelectable;
import gr.interamerican.bo2.samples.ibean.IBeanWithIdAndName;

/**
 * The Interface SamplePoForTest.
 */
public interface SamplePoForTest 
extends SamplePoKP, PersistentObject<SamplePoKey>, 
ModificationRecord, SampleCalculator, TypedSelectable<Long>,
IBeanWithIdAndName
{
	
	/**
	 * Sets the serial no.
	 *
	 * @param serialNo the new serial no
	 */
	public void setSerialNo(Long serialNo);
	
	/**
	 * Gets the serial no.
	 *
	 * @return the serial no
	 */
	public Long getSerialNo();
	
	/**
	 * hack used to initialize class fields
	 * with @DelegateProperties or @DelegateMethods.
	 */
	public void init();
}
