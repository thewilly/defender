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
package org.weso.security.defender.server.services.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.weso.security.defender.server.repositories.MetadataEntryRepository;
import org.weso.security.defender.server.services.MetadataEntryWriteService;
import org.weso.security.defender.server.types.MetadataEntry;
import org.weso.security.defender.server.types.OneTimeToken;

/**
 * The Class CookieServiceImpl.
 *
 * @author Guillermo Facundo Colunga
 * @version 201806081225
 */
@Service
public class MetadataEntryWriteServiceImpl implements MetadataEntryWriteService {

	/** The repository. */
	@Autowired
	private MetadataEntryRepository repository;


	/* (non-Javadoc)
	 * @see org.weso.security.services.CookieService#register(java.util.HashMap)
	 */
	@Override
	public String register() {
		String token = new OneTimeToken().value();
		MetadataEntry metadataRecord = new MetadataEntry(token, new HashMap<String, Object>());
		repository.save( metadataRecord );
		return token;
	}
	
	
	@Override
	public boolean update( String token, Map<String, Object> metadata ) {
		
		MetadataEntry temp = repository.findByToken( token );
		temp.setMetadata( metadata );
		if(repository.findByToken( token ) == null) {
			return false;
		}
		
		repository.save( temp );
		return true;
	}

}
