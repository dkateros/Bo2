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
package gr.interamerican.wicket.markup.html.panel.back;

import static org.junit.Assert.assertNull;

import org.apache.wicket.Page;
import org.apache.wicket.markup.html.form.Form;
import org.junit.Test;

import gr.interamerican.wicket.ajax.markup.html.form.CallbackAjaxButton;
import gr.interamerican.wicket.callback.MockedCallback;
import gr.interamerican.wicket.markup.html.BaseTestPage;
import gr.interamerican.wicket.markup.html.Markup;
import gr.interamerican.wicket.markup.html.TestPage;
import gr.interamerican.wicket.test.WicketTest;

/**
 * Unit test for {@link ServicePanelWithBack}.
 */
@SuppressWarnings("nls")
public class TestServicePanelWithBack 
extends WicketTest {
	
	/**
	 * Creates a sample definition.
	 * 
	 * @return returns a definition.
	 */	
	ServicePanelWithBackDef createDef() {
		ServicePanelWithBackDef def = new ServicePanelWithBackDefImpl();
		def.setBackAction(null);
		def.setWicketId(BaseTestPage.TEST_ID);
		return def;
	}
	
	/**
	 * Tests creation of {@link ServicePanelWithBack}.
	 */	
	@Test
	public void testCreation_withCallback() {	
		MockedCallback action = new MockedCallback();
		ServicePanelWithBackDef def = createDef();
		def.setBackAction(action);
		ServicePanelWithBack panel = new ServicePanelWithBack(def);
		Page source = new TestPage(panel, Markup.div);

		
		tester.startPage(source);
		tester.assertRenderedPage(TestPage.class);
		tester.assertComponent(path("backForm"),Form.class);
		
		tester.assertComponent(path("backForm:backButton"),CallbackAjaxButton.class);
		tester.assertVisible(path("backForm:backButton"));			
	}
	
	/**
	 * Tests creation of {@link ServicePanelWithBack}.
	 */	
	@Test
	public void testCreation_withoutCallback() {
		final ServicePanelWithBackDef def = createDef();
		ServicePanelWithBack panel = new ServicePanelWithBack(def);
		Page source = new TestPage(panel, Markup.div);
		tester.startPage(source);
		tester.assertRenderedPage(TestPage.class);
		tester.assertInvisible(path("backForm"));
		tester.assertInvisible(path("backForm:backButton"));
		
		//since this was not rendered it is null??
		CallbackAjaxButton button = (CallbackAjaxButton) 
			tester.getComponentFromLastRenderedPage(path("backForm:backButton"));
		assertNull(button);

	}
	
	
	/**
	 * Test ValidateDef.
	 */
	@Test(expected = RuntimeException.class)
	public void testValidateDef(){
		ServicePanelWithBackDef def = new ServicePanelWithBackDefImpl();
		def.setWicketId(null);
		new ServicePanelWithBack(def);
	}
}