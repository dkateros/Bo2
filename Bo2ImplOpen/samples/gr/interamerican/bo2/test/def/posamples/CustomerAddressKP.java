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
package gr.interamerican.bo2.test.def.posamples;

/**
 * {@link CustomerAddress} key properties.
 */
@SuppressWarnings("all")
public interface CustomerAddressKP extends CustomerKP {

	/**
	 * Gets the address no.
	 *
	 * @return the address no
	 */
	public Integer getAddressNo();
	
	/**
	 * Sets the address no.
	 *
	 * @param addressNo the new address no
	 */
	public void setAddressNo(Integer addressNo);
}
