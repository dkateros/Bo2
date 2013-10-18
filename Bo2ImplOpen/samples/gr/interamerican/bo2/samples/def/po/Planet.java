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
package gr.interamerican.bo2.samples.def.po;

import gr.interamerican.bo2.arch.ModificationRecord;
import gr.interamerican.bo2.arch.PersistentObject;
import gr.interamerican.bo2.utils.attributes.Named;

import java.util.Set;

/**
 * 
 */
public interface Planet 
extends Named, Populated, PersistentObject<PlanetKey>, ModificationRecord, PlanetKP {
	
	/**
	 * Child Collection getter.
	 * 
	 * @return Returns the collection.
	 */
	public Set<Continent> getContinents();
	
	/**
	 * Child Collection setter.
	 * 
	 * @param continents
	 */
	public void setContinents(Set<Continent> continents);
	

}
