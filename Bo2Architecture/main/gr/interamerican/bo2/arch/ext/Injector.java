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
package gr.interamerican.bo2.arch.ext;

/**
 * Injects a resource to its {@link Consumer}.
 * 
 * @param <R> 
 *        Type of resource injected.
 */
public interface Injector<R> {
	
	/**
	 * Provides the requested object to the visitor that
	 * requested it.
	 *
	 * @param consumer the consumer
	 */
	public void inject(Consumer<R> consumer);

}
