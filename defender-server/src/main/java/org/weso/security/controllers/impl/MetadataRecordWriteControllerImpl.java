package org.weso.security.controllers.impl;


import java.util.HashMap;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.weso.security.controllers.MetadataRecordWriteController;
import org.weso.security.services.MetadataRecordWriteService;
import org.weso.security.types.MetadataRecord;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class MetadataRecordWriteControllerImpl implements MetadataRecordWriteController {

	@Autowired
	private MetadataRecordWriteService writeService;

	@Override
	@RequestMapping(value = "/register",
		method = RequestMethod.GET,
		consumes = MediaType.APPLICATION_JSON_VALUE,
		produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> register() {
		
		log.info( "Generating new token" );

		// Initialize some objects for the response.
		JSONObject response;
		HttpStatus httpStatus;
		HashMap<String, String> responseMap = new HashMap<String, String>();
		
		String token = writeService.register();
		
		httpStatus = HttpStatus.OK;
		responseMap.put("token",token);
		response = new JSONObject(responseMap);
		
		log.info( "New token generated" );
		return new ResponseEntity<String>( response.toString(), httpStatus );
	}

	@Override
	@RequestMapping(value = "/",
		method = RequestMethod.POST,
		consumes = MediaType.APPLICATION_JSON_VALUE,
		produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> update( @RequestBody MetadataRecord record ) {
		
		log.info( "Updating existing token" );

		// Initialize some objects for the response.
		JSONObject response;
		HttpStatus httpStatus;
		HashMap<String, String> responseMap = new HashMap<String, String>();
		
		// If the is no record in the request...
		if(record == null) {
			log.info( "Updating a null metadata record" );
			
			httpStatus = HttpStatus.BAD_REQUEST;
			responseMap.put( "message", "no metadata record received" );
			response = new JSONObject( responseMap );
			
			return new ResponseEntity<String>( response.toString(), httpStatus );
		}
		
		// If the token is null or empty...
		if(record.getToken() == null || record.getToken() == "") {
			log.info( "Updating a metadata record with no token" );
			
			httpStatus = HttpStatus.BAD_REQUEST;
			responseMap.put( "message", "no token received for the metadata" );
			response = new JSONObject( responseMap );
			
			return new ResponseEntity<String>( response.toString(), httpStatus );
		}
		
		boolean success = writeService.update( record.getToken(), record.getMetadata() );
		
		// If the tokewn associated with the record in the request does not exist...
		if(!success) {
			log.info( "Updating a non existing metadata record" );

			httpStatus = HttpStatus.BAD_REQUEST;
			responseMap.put( "message", "the token received does not exist" );
			response = new JSONObject( responseMap );

			return new ResponseEntity<String>( response.toString(), httpStatus );
		}
		
		// Finally if all checks passed...
		log.info( "Metadata updated for the given token and metadata" );
		httpStatus = HttpStatus.OK;
		response = new JSONObject(record);
		
		return new ResponseEntity<String>( response.toString(), httpStatus );
	}

}
