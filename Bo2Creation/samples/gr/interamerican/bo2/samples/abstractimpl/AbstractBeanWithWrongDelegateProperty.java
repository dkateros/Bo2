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
package gr.interamerican.bo2.samples.abstractimpl;

import gr.interamerican.bo2.creation.annotations.DelegateProperties;
import gr.interamerican.bo2.creation.annotations.Property;
import gr.interamerican.bo2.samples.bean.IBeanWithIdAndNameImpl;
import gr.interamerican.bo2.samples.ibean.IBeanWith2Strings;
import gr.interamerican.bo2.samples.ibean.IBeanWithIdAndName;

/**
 * Abstract class with wrong {@link DelegateProperties} annotation.
 */
public abstract class AbstractBeanWithWrongDelegateProperty 
implements IBeanWithIdAndName, IBeanWith2Strings {
	/**
	 * serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * support for IBeanWithIdAndName.
	 */
	@DelegateProperties("beanName")
	private IBeanWithIdAndName bean1 = new IBeanWithIdAndNameImpl();
	
	/**
	 * support for IBeanWithIdAndName.
	 */
	@DelegateProperties("beanId")
	protected Object bean2 = new Object(); 


	/**
	 * string 1.
	 */
	@Property protected String string1;
	
	/**
	 * string 2.
	 */	
	@Property private String string2;
	

}
