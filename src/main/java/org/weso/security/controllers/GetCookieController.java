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
package org.weso.security.controllers;

import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.weso.security.services.CookieService;

import com.github.andrewoma.dexx.collection.HashMap;

import lombok.extern.slf4j.Slf4j;

/**
 * The Constant log.
 *
 * @author Guillermo Facundo Colunga
 * @version 201806081225
 */

/** The Constant log. */
@Slf4j
@RestController
public class GetCookieController {

	/** The service. */
	@Autowired
	private CookieService service;

	/**
	 * Gets the token.
	 *
	 * @param payload the payload
	 * @return the token
	 */
	@RequestMapping( value = "/",
					method = RequestMethod.POST,
					consumes = { MediaType.APPLICATION_JSON_VALUE },
					produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<String> handler( @RequestBody Map<String, Object> payload ) {

		JSONObject response;
		HttpStatus httpStatus;
		HashMap<String, String> responseMap;
		
		
		if (!payload.containsKey( "token" )) {
			responseMap = new HashMap<String, String>();
			responseMap.put( "error", "token for the cookie not found" );
			response = new JSONObject( responseMap );
			httpStatus = HttpStatus.UNAUTHORIZED;
			log.debug( "Triying to save a cookie with no token" );
			
		} else {
			
			String token = payload.get( "token" ).toString();
			
			if(token.isEmpty()) {
				responseMap = new HashMap<String, String>();
				responseMap.put( "error", "The value of the token cannot be empty" );
				httpStatus = HttpStatus.BAD_REQUEST;
				response = new JSONObject( responseMap ); 
				log.debug( "Triying to save a cookie with empty token" );
			} else {
				response = new JSONObject( service.getCookie( token ) );
				httpStatus = HttpStatus.OK;
				log.debug( "Saving cookie with token: " + token );
			}
		}
		
		return new ResponseEntity<String>( response.toString(), httpStatus );
	}
}
