package org.weso.security.controllers;

import java.util.Map;

import org.springframework.http.ResponseEntity;

public interface MetadataRecordReadController {
	
	public ResponseEntity<String> getDataForToken( Map<String, Object> payload );

}
