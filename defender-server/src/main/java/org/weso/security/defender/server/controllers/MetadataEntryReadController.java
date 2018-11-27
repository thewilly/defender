package org.weso.security.defender.server.controllers;

import java.util.Map;

import org.springframework.http.ResponseEntity;

public interface MetadataEntryReadController {
	
	public ResponseEntity<String> getDataForToken( Map<String, Object> payload );

}
