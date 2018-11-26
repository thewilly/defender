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

@RestController
public class SaveCookieController {
	
	@Autowired
	private CookieService service;
	
	@SuppressWarnings("unchecked")
	@RequestMapping( value = "/",
			method = RequestMethod.GET,
			consumes = { MediaType.APPLICATION_JSON_VALUE },
			produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<String> handler(@RequestBody Map<String, Object> payload) {
		
		JSONObject response;
		HttpStatus httpStatus = null;
		HashMap<String, String> responseMap = new HashMap<String, String>();
		
		if(payload.containsKey( "token" )) {
			service.register( payload.get( "token" ).toString(), (Map<String,Object>) payload.get( "metadata" ) );
			responseMap.put( "message", "cookie stored succesfully" );
			httpStatus = HttpStatus.OK;
		} else {
			responseMap.put( "error", "no token found." );
			httpStatus = HttpStatus.BAD_REQUEST;
		}
		
		response = new JSONObject( responseMap );
		return new ResponseEntity<String>( response.toString(), httpStatus );
	}

}
