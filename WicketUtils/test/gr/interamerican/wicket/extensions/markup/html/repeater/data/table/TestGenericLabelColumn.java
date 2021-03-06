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
package gr.interamerican.wicket.extensions.markup.html.repeater.data.table;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.apache.wicket.Component;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DefaultDataTable;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.junit.Test;

import gr.interamerican.bo2.samples.SampleBean2;
import gr.interamerican.bo2.utils.StringUtils;
import gr.interamerican.bo2.utils.Utils;
import gr.interamerican.bo2.utils.functions.SerializableComparableFunction;
import gr.interamerican.bo2.utils.functions.SerializableFunction;
import gr.interamerican.wicket.extensions.markup.html.repeater.util.FunctionalSortableDataProvider;
import gr.interamerican.wicket.markup.html.Markup;
import gr.interamerican.wicket.test.WicketTest;

/**
 * Unit tests for {@link GenericLabelColumn}
 */
public class TestGenericLabelColumn extends WicketTest {

	/**
	 * Test method for
	 * {@link GenericLabelColumn#GenericLabelColumn(IModel, SerializableFunction)}.
	 */
	@SuppressWarnings("nls")
	@Test
	public void testGenericLabelColumnIModelOfStringEmbeddedSerializableConsumerOfT() {
		GenericLabelColumn<SampleBean2, String> tested = new GenericLabelColumn<>(Model.of("text"),
				(a) -> StringUtils.firstCapital(a.getField1()));
		assertNotNull(tested);
		assertEquals("text", tested.getDisplayModel().getObject());
	}

	/**
	 * Test method for
	 * {@link GenericLabelColumn#populateItem(Item, String, IModel)}.
	 */
	@Test
	public void testPopulateItem() {
		startAndTestComponent(DefaultDataTable.class, Markup.table);
	}

	@SuppressWarnings("nls")
	@Override
	protected Component initializeComponent(String wicketId) {
		GenericLabelColumn<SampleBean2, SerializableComparableFunction<SampleBean2, ?>> tested = new GenericLabelColumn<>(
				Model.of("text"), (a) -> StringUtils.firstCapital(Utils.notNull(a.getField1(), "")));
		return new DefaultDataTable<>(wicketId, Arrays.asList(tested),
				new FunctionalSortableDataProvider<>(Arrays.asList(new SampleBean2())), 10);
	}
}