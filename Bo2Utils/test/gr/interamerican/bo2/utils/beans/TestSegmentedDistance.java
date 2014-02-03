package gr.interamerican.bo2.utils.beans;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class for {@link SegmentedDistance}.
 */
public class TestSegmentedDistance {
	
	/**
	 * Tests the constructor.
	 */
	@Test
	public void testConstructor() {
		SegmentedDistance<Integer, Object> distance = new SegmentedDistance<Integer, Object>();
		Assert.assertNotNull(distance.ranges);
	}
	
	/**
	 * Tests the isOverlapping.
	 */
	@Test
	public void testIsOverlapping() {
		SegmentedDistance<Integer, Object> distance = new SegmentedDistance<Integer, Object>();
		Range<Integer> r0to5 = new Range<Integer>(0,5);
		Range<Integer> r6to11 = new Range<Integer>(6,11);
		Range<Integer> range = new Range<Integer>(5,6);
		distance.ranges.put(r0to5, 1);
		distance.ranges.put(r6to11, 2);
		Assert.assertTrue(distance.isOverlapping(range));		
	}
	
	/**
	 * Tests setValue(x1,x2,v).
	 */
	@Test
	public void testSetValue() {
		SegmentedDistance<Integer, Object> distance = new SegmentedDistance<Integer, Object>();
		Range<Integer> r0to5 = new Range<Integer>(0,5);
		Range<Integer> r6to13 = new Range<Integer>(6,13);
		Object o1 = new Object();
		Object o2 = new Object();
		distance.setValue(0, 5, o1);
		distance.setValue(6, 13, o2);
		Assert.assertTrue(distance.ranges.containsKey(r0to5));
		Assert.assertTrue(distance.ranges.containsKey(r6to13));
		Object actual1 = distance.ranges.get(r0to5);
		Assert.assertEquals(o1, actual1);
		Object actual2 = distance.ranges.get(r6to13);
		Assert.assertEquals(o2, actual2);
	}
	
	/**
	 * Tests setRange.
	 */
	@Test(expected=RuntimeException.class)
	public void testSetValue_withOverlappingValues() {
		SegmentedDistance<Integer, Object> distance = new SegmentedDistance<Integer, Object>();
		distance.setValue(0, 5, new Object());
		distance.setValue(3, 13, new Object());
	}
	
	/**
	 * Tests setRange.
	 */
	@Test
	public void testGetValue() {
		SegmentedDistance<Integer, Object> distance = new SegmentedDistance<Integer, Object>();
		Object o1 = new Object();
		Object o2 = new Object();
		distance.setValue(0, 5, o1);
		distance.setValue(6, 13, o2);
		Assert.assertEquals(o1, distance.getValue(3));
		Assert.assertEquals(o1, distance.getValue(5));
		Assert.assertEquals(o2, distance.getValue(10));
		Assert.assertNull(distance.getValue(25));
	}
	
	/**
	 * Tests setRange.
	 */
	@Test
	public void testGetRange() {
		SegmentedDistance<Integer, Object> distance = new SegmentedDistance<Integer, Object>();
		Integer l1 = 0;
		Integer r1= l1+5;
		Integer l2 = r1+1;
		Integer r2 = l2+15;		
		Object o1 = new Object();
		Object o2 = new Object();
		
		distance.setValue(l1, r1, o1);
		distance.setValue(l2, r2, o2);
		Range<Integer> expected = new Range<Integer>(l1, r1);
		Range<Integer> actual = distance.getRange(r1-1);
		
		Assert.assertEquals(expected, actual);
		
	}
	
	
	
	

}