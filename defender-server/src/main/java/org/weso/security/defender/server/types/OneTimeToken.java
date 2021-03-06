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
package org.weso.security.defender.server.types;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * The Class OneTimeToken.
 *
 * @author Guillermo Facundo Colunga
 * @version 201806081225
 */
public class OneTimeToken {

	/** The token. */
	private String token;

	/**
	 * Instantiates a new one time token.
	 */
	public OneTimeToken() {
		this.token = generateToken();
	}

	/**
	 * Generate token.
	 *
	 * @return the string
	 */
	private synchronized String generateToken() {
		return RandomStringUtils.randomAlphanumeric(512);
	}
	
	/**
	 * Only one time access token.
	 *
	 * @return the string
	 */
	public String value() {
		String aux = token;
		token = null;
		return aux;
	}
}
