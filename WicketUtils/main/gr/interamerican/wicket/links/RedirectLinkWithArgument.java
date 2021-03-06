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
package gr.interamerican.wicket.links;

import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.component.IRequestablePage;

import gr.interamerican.bo2.utils.functions.SerializableFunction;

/**
 * A {@link Link} that will redirect to the page we provide a constructor for in
 * this Constructor, with the use of the input argument provided also on this
 * constructor.
 * 
 * @param <T>
 *            type of model object
 */
public class RedirectLinkWithArgument<T> extends Link<T> {

	/**
	 * Version UID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the page we link to
	 */
	private final SerializableFunction<T, IRequestablePage> constructor;

	/**
	 * Public Constructor.
	 *
	 * @param id
	 *            Wicket Id
	 * @param argument
	 *            Argument for the page creation
	 * @param constructor
	 *            Constructor of the page we link to
	 */
	public RedirectLinkWithArgument(String id, IModel<T> argument,
			SerializableFunction<T, IRequestablePage> constructor) {
		super(id, argument);
		this.constructor = constructor;
	}

	@Override
	public void onClick() {
		setResponsePage(constructor.apply(getModelObject()));
	}
}