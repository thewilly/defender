package org.weso.security.controllers;

import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.weso.security.services.APITokensService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class GetAPITokenController {

	@Autowired
	private APITokensService service;
	
	@RequestMapping(value = "/auth", method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getToken(@RequestBody Map<String, Object> payload) {
		
		if(!payload.containsKey( "token" )) {
			return new ResponseEntity<String>( "{\"response\":\"unauthorized\"}",
					HttpStatus.UNAUTHORIZED );
		}
		
		String token = payload.get( "token" ).toString();
		
		try {
			return new ResponseEntity<String>( new JSONObject( /*service.getdAPIToken( token )*/ "OK" ).toString(),
					HttpStatus.OK );
		
		} catch (JSONException e) {
			log.error( "Exception generated when trying to send response as JSONObject: "
					+ e.getMessage() );
			log.trace( e.getMessage() );
			
			return new ResponseEntity<String>( new JSONObject ( e.getMessage() ).toString() ,
					HttpStatus.INTERNAL_SERVER_ERROR );
		}
	}
}
