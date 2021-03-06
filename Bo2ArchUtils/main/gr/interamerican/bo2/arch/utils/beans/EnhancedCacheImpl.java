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
package gr.interamerican.bo2.arch.utils.beans;

import gr.interamerican.bo2.arch.ext.Cache;
import gr.interamerican.bo2.arch.ext.EnhancedCache;
import gr.interamerican.bo2.arch.ext.Translator;
import gr.interamerican.bo2.arch.utils.CacheRegistry;
import gr.interamerican.bo2.arch.utils.TranslatorRegistry;

/**
 * Implementation of {@link EnhancedCache}.
 *
 * @param <C> the generic type
 * @param <R> the generic type
 * @param <L> the generic type
 */
public class EnhancedCacheImpl
<C extends Comparable<? super C>,R extends Comparable<? super R>,L>  
implements gr.interamerican.bo2.arch.ext.EnhancedCache<C,R,L> {
	
	/**
	 * Cache.
	 */
	private Cache<C> cache;
	
	/**
	 * Translator.
	 */
	private Translator<R,L> translator;
	
	/**
	 * Creates a new ControlPanelImpl object. 
	 * Used on tests.
	 */
	EnhancedCacheImpl() {
		super();
		cache = new CacheImpl<C>();
		translator = new TranslatorImpl<R, L>();
	}
	
	/**
	 * Creates a new ControlPanelImpl object. 
	 * 
	 * @param cacheName Cache name.
	 * @param codeType Type of cache code.
	 */
	public EnhancedCacheImpl(String cacheName, Class<C> codeType) {
		super();
		cache = new CacheImpl<C>();
		CacheRegistry.registerCache(cacheName, cache, codeType);
		
		translator = new TranslatorImpl<R,L>();
		TranslatorRegistry.registerTranslator(cacheName, translator);
	}

	@Override
	public Cache<C> getCache() {		
		return cache;
	}

	@Override
	public Translator<R,L> getTranslator() {		
		return translator;
	}
}