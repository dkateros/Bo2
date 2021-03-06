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
package gr.interamerican.bo2.utils.conditions;

import java.util.function.Function;

import gr.interamerican.bo2.utils.adapters.trans.GetRange;
import gr.interamerican.bo2.utils.beans.Range;

/**
 * Checks that a specified value is within the limits defined by two properties.
 * 
 * 
 * @param <T>
 *            Type of objects being checked by the condition.
 * @param <P>
 *            Return type of the properties that define the range.
 * 
 */
public class ValueIsWithinRangeDefinedByProperties<T, P extends Comparable<? super P>>
extends ConditionOnTransformation<T, Range<P>>
implements Condition<T> {

	/**
	 * Creates a new ValueIsWithinRangeDefinedByProperties object.
	 * 
	 * @param leftProperty
	 *            Expression for left property.
	 * @param rightProperty
	 *            Expression for right property.
	 * @param clazz
	 *            Class of objects being checked.
	 * @param value
	 *            Value that must be within the limits specified by the
	 *            properties.
	 *
	 * @deprecated Use the Other Constructor
	 */
	@Deprecated
	public ValueIsWithinRangeDefinedByProperties(String leftProperty, String rightProperty, Class<T> clazz,
			final P value) {
		super(new gr.interamerican.bo2.utils.adapters.trans.GetRangeFromProperties<T, P>(leftProperty, rightProperty,
				clazz), new RangeContainsValue<P>(value));
	}

	/**
	 * Public Constructo.
	 * 
	 * @param getLeft
	 *            Function that defines the left limit of the range.
	 * @param getRight
	 *            Function that defines the right limit of the range.
	 * @param value
	 *            Value that must be within the limits specified by the
	 *            properties.
	 */
	public ValueIsWithinRangeDefinedByProperties(Function<T, P> getLeft, Function<T, P> getRight, final P value) {
		super(new GetRange<>(getLeft, getRight), new RangeContainsValue<>(value));
	}
}