/*
 * MIT License
 *
 * Copyright (c) 2018 Guillermo Facundo Colunga
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package org.weso.security.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * The Class VolatileCache.
 *
 * @author Guillermo Facundo Colunga
 * @version 201806081225
 */
public class VolatileCache {

	/** The volatile table. */
	// The table that will store cache data.
	private Map<String, Map<String, Object>> volatileTable = null;

	/** The clean up time. */
	// The time between table cleans. NOT IMPLEMENTED YET.
	//private long cleanUpTime = -1;

	/**
	 * Instantiates a new volatile cache.
	 */
	public VolatileCache() {
		volatileTable = new HashMap<String, Map<String, Object>>();
		//cleanUpTime = 1000;
	}

	/**
	 * Gets the metadata.
	 *
	 * @param token the token
	 * @return the metadata
	 */
	public Map<String, Object> getMetadata(String token) {
		return volatileTable.get( token );
	}

	/**
	 * Save metadata.
	 *
	 * @param token the token
	 * @param metadata the metadata
	 * @return true, if successful
	 */
	public boolean saveMetadata(String token, Map<String, Object> metadata) {
		volatileTable.put( token, metadata );
		return true;
	}

}
