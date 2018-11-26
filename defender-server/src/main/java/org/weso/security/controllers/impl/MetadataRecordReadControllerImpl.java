package org.weso.security.controllers.impl;

import java.util.HashMap;
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
import org.weso.security.controllers.MetadataRecordReadController;
import org.weso.security.services.MetadataRecordReadService;
import org.weso.security.types.MetadataRecord;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class MetadataRecordReadControllerImpl implements MetadataRecordReadController {
	
	@Autowired
	private MetadataRecordReadService readService;

	@Override
	@RequestMapping(value = "/",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getDataForToken( @RequestBody Map<String, Object> payload ) {
		
		// Initialize some objects for the response.
		JSONObject response;
		HttpStatus httpStatus;
		HashMap<String, String> responseMap = new HashMap<String, String>();
		
		// Check if the pay load is null...
		if(payload == null) {
			log.info( "Request for getting data without payload" );
			
			httpStatus = HttpStatus.BAD_REQUEST;
			responseMap.put( "message", "no payload received" );
			response = new JSONObject( responseMap );
			
			return new ResponseEntity<String>( response.toString(), httpStatus );
		}
		
		// Get the token of the request...
		String token = payload.get( "token" ).toString();
		
		log.info( "Geting data for token: " + token);
		
		// Check if the token is null
		if(token == null || token == "") {
			log.info( "Request to get data for an empty token" );
			
			httpStatus = HttpStatus.UNAUTHORIZED;
			responseMap.put( "message", "no token received" );
			response = new JSONObject( responseMap );
			
			return new ResponseEntity<String>( response.toString(), httpStatus );
		}
		
		// Load the record that has that token...
		MetadataRecord record = readService.getDataForToken( token );
		
		// If no record found...
		if(record == null) {
			log.info( "Request to get data for a non existing token" );
			
			httpStatus = HttpStatus.UNAUTHORIZED;
			responseMap.put( "message", "no entry for the token received: " + token );
			response = new JSONObject( responseMap );
			
			return new ResponseEntity<String>( response.toString(), httpStatus );
		}
		
		// Finally if all checks passed...
		log.info( "Sending the data for the given token" );
		httpStatus = HttpStatus.OK;
		response = new JSONObject( record );
		
		
		return new ResponseEntity<String>( response.toString(), httpStatus );
	}

}
