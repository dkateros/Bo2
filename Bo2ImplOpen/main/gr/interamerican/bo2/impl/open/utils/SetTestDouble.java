package gr.interamerican.bo2.impl.open.utils;

import gr.interamerican.bo2.arch.PersistenceWorker;
import gr.interamerican.bo2.arch.PersistentObject;
import gr.interamerican.bo2.arch.Query;
import gr.interamerican.bo2.impl.open.operations.AbstractQueryCrawlerOperation;
import gr.interamerican.bo2.impl.open.workers.FactorySupportedPoHandler;
import gr.interamerican.bo2.impl.open.workers.PredefinedConditionValidator;
import gr.interamerican.bo2.utils.ReflectionUtils;
import gr.interamerican.bo2.utils.conditions.Condition;


/**
 * The SetTestDouble utility facilitates the replacement of package visible or 
 * protected fields. 
 * 
 * Its purpose is to be used by test classes that need to replace fields of the 
 * test class with test doubles (mocks).  
 */
@SuppressWarnings("nls")
public class SetTestDouble {
	
	/**
	 * Sets a test double query to an {@link AbstractQueryCrawlerOperation}.
	 *
	 * @param <Q> the generic type
	 * @param operation the operation
	 * @param query the query
	 */
	public static <Q extends Query> 
	void set(AbstractQueryCrawlerOperation<Q> operation, Q query) {
		ReflectionUtils.set("query", query, operation);		
	}
	
	/**
	 * Sets a test double persistence worker to an {@link FactorySupportedPoHandler}.
	 *
	 * @param <P> the generic type
	 * @param handler the handler
	 * @param pw the pw
	 */	
	public static <P extends PersistentObject<?>> 
	void set(FactorySupportedPoHandler<?,P> handler, PersistenceWorker<P> pw) {
		ReflectionUtils.set("pw", pw, handler);		
	}
	
	
	
	/**
	 * Sets a test double condition to a {@link PredefinedConditionValidator}.
	 *
	 * @param <T> the generic type
	 * @param validator the validator
	 * @param condition the condition
	 */	
	public static <T> 
	void set(PredefinedConditionValidator<T> validator, Condition<T> condition) {
		ReflectionUtils.set("condition", condition, validator);		
	}

}
