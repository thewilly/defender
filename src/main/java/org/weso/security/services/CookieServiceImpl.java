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
package org.weso.security.services;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.weso.security.cache.VolatileCache;
import org.weso.security.repositories.CookiesRepository;
import org.weso.security.types.Cookie;

/**
 * The Class CookieServiceImpl.
 *
 * @author Guillermo Facundo Colunga
 * @version 201806081225
 */
@Service
public class CookieServiceImpl implements CookieService {

	/** The repository. */
	@Autowired
	private CookiesRepository repository;
	
	/** The v cache. */
	private VolatileCache vCache = new VolatileCache();

	/* (non-Javadoc)
	 * @see org.weso.security.services.CookieService#register(java.util.HashMap)
	 */
	@Override
	public void register( String token, Map<String, Object> metadata ) {
		Cookie cookie = new Cookie(token, metadata);
		vCache.saveMetadata( token, metadata );
		repository.save( cookie );
	}

	/* (non-Javadoc)
	 * @see org.weso.security.services.CookieService#getCookie(java.lang.String)
	 */
	@Override
	public Cookie getCookie( String token ) {
		Cookie cookie = new Cookie(token, vCache.getMetadata( token ));
		return cookie.metadata != null ? cookie : repository.findByToken( token );
	}

}
