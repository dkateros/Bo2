package gr.interamerican.bo2.utils.beans;

import gr.interamerican.bo2.utils.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * {@link SegmentedDistance} models a set of segments with a set of
 * {@link Range} objects, each linked to a value.
 * 
 * The purpose of this class is to find the value that is associated
 * with the range that contains a specified dimension value. <br/>
 * 
 * This utility class is suitable for areas with relatively a few
 * segments, because it searches the segments (Ranges) sequentially
 * in order to find which contain the specified dimension value.
 * 
 * 
 * @param <A>
 *        Type of Range 
 * @param <V> 
 *        Type of value.
 */
public class SegmentedDistance<A extends Comparable<? super A>,V> {
	
	/**
	 * Map that keeps the ranges.
	 */
	Map<Range<A>, V> ranges = new HashMap<Range<A>, V>();
	
	
	
	

	/**
	 * Adds a new range to the area.
	 * 
	 * Before adding the area, it checks if the range being added
	 * overlaps with another already existing range. If this is
	 * the case, then a RuntimeException is thrown.
	 * 
	 * @param left
	 *        left limit of the range. 
	 * @param right
	 *        right limit of the range. 
	 * @param value
	 *        Value associated with the rage.  
	 */
	public void setValue(A left, A right, V value) {
		Range<A> range = new Range<A>(left,right);
		if (isOverlapping(range)) {
			@SuppressWarnings("nls")
			String msg = StringUtils.concat(
					"Range ", range.toString(),
					" overlaps with other ranges");
			throw new RuntimeException(msg);
		}
		ranges.put(range,value);
	}
	
	/**
	 * Checks if the specified {@link Range} overlaps with any of the
	 * ranges that compose this {@link SegmentedDistance}.
	 * 
	 * @param range
	 *        Range being checked for overlapping.
	 *        
	 * @return Returns true if the range overlaps with this {@link SegmentedDistance},
	 *         otherwise returns false.
	 */
	public boolean isOverlapping(Range<A> range) {
		Set<Range<A>> set = ranges.keySet();
		for (Range<A> r : set) {
			if (r.overlapsWith(range)) {
				return true;
			}
		}
		return false;
	}

	
	
	/**
	 * Gets the value that is associated with the range that
	 * contains the specified dimension. 
	 * 
	 * @param dimension
	 * 
	 * @return Returns the value associated with the range that
	 *         contains the specified dimension, or null if their 
	 *         is no range containing the specified dimension.  
	 */
	public V getValue(A dimension) {
		Range<A> range = getRange(dimension);
		if (range!=null) {
			return ranges.get(range);
			
		}
		return null;
	}
	
	/**
	 * Gets the value that is associated with the range that
	 * contains the specified dimension. 
	 * 
	 * @param dimension
	 * 
	 * @return Returns the value associated with the range that
	 *         contains the specified dimension, or null if their 
	 *         is no range containing the specified dimension.  
	 */
	public Range<A> getRange(A dimension) {
		Set<Range<A>> set = ranges.keySet();
		for (Range<A> range : set) {
			if (range.contains(dimension)) {
				return range;
			}
		}
		return null;
	}

}