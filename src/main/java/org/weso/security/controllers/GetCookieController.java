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

@Slf4j
@RestController
public class GetCookieController {

	@Autowired
	private CookieService service;

	@RequestMapping( value = "/",
					method = RequestMethod.POST,
					consumes = { MediaType.APPLICATION_JSON_VALUE },
					produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<String> getToken( @RequestBody Map<String, Object> payload ) {

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
