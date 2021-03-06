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
package gr.interamerican.bo2.utils.beans;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * Unit tests for {@link AnyRange}.
 */
public class TestAnyRange {
	/**
	 * object being tested.
	 */
	AnyRange<Integer> any = new AnyRange<Integer>();
	/**
	 * sample range for test.
	 */
	Range<Integer> other = new Range<Integer>(2,5);
	
	/**
	 * test for overlapsWith().
	 */
	@Test
	public void testOverlapsWith() {
		assertTrue(any.overlapsWith(other));
	}
	
	/**
	 * test for overlapsWith().
	 */
	@Test
	public void testContains() {		
		assertTrue(any.contains(7));
		Integer iNull = null;		
		assertTrue(any.contains(iNull));
	}

	/**
	 * test for testCompareTo().
	 */
	@Test
	public void testCompareTo() {
		assertTrue(any.compareTo(other)>0);
		assertTrue(any.compareTo(new AnyRange<Integer>())==0);
	}
	
	/**
	 * test for testCompareTo().
	 */
	@Test
	public void testEquals() {
		assertFalse(any.equals(other));
		assertTrue(any.equals(new AnyRange<Integer>()));
		assertTrue(any.equals(any));
		assertFalse(any.equals(null));
	}
	
	/**
	 * test for setLeft().
	 */
	@Test
	public void testSetLeft() {
		any.setLeft(3);
		assertNull(any.getLeft());
	}	
	
	/**
	 * test for setRight().
	 */
	@Test
	public void testSetRight() {
		any.setRight(3);
		assertNull(any.getRight());
	}
	
	/**
	 * test for toString().
	 */
	@Test
	public void testToString() {		
		assertNotNull(any.toString());
	}
	
	/**
	 * test for hashcode().
	 */
	@Test
	public void testHashcode() {		
		assertTrue(any.hashCode()!=0);
	}
	
	/**
	 * test for contains(range).
	 */
	@Test
	public void testContains_Range() {		
		assertTrue(any.contains(other));
	}
	
	/**
	 * test for intersection(range).
	 */
	@Test
	public void testIntersection() {		
		assertEquals(other, any.intersection(other));
	}
	
	/**
	 * test for overlapsWith(collection).
	 */
	@Test
	public void testOverlapsWith_collection() {
		List<Range<Integer>> list = new ArrayList<Range<Integer>>();
		list.add(other);
		assertTrue(any.overlapsWith(list));
	}
	
	/**
	 * test for isPoint().
	 */
	@Test
	public void testIsPoint() {	
		assertFalse(any.isPoint());
	}
	
	/**
	 * test for isPoint().
	 */
	@Test
	public void testRemainder() {	
		List<Range<Integer>> list = any.remainder(other);
		assertEquals(1, list.size());
		assertEquals(any, list.get(0));
	}
	
	

}
